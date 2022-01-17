package com.blues.login.vm

import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.login.model.LoginResponse
import com.blues.login.service.LoginRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

/**
 * File: com.blues.module_login.vm.LoginViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-21
 **/

class LoginViewModel(private val loginRepo: LoginRepository) : BaseViewModel() {

    private val _result = MutableSharedFlow<LoginResponse>(replay = 1)
    val result: SharedFlow<LoginResponse> = _result

    fun login(username: String, password: String) {
        viewModelScope.launch {
            requestByFlow {
                loginRepo.login(username, password)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _result.tryEmit(it)
                }
            }
        }
    }
}