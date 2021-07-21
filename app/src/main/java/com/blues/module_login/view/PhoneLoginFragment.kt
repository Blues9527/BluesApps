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

class PhoneLoginFragment : BaseKoinFragment(), View.OnClickListener {

    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvLogin: TextView
    private lateinit var tvSkip: TextView
    private var phone: String? = null
    private var password: String? = null

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_skip -> {
                startActivity(Intent(requireActivity(), MainActivity::class.java))
            }
            R.id.tv_login -> {
                if (phone == null) {
                    HelperUtil.showToast("手机号不能为空!!!")
                }

                if (password == null) {
                    HelperUtil.showToast("密码不能为空!!!")
                }

                //调用登陆接口
                loginViewModel.login(phone!!, password!!)
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_phone_login
    }

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {
        rootView?.let {
            etPhone = it.findViewById<EditText>(R.id.et_input_phone)
                .apply {
                    addTextChangedListener(object : TextWatcherAdapter() {
                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int,
                            count: Int) {
                            phone = text.toString()
                                .trim()
                        }
                    })
                }
            etPassword = it.findViewById<EditText>(R.id.et_input_password)
                .apply {
                    addTextChangedListener(object : TextWatcherAdapter() {
                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int,
                            count: Int) {
                            password = text.toString()
                                .trim()
                        }
                    })
                }
            tvSkip = it.findViewById<TextView>(R.id.tv_skip)
                .apply {
                    setOnClickListener(this@PhoneLoginFragment)
                }
            tvLogin = it.findViewById<TextView>(R.id.tv_login)
                .apply {
                    setOnClickListener(this@PhoneLoginFragment)
                }
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
}