package com.example.lanhuajian.blues.framework.widget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.R;

/**
 * User : Blues
 * Date : 2019/4/17
 * Time : 15:06
 */

public class ShowImageActivity extends AppCompatActivity {

    private ImageView ivImageShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_image);

        ivImageShow = findViewById(R.id.image_show);

        //获取跳转时传过来的参数
        final String url = getIntent().getStringExtra("url");

        if (!TextUtils.isEmpty(url)) {
            new Handler(Looper.getMainLooper()).post(() -> {
                Log.i("Blues", url);
                Glide.with(ShowImageActivity.this).load(url).placeholder(R.drawable.shape_place_holder).into(ivImageShow);
            });

        }

        //单击图图片退出
        ivImageShow.setOnClickListener(v -> finish());
    }


}
