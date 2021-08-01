package com.blues.gankio.v2.service

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import com.blues.gankio.v2.api.GankioApi
import com.blues.gankio.v2.model.*
import retrofit2.Retrofit

/**
 * File: com.blues.gankio.v2.service.GankioRepository
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-30 16:48
 **/

class GankioRepository(private val gankioApi: GankioApi,
    private val responseHandler: ResponseHandler) {

    suspend fun getBanner(): Response<GankioBannerBean> {
        return try {
            val response = gankioApi.getGankBanner()
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getCategory(type: String): Response<GankioCategoryBean> {
        return try {
            val response = gankioApi.getCategory(type)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getCategoryPostList(category: String, type: String, page: Int,
        count: Int): Response<GankioUniversalBean> {
        return try {
            val response = gankioApi.getCategoryPostList(category, type, page, count)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getRandomCategoryPostList(category: String, type: String,
        count: Int): Response<GankioRandomBean> {
        return try {
            val response = gankioApi.getRandomCategoryPostList(category, type, count)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getPostDetail(postId: String): Response<GankioPostDetailBean> {
        return try {
            val response = gankioApi.getGankPostDetail(postId)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getPostHotList(type: String, category: String,
        count: Int): Response<GankioHotBean> {
        return try {
            val response = gankioApi.getGankPostHotList(type, category, count)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getGankPostComments(postId: String): Response<GankioPostCommentsBean> {
        return try {
            val response = gankioApi.getGankPostComments(postId)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getSearchContents(search: String, category: String, type: String, page: Int,
        count: Int): Response<GankioSearchResultBean> {
        return try {
            val response = gankioApi.getSearchContents(search, category, type, page, count)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}

fun provideGankioApi(retrofit: Retrofit): GankioApi = retrofit.create(GankioApi::class.java)