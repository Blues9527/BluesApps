package com.blues.framework.utils

import com.google.gson.Gson

/**
 * User : Blues
 * Date : 2019/8/13
 * Time : 16:35
 */
object JsonUtil {

    fun <T> convertToEntity(source: String?, clazz: Class<T>?): T {
        return Gson().fromJson(source, clazz)
    }
}