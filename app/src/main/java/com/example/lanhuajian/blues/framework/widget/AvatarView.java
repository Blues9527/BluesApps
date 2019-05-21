package com.example.lanhuajian.blues.framework.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * User : Blues
 * Date : 2019/4/12
 * Time : 15:29
 */

public class AvatarView extends AppCompatImageView {

    private static final String TAG = "Blues";
    private Bitmap bitmap;

    public AvatarView(Context context) {
        this(context, null);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (bitmap == null) return;

        int bw = bitmap.getWidth();
        int bh = bitmap.getHeight();

        int sizeW = MeasureSpec.getSize(widthMeasureSpec);
        int sizeH = MeasureSpec.getSize(heightMeasureSpec);
        int modeW = MeasureSpec.getMode(widthMeasureSpec);
        int modeH = MeasureSpec.getMode(heightMeasureSpec);

        if (modeW == MeasureSpec.AT_MOST)
            sizeW = bw;

        if (modeH == MeasureSpec.AT_MOST)
            sizeH = bh;

        setMeasuredDimension(sizeW, sizeH);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap != null) {
            canvas.drawBitmap(getCircleView(), 0, 0, null);
        }
    }

    public void setCircleView(Bitmap bitmap) {
        this.bitmap = bitmap;
        invalidate();
    }

    public Bitmap getCircleView() {

        int w = getWidth();
        int h = getHeight();

        Log.i(TAG, "width--->" + w);
        Log.i(TAG, "height--->" + h);

        Bitmap mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mBitmap);
        Paint paint = new Paint();

        int radius = Math.min(w, h)/2;
        canvas.drawCircle(w >> 1, h >> 1, radius, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        Matrix matrix = new Matrix();

        matrix.postScale((float) w / bitmap.getWidth(), (float) h / bitmap.getHeight(), 0, 0);

        canvas.drawBitmap(bitmap, matrix, paint);

        return mBitmap;
    }
}
