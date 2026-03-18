package com.blues.framework.utils

import android.content.res.Resources
import android.util.TypedValue

/**
 * File: com.blues.framework.utils.DisplayExt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16
 **/

//------------------转换成 dp-----------------//
val Float.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.dp: Float
    get() = this.toFloat().dp


//------------------转换成 sp-------------------//
val Float.sp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.sp: Float
    get() = this.toFloat().sp