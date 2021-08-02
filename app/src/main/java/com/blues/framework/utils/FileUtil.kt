package com.blues.framework.utils

import android.content.Context
import android.util.Log
import com.blues.application.BluesApplication
import java.io.File
import java.io.IOException

/**
 * File: com.blues.framework.utils.FileUtil.kt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021/8/2
 **/

object FileUtil {

    /**
     * @return 创建缓存目录
     */
    @JvmStatic
    val cacheDirectory: File
        get() {

            val file = File(BluesApplication.app.externalCacheDir, "Cache")
            if (!file.exists()) {
                val b = file.mkdirs()
                Log.e("Blues", "Cache" + "缓存文件夹不存在，创建" + if (b) "成功" else "失败")
            } else {
                Log.e("Blues", "Cache" + "缓存文件夹已存在")
            }
            return file
        }

    /**
     * 获取Asset沐流文件数据
     *
     * @param context
     * @param fileName
     * @return
     */
    @JvmStatic
    fun getAssetsFile(context: Context, fileName: String): String {
        var result = ""
        try {
            val assetManager = context.assets
            val inputStream = assetManager.open(fileName)
            val buffer = ByteArray(inputStream.available())
            val sum = inputStream.read(buffer)
            if (sum != 0) {
                result = String(buffer, Charsets.UTF_8)

            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return result
    }
}