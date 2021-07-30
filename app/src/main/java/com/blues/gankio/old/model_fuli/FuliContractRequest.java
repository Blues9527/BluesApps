package com.blues.gankio.old.model_fuli;

import com.blues.gankio.old.model_fuli.model.FuliEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface FuliContractRequest {

    @GET("/api/data/福利/{limit}/{page}")
    Observable<FuliEntity> getData(@Path("limit") int limit, @Path("page") int page);
}
