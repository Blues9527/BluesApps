package com.blues.module_kaiyan;


import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 09:59
 */

public interface OpenEyeContractReq {

    @GET("/api/v3/ranklist")
    Observable<OpenEyeEntity> getRankList();

    @GET("/api/v4/rankList/videos")
    Observable<OpenEyeEntity> getRankList(@Query("strategy") String strategy);

    @GET("/api/v1/search")
    Observable<OpenEyeEntity> getSearchResult(@Query("num") int num, @Query("start") int start, @Query("query") String query);

    @GET("/api/v3/queries/hot")
    Observable<List<String>> getHotSearch();

    @GET
    Observable<OpenEyeEntity> getMoreOpenEye(@Url String url);
}
