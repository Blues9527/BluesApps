package com.blues.framework.utils

/**
 * User : Blues
 * Date : 2019/8/28
 * Time : 14:23
 */
object TimeFormatUtil {

    @JvmStatic
    fun formatTime(duration: Int): String {
        val time: String
        val minute = duration / 60
        val second = duration % 60
        time = if (minute < 10) {
            if (second == 0) {
                String.format("0%s'", minute)
            } else {
                String.format("0%s'%s\"", minute, second)
            }
        } else {
            if (second == 0) {
                String.format("%s'", minute)
            } else {
                String.format("%s'%s\"", minute, second)
            }
        }
        return time
    }
}