package com.blues.article

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import retrofit2.Retrofit


/**
 * 每日一文repo
 */
class EverydayArticleRepository(
    private val everydayArticleServiceApi: EverydayArticleServiceApi,
    private val responseHandler: ResponseHandler
) {

    suspend fun getTodayArticle(): Response<EverydayArticleBean> {

        return try {
            val response = everydayArticleServiceApi.getTodayArticle()
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}

fun provideEverydayArticleApi(
    retrofit: Retrofit
): EverydayArticleServiceApi = retrofit.create(EverydayArticleServiceApi::class.java)