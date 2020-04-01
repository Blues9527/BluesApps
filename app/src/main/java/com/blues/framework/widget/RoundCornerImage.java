package com.blues.framework.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.blues.R;


/**
 * User : Blues
 * Date : 2019/8/5
 * Time : 15:47
 */

public class RoundCornerImage extends View {

    private float radius_all = 0;//圆角弧度
    private float radius_left_top, radius_left_bottom, radius_right_top, radius_right_bottom;
    private Drawable imgSrc;
    private Bitmap mBitmap;

    private int width, height;

    public RoundCornerImage(Context context) {
        this(context, null);
    }

    public RoundCornerImage(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundCornerImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RoundCornerImage);
        radius_all = ta.getDimension(R.styleable.RoundCornerImage_radius_all, radius_all);
        radius_left_top = ta.getDimension(R.styleable.RoundCornerImage_radius_left_top, radius_all);
        radius_left_bottom = ta.getDimension(R.styleable.RoundCornerImage_radius_left_bottom, radius_all);
        radius_right_top = ta.getDimension(R.styleable.RoundCornerImage_radius_right_top, radius_all);
        radius_right_bottom = ta.getDimension(R.styleable.RoundCornerImage_radius_right_bottom, radius_all);
        imgSrc = ta.getDrawable(R.styleable.RoundCornerImage_image_src);
        ta.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (imgSrc == null && getBitmap() == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (imgSrc != null) {
            drawRoundCorner(canvas, getBitmapFromDrawable(imgSrc));
        } else {
            drawRoundCorner(canvas, getBitmap());
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    private void drawRoundCorner(Canvas canvas, Bitmap bitmap) {

        Paint paint = new Paint();
        paint.setColor(0xffffffff);
        paint.setAntiAlias(true);

        canvas.saveLayer(0, 0, width, height, null, Canvas.ALL_SAVE_FLAG);

        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(rectF, radius_all, radius_all, paint);

        //SRC_IN 只显示两层图片交集部分的上层图像
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        //Bitmap缩放
        float scaleWidth = ((float) getWidth()) / bitmap.getWidth();
        float scaleHeight = ((float) getHeight()) / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();
    }

    // 获取Bitmap内容
    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        try {
            Bitmap bitmap;
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            } else if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }
}
