package com.blues.framework.utils

import android.content.Context
import android.view.WindowManager
import android.util.DisplayMetrics

/**
 * User : Blues
 * Date : 2019/3/6
 * Time : 15:37
 * Email : huajianlan@rastar.com
 */
object ScreenUtil {

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    @JvmStatic
    val screenWidth: Int
        get() {
            val wm = Utils.getContext()
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager

            val dm = DisplayMetrics()

            wm.defaultDisplay.getMetrics(dm)

            return dm.widthPixels
        }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    @JvmStatic
    val screenHeight: Int
        get() {
            val wm = Utils.getContext()
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager

            val dm = DisplayMetrics()

            wm.defaultDisplay.getMetrics(dm)

            return dm.heightPixels
        }
}