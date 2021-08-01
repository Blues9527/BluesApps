package com.blues.wanandroid.api

import com.blues.wanandroid.model.WanAndroidEntity
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * User : Blues
 * Date : 2020/4/04
 * Time : 21:46
 */
interface WanAndroidServiceApi {

    /**
     * wan android 获取热门帖子列表
     *
     * @param page 页数，从0开始
     * @return
     */
    @GET("articleDetail/listproject/{page}/json")
    suspend fun getPostList(@Path("page") page: Int): WanAndroidEntity

}