package com.blues.login.service

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import com.blues.login.model.LoginResponse
import com.blues.login.api.LoginApi
import retrofit2.Retrofit

/**
 * File: com.blues.module_login.service.LoginRepository
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-21
 **/

class LoginRepository(private val loginApi: LoginApi,
    private val responseHandler: ResponseHandler) {

    suspend fun login(username: String, password: String): Response<LoginResponse> {
        return try {
            val response = loginApi.login(username, password)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}

fun provideLoginApi(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)