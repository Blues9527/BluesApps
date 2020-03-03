package com.blues.framework.widget.explosionanimator;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 粒子
 */
public abstract class Particle {

    float cx;
    float cy;
    int color;

    public Particle(int color, float x, float y) {
        cx = x;
        cy = y;
        this.color = color;
    }

    protected abstract void draw(Canvas canvas, Paint paint);

    protected abstract void calculate(float factor);

    public void advance(Canvas canvas, Paint paint, float factor) {
        calculate(factor);
        draw(canvas, paint);

    }
}
