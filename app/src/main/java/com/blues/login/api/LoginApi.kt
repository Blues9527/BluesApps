package com.blues.login.api

import com.blues.login.model.LoginResponse
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * File: com.blues.module_login.api.LoginApi
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-21
 **/

interface LoginApi {

    @POST("/user/login")
    suspend fun login(@Query("username") username: String?,
        @Query("password") password: String?): LoginResponse
}