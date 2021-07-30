package com.blues.kaiyan.detail;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 09:59
 */

public interface OEDetailRelatedContractReq {

    @GET("/api/v4/video/related")
    Observable<OEDetailRelatedEntity> getRelatedVideos(@Query("id") String relatedId);

}
