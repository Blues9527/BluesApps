package com.blues.framework.utils;

import android.util.Log;
import android.widget.Toast;

/**
 * User : Blues
 * Date : 2019/8/15
 * Time : 11:04
 */

public class HelperUtil {

    private static final String GLOBAL_TAG = "Blues";
    public static boolean LOGGER_SWITCH_ON = true;

    private HelperUtil() {
        throw new UnsupportedOperationException("please init Utils from HelperUtil");
    }

    public static void showToastShort(String str) {
        Toast.makeText(Utils.getContext(), str, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(String str) {
        Toast.makeText(Utils.getContext(), str, Toast.LENGTH_LONG).show();
    }

    public static void showSimpleLog(String str) {
        if (LOGGER_SWITCH_ON)
            Log.i(GLOBAL_TAG, String.format("=====> %s <=====", str));
    }

    public static void showMultiLogs(String... strs) {
        if (LOGGER_SWITCH_ON)
            for (String str : strs) Log.i(GLOBAL_TAG, String.format("=====> %s <=====", str));
    }
}
