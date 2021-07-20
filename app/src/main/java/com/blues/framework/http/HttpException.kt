package com.blues.framework.http

import java.lang.RuntimeException

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */
class HttpException : RuntimeException {

    constructor(errorType: ErrorType?) {
        getHttpExceptionMessage(errorType, null)
    }

    constructor(msg: String?) {
        getHttpExceptionMessage(null, msg)
    }

    enum class ErrorType(var message: String) {

        TYPE_PARSE_DATA_ERROR("数据解析错误"),

        TYPE_CONNECT_NETWORK_ERROR("网络连接异常"),

        TYPE_SERVER_RETURNS_ERROR("服务器返回错误");

    }

    companion object {

        /**
         * 对服务器接口传过来的错误信息进行统一处理
         * 免除在Activity的过多的错误判断
         */
        private fun getHttpExceptionMessage(errorType: ErrorType?, msg: String?): String? {
            return when (errorType) {
                ErrorType.TYPE_PARSE_DATA_ERROR -> ErrorType.TYPE_PARSE_DATA_ERROR.message
                ErrorType.TYPE_SERVER_RETURNS_ERROR -> ErrorType.TYPE_SERVER_RETURNS_ERROR.message
                ErrorType.TYPE_CONNECT_NETWORK_ERROR -> ErrorType.TYPE_CONNECT_NETWORK_ERROR.message
                else -> msg
            }
        }
    }
}