package com.blues.framework.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public final class NetWorkUtil {

    private NetWorkUtil() {
        throw new UnsupportedOperationException("please init Utils from NetWorkUtil");
    }

    public static boolean isConnected() {
        NetworkInfo info = getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    //需要添加权限 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    private static NetworkInfo getActiveNetworkInfo() {
        return ((ConnectivityManager) Utils.getContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
    }
}
