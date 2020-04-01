package com.blues.framework.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * User : Blues
 * Date : 2019/7/24
 * Time : 10:16
 */

public class TextClockView extends View {

    private final String TAG = this.getClass().getSimpleName();

    private float mWidth, mHeight;

    private float mHourR, mMinuteR, mSecondR;

    private float mHourDeg, mMinuteDeg, mSecondDeg;

    private ValueAnimator mAnimator;

    private Paint mPaint;
    private Paint mHelperPaint;

    private Paint.FontMetrics fontMetrics;

    private String[] texts = {"日", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    private List<String> NUMBER_TEXT_LIST = new ArrayList<>(Arrays.asList(texts));

    private Timer mTimer;

    public TextClockView(Context context) {
        this(context, null);
    }

    public TextClockView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    public void init() {
        mTimer = new Timer();

        mAnimator = ValueAnimator.ofFloat(6f, 0f);
        mAnimator.setDuration(150);
        mAnimator.setInterpolator(new LinearInterpolator());
        mPaint = createPaint(0);
        //辅助基准线使用红色，更显眼
        mHelperPaint = createPaint(Color.RED);
        fontMetrics = new Paint.FontMetrics();
        //刷新
        doInvalidate();
    }

    //在layout方法中计算view去除padding后的宽高
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        mWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        mHeight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();

        mHourR = mWidth * 0.143f;
        mMinuteR = mWidth * 0.315f;
        mSecondR = mWidth * 0.425f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) return;
        //黑色背景
        canvas.drawColor(Color.BLACK);
        canvas.save();
        //将圆点移到中心点
        canvas.translate(mWidth / 2, mHeight / 2);

        //绘制中心信息，包括日期，星期
        drawCenterInfo(canvas);
        //绘制时
        drawHour(canvas, mHourDeg);
        //绘制分
        drawMinute(canvas, mMinuteDeg);
        //绘制秒
        drawSecond(canvas, mSecondDeg);

        //辅助线
//        canvas.drawLine(0f, 0f, mWidth, 0f, mHelperPaint);

