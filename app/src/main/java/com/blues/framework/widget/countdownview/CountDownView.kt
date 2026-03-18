package com.blues.framework.widget.countdownview

import android.util.AttributeSet
import android.graphics.Paint
import android.os.CountDownTimer
import com.blues.R
import android.graphics.Canvas
import android.graphics.RectF
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Rect
import android.text.TextUtils
import android.view.View
import com.blues.framework.utils.dp
import com.blues.framework.utils.sp
import com.blues.nicevideoplayer.CountDownTimerImpl
import java.lang.NullPointerException

/**
 * User : Blues
 * Date : 2019/7/10
 * Time : 11:09
 */

class CountDownView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr), View.OnClickListener {


    companion object {

        private const val skipText = "跳过"

        //倒计时间隔，默认1s
        private const val INTERVAL_DEFAULT: Long = 1000
    }


    //view的中心点X坐标
    private var centerX = 0

    //view中心点的Y坐标
    private var centerY = 0
    private val max = 100

    //表示进度，值介于0~100之间
    private var progress = 0f
        set(value) {
            field = if (value > 100) max.toFloat() else value
            postInvalidate()
        }
    private var radius = 15f.dp

    //画笔
    private val mPaint: Paint

    //进度颜色
    private var progressColor = 0

    //进度背景颜色
    private var progressBgColor = 0

    //倒计时颜色
    private var textColor = 0

    //是否显示倒计时
    private var showCountText = false

    //倒计时字体大小
    private var textSize = 0f

    //progressbar宽度
    private var strokeWidth = 0f

    //倒计时
    private var countDownText: String? = null
        set(value) {
            field = value
            postInvalidate()
        }

    //形状,默认圆形
    private var progressShape = 0

    //计时器，用于更新文本
    private var countDownTimer: CountDownTimer? = null

    //Timer结束回调
    var mTimerCallBack: (() -> Unit)? = null

    //Timer点击跳过监听
    var mSkipListener: (() -> Unit)? = null


    private var drawText: String? = null


    init {
        initAttrs(context, attrs)
        //抗锯齿
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        if (TextUtils.isEmpty(countDownText)) throw NullPointerException("countDownText not null")
        startCountDown((countDownText!!.toInt() * 1000).toLong(), INTERVAL_DEFAULT)
        setOnClickListener(this)
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CountDownView)

        //是否显示倒数文字
        showCountText = ta.getBoolean(R.styleable.CountDownView_showCountText, true)

        //倒计时
        countDownText = ta.getString(R.styleable.CountDownView_countDownTime)

        //倒数字体默认15px
        textSize = ta.getDimension(R.styleable.CountDownView_textSize, 15f.sp)

        //倒计时颜色，默认黑色
        textColor = ta.getColor(R.styleable.CountDownView_textColor, -0x1000000)

        //进度条宽度默认 5dp
        strokeWidth = ta.getFloat(R.styleable.CountDownView_progressStrokeWidth, 5f)

        //进度条进度默认蓝色
        progressColor = ta.getColor(R.styleable.CountDownView_progressColor, -0xb48b63)

        //背景默认灰色
        progressBgColor = ta.getColor(R.styleable.CountDownView_progressBgColor, -0x121213)

        //默认圆形
        progressShape = ta.getInt(R.styleable.CountDownView_mode, 1)
        ta.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        centerX = width / 2
        centerY = height / 2
        radius = centerX - strokeWidth.dp / 2
        if (progressShape == 0) {
            drawLinearProgressBar(canvas, mPaint)
        } else {
            drawRoundProgressBar(canvas, mPaint)
        }
    }

    /**
     * 绘制圆形progressbar
     *
     * @param canvas
     * @param paint
     */
    private fun drawRoundProgressBar(canvas: Canvas, paint: Paint) {
        paint.color = progressBgColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth.dp
        canvas.drawCircle(centerX.toFloat(), centerY.toFloat(), radius, paint)
        paint.color = progressColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth.dp
        val oval = RectF(
            (centerX - radius), (centerY - radius),
            (radius + centerX), (radius + centerY)
        )
        canvas.drawArc(oval, -90f, angle, false, paint)

        //开始绘制文字
        paint.style = Paint.Style.FILL
        paint.color = textColor
        paint.textSize = textSize.sp
        val rect = Rect()
        drawText =
            if (showCountText && countDownText !== skipText) (countDownText!!.toInt() + 1).toString() else skipText

        paint.getTextBounds(drawText, 0, drawText!!.length, rect)
        var textWidth = rect.width().toFloat()
        val textHeight = rect.height().toFloat()
        if (textWidth >= radius * 2) {
            textWidth = (radius * 2)
        }
        //绘制倒计时
        canvas.drawText(drawText!!, centerX - textWidth / 2, centerY + textHeight / 2, paint)
    }

    /**
     * 绘制线型的progressbar
     *
     * @param canvas
     * @param paint
     */
    private fun drawLinearProgressBar(canvas: Canvas, paint: Paint) {
        paint.color = progressBgColor
        paint.style = Paint.Style.FILL
        paint.strokeWidth = strokeWidth.dp
        canvas.drawRoundRect(
            RectF(0f, 0f, width.toFloat(), strokeWidth.dp), 0f, 0f,
            paint
        )
        paint.color = progressColor
        paint.style = Paint.Style.FILL
        paint.strokeWidth = strokeWidth.dp
        canvas.drawRoundRect(
            RectF(0f, 0f, progress / 100 * width, strokeWidth.dp),
            0f, 0f, paint
        )
    }

    /**
     * 获取当前进度对应圆形的角度
     *
     * @return 度数
     */
    private val angle: Float
        get() {
            var percent = 360 * (max - progress) / max
            if (percent > 360) percent = 360f
            percent = 360 - percent
            return percent
        }

    /**
     * 开启倒计时,圆形倒计时progressbar需要用到
     */
    private fun startCountDown(millisInFuture: Long, countDownInterval: Long) {
        countDownTimer = CountDownTimerImpl(millisInFuture, countDownInterval, {
            countDownText = ((it / 1000).toInt()).toString()
        }) {
            //更新倒计时文本为:跳过
            if (drawText !== skipText) {
                countDownText = skipText
            }
            mTimerCallBack?.invoke()
        }
        (countDownTimer as CountDownTimerImpl).start()
        //使用属性动画过度progress的更新，会更加圆滑
        ObjectAnimator.ofFloat(this, "progress", 100.0f, 0.0f).apply {
            duration = millisInFuture
            start()
        }
    }

    /**
     * onResume时候开启倒计时，主要用于界面生命周期变化恢复倒计时
     */
    fun countDownResume() {
        countDownTimer?.start()
    }

    /**
     * onStop或者是onPause的时候取消倒计时，主要用于界面生命周期变化取消倒计时
     */
    fun countDownCancel() {
        countDownTimer?.cancel()
    }

    override fun onClick(view: View) {
        //等到文字为跳过时再响应监听
        if (drawText == skipText) {
            mSkipListener?.invoke()
            //跳过了，取消倒计时了
            countDownCancel()
        }
    }
}