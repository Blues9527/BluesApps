package com.blues.kaiyan.detail.service

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import com.blues.kaiyan.detail.api.KaiyanDetailApi
import com.blues.kaiyan.detail.model.KaiyanDetailBean
import retrofit2.Retrofit

/**
 * File: com.blues.kaiyan.detail.service.KaiyanDetailRepository
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-30 16:03
 **/

class KaiyanDetailRepository(private val kaiyanDetailApi: KaiyanDetailApi,
    private val responseHandler: ResponseHandler) {

    suspend fun getRelatedVideos(id: String): Response<KaiyanDetailBean> {

        return try {
            val response = kaiyanDetailApi.getRelatedVideos(id)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}

fun provideKaiyanDetailApi(
    retrofit: Retrofit): KaiyanDetailApi = retrofit.create(KaiyanDetailApi::class.java)