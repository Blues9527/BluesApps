package com.blues.module_register;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:20
 */

public interface RegisterContractRequest {

    @POST("/user/register")
    Observable<RegisterResponse> doRegister(@Query("username") String username, @Query("password") String password, @Query("repassword") String repassword);
}
