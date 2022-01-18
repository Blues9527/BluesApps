package com.blues.login.view

import android.content.Intent
import com.blues.framework.base.BaseKoinFragment
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
import com.blues.framework.utils.HelperUtil
import com.blues.login.vm.LoginViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountLoginFragment : BaseKoinFragment(), View.OnClickListener, TextWatcherAdapter {

    private lateinit var etAccount: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvLogin: TextView
    private lateinit var tvSkip: TextView
    private var account: String = ""
    private var password: String = ""

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_skip -> {
                startActivity(Intent(requireActivity(), MainActivity::class.java))
            }
            R.id.tv_login -> {
                if (account.isEmpty()) {
                    HelperUtil.showToast("账号不能为空!!!")
                }

                if (password.isEmpty()) {
                    HelperUtil.showToast("密码不能为空!!!")
                }

                //调用登陆接口
                loginViewModel.login(account, password)
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_account_login
    }

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {
        with(rootView) {

            etAccount = findViewById<EditText>(R.id.et_input_account).apply {
                addTextChangedListener(this@AccountLoginFragment)
            }
            etPassword = findViewById<EditText>(R.id.et_input_password).apply {
                addTextChangedListener(this@AccountLoginFragment)
            }
            tvSkip = findViewById<TextView>(R.id.tv_skip).apply {
                setOnClickListener(this@AccountLoginFragment)
            }
            tvLogin = findViewById<TextView>(R.id.tv_login).apply {
                setOnClickListener(this@AccountLoginFragment)
            }
        }
    }

    override fun collect() {
        lifecycleScope.launch {
            loginViewModel.result.collect{
                if (it.errorCode == 200) {
                    startActivity(Intent(requireActivity(), MainActivity::class.java))
                } else {
                    HelperUtil.showToast(it.errorMsg)
                }
            }
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        password = etPassword.toString()
            .trim()
        account = etAccount.toString()
            .trim()
    }
}