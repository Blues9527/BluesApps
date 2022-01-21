package com.blues.framework.utils

import com.alibaba.fastjson.JSON
import com.google.gson.Gson

/**
 * File: com.blues.framework.utils.StringExt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-29
 **/

//fastJson
inline fun <reified T> String.fromJson(): T = JSON.parseObject(this, T::class.java)

//Gson
inline fun <reified T> String.convertToEntity(): T = Gson().fromJson(this, T::class.java)


