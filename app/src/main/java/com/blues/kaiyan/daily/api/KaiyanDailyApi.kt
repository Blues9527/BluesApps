package com.blues.kaiyan.daily.api

import com.blues.kaiyan.daily.model.KaiyanDailyBean
import retrofit2.http.GET

/**
 * File: com.blues.kaiyan.daily.api.KaiyanDailyApi.kt
 * Description: xxx
 *
 * @author lanhuajian
 * @date 2023/6/29
 **/
interface KaiyanDailyApi {

    @GET("/api/v5/index/tab/feed")
    suspend fun getDailyData(): KaiyanDailyBean
}