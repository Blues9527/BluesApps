package com.blues.article

import retrofit2.http.GET
import retrofit2.http.Query


/**
 * 每日一文api
 */
interface EverydayArticleServiceApi {

    companion object {
        const val EVERYDAY_ARTICLE_URL = "https://interface.meiriyiwen.com/"
    }

    /**
     * 获取当天文章
     *
     * https://interface.meiriyiwen.com/article/today?dev=1
     */
    @GET("article/today")
    suspend fun getTodayArticle(@Query("dev") dev: String = "1"): EverydayArticleBean

}