package com.blues.module_login.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.module_login.model.LoginResponse
import com.blues.module_login.service.LoginRepository
import kotlinx.coroutines.launch

/**
 * File: com.blues.module_login.vm.LoginViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-21 10:22
 **/

class LoginViewModel(private val loginRepo: LoginRepository) : BaseViewModel() {

    val result = MutableLiveData<LoginResponse>()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            requestByFlow {
                loginRepo.login(username, password)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                    this.data?.let {
                        result.value = it
                    }
                }
        }
    }
}