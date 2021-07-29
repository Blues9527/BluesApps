package com.blues.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.blues.MainActivity;
import com.blues.R;
import com.blues.framework.base.BaseActivity;

/**
 * File: com.blues.splash.ImageSplashActivity
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-06-17 17:49
 **/


public class ImageSplashActivity extends BaseActivity {


    private static final int SPLASH_ID = 0xff0001;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public ImageSplashActivity() {
    }

    private final Runnable mRunnable = () -> {
        FrameLayout decorView = (FrameLayout) getWindow().getDecorView();
        View view = decorView.findViewById(SPLASH_ID);
        if (view != null) {
            decorView.removeView(view);
        }



        startActivity(new Intent(ImageSplashActivity.this, MainActivity.class));
        ImageSplashActivity.this.finish();
    };

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_placeholder;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout decorView = (FrameLayout) getWindow().getDecorView();
        FrameLayout splashView = (FrameLayout) LayoutInflater.from(this).inflate(R.layout.item_splash, null);
        splashView.setId(SPLASH_ID);
        splashView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        decorView.addView(splashView);

        mHandler.postDelayed(mRunnable, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }
}
