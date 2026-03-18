package com.blues.framework.http

import com.blues.framework.utils.NetWorkUtil.isConnected
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */
abstract class HttpCallBack<T> {

    abstract fun onSuccess(data: T)
    abstract fun onFailure(error: String?)
    fun onFailure(e: Throwable) {
        if (e is HttpException || e is UnknownHostException) {
            onFailure("很抱歉，服务器开小差了")
        } else if (!isConnected || e is SocketTimeoutException) {
            onFailure("网络不给力，请查看网络或稍后重试")
        } else {
            onFailure(e.localizedMessage)
        }
    }
}