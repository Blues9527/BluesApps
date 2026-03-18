package com.blues.article

import retrofit2.http.GET
import retrofit2.http.Query


/**
 * 每日一文api
 * 原接口已不可用，现使用本地模拟数据
 */
interface EverydayArticleServiceApi {

    companion object {
        const val EVERYDAY_ARTICLE_URL = "https://picsum.photos/"
    }

    /**
     * 保留接口签名，实际数据由本地提供
     * 兼容旧代码
     */
    @GET("article/today")
    suspend fun getTodayArticle(@Query("dev") dev: String = "1"): EverydayArticleBean

}
