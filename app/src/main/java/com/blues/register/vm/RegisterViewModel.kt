package com.blues.register.vm

import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.register.model.RegisterResponse
import com.blues.register.service.RegisterRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

/**
 * File: com.blues.module_register.vm.RegisterViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-20
 **/

class RegisterViewModel(private val registerRepo: RegisterRepository) : BaseViewModel() {

    private val _result = MutableSharedFlow<RegisterResponse>(replay = 1)
    val result: SharedFlow<RegisterResponse> = _result

    fun register(username: String, password: String, repassword: String) {
        viewModelScope.launch {
            requestByFlow {
                registerRepo.register(username, password, repassword)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }
                .next {
                    this.data?.let {
                        _result.tryEmit(it)
                    }
                }
        }
    }

    private val _localRegisterResult = MutableSharedFlow<Boolean>(replay = 1)
    val localRegisterResult: SharedFlow<Boolean> = _localRegisterResult

    /**
     * 本地注册
     */
    fun registerLocal(username: String, password: String, repassword: String) {
        viewModelScope.launch {

            //先校验参数是否为空
            if (HelperUtil.checkEmpty(mutableListOf(username, password, repassword))) {
                //为空就return false
                _localRegisterResult.tryEmit(false)
            }

            //再校验 两次密码是否相同
            if (password == repassword) {
                //密码相同就直接注册
                registerRepo.registerLocal(username, password)
                _localRegisterResult.tryEmit(true)
            } else {
                _localRegisterResult.tryEmit(false)
            }
        }
    }


}