package com.blues.register.view

import com.blues.framework.base.BaseKoinActivity
import android.widget.TextView
import android.widget.FrameLayout
import com.blues.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 10:21
 */
class RegisterActivity : BaseKoinActivity(), View.OnClickListener {

    private val fragments: List<Fragment> =
        listOf(AccountRegisterFragment(), PhoneRegisterFragment())

    private var mCurrentFragment: Fragment? = null

    private val tvAccountRegister: TextView by lazy {
        findViewById(R.id.tv_account_register)
    }
    private val tvPhoneRegister: TextView by lazy {
        findViewById(R.id.tv_phone_register)
    }
    private val flContainer: FrameLayout by lazy {
        findViewById(R.id.fl_container)
    }

    private fun showFragment(from: Fragment?, to: Fragment?) {
        if (to == null) return
        val transaction = supportFragmentManager.beginTransaction()
        val isAdded = to.isAdded
        if (!isAdded) {
            if (from != null) {
                transaction.hide(from)
                    .add(R.id.fl_container, to, null)
                    .show(to)
                    .commitAllowingStateLoss()
            } else {
                transaction.add(R.id.fl_container, to, null)
                    .show(to)
                    .commitAllowingStateLoss()
            }
        } else {
            if (from != null) {
                transaction.hide(from)
                    .show(to)
                    .commitAllowingStateLoss()
            } else {
                transaction.show(to)
                    .commitAllowingStateLoss()
            }
        }
        mCurrentFragment = to
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_account_register -> {

                // 跳转账号注册fragment
                tvAccountRegister.visibility = View.GONE
                tvPhoneRegister.visibility = View.GONE
                flContainer.visibility = View.VISIBLE
                showFragment(mCurrentFragment, fragments[0])
            }
            R.id.tv_phone_register -> {

                // 跳转手机注册fragment
                tvAccountRegister.visibility = View.GONE
                tvPhoneRegister.visibility = View.GONE
                flContainer.visibility = View.VISIBLE
                showFragment(mCurrentFragment, fragments[1])
            }
        }
    }

    override fun getLayoutId() = R.layout.activity_register

    override fun initData(savedInstanceState: Bundle?) {
        tvAccountRegister.setOnClickListener(this@RegisterActivity)
        tvPhoneRegister.setOnClickListener(this@RegisterActivity)
    }
}