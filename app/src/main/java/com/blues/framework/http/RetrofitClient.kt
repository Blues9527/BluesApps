package com.blues.framework.http

import com.blues.constant.*
import com.blues.framework.http.typeadapter.DoubleDefaultAdapter
import com.blues.framework.http.typeadapter.IntegerDefaultAdapter
import com.blues.framework.http.typeadapter.LongDefaultAdapter
import com.google.gson.GsonBuilder
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * File: com.blues.framework.http.RetrofitClient
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16 18:36
 **/

val networkModule = module {
    single(named(WANANDROID)) { provideRetrofit(BASE_WANANDROID_URL) }
    single(named(KAIYAN)) { provideRetrofit(BASE_KAIYAN_URL) }
    single(named(GANKIO)) { provideRetrofit(BASE_GANKIO_URL) }
    factory { ResponseHandler() }
}

fun provideRetrofit(baseUrl: String): Retrofit {
    return Retrofit.Builder().client(OkHttpClientManager.instance)
        .addConverterFactory(GsonConverterFactory.create(buildGson()))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).baseUrl(baseUrl).build()
}

/**
 * 增加后台返回""和"null"的处理
 * 1.int=>0
 * 2.double=>0.00
 * 3.long=>0L
 */
private fun buildGson() = GsonBuilder().registerTypeAdapter(Int::class.java, IntegerDefaultAdapter())
    .registerTypeAdapter(Int::class.javaPrimitiveType, IntegerDefaultAdapter())
    .registerTypeAdapter(Double::class.java, DoubleDefaultAdapter())
    .registerTypeAdapter(Double::class.javaPrimitiveType, DoubleDefaultAdapter())
    .registerTypeAdapter(Long::class.java, LongDefaultAdapter())
    .registerTypeAdapter(Long::class.javaPrimitiveType, LongDefaultAdapter()).create()
