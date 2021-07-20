package com.blues.framework.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */
object RetrofitManager {

    @JvmStatic
    var baseUrl = ""

    @JvmStatic
    val instance: Retrofit
        get() = Retrofit.Builder()
            .client(OkHttpClientManager.instance)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl(baseUrl)
            .build()
}