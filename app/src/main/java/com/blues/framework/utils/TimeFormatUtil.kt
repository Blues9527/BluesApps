package com.blues.framework.utils

/**
 * User : Blues
 * Date : 2019/8/28
 * Time : 14:23
 */
object TimeFormatUtil {

    fun formatTime(duration: Int): String {

        //获取分钟
        val minute = duration / 60
        //获取秒数
        val second = duration % 60

        return when {
            minute < 10 -> if (second == 0) "0$minute'" else "0$minute'$second\""
            else -> if (second == 0) "$minute'" else "$minute'$second\""
        }
    }
}