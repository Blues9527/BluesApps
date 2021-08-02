package com.blues.framework.utils

import android.util.Log
import android.widget.Toast
import com.blues.application.BluesApplication
import com.blues.framework.utils.HelperUtil
import com.google.android.material.snackbar.BaseTransientBottomBar

/**
 * User : Blues
 * Date : 2019/8/15
 * Time : 11:04
 */
object HelperUtil {

    private const val GLOBAL_TAG = "Blues"
    var LOGGER_SWITCH_ON = true

    @JvmStatic
    @JvmOverloads
    fun showToast(str: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BluesApplication.app, str, duration)
            .show()
    }

    @JvmStatic
    fun showSimpleLog(str: String?) {
        if (LOGGER_SWITCH_ON) Log.i(GLOBAL_TAG, String.format("=====> %s <=====", str))
    }

}