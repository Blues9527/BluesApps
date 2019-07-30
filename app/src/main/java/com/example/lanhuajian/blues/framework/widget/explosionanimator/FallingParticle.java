package com.example.lanhuajian.blues.framework.widget.explosionanimator;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class FallingParticle extends Particle {

    float radius = FallingParticleFactory.PART_WH;
    float alpha = 1.0f;
    Rect mRect;

    public FallingParticle(int color, float cx, float cy, Rect rect) {
        super(color, cx, cy);
        mRect = rect;
    }

    @Override
    protected void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setAlpha((int) (Color.alpha(color) * alpha));
        canvas.drawCircle(cx, cy, radius, paint);

    }

    @Override
    protected void calculate(float factor) {
        cx += factor * BitmapUtils.RANDOM.nextInt(mRect.width()) * ((BitmapUtils.RANDOM.nextFloat() - 0.5f));
        cy += factor * BitmapUtils.RANDOM.nextInt(mRect.height() / 2);
        radius -= factor * BitmapUtils.RANDOM.nextInt(2);
        alpha = (1f - factor) * (BitmapUtils.RANDOM.nextFloat() + 1);
    }
}
