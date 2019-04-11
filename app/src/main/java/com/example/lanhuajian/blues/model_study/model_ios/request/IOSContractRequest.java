package com.example.lanhuajian.blues.model_study.model_ios.request;

import com.example.lanhuajian.blues.model_study.model_ios.model.IOSEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface IOSContractRequest {

    @GET("/api/data/iOS/{limit}/{page}")
    Observable<IOSEntity> getData(@Path("limit") int limit, @Path("page") int page);
}
