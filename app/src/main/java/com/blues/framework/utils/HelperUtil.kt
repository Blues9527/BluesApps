package com.blues.framework.utils

import android.util.Log
import android.widget.Toast
import com.blues.application.BluesApplication

/**
 * User : Blues
 * Date : 2019/8/15
 * Time : 11:04
 */
object HelperUtil {

    private const val GLOBAL_TAG = "Blues"
    var LOGGER_SWITCH_ON = true

    fun showToast(str: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BluesApplication.app, str, duration).show()
    }

    fun showSimpleLog(str: String?) {
        if (LOGGER_SWITCH_ON) Log.i(GLOBAL_TAG, String.format("=====> %s <=====", str))
    }

    /**
     * 校验参数不为空串
     */
    fun checkEmpty(args: List<String>): Boolean {
        var result = false
        args.forEach {
            if (it.isEmpty()) {
                result = true
            }
        }
        return result
    }
}