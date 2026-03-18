package com.blues.kaiyan.daily.service

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import com.blues.kaiyan.daily.api.KaiyanDailyApi
import com.blues.kaiyan.daily.model.KaiyanDailyBean
import retrofit2.Retrofit

/**
 * File: com.blues.kaiyan.daily.service.KaiyanDailyRepository.kt
 * Description: xxx
 *
 * @author lanhuajian
 * @date 2023/6/29
 **/

class KaiyanDailyRepository(
    private val kaiyanDailyApi: KaiyanDailyApi, private val responseHandler: ResponseHandler
) {
    /**
     * 获取日报
     */
    suspend fun getDailyData(): Response<KaiyanDailyBean?> {
        return try {
            val response = kaiyanDailyApi.getDailyData()
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}


fun provideKaiyanDailyApi(retrofit: Retrofit): KaiyanDailyApi =
    retrofit.create(KaiyanDailyApi::class.java)