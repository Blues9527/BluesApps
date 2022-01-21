package com.blues.register.service

import com.blues.application.BluesApplication
import com.blues.constant.USER_INFO_KEY
import com.blues.db.user.User
import com.blues.db.user.UserDatabase
import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import com.blues.framework.utils.mmkv
import com.blues.register.model.RegisterResponse
import com.blues.register.api.RegisterApi
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import retrofit2.Retrofit

/**
 * File: com.blues.module_register.service.RegisterRepository
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-20
 **/

class RegisterRepository(
    private val registerApi: RegisterApi,
    private val responseHandler: ResponseHandler,
    private val mmkv: MMKV
) {

    suspend fun register(
        username: String, password: String,
        repassword: String
    ): Response<RegisterResponse> {
        return try {
            val response = registerApi.doRegister(username, password, repassword)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    /**
     * 本地注册
     */
    suspend fun registerLocal(
        username: String,
        password: String
    ) {
        UserDatabase.getInstance(BluesApplication.app).userDao().isUsernameExist(username).collect {
            //查出来用户不为空，表示已注册
            if (it.isEmpty()) {
                UserDatabase.getInstance(BluesApplication.app).userDao()
                    .insertUser(User(userName = username, password = password))
                mmkv.putString(USER_INFO_KEY, username)
            }
        }
    }

}

fun provideRegisterApi(retrofit: Retrofit): RegisterApi = retrofit.create(RegisterApi::class.java)