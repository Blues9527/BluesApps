package com.example.lanhuajian.blues.module_login;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:20
 */

public interface LoginContractRequest {

    @POST("/user/login")
    Observable<LoginResponse> doLogin(@Query("username") String username, @Query("password") String password);
}
