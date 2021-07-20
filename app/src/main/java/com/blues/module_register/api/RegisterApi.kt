package com.blues.module_register.api

import retrofit2.http.POST
import com.blues.module_register.model.RegisterResponse
import retrofit2.http.Query

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:20
 */
interface RegisterApi {

    @POST("/user/register")
    suspend fun doRegister(@Query("username") username: String?, @Query("password") password: String?,
        @Query("repassword") repassword: String?): RegisterResponse
}