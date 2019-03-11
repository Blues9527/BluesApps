package com.example.lanhuajian.blues.model_android.request;

import com.example.lanhuajian.blues.model_android.model.AndroidEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public interface AndroidContractRequest {

    @GET("/api/data/Android/{limit}/{page}")
    Observable<AndroidEntity> getData(@Path("limit") int limit, @Path("page") int page);
}
