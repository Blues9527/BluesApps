package com.blues.register.service

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import com.blues.register.model.RegisterResponse
import com.blues.register.api.RegisterApi
import retrofit2.Retrofit

/**
 * File: com.blues.module_register.service.RegisterRepository
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-20
 **/

class RegisterRepository(private val registerApi: RegisterApi,
    private val responseHandler: ResponseHandler) {

    suspend fun register(username: String, password: String,
        repassword: String): Response<RegisterResponse> {
        return try {
            val response = registerApi.doRegister(username, password, repassword)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}

fun provideRegisterApi(retrofit: Retrofit): RegisterApi = retrofit.create(RegisterApi::class.java)