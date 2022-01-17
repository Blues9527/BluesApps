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
}