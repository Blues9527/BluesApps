package com.example.lanhuajian.blues.framework.widget;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.R;

/**
 * User : Blues
 * Date : 2019/4/17
 */

public class ShowImageActivity extends Activity {

    private ImageView ivImageShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_image);

        ivImageShow = findViewById(R.id.image_show);

        String imgUrl = (String) getIntent().getExtras().get("imgUrl");
        Glide.with(this).load(imgUrl).into(ivImageShow);

        //单击图图片退出
        ivImageShow.setOnClickListener(v -> finish());
    }
}
