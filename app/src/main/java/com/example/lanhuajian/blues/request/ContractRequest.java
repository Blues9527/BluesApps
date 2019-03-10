package com.example.lanhuajian.blues.request;

import com.example.lanhuajian.blues.model.Entity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public interface ContractRequest {

    @GET("/api/data/Android/{limit}/{page}")
    Observable<Entity> getData(@Path("limit") int limit, @Path("page") int page);
}
