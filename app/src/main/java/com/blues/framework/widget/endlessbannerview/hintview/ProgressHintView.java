package com.blues.framework.widget.endlessbannerview.hintview;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * Created by Administrator on 2018/1/4.
 */

public class ProgressHintView extends LinearLayout implements HintView {

    private static final float DEFAULT_MARGINS = 15F;
    private static final float DEFAULT_WIDTH = 50.0F;
    private static final float DEFAULT_HEIGHT = 2.5F;
    private static final float DEFAULT_HORIZONTAL_MARGINS = 5F;
    private ImageView[] mDots;
    private int length = 0;
    private int lastPosition = 0;

    private ProgressDrawable mDotNormalDrawable;
    private ProgressDrawable mDotFocusDrawable;

    private int mFocusColor;
    private int mNormalColor;
    private int mDuration;
    private float mWidth;
    private float mHeight;
    private int mMargins;
    private int mHorizontalMargins;

    public ProgressHintView(Context context) {
        super(context);
    }

    public ProgressHintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressHintView(Context context, int focusColor, int normalColor, int duration) {
        super(context);
        this.mFocusColor = focusColor;
        this.mNormalColor = normalColor;
        this.mDuration = duration;
        this.mWidth = DEFAULT_WIDTH;
        this.mHeight = DEFAULT_HEIGHT;
        this.mMargins = dp2px(DEFAULT_MARGINS);
        this.mHorizontalMargins = dp2px(DEFAULT_HORIZONTAL_MARGINS);
    }

    public ProgressDrawable makeFocusDrawable() {
        return new ProgressDrawable(getContext(), mWidth, mHeight, mNormalColor, mFocusColor, mDuration, true);
    }

    public ProgressDrawable makeNormalDrawable() {
        return new ProgressDrawable(getContext(), mWidth, mHeight, mNormalColor, mFocusColor, mDuration, false);
    }

    @Override
    public void initView(int length, int gravity, int duration) {

        if (length == 0) return;

        removeAllViews();
        lastPosition = 0;
        setOrientation(HORIZONTAL);
        switch (gravity) {
            case 0:
                setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
                break;
            case 1:
                setGravity(Gravity.CENTER);
                break;
            case 2:
                setGravity(Gravity.END | Gravity.CENTER_VERTICAL);
                break;
        }

        this.length = length;
        mDots = new ImageView[length];

        try {
            mWidth = (getScreenWidth() - mMargins * 2 - mHorizontalMargins * 2 * length) / length;
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.mDotNormalDrawable = makeNormalDrawable();
        this.mDotFocusDrawable = makeFocusDrawable();

        for (int i = 0; i < length; i++) {
            mDots[i] = new ImageView(getContext());
            LayoutParams dotLp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0F);
            dotLp.setMargins(mHorizontalMargins, 0, mHorizontalMargins, 0);
            mDots[i].setLayoutParams(dotLp);
            mDots[i].setBackground(mDotNormalDrawable);
            //设置ScaleType为FIT_XY,否则ProgressDrawable居中显示
            mDots[i].setScaleType(ImageView.ScaleType.FIT_XY);
            addView(mDots[i]);
        }

        setCurrent(0, duration);
    }

    @Override
    public void setCurrent(int current, int duration) {
        if (current < 0 || current > length - 1) {
            return;
        }
        mDots[lastPosition].setBackground(mDotNormalDrawable);
        mDots[current].setBackground(mDotFocusDrawable);
        mDotFocusDrawable.reStart(duration);
        lastPosition = current;
    }

    /**
     * dp转px
     *
     * @param dpValue dp值
     * @return px值
     */
    private int dp2px(float dpValue) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获取屏幕的宽度（单位：px）
     *
     * @return 屏幕宽px
     */
    private int getScreenWidth() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();// 创建了一张白纸
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(dm);// 给白纸设置宽高
        }
        return dm.widthPixels;
    }
}
