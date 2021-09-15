package com.blues.framework.widget.explosionanimator

import android.graphics.Bitmap
import android.graphics.Rect

class FallingParticleFactory : ParticleFactory() {

    companion object {

        const val PART_WH = 8 //默认小球宽高
    }

    override fun generateParticles(bitmap: Bitmap?, rect: Rect): Array<Array<Particle?>> {
        val w = rect.width()
        val h = rect.height()
        val partWCount = w / PART_WH //横向个数
        val partHCount = h / PART_WH //竖向个数
        val particles = Array<Array<Particle?>>(partHCount) { arrayOfNulls(partWCount) }
        bitmap?.let {
            val bitmapPartW = bitmap.width / partWCount
            val bitmapPartH = bitmap.height / partHCount
            for (row in 0 until partHCount) { //行
                for (column in 0 until partWCount) { //列
                    //取得当前粒子所在位置的颜色
                    val color = bitmap.getPixel(column * bitmapPartW, row * bitmapPartH)
                    val x = (rect.left + PART_WH * column).toFloat()
                    val y = (rect.top + PART_WH * row).toFloat()
                    particles[row][column] = FallingParticle(color, x, y, rect)
                }
            }
        }
        return particles
    }
}