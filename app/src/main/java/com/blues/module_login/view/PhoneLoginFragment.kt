package com.blues.module_login.view

import android.content.Intent
import android.widget.EditText
import android.widget.TextView
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import com.blues.MainActivity
import com.blues.adapter.TextWatcherAdapter
import com.blues.framework.base.BaseKoinFragment
import com.blues.framework.utils.HelperUtil
import com.blues.module_login.vm.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhoneLoginFragment : BaseKoinFragment(), View.OnClickListener, TextWatcherAdapter {

    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private var phone: String = ""
    private var password: String = ""

    private val loginViewModel: LoginViewModel by viewModel()

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
                loginViewModel.login(phone, password)
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

    override fun observe() {
        loginViewModel.result.observe(this) {
            if (it.errorCode == 200) {
                startActivity(Intent(requireActivity(), MainActivity::class.java))
            } else {
                HelperUtil.showToast(it.errorMsg)
            }
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        password = etPassword.toString()
            .trim()
        phone = etPhone.toString()
            .trim()
    }
}