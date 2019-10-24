package com.example.lanhuajian.blues.module_main.banner;


import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:20
 */

public interface BannerContractRequest {

    @GET("/banner/json")
    Observable<BannerEntity> getBanner();

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
