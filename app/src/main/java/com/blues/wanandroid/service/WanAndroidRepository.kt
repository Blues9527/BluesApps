package com.blues.wanandroid.service

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import com.blues.wanandroid.api.WanAndroidServiceApi
import com.blues.wanandroid.model.WanAndroidEntity
import retrofit2.Retrofit

/**
 * File: com.blues.model_wanandroid.service.WanAndroidRepository
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16
 **/

class WanAndroidRepository(private val wanAndroidApi: WanAndroidServiceApi,
    private val responseHandler: ResponseHandler) {

    suspend fun getPostList(page: Int): Response<WanAndroidEntity> {

        return try {
            val response = wanAndroidApi.getPostList(page)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}

fun provideWanAndroidPostApi(
    retrofit: Retrofit): WanAndroidServiceApi = retrofit.create(WanAndroidServiceApi::class.java)