        canvas.restore();
    }

    //绘制中心信息
    private void drawCenterInfo(Canvas canvas) {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        String minute = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));

        mPaint.setTextSize(mHourR * 0.4f);
        mPaint.setAlpha(255);
        mPaint.setTextAlign(Paint.Align.CENTER);

        if (Integer.parseInt(minute) < 10) {
            minute = String.format("0%s", minute);
        }
        canvas.drawText(String.format("%s:%s", hour, minute), 0f, getBottomedY(), mPaint);

        String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1);

        if (Integer.parseInt(month) < 10) {
            month = String.format("0%s", month);
        }

        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        String dayOfWeek = toText(Calendar.getInstance().get((Calendar.DAY_OF_WEEK)) - 1);

        mPaint.setTextSize(mHourR * 0.16f);
        mPaint.setAlpha(255);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(String.format("%s.%s 星期%s", month, day, dayOfWeek), 0f, getCenteredY(mPaint), mPaint);

        mPaint.setTextSize(mHourR * 0.16f);
        mPaint.setAlpha(255);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("点", mWidth * 0.225f, getCenteredY(mPaint), mPaint);

        mPaint.setTextSize(mHourR * 0.16f);
        mPaint.setAlpha(255);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("分", mWidth * 0.33f, getCenteredY(mPaint), mPaint);

        mPaint.setTextSize(mHourR * 0.2f);
        mPaint.setAlpha(255);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("秒", mWidth * 0.45f, getCenteredY(mPaint), mPaint);
    }

    private void drawHour(Canvas canvas, float degrees) {
        mPaint.setTextSize(mHourR * 0.16f);

        canvas.save();
        canvas.rotate(degrees);

        for (int i = 0; i < 12; i++) {
            canvas.save();

            float iDeg = 360 / 12f * i;
            canvas.rotate(iDeg);

            mPaint.setAlpha((iDeg + degrees == 0f) ? 255 : (int) (0.6f * 255));
            mPaint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(String.format("%s", toText(i + 1)), mHourR, getCenteredY(mPaint), mPaint);
            canvas.restore();
        }
        canvas.restore();
    }

    /**
     * 绘制分
     */
    private void drawMinute(Canvas canvas, float degrees) {
        mPaint.setTextSize(mHourR * 0.16f);
        //处理整体旋转
        canvas.save();
        canvas.rotate(degrees);

        for (int i = 0; i < 60; i++) {
            canvas.save();

            float iDeg = 360 / 60f * i;
            canvas.rotate(iDeg);

            mPaint.setAlpha((iDeg + degrees == 0f) ? 255 : (int) (0.6f * 255));
            mPaint.setTextAlign(Paint.Align.RIGHT);

            if (i < 59) {
                canvas.drawText(String.format("%s", toText(i + 1)), mMinuteR, getCenteredY(mPaint), mPaint);
            } else {
                canvas.drawText("整", mMinuteR, getCenteredY(mPaint), mPaint);
            }
            canvas.restore();
        }

        canvas.restore();
    }

    /**
     * 绘制秒
     */
    private void drawSecond(Canvas canvas, float degrees) {
        mPaint.setTextSize(mHourR * 0.2f);

        //处理整体旋转
        canvas.save();
        canvas.rotate(degrees);

        for (int i = 0; i < 60; i++) {
            canvas.save();

            float iDeg = 360 / 60f * i;
            canvas.rotate(iDeg);

            mPaint.setAlpha((iDeg + degrees == 0f) ? 255 : (int) (0.6f * 255));
            mPaint.setTextAlign(Paint.Align.RIGHT);

            if (i < 59) {
                canvas.drawText(String.format("%s", toText(i + 1)), mSecondR, getCenteredY(mPaint), mPaint);
            } else {
                canvas.drawText("整", mSecondR, getCenteredY(mPaint), mPaint);
            }
            canvas.restore();
        }
        canvas.restore();
    }


    /**
     * 创建一个画笔
     *
     * @param color 传入一个int类型的颜色
     */
    private Paint createPaint(int color) {

        //默认画笔颜色为白色
        color = color == 0 ? Color.WHITE : color;
        Paint mPaint = new Paint();
        mPaint.setColor(color);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        return mPaint;
    }

    //刷新方法
    private void doInvalidate() {
        //注意得是，通过Calendar.getInstance().get()方法去获取时间的时候，不能在初始方法的时候初始Calendar
        int hour = Calendar.getInstance().get(Calendar.HOUR);
        final int minute = Calendar.getInstance().get(Calendar.MINUTE);
        final int second = Calendar.getInstance().get(Calendar.SECOND);

        mHourDeg = -360 / 12f * (hour - 1);
        mMinuteDeg = -360 / 60f * (minute - 1);
        mSecondDeg = -360 / 60f * (second - 1);

        final float hd = mHourDeg;
        final float md = mMinuteDeg;
        final float sd = mSecondDeg;

        mAnimator.removeAllUpdateListeners();
        mAnimator.addUpdateListener(animation -> {
            float av = (float) animation.getAnimatedValue();

            if (minute == 0 && second == 0) {
                mHourDeg = hd + av * 5;
            }

            if (second == 0) {
                mMinuteDeg = md + av;
            }

            mSecondDeg = sd + av;

            invalidate();
        });
        mAnimator.start();
    }

    private float getCenteredY(Paint paint) {
        return paint.getFontMetrics(null) / 2 - fontMetrics.bottom + 10;
    }

    private float getBottomedY() {
        return -fontMetrics.bottom - 10;
    }

    /**
     * 将数字转化成中文
     *
     * @param num 待转阿拉伯数字
     * @return 汉字数字
     */
    private String toText(int num) {

        String result = "";
        List list = null;

        //先将int类型转成string
        String str = String.valueOf(num);

        if (str != null) {
            //通过toCharArray 将string转成 char数组
            char[] chars = str.toCharArray();

            //初始化一个ArrayList，长度为char数组的长度
            list = new ArrayList(chars.length);

            //遍历char数组，将值插入ArrayList
            for (int len = chars.length, i = 0; i < len; ++i) {
                list.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }

        //判断list 的大小，大于1则是 2位数（大于10），小于1则为 1位数（小于10）
        if (list.size() > 1) {
            if ((int) list.get(0) != 1) {
                result += NUMBER_TEXT_LIST.get((int) list.get(0));
            }

            result += "十";
            if ((int) list.get(1) > 0) {
                result += NUMBER_TEXT_LIST.get((int) list.get(1));
            }
        } else {
            result = NUMBER_TEXT_LIST.get((int) list.get(0));
        }

        return result;
    }

    /**
     * 调用此方法去进行时间的更新
     */
    public void startTimerSafely() {
        if (mTimer == null) {
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        doInvalidate();
                    }
                });
            }
        }, 1000, 1000);
    }

    /**
     * activity被销毁的时候调用此方法以释放mTimer
     */
    public void release() {
        if (mTimer != null) {
            mTimer.cancel();
        }
    }

    private float dp2px(float dp) {
        return getResources().getDisplayMetrics().density * dp + 0.5f;
    }
}
