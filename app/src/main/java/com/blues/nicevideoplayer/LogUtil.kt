package com.blues.nicevideoplayer
import android.util.Log

/**
 * Created by XiaoJianjun on 2017/5/4.
 * log工具.
 */
object LogUtil {

    private const val TAG = "NiceVideoPlayer"
    @JvmStatic
    fun d(message: String?) {
        Log.d(TAG, message!!)
    }

    fun i(message: String?) {
        Log.i(TAG, message!!)
    }

    @JvmStatic
    fun e(message: String?, throwable: Throwable?) {
        Log.e(TAG, message, throwable)
    }
}