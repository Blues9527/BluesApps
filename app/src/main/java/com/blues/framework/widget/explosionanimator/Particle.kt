package com.blues.framework.widget.explosionanimator

import android.graphics.Canvas
import android.graphics.Paint

/**
 * 粒子
 */
abstract class Particle(var color: Int, var cx: Float, var cy: Float) {

    protected abstract fun draw(canvas: Canvas, paint: Paint)
    protected abstract fun calculate(factor: Float)
    fun advance(canvas: Canvas, paint: Paint, factor: Float) {
        calculate(factor)
        draw(canvas, paint)
    }
}