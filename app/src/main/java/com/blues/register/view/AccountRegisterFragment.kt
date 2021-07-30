package com.blues.register.view

import com.blues.framework.utils.HelperUtil.showToast
import android.widget.EditText
import android.widget.TextView
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.blues.adapter.TextWatcherAdapter
import com.blues.framework.base.BaseKoinFragment
import com.blues.login.view.LoginActivity
import com.blues.register.vm.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountRegisterFragment : BaseKoinFragment(), View.OnClickListener, TextWatcherAdapter {

    private lateinit var etAccount: EditText
    private lateinit var etPassword: EditText
    private lateinit var etRepassword: EditText
    private var account: String = ""
    private var password: String = ""
    private var repassword: String = ""

    private val registerViewModel: RegisterViewModel by viewModel()

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_skip -> startActivity(Intent(requireContext(), LoginActivity::class.java))
            R.id.tv_register -> registerViewModel.register(account, password, repassword)               //调用注册接口
        }
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        account = etAccount.text.toString()
            .trim()
        password = etPassword.text.toString()
            .trim()
        repassword = etRepassword.text.toString()
            .trim()
    }

    override fun observe() {
        registerViewModel.result.observe(this) {
            if (it.errorCode == 200) {
                showToast("注册成功") //跳转登陆界面
                startActivity(Intent(requireContext(), LoginActivity::class.java))
            } else {
                showToast(it.errorMsg)
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_account_register

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        with(rootView) {
            etAccount = findViewById<EditText>(R.id.et_input_account).apply {
                addTextChangedListener(this@AccountRegisterFragment)
            }
            etPassword = findViewById<EditText>(R.id.et_input_password).apply {
                addTextChangedListener(this@AccountRegisterFragment)
            }
            etRepassword = findViewById<EditText>(R.id.et_input_repassword).apply {
                addTextChangedListener(this@AccountRegisterFragment)
            }

            findViewById<TextView>(R.id.tv_skip).setOnClickListener(this@AccountRegisterFragment)
            findViewById<TextView>(R.id.tv_register).setOnClickListener(this@AccountRegisterFragment)
        }
    }
}