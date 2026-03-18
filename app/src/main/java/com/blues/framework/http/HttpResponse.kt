package com.blues.framework.http

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */
class HttpResponse<T> {

    var code = 0
    var msg: String? = null
    var result: T? = null

    override fun toString(): String {
        return "HttpResponse{code=$code, msg='$msg', result=$result}"
    }
}