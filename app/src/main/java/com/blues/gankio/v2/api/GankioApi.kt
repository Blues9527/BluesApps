package com.blues.gankio.v2.api

import com.blues.gankio.v2.model.GankioPostCommentsBean
import com.blues.gankio.v2.model.GankioPostDetailBean
import com.blues.gankio.v2.model.GankioHotBean
import com.blues.gankio.v2.model.GankioBannerBean
import com.blues.gankio.v2.model.GankioCategoryBean
import com.blues.gankio.v2.model.GankioUniversalBean
import com.blues.gankio.v2.model.GankioRandomBean
import com.blues.gankio.v2.model.GankioSearchResultBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * File: com.blues.gankio.v2.api.GankioApi
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-30 16:42
 **/

interface GankioApi {

    /**
     * 获取gank.io的banner
     */
    @GET("/api/v2/banners")
    suspend fun getGankBanner(): GankioBannerBean

    /**
     * 获取分类
     *
     * @param type 可传参数Article | GanHuo | Girl
     */
    @GET("/api/v2/categories/{category_type}")
    suspend fun getCategory(@Path("category_type") type: String?): GankioCategoryBean

    /**
     * 获取对应分类的数据
     *
     * @param category 可接受参数 All(所有分类) | Article | GanHuo | Girl
     * @param type     可接受参数 All(全部类型) | Android | iOS | Flutter | Girl ...，即分类API返回的类型数据
     * @param page     >=1
     * @param count    [10, 50]
     */
    @GET("/api/v2/data/category/{category}/type/{type}/page/{page}/count/{count}")
    suspend fun getCategoryPostList(@Path("category") category: String?,
        @Path("type") type: String?, @Path("page") page: Int,
        @Path("count") count: Int): GankioUniversalBean

    /**
     * 获取随机分类的{count}条数据
     *
     * @param category 可接受参数 All(所有分类) | Article | GanHuo | Girl
     * @param type     可接受参数 All(全部类型) | Android | iOS | Flutter | Girl ...，即分类API返回的类型数据
     * @param count    [10, 50]
     */
    @GET("/api/v2/random/category/{category}/type/{type}/count/{count}")
    suspend fun getRandomCategoryPostList(@Path("category") category: String?,
        @Path("type") type: String?, @Path("count") count: Int): GankioRandomBean

    /**
     * 文章详情
     *
     * @param postId 帖子Id 文章id[分类数据API返回的_id字段]
     */
    @GET("/api/v2/post/{post_id}")
    suspend fun getGankPostDetail(@Path("post_id") postId: String?): GankioPostDetailBean

    /**
     * 本周最热文章列表
     *
     * @param type     可接受参数 views（浏览数） | likes（点赞数） | comments（评论数）
     * @param category 可接受参数 Article | GanHuo | Girl
     * @param count    [1, 20]
     */
    @GET("/api/v2/hot/{hot_type}/category/{category}/count/{count}")
    suspend fun getGankPostHotList(@Path("hot_type") type: String?,
        @Path("category") category: String?, @Path("count") count: Int): GankioHotBean

    /**
     * 文章评论
     *
     * @param postId 帖子Id 文章id[分类数据API返回的_id字段]
     */
    @GET("/api/v2/post/comments/{post_id}")
    suspend fun getGankPostComments(@Path("post_id") postId: String?): GankioPostCommentsBean

    /**
     * 搜索
     *
     * @param search   要搜索的内容
     * @param category 可接受参数 All[所有分类] | Article | GanHuo
     * @param type     Android | iOS | Flutter ...，即分类API返回的类型数据
     * @param page     >=1
     * @param count    [10, 50]
     */
    @GET("/api/v2/search/{search}/category/{category}/type/{type}/page/{page}/count/{count}")
    suspend fun getSearchContents(@Path("search") search: String?,
        @Path("category") category: String?, @Path("type") type: String?, @Path("page") page: Int,
        @Path("count") count: Int): GankioSearchResultBean
}