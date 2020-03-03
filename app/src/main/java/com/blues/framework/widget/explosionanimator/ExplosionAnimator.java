package com.blues.framework.widget.explosionanimator;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class ExplosionAnimator extends ValueAnimator {

    private static final int DEFAULT_DURATION = 1500;

    private View mContainer;
    private Paint mPaint;
    private Particle[][] mParticles;
    private ParticleFactory mParticleFactory;

    public ExplosionAnimator(View field, Bitmap bitmap, Rect rect, ParticleFactory particleFactory) {
        mParticleFactory = particleFactory;
        mPaint = new Paint();
        mContainer = field;
        setFloatValues(0.0f, 1.0f);
        setDuration(DEFAULT_DURATION);
        mParticles = mParticleFactory.generateParticles(bitmap, rect);
    }

    public void draw(Canvas canvas) {
        if (!isStarted()) {
            return;
        }

        for (Particle[] mParticle : mParticles) {
            for (Particle particle : mParticle) {
                particle.advance(canvas, mPaint, (float) getAnimatedValue());
            }
        }
        mContainer.invalidate();
    }

    @Override
    public void start() {
        super.start();
        mContainer.invalidate();
    }
}
