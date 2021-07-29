package com.blues.framework.widget.endlessbannerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.blues.R;
import com.blues.framework.widget.endlessbannerview.hintview.ColorPointHintView;
import com.blues.framework.widget.endlessbannerview.hintview.HintView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/**
 * User : Blues
 * Date : 2019/7/9
 * Time : 14:39
 */

public class BannerView extends RelativeLayout implements ViewPager.OnPageChangeListener {

    /**
     * 支持轮播和提示的的viewpager
     */
    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private long mRecentTouchTime;
    //播放延迟
    private int delay;
    //位置，颜色，透明度
    private int gravity, color, alpha;
    private int paddingLeft, paddingRight, paddingTop, paddingBottom;

    private Timer timer;
    private View mHintView;

    private int mCurrentPosition;

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
    }

    /**
     * 读取提示形式  和   提示位置   和    播放延迟
     *
     * @param attrs
     */
    private void initView(AttributeSet attrs) {
        TypedArray type = getContext().obtainStyledAttributes(attrs, R.styleable.BannerView);
        delay = type.getInt(R.styleable.BannerView_play_delay, 0);
        gravity = type.getInteger(R.styleable.BannerView_hint_gravity, 1);
        color = type.getColor(R.styleable.BannerView_hint_color, Color.BLACK);
        alpha = type.getInt(R.styleable.BannerView_hint_alpha, 0);
        paddingLeft = (int) type.getDimension(R.styleable.BannerView_hint_paddingLeft, 0);
        paddingRight = (int) type.getDimension(R.styleable.BannerView_hint_paddingRight, 0);
        paddingTop = (int) type.getDimension(R.styleable.BannerView_hint_paddingTop, 0);
        paddingBottom = (int) type.getDimension(R.styleable.BannerView_hint_paddingBottom, dp2px(4));

        addViewPager();
        type.recycle();
        initHint(new ColorPointHintView(getContext(), Color.parseColor("#ff5ac8fa"), Color.parseColor("#ff3aa64c")));
    }

    private void addViewPager() {
        if (mViewPager != null) {
            removeView(mViewPager);
        }
        mViewPager = new ViewPager(getContext());
        mViewPager.setId(R.id.viewpager_inner);
        mViewPager.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(mViewPager);
    }

    public void setViewPager(ViewPager viewPager) {
        if (mViewPager != null) {
            removeView(mViewPager);
        }
        mViewPager = viewPager;
        mViewPager.setId(R.id.viewpager_inner);
        mViewPager.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(mViewPager);
    }

    private final static class TimeTaskHandler extends Handler {
        private WeakReference<BannerView> mRollPagerViewWeakReference;

        public TimeTaskHandler(BannerView rollPagerView) {
            this.mRollPagerViewWeakReference = new WeakReference<>(rollPagerView);
        }

        @Override
        public void handleMessage(Message msg) {
            BannerView rollPagerView = mRollPagerViewWeakReference.get();
            int cur = rollPagerView.mViewPager.getCurrentItem() + 1;
            if (cur >= rollPagerView.mAdapter.getCount()) {
                cur = 0;
            }
            rollPagerView.getViewPager().setCurrentItem(cur);
            rollPagerView.mHintViewDelegate.setCurrentPosition(cur, msg.arg1, (HintView) rollPagerView.mHintView);
            if (rollPagerView.mAdapter.getCount() <= 1) rollPagerView.stopPlay();

        }
    }

    private TimeTaskHandler mHandler = new TimeTaskHandler(this);

    private static class WeakTimerTask extends TimerTask {
        private WeakReference<BannerView> mRollPagerViewWeakReference;

        WeakTimerTask(BannerView mRollPagerView) {
            this.mRollPagerViewWeakReference = new WeakReference<>(mRollPagerView);
        }

        @Override
        public void run() {
            BannerView rollPagerView = mRollPagerViewWeakReference.get();
            if (rollPagerView != null) {
                if (rollPagerView.isShown() && System.currentTimeMillis() - rollPagerView.mRecentTouchTime > rollPagerView.delay) {
                    Message message = new Message();
                    message.what = 0;
                    message.arg1 = rollPagerView.delay;
                    rollPagerView.mHandler.sendMessage(message);
                }
            } else {
                cancel();
            }
        }
    }

    /**
     * 开始播放
     * 仅当view正在显示 且 触摸等待时间过后 播放
     */
    private void startPlay() {
        if (delay <= 0 || mAdapter == null || mAdapter.getCount() <= 1) {
            return;
        }
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        //用一个timer定时设置当前项为下一项
        timer.schedule(new WeakTimerTask(this), delay, delay);
    }

    private void stopPlay() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    /**
     * 设置viewager滑动动画持续时间
     *
     * @param during
     */
    public void setAnimationDuration(final int during) {
        try {
            // viePager平移动画事件
            Field mField = ViewPager.class.getDeclaredField("mScroller");
            mField.setAccessible(true);
            Scroller mScroller = new Scroller(getContext(),
                    // 动画效果与ViewPager的一致
                    t -> {
                        t -= 1.0f;
                        return t * t * t * t * t + 1.0f;
                    }) {

                @Override
                public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                    // 如果手工滚动,则加速滚动
                    if (System.currentTimeMillis() - mRecentTouchTime > delay) {
                        duration = during;
                    } else {
                        duration /= 2;
                    }
                    super.startScroll(startX, startY, dx, dy, duration);
                }

                @Override
                public void startScroll(int startX, int startY, int dx, int dy) {
                    super.startScroll(startX, startY, dx, dy, during);
                }
            };
            mField.set(mViewPager, mScroller);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setPlayDelay(int delay) {
        this.delay = delay;
        startPlay();
    }

    public void pause() {
        stopPlay();
    }

    public void resume() {
        startPlay();
    }

    public boolean isPlaying() {
        return timer != null;
    }


    /**
     * 取真正的Viewpager
     *
     * @return
     */
    public ViewPager getViewPager() {
        return mViewPager;
    }

    /**
     * 设置Adapter
     *
     * @param adapter
     */
    public void setAdapter(PagerAdapter adapter) {
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(mCurrentPosition);
        mViewPager.addOnPageChangeListener(this);
        mAdapter = adapter;
        startPlay();
        dataSetChanged();
    }

    /**
     * 为了实现触摸时和过后一定时间内不滑动
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mRecentTouchTime = System.currentTimeMillis();
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        mCurrentPosition = position;
        mHintViewDelegate.setCurrentPosition(position, delay, (HintView) mHintView);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    public int dp2px(float dp) {
        return (int) (getResources().getDisplayMetrics().density * dp);
    }

    /* -------------------------------------------------------------------hint view相关-----------------------------------------------------------------------------------------------------------------*/

    public interface HintViewDelegate {
        void setCurrentPosition(int position, int duration, HintView hintView);

        void initView(int length, int gravity, int duration, HintView hintView);
    }

    private BannerView.HintViewDelegate mHintViewDelegate = new BannerView.HintViewDelegate() {
        @Override
        public void setCurrentPosition(int position, int duration, HintView hintView) {
            if (hintView != null) hintView.setCurrent(position, duration);
        }

        @Override
        public void initView(int length, int gravity, int duration, HintView hintView) {
            if (hintView != null) {
                hintView.initView(length, gravity, duration);
            }
        }
    };

    public void setHintViewDelegate(BannerView.HintViewDelegate delegate) {
        this.mHintViewDelegate = delegate;
    }

    private void initHint(HintView hintview) {
        if (hintview == null) {
            return;
        }
        if (mHintView != null) {
            removeView(mHintView);
        }

        mHintView = (View) hintview;
        loadHintView();
    }

    /**
     * 加载hintview的容器
     */
    private void loadHintView() {
        addView(mHintView);
        mHintView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mHintView.setLayoutParams(lp);

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(color);
        gd.setAlpha(alpha);
        mHintView.setBackgroundDrawable(gd);

        mHintViewDelegate.initView(mAdapter == null ? 0 : mAdapter.getCount(), gravity, delay, (HintView) mHintView);
    }

    /**
     * 设置提示view的位置
     */
    public void setHintPadding(int left, int top, int right, int bottom) {
        paddingLeft = left;
        paddingTop = top;
        paddingRight = right;
        paddingBottom = bottom;
        mHintView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    /**
     * 设置提示view的透明度
     *
     * @param alpha 0为全透明  255为实心
     */
    public void setHintAlpha(int alpha) {
        this.alpha = alpha;
        initHint((HintView) mHintView);
    }

    /**
     * 支持自定义hintview
     * 只需new一个实现HintView的View传进来
     * 会自动将你的view添加到本View里面。重新设置LayoutParams。
     *
     * @param hintview
     */
    public void setHintView(HintView hintview) {

        if (mHintView != null) {
            removeView(mHintView);
        }
        this.mHintView = (View) hintview;
        if (hintview != null && hintview instanceof View) {
            initHint(hintview);
        }
    }

    public void dataSetChanged() {
        if (mHintView != null) {
            mHintViewDelegate.initView(mAdapter.getCount(), gravity, delay, (HintView) mHintView);
        }
        startPlay();
    }
}
