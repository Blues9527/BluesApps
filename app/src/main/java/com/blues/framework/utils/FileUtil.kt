package com.blues.framework.utils

import android.content.Context
import kotlin.Throws
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.lang.StringBuilder
import java.nio.charset.StandardCharsets

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */
object FileUtil {

    /**
     * @return 创建缓存目录
     */
    @JvmStatic
    val cacheDirectory: File
        get() {
            val file = File(Utils.getContext().externalCacheDir, "Cache")
            if (!file.exists()) {
                val b = file.mkdirs()
                Log.e("Blues", "Cache" + "缓存文件夹不存在，创建" + if (b) "成功" else "失败")
            } else {
                Log.e("Blues", "Cache" + "缓存文件夹已存在")
            }
            return file
        }

    /**
     * @param path
     */
    @Throws(IOException::class)
    fun read(path: String?): String {

        //用StringBuffer 线程安全
        val sb = StringBuffer() //先读成文件的形式
        val file = File(path) //通过文件流来读
        val fios = FileInputStream(file) //用于循环
        var len: Int //定义一个字节数组，用于存放读出来的内容
        val bytes = ByteArray(1024) //while循环通过fios读数据
        while (fios.read(bytes).also { len = it } != -1) { //将读出来的数据存入StringBuffer，默认使用utf-8 中文字符集
            sb.append(String(bytes, 0, len, StandardCharsets.UTF_8))
        } //流用完后记得要关闭
        fios.close()
        return sb.toString()
    }

    /**
     * 从assets文件中读取json数据
     * @param fileName json格式文件名
     * @return json字符串
     */
    fun readJson(fileName: String): String { //用StringBuffer 线程安全
        val sb = StringBuilder()
        var inputStream: InputStream? = null
        try {
            inputStream = Utils.getContext().resources.assets.open(fileName) //用于循环
            var len: Int //定义一个字节数组，用于存放读出来的内容
            val bytes = ByteArray(1024) //while循环通过in读数据
            while (inputStream.read(bytes)
                    .also { len = it } != -1
            ) { //将读出来的数据存入StringBuilder，默认使用utf-8 中文字符集
                sb.append(String(bytes, 0, len, StandardCharsets.UTF_8))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            try {
                inputStream?.close()
            } catch (e1: IOException) {
                e1.printStackTrace()
            }
        }
        return sb.toString()
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