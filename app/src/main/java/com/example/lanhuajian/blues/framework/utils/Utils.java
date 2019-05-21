package com.example.lanhuajian.blues.framework.utils;

import android.annotation.SuppressLint;
import android.content.Context;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

//统一初始化util类
public final class Utils {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    private Utils() {
        throw new UnsupportedOperationException("please init Utils from Utils");
    }

    public static void init(Context context) {
        Utils.mContext = context.getApplicationContext();
    }

    public static Context getContext() {
        if (mContext != null) return mContext;
        throw new NullPointerException("please init Utils from Utils");
    }
}
