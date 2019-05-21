package com.example.lanhuajian.blues.module_login;

import com.example.lanhuajian.blues.framework.http.HttpResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:20
 */

public interface LoginContractRequest {

    @GET("/login")
    Observable<HttpResponse> doLogin(@Query("username") String username, @Query("password") String password);
}
