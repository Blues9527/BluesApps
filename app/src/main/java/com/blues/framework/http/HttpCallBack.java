package com.blues.framework.http;

import android.util.Log;

import com.blues.framework.utils.NetWorkUtil;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public abstract class HttpCallBack<T> {

    public abstract void onSuccess(T data);

    public abstract void onFailure(String error);

    public void onFailure(Throwable e) {
        String msg;
        if (e instanceof HttpException || e instanceof UnknownHostException) {
            onFailure(msg = "很抱歉，服务器开小差了");
        } else if (!NetWorkUtil.isConnected() || e instanceof SocketTimeoutException) {
            onFailure(msg = "网络不给力，请查看网络或稍后重试");
        } else {
            onFailure(msg = e.getLocalizedMessage());
        }
        Log.e("Blues", msg);
    }
}
