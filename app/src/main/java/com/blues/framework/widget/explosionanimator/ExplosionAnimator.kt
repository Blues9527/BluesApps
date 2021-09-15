package com.blues.framework.widget.explosionanimator

import android.animation.ValueAnimator
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View

class ExplosionAnimator(private val view: View, bitmap: Bitmap?, rect: Rect,
    mParticleFactory: ParticleFactory) : ValueAnimator() {

    companion object {

        private const val DEFAULT_DURATION = 1500
    }

    private val mPaint: Paint = Paint()
    private val mParticles: Array<Array<Particle?>>

    init {
        setFloatValues(0.0f, 1.0f)
        duration = DEFAULT_DURATION.toLong()
        mParticles = mParticleFactory.generateParticles(bitmap, rect)
    }

    fun draw(canvas: Canvas) {
        if (!isStarted) {
            return
        }
        for (mParticle in mParticles) {
            for (particle in mParticle) {
                particle?.advance(canvas, mPaint, animatedValue as Float)
            }
        }
        view.invalidate()
    }

    override fun start() {
        super.start()
        view.invalidate()
    }
}