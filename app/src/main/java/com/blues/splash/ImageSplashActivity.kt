package com.blues.splash

import android.widget.FrameLayout
import com.blues.MainActivity
import com.blues.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.blues.constant.USER_INFO_KEY
import com.blues.framework.base.BaseKoinActivity
import com.blues.framework.utils.startActivity
import com.blues.login.view.LoginActivity
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.*
import org.koin.android.ext.android.get

/**
 * File: com.blues.splash.ImageSplashActivity
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-06-17
 */
class ImageSplashActivity : BaseKoinActivity() {

    companion object {

        private const val SPLASH_ID = 0xff0001
    }

    private val mmkv: MMKV = get()

    override fun getLayoutId(): Int = R.layout.activity_placeholder

    override fun initData(savedInstanceState: Bundle?) {
        //使用coroutine替代handler
        CoroutineScope(Dispatchers.Main).launch {

            val decorView = window.decorView as FrameLayout

            val decor = LayoutInflater.from(this@ImageSplashActivity)
                .inflate(R.layout.item_splash, null) as ConstraintLayout

            val skipTv = decor.findViewById<TextView>(R.id.tv_skip)
            skipTv.setOnClickListener {
                startActivity<MainActivity>()
                finish()
                cancel()
            }

            decor.apply {
                id = SPLASH_ID
                layoutParams = ConstraintLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
            decorView.addView(decor)

            //延迟2s消失
            delay(2000)
            decorView.findViewById<View>(SPLASH_ID)?.also {
                decorView.removeView(it)
            }
            val userInfo = mmkv.getString(USER_INFO_KEY, "")
            if (userInfo!!.isNotEmpty()) {
                startActivity<MainActivity>()
            } else {
                startActivity<LoginActivity>()
            }
            finish()
        }
    }
}