package com.blues.splash

import android.os.Looper
import android.widget.FrameLayout
import com.blues.MainActivity
import com.blues.R
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blues.framework.base.BaseKoinActivity

/**
 * File: com.blues.splash.ImageSplashActivity
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-06-17 17:49
 */
class ImageSplashActivity : BaseKoinActivity() {

    companion object {

        private const val SPLASH_ID = 0xff0001
    }

    private val mHandler = Handler(Looper.getMainLooper())
    private val mRunnable = Runnable {
        val decorView = window.decorView as FrameLayout
        decorView.findViewById<View>(SPLASH_ID)?.also {
            decorView.removeView(it)
        }
        startActivity<MainActivity>()
        finish()
    }

    override fun getLayoutId(): Int = R.layout.activity_placeholder

    override fun initData(savedInstanceState: Bundle?) {

        (LayoutInflater.from(this).inflate(R.layout.item_splash, null) as FrameLayout).apply {
            id = SPLASH_ID
            layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }.also {
            (window.decorView as FrameLayout).addView(it)
        }
        mHandler.postDelayed(mRunnable, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacks(mRunnable)
    }
}