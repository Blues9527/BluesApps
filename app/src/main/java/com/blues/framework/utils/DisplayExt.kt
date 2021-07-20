package com.blues.framework.utils

import android.content.res.Resources
import android.util.TypedValue

/**
 * File: com.blues.framework.utils.DisplayExt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16 17:38
 **/

val Float.dp: Float
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

val Int.dp: Float
    get() = this.toFloat().dp