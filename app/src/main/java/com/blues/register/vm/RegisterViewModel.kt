package com.blues.register.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.register.model.RegisterResponse
import com.blues.register.service.RegisterRepository
import kotlinx.coroutines.launch

/**
 * File: com.blues.module_register.vm.RegisterViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-20
 **/

class RegisterViewModel(private val registerRepo: RegisterRepository) : BaseViewModel() {

    val result = MutableLiveData<RegisterResponse>()

    fun register(username: String, password: String, repassword: String) {
        viewModelScope.launch {
            requestByFlow {
                registerRepo.register(username, password, repassword)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }
                .next {
                    this.data?.let {
                        result.value = it
                    }
                }
        }
    }
}