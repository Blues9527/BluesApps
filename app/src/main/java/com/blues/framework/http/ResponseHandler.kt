package com.blues.framework.http

import retrofit2.HttpException
import java.lang.Exception
import java.net.SocketTimeoutException

enum class ErrorCodes(val code: Int) { SocketTimeOut(-1)
}

open class ResponseHandler {

    fun <T : Any> handleSuccess(data: T): Response<T> {
        return Response.success(data)
    }

    fun <T : Any> handleException(e: Exception): Response<T> {
        return when (e) {
            is HttpException -> Response.error(getErrorMessage(e.code()), null)
            is SocketTimeoutException -> Response.error(getErrorMessage(ErrorCodes.SocketTimeOut.code), null)
            else -> Response.error(getErrorMessage(Int.MAX_VALUE), null)
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            ErrorCodes.SocketTimeOut.code -> "Timeout"
            401 -> "Unauthorised"
            404 -> "Not found"
            else -> "Something went wrong"
        }
    }
}
