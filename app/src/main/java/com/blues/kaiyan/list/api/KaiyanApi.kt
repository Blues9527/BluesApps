package com.blues.kaiyan.list.api

import com.blues.kaiyan.list.model.KaiyanBean
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * File: com.blues.module_kaiyan.main.api.KaiyanApi
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-30
 **/

interface KaiyanApi {

    @GET("/api/v3/ranklist")
    suspend fun getRankList(): KaiyanBean

    @GET("/api/v4/rankList/videos")
    suspend fun getRankListVideos(@Query("strategy") strategy: String?): KaiyanBean

    @GET("/api/v1/search")
    suspend fun getSearchResult(@Query("num") num: Int, @Query("start") start: Int,
        @Query("query") query: String?): KaiyanBean

    @GET("/api/v3/queries/hot")
    suspend fun getHotSearch(): List<String?>
}