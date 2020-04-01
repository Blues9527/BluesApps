package com.blues.framework.widget.endlessbannerview.hintview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import android.view.animation.LinearInterpolator;

/**
 * 进度图片
 * Created by Administrator on 2018/2/25.
 */

public class ProgressDrawable extends Drawable implements Animatable {

    private static final float DEFAULT_WIDTH = 50.0F;
    private static final float DEFAULT_HEIGHT = 2.5F;
    private static final int DEFAULT_DURATION = 3000;
    private static final int DEFAULT_BACKGROUND_COLOR = Color.RED;
    private static final int DEFAULT_PROGRESS_COLOR = Color.WHITE;
    private float mWidth;
    private float mHeight;
    private int mDuration;
    private int mBackgroundColor;
    private int mProgressColor;
    private boolean isAnimated;
    private Paint mPaint;
    private ValueAnimator mAnimator;
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private Context mContext;

    public ProgressDrawable(Context context) {
        this(context, 0f, 0f, false);
    }

    public ProgressDrawable(Context context, boolean isAnimated) {
        this(context, 0f, 0f, isAnimated);
    }

    public ProgressDrawable(Context context, float width, float height, boolean isAnimated) {
        this(context, width, height, -1, -1, 0, isAnimated);
    }

    public ProgressDrawable(Context context, int backgroundColor, int progressColor, int duration, boolean isAnimated) {
        this(context, 0, 0, backgroundColor, progressColor, duration, isAnimated);
    }

    public ProgressDrawable(Context context, float width, float height, int backgroundColor, int progressColor, int duration, boolean isAnimated) {
        this.mContext = context;
        this.mWidth = width == 0 ? dp2px(DEFAULT_WIDTH) : dp2px(width);
        this.mHeight = height == 0 ? dp2px(DEFAULT_HEIGHT) : dp2px(height);
        this.mBackgroundColor = backgroundColor == -1 ? DEFAULT_BACKGROUND_COLOR : backgroundColor;
        this.mProgressColor = backgroundColor == -1 ? DEFAULT_PROGRESS_COLOR : progressColor;
        this.mDuration = duration == 0 ? DEFAULT_DURATION : duration;
        this.isAnimated = isAnimated;
        init();
    }

    private void init() {
        // 设置画笔参数
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        if (isAnimated) {
            // 设置属性动画参数
            mAnimator = new ValueAnimator();
            mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            mAnimator.setRepeatCount(ValueAnimator.INFINITE);
            mAnimator.setDuration(mDuration);
            mAnimator.setRepeatMode(ValueAnimator.RESTART);
            mAnimator.setInterpolator(new LinearInterpolator());
            // 设置动画的回调
            mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    calculate((float) animation.getAnimatedValue());
                    invalidateSelf();
                }
            };
            start();
        }
    }

    public void reStart(int duration) {
        stop();
        if (mAnimator != null && duration > 0) {
            mAnimator.setDuration(duration);
        }
        start();
    }

    @Override
    public void start() {
        if (mAnimator != null) {
            mAnimator.addUpdateListener(mAnimatorUpdateListener);
            mAnimator.start();
        }
    }

    @Override
    public void stop() {
        if (mAnimator != null) {
            mAnimator.removeUpdateListener(mAnimatorUpdateListener);
            mAnimator.end();
        }
    }

    @Override
    public boolean isRunning() {
        return mAnimator != null && mAnimator.isRunning();
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        mPaint.setColor(mBackgroundColor);
        canvas.drawRect(new RectF(0, 0, dp2px(DEFAULT_WIDTH), mHeight), mPaint);
        if (isAnimated) {
            mPaint.setColor(mProgressColor);
            canvas.drawRect(new RectF(0, 0, mWidth, mHeight), mPaint);
        }
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    // 获取默认的高度
    @Override
    public int getIntrinsicHeight() {
        return (int) mHeight;
    }

    // 获取默认的宽度
    @Override
    public int getIntrinsicWidth() {
        return (int) mWidth;
    }

    public float dp2px(float dpValue) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return dpValue * scale;
    }

    private void calculate(float animatedValue) {
        mWidth = dp2px(DEFAULT_WIDTH) * animatedValue;
    }

    public float getWidth() {
        return mWidth;
    }

    public void setWidth(float mWidth) {
        this.mWidth = mWidth;
    }

    public float getHeight() {
        return mHeight;
    }

    public void setHeight(float mHeight) {
        this.mHeight = mHeight;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int mDuration) {
        this.mDuration = mDuration;
    }
}
