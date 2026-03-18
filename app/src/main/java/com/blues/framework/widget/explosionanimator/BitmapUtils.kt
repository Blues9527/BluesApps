package com.blues.framework.widget.explosionanimator

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import java.lang.OutOfMemoryError
import java.util.*

/**
 * 1.生成一张与原来一样的图片
 * 2.添加一个全屏动画显示场地
 * 3.动画执行
 * 3.1 震动
 * 3.2 缩小透明
 * 3.3 粒子爆炸
 * 3.4 view恢复原状
 */
object BitmapUtils {

    private val CANVAS = Canvas()
    @JvmField
    val RANDOM = Random()
    private const val DEFAULT_RETRY_COUNT = 1
    @JvmOverloads
    fun createBitmapFromView(v: View, retryCount: Int = DEFAULT_RETRY_COUNT): Bitmap? {

        //清除焦点，使view恢复原样
        v.clearFocus()
        val bitmap = createBitmapSafely(v.width, v.height, Bitmap.Config.ARGB_8888, retryCount)
        if (bitmap != null) {
            synchronized(CANVAS) {
                CANVAS.setBitmap(bitmap)
                v.draw(CANVAS)
                CANVAS.setBitmap(null)
            }
        }
        return bitmap
    }

    /**
     * 安全创建一个bitmap
     *
     * @param width      宽
     * @param height     高
     * @param config     bitmap配置
     * @param retryCount 重试次数
     * @return bitmap
     */
    private fun createBitmapSafely(width: Int, height: Int, config: Bitmap.Config,
        retryCount: Int): Bitmap? {
        try {
            return Bitmap.createBitmap(width, height, config)
        } catch (e: OutOfMemoryError) {
            e.printStackTrace()
            if (retryCount > 0) {
                System.gc()
                return createBitmapSafely(width, height, config, retryCount - 1)
            }
        }
        return null
    }
}