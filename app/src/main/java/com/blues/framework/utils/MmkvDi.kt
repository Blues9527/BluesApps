package com.blues.framework.utils

import com.tencent.mmkv.MMKV
import org.koin.dsl.module

/**
 * File: com.blues.framework.utils.MmkvUtils
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-09-10 11:07
 **/

val mmkv = module {
    single {
        MMKV.defaultMMKV()
    }
}