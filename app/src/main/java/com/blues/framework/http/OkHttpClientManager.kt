package com.blues.framework.http

import android.util.Log
import com.blues.framework.utils.FileUtil.cacheDirectory
import com.blues.framework.utils.NetWorkUtil.isConnected
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */
object OkHttpClientManager {

    private val cache = Cache(cacheDirectory, 100 * 1024 * 1024)

    //打印请求连接和参数
    private val loggingInterceptor = HttpLoggingInterceptor { message -> Log.e("Blues", message) }.setLevel(HttpLoggingInterceptor.Level.BODY)

    /**
     * 云端响应头拦截器
     * 用于添加统一请求头  请按照自己的需求添加
     */
    private val interceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val authorised = originalRequest.newBuilder()
            .addHeader("user-agent", "Android")
            .build()
        chain.proceed(authorised)
    }

    // 云端响应头拦截器，用来配置缓存策略
    private val networkInterceptor = Interceptor { chain ->
        var request = chain.request()
        request = if (isConnected) {
            Log.e("Blues", "有网络")
            request.newBuilder() //走网络
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()
        } else {
            Log.e("Blues", "无网络")
            request.newBuilder() //只走缓存
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
        }
        val originalResponse = chain.proceed(request)
        val response = if (isConnected) { //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
            val maxAge = 0 //在线缓存不可读取
            originalResponse.newBuilder()
                .header("Cache-Control", "public, max-age=$maxAge")
                .removeHeader("Pragma")
                .build()
        } else { //无网络时
            val maxStale = 60 * 60 * 24 * 365 //缓存保存时间为365天
            originalResponse.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                .removeHeader("Pragma")
                .build()
        }
        response
    }

    //添加拦截器
    //设置连接、读写超时时间
    //错误重连
    val instance: OkHttpClient
        get() = OkHttpClient.Builder() //添加拦截器
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(networkInterceptor) //设置连接、读写超时时间
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS) //错误重连
            .retryOnConnectionFailure(true)
            .cache(cache)
            .hostnameVerifier { _, _ -> true }
            .sslSocketFactory(createSSLSocketFactory(),TrustAllCerts())
            .build()

    private fun createSSLSocketFactory(): SSLSocketFactory? {
        var ssfFactory: SSLSocketFactory? = null
        try {
            val sc = SSLContext.getInstance("TLS")
            sc.init(null, arrayOf<TrustManager>(TrustAllCerts()), SecureRandom())
            ssfFactory = sc.socketFactory
        } catch (e: Exception) {
            e.localizedMessage?.let { Log.e("Blues", it) }
        }
        return ssfFactory
    }
}

class TrustAllCerts : X509TrustManager {
    @Throws(CertificateException::class)
    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
    }

    @Throws(CertificateException::class)
    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
    }

    override fun getAcceptedIssuers(): Array<X509Certificate?> {
        return arrayOfNulls(0)
    }
}