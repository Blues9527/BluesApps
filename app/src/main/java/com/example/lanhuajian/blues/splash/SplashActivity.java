package com.example.lanhuajian.blues.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.framework.base.BaseActivity;
import com.example.lanhuajian.blues.framework.utils.ResourcesUtils;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.module_login.LoginActivity;

import java.lang.ref.WeakReference;
import java.util.Locale;

/**
 * User : Blues
 * Date : 2019/5/6
 * Time : 10:49
 */

public class SplashActivity extends BaseActivity {

    private ImageView ivSplash;
    private TextView tvCountDown;
    private SplashTimer mTimer;

    @Override
    public int setLayoutResourceId() {
        return R.layout.dialog_splash;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        ivSplash = findViewById(R.id.iv_splash);
        tvCountDown = findViewById(R.id.tv_count_down);

        Glide.with(mContext).load(ResourcesUtils.getMipmapID("ic_background", mContext)).into(ivSplash);

        mTimer = new SplashTimer(this);
        mTimer.start();
    }

    @Override
    protected void onDestroy() {
        if (mTimer != null) {
            mTimer.cancel();
        }
        super.onDestroy();
        System.gc();
    }

    @Override
    public void setListener() {

    }

    private class SplashTimer extends CountDownTimer {

        private WeakReference<SplashActivity> weakReference;

        SplashTimer(SplashActivity splashActivity) {
            super(5000, 1000);
            this.weakReference = new WeakReference<>(splashActivity);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            weakReference.get().tvCountDown.setText(String.format(Locale.getDefault(), "%ds", millisUntilFinished / 1000));
        }

        @Override
        public void onFinish() {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            overridePendingTransition(R.anim.anim_zoom_in, 0);
            finish();
        }
    }
}
