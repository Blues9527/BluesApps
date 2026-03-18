package com.blues.framework.widget.explosionanimator

import android.graphics.Bitmap
import android.graphics.Rect

abstract class ParticleFactory {

    abstract fun generateParticles(bitmap: Bitmap?, rect: Rect): Array<Array<Particle?>>
}