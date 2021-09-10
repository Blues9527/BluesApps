package com.blues.framework.utils

import android.content.Context
import android.net.NetworkInfo
import android.net.ConnectivityManager
import com.blues.application.BluesApplication

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */
object NetWorkUtil {

    //判断网络是否连接
    val isConnected: Boolean
        get() = activeNetworkInfo.isConnected

    //需要添加权限 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    private val activeNetworkInfo: NetworkInfo
        get() = (BluesApplication.app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo!!
}