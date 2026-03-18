package com.blues.framework.widget.endlessbannerview.hintview

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import com.blues.framework.utils.dp

/**
 * Created by Mr.Jude on 2016/1/10.
 */
class ColorPointHintView(context: Context?, private val focusColor: Int,
    private val normalColor: Int) : ShapeHintView(context) {

    override fun makeFocusDrawable(): Drawable {
        return GradientDrawable().apply {
            setColor(focusColor)
            cornerRadius = 4f.dp
            setSize(8f.dp.toInt(), 8f.dp.toInt())
        }
    }

    override fun makeNormalDrawable(): Drawable {
        return GradientDrawable().apply {
            setColor(normalColor)
            cornerRadius = 4f.dp
            setSize(8f.dp.toInt(), 8f.dp.toInt())
        }
    }
}