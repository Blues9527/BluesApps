package com.blues.framework.utils

import com.alibaba.fastjson.JSON

/**
 * File: com.blues.framework.utils.StringExt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-29
 **/

inline fun <reified T> String.fromJson(): T = JSON.parseObject(this, T::class.java)


