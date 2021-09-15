package com.blues.framework.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText

/**
 * File: com.blues.framework.widget.NoTouchEditText
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-09-15 17:55
 **/

class NoTouchEditText(context: Context, attrs: AttributeSet?) : AppCompatEditText(context, attrs) {

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return false
    }
}