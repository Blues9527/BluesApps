package com.blues.module_main.service

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import com.blues.module_main.model.WanAndroidBannerEntity
import com.blues.module_main.api.WanAndroidBannerApi
import retrofit2.Retrofit

/**
 * File: com.blues.module_main.service.WanAndroidBannerRepository
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16 22:51
 **/

class WanAndroidBannerRepository(private val wanAndroidApi: WanAndroidBannerApi,
    private val responseHandler: ResponseHandler) {

    suspend fun getBanner(): Response<WanAndroidBannerEntity> {
        return try {
            val response = wanAndroidApi.getBanner()
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}

fun provideBannerApi(
    retrofit: Retrofit): WanAndroidBannerApi = retrofit.create(WanAndroidBannerApi::class.java)