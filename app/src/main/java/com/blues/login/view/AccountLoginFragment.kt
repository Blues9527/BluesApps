package com.blues.login.view

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
import com.blues.constant.USER_INFO_KEY
import com.blues.framework.utils.HelperUtil
import com.blues.framework.utils.startActivity
import com.blues.login.vm.LoginViewModel
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountLoginFragment : BaseKoinFragment(), View.OnClickListener, TextWatcherAdapter {

    private lateinit var etAccount: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvLogin: TextView
    private lateinit var tvSkip: TextView
    private var account: String = ""
    private var password: String = ""

    private val loginViewModel: LoginViewModel by viewModel()
    private val mmkv: MMKV = get()

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_skip -> {
                //点击跳过，进入主页面
                startActivity<MainActivity>()
            }
            R.id.tv_login -> {
                //调用登陆接口
                loginViewModel.loginLocal(account, password)
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
//            loginViewModel.result.collect{
//                if (it.errorCode == 200) {
//                    startActivity(Intent(requireActivity(), MainActivity::class.java))
//                } else {
//                    HelperUtil.showToast(it.errorMsg)
//                }
//            }
            loginViewModel.resultLocal.collect {
                //first -> 登录状态 second->用户信息
                mmkv.putString(USER_INFO_KEY, it.second)
                if (it.first) {
                    HelperUtil.showToast("登录成功～")
                    startActivity<MainActivity>()
                } else {
                    HelperUtil.showToast("登录失败～")
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