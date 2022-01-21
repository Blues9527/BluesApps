package com.blues.framework.utils

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment

/**
 * File: com.blues.framework.utils.ActivityExt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-09-28 14:04
 **/

//Activity扩展快速跳转
inline fun <reified T> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}

//Fragment扩展快速跳转
inline fun <reified T> Fragment.startActivity() {
    requireActivity().startActivity(Intent(requireActivity(), T::class.java))
}


