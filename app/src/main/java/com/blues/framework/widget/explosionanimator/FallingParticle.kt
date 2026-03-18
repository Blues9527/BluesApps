package com.blues.framework.widget.explosionanimator

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect

class FallingParticle(color: Int, cx: Float, cy: Float, var mRect: Rect) : Particle(color, cx, cy) {

    var radius = FallingParticleFactory.PART_WH.toFloat()
    var alpha = 1.0f
    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = color
        paint.alpha = (Color.alpha(color) * alpha).toInt()
        canvas.drawCircle(cx, cy, radius, paint)
    }

    override fun calculate(factor: Float) {
        cx += factor * BitmapUtils.RANDOM.nextInt(
                mRect.width()) * (BitmapUtils.RANDOM.nextFloat() - 0.5f)
        cy += factor * BitmapUtils.RANDOM.nextInt(mRect.height() / 2)
        radius -= factor * BitmapUtils.RANDOM.nextInt(2)
        alpha = (1f - factor) * (BitmapUtils.RANDOM.nextFloat() + 1)
    }
}