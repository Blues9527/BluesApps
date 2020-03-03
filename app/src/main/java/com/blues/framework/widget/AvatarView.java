package com.blues.framework.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.blues.R;

/**
 * User : Blues
 * Date : 2019/7/16
 * Time : 09:57
 */

public class AvatarView extends View {

    private Bitmap defaultBitmap;
    private static final String TAG = "Blues";
    private Bitmap mBitmap;

    public AvatarView(Context context) {
        this(context, null);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.AvatarView);
        int bitmapResId = ta.getResourceId(R.styleable.AvatarView_Src, 0);

        ta.recycle();

        defaultBitmap = BitmapFactory.decodeResource(getContext().getResources(), bitmapResId);
    }

    private Bitmap drawCircleView() {

        int w = getWidth();
        int h = getHeight();

        Bitmap bitmap = createBitmapSafely(w, h, Bitmap.Config.ARGB_8888, 1);
        if (bitmap == null) {
            Log.d(TAG, "bitmap is null ,return ");
            return null;
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        int radius = Math.min(w, h) / 2;

        canvas.drawCircle(w >> 1, h >> 1, radius, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        Matrix matrix = new Matrix();

        if (defaultBitmap != null) {
            matrix.postScale((float) w / defaultBitmap.getWidth(), (float) h / defaultBitmap.getHeight(), 0, 0);

            canvas.drawBitmap(defaultBitmap, matrix, paint);
        } else {
            matrix.postScale((float) w / getBitmap().getWidth(), (float) h / getBitmap().getHeight(), 0, 0);

            canvas.drawBitmap(getBitmap(), matrix, paint);
        }

        return bitmap;
    }

    private Bitmap createBitmapSafely(int width, int height, Bitmap.Config config, int retryCount) {
        try {
            return Bitmap.createBitmap(width, height, config);
        } catch (Exception e) {
            e.printStackTrace();
            if (retryCount > 0) {
                System.gc();
                return createBitmapSafely(width, height, config, retryCount - 1);
            }
        }
        return null;
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (drawCircleView() != null) {
            canvas.drawBitmap(drawCircleView(), 0, 0, null);
        }
    }

}
