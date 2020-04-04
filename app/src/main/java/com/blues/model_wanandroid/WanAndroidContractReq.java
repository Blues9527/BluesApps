package com.blues.model_wanandroid;


import com.blues.model_wanandroid.netease.CategoryCourseEntity;
import com.blues.model_wanandroid.netease.CategoryEntity;
import com.blues.model_wanandroid.netease.MicroSpecEntity;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * User : Blues
 * Date : 2020/4/04
 * Time : 21:46
 */

public interface WanAndroidContractReq {

    /**
     * wan android 获取热门帖子列表
     *
     * @param page 页数，从0开始
     * @return
     */
    @GET("article/listproject/{page}/json")
    Observable<WanAndroidEntity> getPostList(@Path("page") int page);

    /**
     * wan android 获取banner
     *
     * @return
     */
    @GET("/banner/json")
    Observable<WanAndroidBannerEntity> getBanner();


    //-----------网易微专业---------------//
    @GET("/j/microSpec/fetchLiveData.json")
    Observable<MicroSpecEntity> getMicroSpec();

    @POST("/j/operation/category.json")
    Observable<CategoryEntity> getCategory(@Query("frontCategoryId") String id);

    @POST("/j/operation/categoryCourse.json")
    Observable<CategoryCourseEntity> getCategoryCourse(@Query("activityId") int activityId,
                                                       @Query("priceType") int priceType,
                                                       @Query("orderType") int orderType,
                                                       @Query("categoryId") String categoryId,
                                                       @Query("pageIndex") int pageIndex,
                                                       @Query("pageSize") int pageSize);
}
