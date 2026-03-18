package com.blues.kaiyan.list.service

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import com.blues.kaiyan.list.api.KaiyanApi
import com.blues.kaiyan.list.model.KaiyanBean
import retrofit2.Retrofit

/**
 * File: com.blues.module_kaiyan.main.service.KaiyanRepository
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-30
 **/

class KaiyanRepository(private val kaiyanApi: KaiyanApi,
    private val responseHandler: ResponseHandler) {

    suspend fun getRankList(): Response<KaiyanBean> {
        return try {
            val response = kaiyanApi.getRankList()
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getRankListVideos(strategy: String): Response<KaiyanBean> {
        return try {
            val response = kaiyanApi.getRankListVideos(strategy)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getSearchResult(query: String): Response<KaiyanBean> {
        return try {
            val response = kaiyanApi.getSearchResult(10, 10, query)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getHotSearch(): Response<List<String?>> {
        return try {
            val response = kaiyanApi.getHotSearch()
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}

fun provideKaiyanApi(retrofit: Retrofit): KaiyanApi = retrofit.create(KaiyanApi::class.java)