package com.example.lanhuajian.blues.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.framework.base.BaseActivity;
import com.example.lanhuajian.blues.framework.utils.ResourcesUtils;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.widget.TextClockView;
import com.example.lanhuajian.blues.framework.widget.countdownview.CountDownView;
import com.example.lanhuajian.blues.framework.widget.explosionanimator.ExplosionField;
import com.example.lanhuajian.blues.framework.widget.explosionanimator.FallingParticleFactory;
import com.example.lanhuajian.blues.module_login.LoginActivity;

import java.lang.ref.WeakReference;
import java.util.Locale;

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
