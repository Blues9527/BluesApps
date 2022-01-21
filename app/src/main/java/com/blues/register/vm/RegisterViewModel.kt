package com.blues.register.vm

import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.register.model.RegisterResponse
import com.blues.register.service.RegisterRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

/**
 * File: com.blues.module_register.vm.RegisterViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-20
 **/

class RegisterViewModel(private val registerRepo: RegisterRepository) : BaseViewModel() {

    //接口注册
//    private val _result = MutableSharedFlow<RegisterResponse>(replay = 1)
//    val result: SharedFlow<RegisterResponse> = _result
//
//    fun register(username: String, password: String, repassword: String) {
//        viewModelScope.launch {
//            requestByFlow {
//                registerRepo.register(username, password, repassword)
//            }.catch {
//                HelperUtil.showSimpleLog(this.message)
//            }
//                .next {
//                    this.data?.let {
//                        _result.tryEmit(it)
//                    }
//                }
//        }
//    }

    private val _resultUserInfo = MutableSharedFlow<Boolean>(replay = 1)
    val resultUserInfo: SharedFlow<Boolean> = _resultUserInfo

    /**
     * 本地注册
     */
    fun registerByUsername(username: String, password: String, repassword: String) {
        viewModelScope.launch {

            //先校验参数是否为空
            if (HelperUtil.checkEmpty(mutableListOf(username, password, repassword))) {
                //为空就return false
                _resultUserInfo.tryEmit(false)
                return@launch
            }

        }
        //再校验 两次密码是否相同
        if (password == repassword) {
            //密码相同就直接注册
            CoroutineScope(Dispatchers.IO).launch {
                registerRepo.registerByUsername(username, password)
            }
            viewModelScope.launch {
                _resultUserInfo.tryEmit(true)
            }

        } else {
            viewModelScope.launch {
                _resultUserInfo.tryEmit(false)
            }
        }
    }


    private val _resultPhoneInfo = MutableSharedFlow<Boolean>(replay = 1)
    val resultPhoneInfo: SharedFlow<Boolean> = _resultPhoneInfo

    /**
     * 本地注册
     */
    fun registerByPhone(phone: String, password: String) {
        viewModelScope.launch {

            //先校验参数是否为空
            if (HelperUtil.checkEmpty(mutableListOf(phone, password))) {
                //为空就return false
                _resultUserInfo.tryEmit(false)
                return@launch
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            registerRepo.registerByPhone(phone, password)
        }
        viewModelScope.launch {
            _resultUserInfo.tryEmit(true)
        }
    }
}