package com.blues.framework.utils

import android.app.Activity
import android.content.Intent

/**
 * File: com.blues.framework.utils.ActivityExt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-09-28 14:04
 **/

inline fun <reified T> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}


