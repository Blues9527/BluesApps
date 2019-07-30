package com.example.lanhuajian.blues.framework.widget.endlessbannerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.example.lanhuajian.blues.R;

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

    private Timer timer;

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


    /**
     * 读取提示形式  和   提示位置   和    播放延迟
     *
     * @param attrs
     */
    private void initView(AttributeSet attrs) {
        TypedArray type = getContext().obtainStyledAttributes(attrs, R.styleable.BannerView);
        delay = type.getInt(R.styleable.BannerView_rsrollviewpager_play_delay, 0);

        addViewPager();
        type.recycle();
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
                    new Interpolator() {
                        public float getInterpolation(float t) {
                            t -= 1.0f;
                            return t * t * t * t * t + 1.0f;
                        }
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
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
