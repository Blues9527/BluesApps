package com.blues.login.view

import android.content.Intent
import android.widget.EditText
import android.widget.TextView
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.blues.MainActivity
import com.blues.adapter.TextWatcherAdapter
import com.blues.constant.USER_INFO_KEY
import com.blues.framework.base.BaseKoinFragment
import com.blues.framework.utils.HelperUtil
import com.blues.framework.utils.startActivity
import com.blues.login.vm.LoginViewModel
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhoneLoginFragment : BaseKoinFragment(), View.OnClickListener, TextWatcherAdapter {

    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private var phone: String = ""
    private var password: String = ""

    private val loginViewModel: LoginViewModel by viewModel()
    private val mmkv: MMKV = get()

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_skip -> {
                startActivity(Intent(requireActivity(), MainActivity::class.java))
            }
            R.id.tv_login -> {
                if (phone.isEmpty()) {
                    HelperUtil.showToast("手机号不能为空!!!")
                }

                if (password.isEmpty()) {
                    HelperUtil.showToast("密码不能为空!!!")
                }

                //调用登陆接口
                loginViewModel.loginByPhone(phone, password)
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_phone_login
    }

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {
        with(rootView) {
            etPhone = findViewById<EditText>(R.id.et_input_phone).apply {
                addTextChangedListener(this@PhoneLoginFragment)
            }
            etPassword = findViewById<EditText>(R.id.et_input_password).apply {
                addTextChangedListener(this@PhoneLoginFragment)
            }
            findViewById<TextView>(R.id.tv_skip).setOnClickListener(this@PhoneLoginFragment)
            findViewById<TextView>(R.id.tv_login).setOnClickListener(this@PhoneLoginFragment)
        }
    }

    override fun collect() {
        lifecycleScope.launch {
//            loginViewModel.result.collect {
//                if (it.errorCode == 200) {
//                    startActivity(Intent(requireActivity(), MainActivity::class.java))
//                } else {
//                    HelperUtil.showToast(it.errorMsg)
//                }
//            }

            loginViewModel.resultPhone.collect {
                //first -> 登录状态 second->phone信息
                mmkv.putString(USER_INFO_KEY, it.second)
                if (it.first) {
                    HelperUtil.showToast("登录成功～")
                    delay(1000)
                    startActivity<MainActivity>()
                } else {
                    HelperUtil.showToast("登录失败～")
                }
            }
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        password = etPassword.text.toString()
            .trim()
        phone = etPhone.text.toString()
            .trim()
    }
}