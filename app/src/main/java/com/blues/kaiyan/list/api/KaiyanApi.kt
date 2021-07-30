package com.blues.kaiyan.list.api

import com.blues.kaiyan.list.model.OpenEyeEntity
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
    suspend fun getRankList(): OpenEyeEntity

    @GET("/api/v4/rankList/videos")
    suspend fun getRankListVideos(@Query("strategy") strategy: String?): OpenEyeEntity

    @GET("/api/v1/search")
    suspend fun getSearchResult(@Query("num") num: Int, @Query("start") start: Int,
        @Query("query") query: String?): OpenEyeEntity

    @GET("/api/v3/queries/hot")
    suspend fun getHotSearch(): List<String?>
}