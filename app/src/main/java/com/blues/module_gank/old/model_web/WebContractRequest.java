package com.blues.module_gank.old.model_web;

import com.blues.module_gank.old.model_web.model.WebEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface WebContractRequest {

    @GET("/api/data/前端/{limit}/{page}")
    Observable<WebEntity> getData(@Path("limit") int limit, @Path("page") int page);
}
