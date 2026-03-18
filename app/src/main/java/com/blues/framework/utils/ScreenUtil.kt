package com.blues.framework.utils

import android.content.Context
import android.view.WindowManager
import android.util.DisplayMetrics
import com.blues.application.BluesApplication

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
            val wm = BluesApplication.app.getSystemService(Context.WINDOW_SERVICE) as WindowManager

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
            val wm = BluesApplication.app.getSystemService(Context.WINDOW_SERVICE) as WindowManager

            val dm = DisplayMetrics()

            wm.defaultDisplay.getMetrics(dm)

            return dm.heightPixels
        }

    /**
     * 获取状态栏高度
     */
    val statusBarHeight: Int
        get() {
            val resources = BluesApplication.app.resources
            val resId = resources.getIdentifier(
                "status_bar_height",
                "dimen",
                "android"
            )
            return if (resId > 0) resources.getDimensionPixelSize(resId) else 0
        }
}