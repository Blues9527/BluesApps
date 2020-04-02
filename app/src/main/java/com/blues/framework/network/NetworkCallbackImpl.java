package com.blues.framework.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;

import androidx.annotation.NonNull;

public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {

    private NetworkDialog mDialog;

    public NetworkCallbackImpl(Context context) {
        if (context != null) {
            mDialog = new NetworkDialog(context);
        } else {
            Log.i("Blues", "context is null");
        }
    }

    @Override
    public void onAvailable(@NonNull Network network) {
        super.onAvailable(network);
        Log.i("Blues", "网络已连接");
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    @Override
    public void onUnavailable() {
        super.onUnavailable();
        Log.i("Blues", "没有网络连接");
        if (mDialog != null) {
            mDialog.show();
        }
    }

    @Override
    public void onLost(@NonNull Network network) {
        super.onLost(network);
        Log.i("Blues", "网络已断开");
        if (mDialog != null) {
            mDialog.show();
        }
    }


    @Override
    public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
            if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Blues", "网络类型切换为WIFI");
            } else {
                Log.i("Blues", "网络已切换为其他类型");
            }
        }
    }
}
