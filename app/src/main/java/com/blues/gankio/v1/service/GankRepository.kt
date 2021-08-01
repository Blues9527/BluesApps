package com.blues.gankio.v1.service

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import com.blues.gankio.v1.api.GankApi
import com.blues.gankio.v1.model.GankBean
import retrofit2.Retrofit

/**
 * File: com.blues.gankio.v1.service.GankRepository
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-08-01 15:25
 **/

class GankRepository(private val gankApi: GankApi, private val responseHandler: ResponseHandler) {

    suspend fun getData(type: String, limit: Int, page: Int): Response<GankBean> {
        return try {
            val response = gankApi.getData(type, limit, page)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}

fun provideGankApi(retrofit: Retrofit): GankApi = retrofit.create(GankApi::class.java)