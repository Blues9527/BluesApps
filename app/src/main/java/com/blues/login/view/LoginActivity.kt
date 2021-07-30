package com.blues.login.view

import android.widget.TextView
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.blues.R
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.blues.MainActivity
import androidx.fragment.app.Fragment
import com.blues.framework.base.BaseKoinActivity
import com.blues.register.view.RegisterActivity

/**
 * User : Blues
 * Date : 2019/4/25
 * Time : 14:22
 */
class LoginActivity : BaseKoinActivity(), View.OnClickListener {

    private val fragments: MutableList<Fragment> = mutableListOf(AccountLoginFragment(), PhoneLoginFragment())
    private var mCurrentFragment: Fragment? = null
    private lateinit var flContainer: FrameLayout
    private lateinit var llContainer: LinearLayout

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_skip -> {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                overridePendingTransition(R.anim.anim_zoom_in, R.anim.anim_slide_to_bottom)
                finish()
            }
            R.id.tv_account_login -> {

                // 跳转账号登陆fragment
                llContainer.visibility = View.GONE
                flContainer.visibility = View.VISIBLE
                showFragment(mCurrentFragment, fragments[0])

            }
            R.id.tv_phone_login -> {

                //跳转手机登陆fragment
                llContainer.visibility = View.GONE
                flContainer.visibility = View.VISIBLE
                showFragment(mCurrentFragment, fragments[1])
            }
            R.id.tv_user_reg -> {
                startActivity(Intent(this, RegisterActivity::class.java))
                finish()
            }
        }
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

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData(savedInstanceState: Bundle?) {
        findViewById<TextView>(R.id.tv_skip).also {
            it.setOnClickListener(this)
        }
        findViewById<TextView>(R.id.tv_forget_pwd).also {
            it.setOnClickListener(this)
        }

        findViewById<TextView>(R.id.tv_user_reg).also {
            it.setOnClickListener(this)
        }
        findViewById<TextView>(R.id.tv_account_login).also {
            it.setOnClickListener(this)
        }
        findViewById<TextView>(R.id.tv_phone_login).also {
            it.setOnClickListener(this)
        }
        flContainer = findViewById(R.id.fl_container)
        llContainer = findViewById(R.id.ll_container)
    }
}