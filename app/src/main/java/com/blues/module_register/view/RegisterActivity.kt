package com.blues.module_register.view

import com.blues.framework.base.BaseKoinActivity
import android.widget.TextView
import android.widget.FrameLayout
import com.blues.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.blues.module_register.view.AccountRegisterFragment
import com.blues.module_register.view.PhoneRegisterFragment
import org.w3c.dom.Text
import java.util.ArrayList

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 10:21
 */
class RegisterActivity : BaseKoinActivity(), View.OnClickListener {

    private val fragments: List<Fragment> = listOf(AccountRegisterFragment(), PhoneRegisterFragment())
    private var mCurrentFragment: Fragment? = null
    private lateinit var tvAccountRegister: TextView
    private lateinit var tvPhoneRegister: TextView
    private lateinit var flContainer: FrameLayout

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
            R.id.tv_account_register -> { //TODO 跳转账号注册fragment
                tvAccountRegister.visibility = View.GONE
                tvPhoneRegister.visibility = View.GONE
                flContainer.visibility = View.VISIBLE
                showFragment(mCurrentFragment, fragments[0])
            }
            R.id.tv_phone_register -> { //TODO 跳转手机注册fragment
                tvAccountRegister.visibility = View.GONE
                tvPhoneRegister.visibility = View.GONE
                flContainer.visibility = View.VISIBLE
                showFragment(mCurrentFragment, fragments[1])
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initData(savedInstanceState: Bundle?) {
        tvAccountRegister = findViewById<TextView>(R.id.tv_account_register).apply {
            setOnClickListener(this@RegisterActivity)
        }
        tvPhoneRegister = findViewById<TextView>(R.id.tv_phone_register).apply {
            setOnClickListener(this@RegisterActivity)
        }
        flContainer = findViewById(R.id.fl_container)
    }
}