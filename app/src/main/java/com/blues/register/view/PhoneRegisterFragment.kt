package com.blues.register.view

import com.blues.framework.utils.HelperUtil.showToast
import android.widget.TextView
import android.widget.EditText
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.blues.adapter.TextWatcherAdapter
import com.blues.framework.base.BaseKoinFragment

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
            }
            R.id.tv_register -> if (TextUtils.isEmpty(phoneNum) || TextUtils.isEmpty(verifyCode)) {
                showToast("手机号码 or 验证码不能为空")
            }
            R.id.tv_get_verify -> {
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