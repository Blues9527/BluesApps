package com.blues.register.view

import com.blues.framework.utils.HelperUtil.showToast
import android.widget.TextView
import android.widget.EditText
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.blues.MainActivity
import com.blues.adapter.TextWatcherAdapter
import com.blues.framework.base.BaseKoinFragment
import com.blues.framework.utils.startActivity
import com.blues.register.vm.RegisterViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 10:21
 */
class PhoneRegisterFragment : BaseKoinFragment(), TextWatcherAdapter, View.OnClickListener {

    private lateinit var etPhone: EditText
    private lateinit var etVerify: EditText
    private lateinit var etPassword: EditText
    private var phoneNum: String = ""
    private var verifyCode: String = ""
    private var password: String = ""

    private val registerViewModel: RegisterViewModel by viewModel()

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        phoneNum = etPhone.text.toString()
            .trim()
        verifyCode = etVerify.text.toString()
            .trim()
        password = etPassword.text.toString()
            .trim()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_skip -> {
                startActivity<MainActivity>()
            }
            R.id.tv_register -> registerViewModel.registerByPhone(phoneNum, password)
            R.id.tv_get_verify -> {
            }
        }
    }

    override fun collect() {
        lifecycleScope.launch {
            registerViewModel.resultPhoneInfo.collect {
                if (it) {
                    showToast("注册成功，即将跳转主页面～") //跳转登陆界面
                    delay(1000)
                    startActivity<MainActivity>()
                } else {
                    showToast("注册失败，请检查手机号和密码～")
                }
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_phone_register

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        with(rootView) {
            etPhone = findViewById<EditText>(R.id.et_phone)
                .apply {
                    addTextChangedListener(this@PhoneRegisterFragment)
                }
            etVerify = findViewById<EditText>(R.id.et_verify)
                .apply {
                    addTextChangedListener(this@PhoneRegisterFragment)
                }
            etPassword = findViewById<EditText>(R.id.et_password)
                .apply {
                    addTextChangedListener(this@PhoneRegisterFragment)
                }

            findViewById<TextView>(R.id.tv_skip)
                .setOnClickListener(this@PhoneRegisterFragment)
            findViewById<TextView>(R.id.tv_register)
                .setOnClickListener(this@PhoneRegisterFragment)
            findViewById<TextView>(R.id.tv_get_verify)
                .setOnClickListener(this@PhoneRegisterFragment)
        }

    }
}