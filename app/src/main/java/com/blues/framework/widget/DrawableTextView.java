package com.blues.framework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.blues.framework.utils.SizeUtil;

import androidx.annotation.Nullable;

public class DrawableTextView extends TextView {

    public DrawableTextView(Context context) {
        this(context, null);
    }

    public DrawableTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //Returns drawables for the left, top, right, and bottom borders.
        Drawable[] drawables = getCompoundDrawables();
        Drawable leftDrawable = drawables[0];
        if (leftDrawable != null) {
            // 得到leftDrawable的宽度

            int leftDrawableWidth = leftDrawable.getIntrinsicWidth();

            // 得到drawable与text之间的间距

            int drawablePadding = getCompoundDrawablePadding();

            // 得到文本的宽度

            int textWidth = (int) getPaint().measureText(getText().toString().trim());

            int bodyWidth = leftDrawableWidth + drawablePadding + textWidth;

            canvas.save();

            canvas.translate((getWidth() - bodyWidth) >> 1, 0);
        }

        super.onDraw(canvas);
    }
}
