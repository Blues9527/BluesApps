package com.blues.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.blues.framework.base.BaseActivity;
import com.blues.R;
import com.blues.framework.widget.TextClockView;
import com.blues.framework.widget.countdownview.CountDownView;
import com.blues.framework.widget.explosionanimator.ExplosionField;
import com.blues.framework.widget.explosionanimator.FallingParticleFactory;
import com.blues.module_login.view.LoginActivity;

/**
 * User : Blues
 * Date : 2019/5/6
 * Time : 10:49
 */

public class SplashActivity extends BaseActivity {

    private CountDownView cdView;
    private ExplosionField mField;
    private TextClockView tcvSplash;

    @Override
    public int setLayoutResourceId() {
        return R.layout.dialog_splash;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        tcvSplash = findViewById(R.id.rclv_splash);
        tcvSplash.startTimerSafely();

        cdView = findViewById(R.id.cdv_count);

        mField = new ExplosionField(SplashActivity.this, new FallingParticleFactory());

        cdView.setCountDownTimerCallBack(() -> {
            mField.explode(cdView);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.anim_zoom_in, 0);
                    finish();
                }
            }, 1500);

        });

    }

    @Override
    protected void onResume() {
        cdView.countDownResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        cdView.countDownCancel();
        tcvSplash.release();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        cdView.countDownCancel();
        tcvSplash.release();
        super.onDestroy();
        System.gc();
    }

    @Override
    public void setListener() {

    }
}
