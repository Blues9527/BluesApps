package com.blues.splash

import android.os.Bundle
import com.blues.R
import com.blues.framework.base.BaseKoinActivity
import com.blues.framework.utils.startActivity
import com.blues.framework.widget.TextClockView
import com.blues.framework.widget.countdownview.CountDownView
import com.blues.framework.widget.explosionanimator.ExplosionField
import com.blues.framework.widget.explosionanimator.FallingParticleFactory
import com.blues.login.view.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * User : Blues
 * Date : 2019/5/6
 * Time : 10:49
 */
class SplashActivity : BaseKoinActivity() {

    private lateinit var tcvSplash: TextClockView

    private lateinit var cdView: CountDownView
    private val mField: ExplosionField by lazy {
        ExplosionField(this@SplashActivity, FallingParticleFactory())
    }

    override fun getLayoutId(): Int = R.layout.dialog_splash

    override fun initData(savedInstanceState: Bundle?) {

        cdView = findViewById(R.id.cdv_count)
        tcvSplash = findViewById(R.id.rclv_splash)

        tcvSplash.startTimerSafely()
        cdView.setCountDownTimerCallBack(object : CountDownView.CountDownTimerCallBack {
            override fun onFinish() {
                mField.explode(cdView)
                CoroutineScope(Dispatchers.Main).launch {
                    delay(1500)
                    startActivity<LoginActivity>()
                    overridePendingTransition(R.anim.anim_zoom_in, 0)
                    finish()
                }
            }
        })
    }

    override fun onResume() {
        cdView.countDownResume()
        super.onResume()
    }

    override fun onPause() {
        cdView.countDownCancel()
        tcvSplash.release()
        super.onPause()
    }

    override fun onDestroy() {
        cdView.countDownCancel()
        tcvSplash.release()
        super.onDestroy()
        System.gc()
    }
}