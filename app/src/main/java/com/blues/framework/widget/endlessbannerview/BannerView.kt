package com.blues.framework.widget.endlessbannerview

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.PagerAdapter
import android.graphics.Color
import com.blues.R
import com.blues.framework.widget.endlessbannerview.hintview.ColorPointHintView
import java.lang.ref.WeakReference
import com.blues.framework.widget.endlessbannerview.hintview.HintView
import android.widget.Scroller
import android.view.MotionEvent
import android.view.ViewGroup
import android.graphics.drawable.GradientDrawable
import android.os.Handler
import android.os.Message
import android.view.View
import android.view.animation.Interpolator
import com.blues.framework.utils.dp
import java.util.*

/**
 * User : Blues
 * Date : 2019/7/9
 * Time : 14:39
 */
class BannerView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null,
    defStyle: Int = 0) : RelativeLayout(context, attrs, defStyle), OnPageChangeListener {

    /**
     * 支持轮播和提示的的viewpager
     */
    private var mViewPager: ViewPager? = null
    private var mAdapter: PagerAdapter? = null
    private var mRecentTouchTime: Long = 0

    //播放延迟
    private var delay = 0

    //位置，颜色，透明度
    private var location = 0
    private var mColor = 0
    private var mAlpha = 0
    private var paddingL = 0
    private var paddingR = 0
    private var paddingT = 0
    private var paddingB = 0
    private var timer: Timer? = null
    private var mHintView: View? = null
    private var mCurrentPosition = 0


    init {
        initView(attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),
                MeasureSpec.getSize(heightMeasureSpec))
    }

    /**
     * 读取提示形式  和   提示位置   和    播放延迟
     *
     * @param attrs
     */
    private fun initView(attrs: AttributeSet?) {
        val type = context.obtainStyledAttributes(attrs, R.styleable.BannerView)
        delay = type.getInt(R.styleable.BannerView_play_delay, 0)
        location = type.getInteger(R.styleable.BannerView_hint_gravity, 1)
        mColor = type.getColor(R.styleable.BannerView_hint_color, Color.BLACK)
        mAlpha = type.getInt(R.styleable.BannerView_hint_alpha, 0)
        paddingL = type.getDimension(R.styleable.BannerView_hint_paddingLeft, 0f).toInt()
        paddingR = type.getDimension(R.styleable.BannerView_hint_paddingRight, 0f).toInt()
        paddingT = type.getDimension(R.styleable.BannerView_hint_paddingTop, 0f).toInt()
        paddingB = type.getDimension(R.styleable.BannerView_hint_paddingBottom, 4f.dp).toInt()
        addViewPager()
        type.recycle()
        initHint(ColorPointHintView(context, Color.parseColor("#ff5ac8fa"),
                Color.parseColor("#ff3aa64c")))
    }

    private fun addViewPager() {
        if (mViewPager != null) {
            removeView(mViewPager)
        }
        mViewPager = ViewPager(context).apply {
            id = R.id.viewpager_inner
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        }
        addView(mViewPager)
    }

    private class TimeTaskHandler(rollPagerView: BannerView) : Handler() {

        private val mRollPagerViewWeakReference: WeakReference<BannerView> = WeakReference(
                rollPagerView)

        override fun handleMessage(msg: Message) {
            val rollPagerView = mRollPagerViewWeakReference.get()
            var cur = rollPagerView!!.mViewPager!!.currentItem + 1
            if (cur >= rollPagerView.mAdapter!!.count) {
                cur = 0
            }
            rollPagerView.viewPager!!.currentItem = cur
            rollPagerView.mHintViewDelegate.setCurrentPosition(cur, msg.arg1,
                    rollPagerView.mHintView as HintView?)
            if (rollPagerView.mAdapter!!.count <= 1) rollPagerView.stopPlay()
        }

    }

    private val mHandler = TimeTaskHandler(this)

    private class WeakTimerTask(mRollPagerView: BannerView) : TimerTask() {

        private val mRollPagerViewWeakReference: WeakReference<BannerView> = WeakReference(
                mRollPagerView)

        override fun run() {
            val rollPagerView = mRollPagerViewWeakReference.get()
            if (rollPagerView != null) {
                if (rollPagerView.isShown && System.currentTimeMillis() - rollPagerView.mRecentTouchTime > rollPagerView.delay) {
                    val message = Message()
                    message.what = 0
                    message.arg1 = rollPagerView.delay
                    rollPagerView.mHandler.sendMessage(message)
                }
            } else {
                cancel()
            }
        }

    }

    /**
     * 开始播放
     * 仅当view正在显示 且 触摸等待时间过后 播放
     */
    private fun startPlay() {
        if (delay <= 0 || mAdapter == null || mAdapter!!.count <= 1) {
            return
        }
        timer?.cancel()
        timer = Timer()
        //用一个timer定时设置当前项为下一项
        timer?.schedule(WeakTimerTask(this), delay.toLong(), delay.toLong())
    }

    private fun stopPlay() {
        timer?.cancel()
        timer = null
    }

    /**
     * 设置viewager滑动动画持续时间
     *
     * @param during
     */
    fun setAnimationDuration(during: Int) {
        try {
            // viePager平移动画事件
            val mField = ViewPager::class.java.getDeclaredField("mScroller")
            mField.isAccessible = true
            val mScroller: Scroller = object : Scroller(context,  // 动画效果与ViewPager的一致
                    Interpolator { t: Float ->
                        var temp = t
                        temp -= 1.0f
                        temp * temp * temp * temp * temp + 1.0f
                    }) {
                override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int,
                    duration: Int) {
                    // 如果手工滚动,则加速滚动
                    var d = duration
                    if (System.currentTimeMillis() - mRecentTouchTime > delay) {
                        d = during
                    } else {
                        d /= 2
                    }
                    super.startScroll(startX, startY, dx, dy, d)
                }

                override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int) {
                    super.startScroll(startX, startY, dx, dy, during)
                }
            }
            mField[mViewPager] = mScroller
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun setPlayDelay(delay: Int) {
        this.delay = delay
        startPlay()
    }

    fun pause() {
        stopPlay()
    }

    fun resume() {
        startPlay()
    }

    /**
     * 取真正的Viewpager
     *
     * @return
     */
    var viewPager: ViewPager?
        get() = mViewPager
        set(viewPager) {
            if (mViewPager != null) {
                removeView(mViewPager)
            }
            mViewPager = viewPager
            mViewPager?.id = R.id.viewpager_inner
            mViewPager?.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT)
            addView(mViewPager)
        }

    /**
     * 设置Adapter
     *
     * @param adapter
     */
    fun setAdapter(adapter: PagerAdapter?) {
        mViewPager?.let {
            it.adapter = adapter
            it.currentItem = mCurrentPosition
            it.addOnPageChangeListener(this)
        }
        mAdapter = adapter
        startPlay()
        dataSetChanged()
    }

    /**
     * 为了实现触摸时和过后一定时间内不滑动
     *
     * @param ev
     * @return
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        mRecentTouchTime = System.currentTimeMillis()
        return super.dispatchTouchEvent(ev)
    }

    override fun onPageScrolled(i: Int, v: Float, i1: Int) {}
    override fun onPageSelected(position: Int) {
        mCurrentPosition = position
        mHintViewDelegate.setCurrentPosition(position, delay, mHintView as HintView?)
    }

    override fun onPageScrollStateChanged(i: Int) {}

    /* -------------------------------------------------------------------hint view相关-----------------------------------------------------------------------------------------------------------------*/
    interface HintViewDelegate {

        fun setCurrentPosition(position: Int, duration: Int, hintView: HintView?)
        fun initView(length: Int, gravity: Int, duration: Int, hintView: HintView?)
    }

    private var mHintViewDelegate: HintViewDelegate = object : HintViewDelegate {
        override fun setCurrentPosition(position: Int, duration: Int, hintView: HintView?) {
            hintView?.setCurrent(position, duration)
        }

        override fun initView(length: Int, gravity: Int, duration: Int, hintView: HintView?) {
            hintView?.initView(length, gravity, duration)
        }
    }

    fun setHintViewDelegate(delegate: HintViewDelegate) {
        mHintViewDelegate = delegate
    }

    private fun initHint(hintView: HintView?) {
        hintView?.let {
            if (mHintView != null) {
                removeView(mHintView)
            }
            mHintView = it as View?
            loadHintView()
        }
    }

    /**
     * 加载hintview的容器
     */
    private fun loadHintView() {
        addView(mHintView)
        mHintView?.apply {
            setPadding(paddingL, paddingT, paddingR, paddingB)
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                addRule(ALIGN_PARENT_BOTTOM)
            }
            background = GradientDrawable().apply {
                setColor(mColor)
                alpha = mAlpha
            }
        }
        mHintViewDelegate.initView(if (mAdapter == null) 0 else mAdapter!!.count, location, delay,
                mHintView as HintView?)
    }

    /**
     * 设置提示view的位置
     */
    fun setHintPadding(left: Int, top: Int, right: Int, bottom: Int) {
        paddingL = left
        paddingT = top
        paddingR = right
        paddingB = bottom
        mHintView?.setPadding(paddingL, paddingT, paddingR, paddingB)
    }

    private fun dataSetChanged() {
        if (mHintView != null) {
            mHintViewDelegate.initView(mAdapter!!.count, location, delay, mHintView as HintView?)
        }
        startPlay()
    }
}