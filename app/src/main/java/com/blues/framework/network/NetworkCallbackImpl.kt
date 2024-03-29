package com.blues.framework.network

import android.content.Context
import android.net.ConnectivityManager.NetworkCallback
import com.blues.framework.network.NetworkDialog
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log

class NetworkCallbackImpl(context: Context?) : NetworkCallback() {

    private val mDialog: NetworkDialog = NetworkDialog(context!!)

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        Log.i("Blues", "网络已连接")
        mDialog.dismiss()
    }

    override fun onUnavailable() {
        super.onUnavailable()
        Log.i("Blues", "没有网络连接")
        mDialog.show()
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        Log.i("Blues", "网络已断开")
        mDialog.show()
    }

    override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities)
        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
            if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Blues", "网络类型切换为WIFI")
            } else {
                Log.i("Blues", "网络已切换为其他类型")
            }
        }
    }
}