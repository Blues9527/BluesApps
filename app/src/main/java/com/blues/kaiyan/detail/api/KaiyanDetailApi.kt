package com.blues.kaiyan.detail.api

import com.blues.kaiyan.detail.model.OEDetailRelatedEntity
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * File: com.blues.kaiyan.detail.api.KaiyanDetailApi
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-30 15:57
 **/

interface KaiyanDetailApi {

    @GET("/api/v4/video/related")
    suspend fun getRelatedVideos(@Query("id") relatedId: String?): OEDetailRelatedEntity
}