package com.example.lanhuajian.blues.framework.utils;

/**
 * User : Blues
 * Date : 2019/8/28
 * Time : 14:23
 */

public class TimeFormatUtil {

    private TimeFormatUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String formatTime(int duration) {

        String time;

        int minute = duration / 60;
        int second = duration % 60;

        if (minute < 10) {
            if (second == 0) {
                time = String.format("0%s'", minute);
            } else {
                time = String.format("0%s'%s\"", minute, second);
            }
        } else {
            if (second == 0) {
                time = String.format("%s'", minute);
            } else {
                time = String.format("%s'%s\"", minute, second);
            }
        }
        return time;
    }
}
