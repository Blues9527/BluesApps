package com.blues.gankio.v1.api

import com.blues.gankio.v1.model.GankBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * File: com.blues.gankio.v1.api.GankApi
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-08-01 15:19
 **/

interface GankApi {

    /**
     * @param type Android/前端/福利/iOS
     * @param limit
     * @param page
     */
    @GET("/api/data/{type}/{limit}/{page}")
    suspend fun getData(@Path("type") type: String, @Path("limit") limit: Int,
        @Path("page") page: Int): GankBean
}

enum class GankType(var type: String) { ANDROID("Android"), WEB("前端"), PICTURE("福利"), IOS("iOS"),
}