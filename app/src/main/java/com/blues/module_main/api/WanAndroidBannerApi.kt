package com.blues.module_main.api

import retrofit2.http.GET
import com.blues.module_main.model.WanAndroidBannerEntity

/**
 * @author lanhuajian
 * create at 2020/5/4 21:56
 */
interface WanAndroidBannerApi {

    /**
     * wan android 获取banner
     *
     * @return
     */
    @GET("banner/json")
    suspend fun getBanner(): WanAndroidBannerEntity
}