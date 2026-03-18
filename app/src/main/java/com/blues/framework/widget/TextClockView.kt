package com.blues.framework.widget

import android.util.AttributeSet
import android.animation.ValueAnimator
import android.graphics.Paint
import android.graphics.Paint.FontMetrics
import android.view.animation.LinearInterpolator
import android.graphics.Canvas
import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.View
import java.lang.Runnable
import java.util.*

/**
 * User : Blues
 * Date : 2019/7/24
 * Time : 10:16
 */
class TextClockView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    private var mWidth = 0f
    private var mHeight = 0f
    private var mHourR = 0f
    private var mMinuteR = 0f
    private var mSecondR = 0f
    private var mHourDeg = 0f
    private var mMinuteDeg = 0f
    private var mSecondDeg = 0f

    private var mAnimator: ValueAnimator? = null
    private lateinit var mPaint: Paint
    private var fontMetrics: FontMetrics? = null
    private val numberTextList: MutableList<String> = mutableListOf("日", "一", "二", "三", "四", "五",
            "六", "七", "八", "九", "十")
    private var mTimer: Timer? = null

    /**
     * 初始化
     */
    private fun init() {
        mTimer = Timer()
        mAnimator = ValueAnimator.ofFloat(6f, 0f).apply {
            duration = 150
            interpolator = LinearInterpolator()
        }
        mPaint = createPaint()
        fontMetrics = FontMetrics()
        //刷新
        doInvalidate()
    }

    //在layout方法中计算view去除padding后的宽高
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        mWidth = (measuredWidth - paddingLeft - paddingRight).toFloat()
        mHeight = (measuredHeight - paddingTop - paddingBottom).toFloat()
        mHourR = mWidth * 0.143f
        mMinuteR = mWidth * 0.315f
        mSecondR = mWidth * 0.425f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //黑色背景
        canvas.drawColor(Color.BLACK)
        canvas.save()
        //将圆点移到中心点
        canvas.translate(mWidth / 2, mHeight / 2)

        //绘制中心信息，包括日期，星期
        drawCenterInfo(canvas)
        //绘制时
        drawHour(canvas, mHourDeg)
        //绘制分
        drawMinute(canvas, mMinuteDeg)
        //绘制秒
        drawSecond(canvas, mSecondDeg)
        canvas.restore()
    }

    //绘制中心信息
    private fun drawCenterInfo(canvas: Canvas) {
        val hour = Calendar.getInstance()[Calendar.HOUR_OF_DAY]
        var minute = Calendar.getInstance()[Calendar.MINUTE].toString()
        with(mPaint) {
            textSize = mHourR * 0.4f
            alpha = 255
            textAlign = Paint.Align.CENTER
        }
        if (minute.toInt() < 10) {
            minute = "0$minute"
        }
        canvas.drawText("$hour:$minute", 0f, bottomedY, (mPaint))

        var month = (Calendar.getInstance()[Calendar.MONTH] + 1).toString()
        if (month.toInt() < 10) {
            month = "0$month"
        }
        val day = Calendar.getInstance()[Calendar.DAY_OF_MONTH]
        val dayOfWeek = toText(Calendar.getInstance()[(Calendar.DAY_OF_WEEK)] - 1)
        with(mPaint) {
            textSize = mHourR * 0.16f
            alpha = 255
            textAlign = Paint.Align.CENTER
            canvas.drawText("$month.$day 星期$dayOfWeek", 0f, getCenteredY(this), this)
        }

        with(mPaint) {
            textSize = mHourR * 0.16f
            alpha = 255
            textAlign = Paint.Align.CENTER
            canvas.drawText("点", mWidth * 0.225f, getCenteredY(this), this)
        }


        with(mPaint) {
            textSize = mHourR * 0.16f
            alpha = 255
            textAlign = Paint.Align.CENTER
            canvas.drawText("分", mWidth * 0.33f, getCenteredY(this), this)
        }


        with(mPaint) {
            textSize = mHourR * 0.2f
            alpha = 255
            textAlign = Paint.Align.CENTER
            canvas.drawText("秒", mWidth * 0.45f, getCenteredY(this), this)
        }
    }

    private fun drawHour(canvas: Canvas, degrees: Float) {
        mPaint.textSize = mHourR * 0.16f
        canvas.save()
        canvas.rotate(degrees)
        for (i in 0..11) {
            canvas.save()
            val iDeg = 360 / 12f * i
            canvas.rotate(iDeg)
            with(mPaint) {
                alpha = if ((iDeg + degrees == 0f)) 255 else (0.6f * 255).toInt()
                textAlign = Paint.Align.LEFT
                canvas.drawText(toText(i + 1), mHourR, getCenteredY(this), this)
            }
            canvas.restore()
        }
        canvas.restore()
    }

    /**
     * 绘制分
     */
    private fun drawMinute(canvas: Canvas, degrees: Float) {
        mPaint.textSize = mHourR * 0.16f
        //处理整体旋转
        canvas.save()
        canvas.rotate(degrees)
        for (i in 0..59) {
            canvas.save()
            val iDeg = 360 / 60f * i
            canvas.rotate(iDeg)
            with(mPaint) {
                alpha = if ((iDeg + degrees == 0f)) 255 else (0.6f * 255).toInt()
                textAlign = Paint.Align.RIGHT
                if (i < 59) {
                    canvas.drawText(String.format("%s", toText(i + 1)), mMinuteR,
                            getCenteredY(this), this)
                } else {
                    canvas.drawText("整", mMinuteR, getCenteredY(this), this)
                }
            }
            canvas.restore()
        }
        canvas.restore()
    }

    /**
     * 绘制秒
     */
    private fun drawSecond(canvas: Canvas, degrees: Float) {
        mPaint.textSize = mHourR * 0.2f

        //处理整体旋转
        canvas.save()
        canvas.rotate(degrees)
        for (i in 0..59) {
            canvas.save()
            val iDeg = 360 / 60f * i
            canvas.rotate(iDeg)
            with(mPaint) {
                alpha = if ((iDeg + degrees == 0f)) 255 else (0.6f * 255).toInt()
                textAlign = Paint.Align.RIGHT
                if (i < 59) {
                    canvas.drawText(String.format("%s", toText(i + 1)), mSecondR,
                            getCenteredY(this), this)
                } else {
                    canvas.drawText("整", mSecondR, getCenteredY(this), this)
                }
            }

            canvas.restore()
        }
        canvas.restore()
    }

    /**
     * 创建一个画笔
     *
     * @param color 传入一个int类型的颜色
     */
    private fun createPaint(): Paint {
        //默认画笔颜色为白色
        return Paint().apply {
            color = Color.WHITE
            isAntiAlias = true
            style = Paint.Style.FILL
        }
    }

    //刷新方法
    private fun doInvalidate() {
        //注意得是，通过Calendar.getInstance().get()方法去获取时间的时候，不能在初始方法的时候初始Calendar
        val hour = Calendar.getInstance()[Calendar.HOUR]
        val minute = Calendar.getInstance()[Calendar.MINUTE]
        val second = Calendar.getInstance()[Calendar.SECOND]
        mHourDeg = -360 / 12f * (hour - 1)
        mMinuteDeg = -360 / 60f * (minute - 1)
        mSecondDeg = -360 / 60f * (second - 1)
        val hd = mHourDeg
        val md = mMinuteDeg
        val sd = mSecondDeg
        mAnimator!!.removeAllUpdateListeners()
        mAnimator!!.addUpdateListener { animation: ValueAnimator ->
            val av: Float = animation.animatedValue as Float
            if (minute == 0 && second == 0) {
                mHourDeg = hd + av * 5
            }
            if (second == 0) {
                mMinuteDeg = md + av
            }
            mSecondDeg = sd + av
            invalidate()
        }
        mAnimator!!.start()
    }

    private fun getCenteredY(paint: Paint?): Float {
        return paint!!.getFontMetrics(null) / 2 - fontMetrics!!.bottom + 10
    }

    private val bottomedY: Float
        get() = -fontMetrics!!.bottom - 10

    /**
     * 将数字转化成中文
     *
     * @param num 待转阿拉伯数字
     * @return 汉字数字
     */
    private fun toText(num: Int): String {
        var result = ""
        val list: MutableList<Int>

        //先将int类型转成string
        val str = num.toString()
        //通过toCharArray 将string转成 char数组
        val chars = str.toCharArray()

        //初始化一个ArrayList，长度为char数组的长度
        list = ArrayList<Int>(chars.size)

        //遍历char数组，将值插入ArrayList
        val len = chars.size
        var i = 0
        while (i < len) {
            list.add(chars[i].toString().toInt())
            ++i
        }

        //判断list 的大小，大于1则是 2位数（大于10），小于1则为 1位数（小于10）
        if (list.size > 1) {
            if (list[0] != 1) {
                result += numberTextList[list[0]]
            }
            result += "十"
            if (list[1] > 0) {
                result += numberTextList[list[1]]
            }
        } else {
            result = numberTextList[list[0]]
        }
        return result
    }

    /**
     * 调用此方法去进行时间的更新
     */
    fun startTimerSafely() {
        if (mTimer == null) {
            mTimer = Timer()
        }
        mTimer?.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post { doInvalidate() }
            }
        }, 1000, 1000)
    }

    /**
     * activity被销毁的时候调用此方法以释放mTimer
     */
    fun release() {
        mTimer?.cancel()
    }

    init {
        init()
    }
}