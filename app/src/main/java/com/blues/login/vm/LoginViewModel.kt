package com.blues.login.vm

import androidx.lifecycle.viewModelScope
import com.blues.application.BluesApplication
import com.blues.db.user.UserDatabase
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.login.model.LoginResponse
import com.blues.login.service.LoginRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * File: com.blues.module_login.vm.LoginViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-21
 **/

class LoginViewModel(private val loginRepo: LoginRepository) : BaseViewModel() {

    //接口登陆
//
//    private val _result = MutableSharedFlow<LoginResponse>(replay = 1)
//    val result: SharedFlow<LoginResponse> = _result
//
//    fun login(username: String, password: String) {
//        viewModelScope.launch {
//            requestByFlow {
//                loginRepo.login(username, password)
//            }.catch {
//                HelperUtil.showSimpleLog(this.message)
//            }.next {
//                this.data?.let {
//                    _result.tryEmit(it)
//                }
//            }
//        }
//    }

    private val _resultUsername = MutableSharedFlow<Pair<Boolean, String>>(replay = 1)
    val resultUsername: SharedFlow<Pair<Boolean, String>> = _resultUsername

    /**
     * 本地数据库登陆
     */
    fun loginByUsername(username: String, password: String) {
        viewModelScope.launch {
            if (HelperUtil.checkEmpty(mutableListOf(username, password))) {
                _resultUsername.tryEmit(Pair(false, ""))
                return@launch
            }
            //校验用户信息
            UserDatabase.getInstance(BluesApplication.app).userDao()
                .isUserNameInfoValidate(username, password).collect {
                    val hasUserInfo = it.isNotEmpty()
                    val userInfo = if (hasUserInfo) it.first().userName else ""
                    _resultUsername.tryEmit(
                        Pair(
                            hasUserInfo,
                            userInfo ?: ""
                        )
                    )
                }
        }
    }


    private val _resultPhone = MutableSharedFlow<Pair<Boolean, String>>(replay = 1)
    val resultPhone: SharedFlow<Pair<Boolean, String>> = _resultPhone

    /**
     * 本地数据库登陆
     */
    fun loginByPhone(phone: String, password: String) {
        viewModelScope.launch {
            if (HelperUtil.checkEmpty(mutableListOf(phone, password))) {
                _resultUsername.tryEmit(Pair(false, ""))
                return@launch
            }
            //校验用户信息
            UserDatabase.getInstance(BluesApplication.app).userDao()
                .isUserPhoneInfoValidate(phone, password).collect {
                    val hasPhoneInfo = it.isNotEmpty()
                    val phoneInfo = if (hasPhoneInfo) it.first().phone else ""
                    _resultPhone.tryEmit(
                        Pair(
                            hasPhoneInfo,
                            phoneInfo ?: ""
                        )
                    )
                }
        }
    }


}