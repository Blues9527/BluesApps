package com.blues.framework.widget

import android.content.Context
import android.util.AttributeSet
import android.graphics.Canvas
import android.widget.TextView

class DrawableTextView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : TextView(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas) {

        val drawables = compoundDrawables
        val leftDrawable = drawables[0]
        if (leftDrawable != null) {
            // 得到leftDrawable的宽度
            val leftDrawableWidth = leftDrawable.intrinsicWidth

            // 得到drawable与text之间的间距
            val drawablePadding = compoundDrawablePadding

            // 得到文本的宽度
            val textWidth = paint.measureText(text.toString().trim { it <= ' ' }).toInt()
            val bodyWidth = leftDrawableWidth + drawablePadding + textWidth
            canvas.save()
            canvas.translate((width - bodyWidth shr 1).toFloat(), 0f)
        }
        super.onDraw(canvas)
    }
}