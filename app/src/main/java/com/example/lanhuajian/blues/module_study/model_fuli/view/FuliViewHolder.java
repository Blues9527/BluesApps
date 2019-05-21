package com.example.lanhuajian.blues.module_study.model_fuli.view;

import android.content.Intent;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.framework.utils.ScreenUtil;
import com.example.lanhuajian.blues.framework.widget.ShowImageActivity;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.module_study.model_fuli.model.FuliEntity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

public class FuliViewHolder extends BaseViewHolder<FuliEntity.ResultsBean> {

    private ImageView ivAvatar, ivUrl;
    private TextView tvDesc, tvAuthor, tvSource, tvPTime;

    public FuliViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_fuli);

        tvDesc = $(R.id.tv_desc);
        tvAuthor = $(R.id.tv_author);
        tvSource = $(R.id.tv_source);
        tvPTime = $(R.id.tv_publish_time);
        ivAvatar = $(R.id.iv_avatar);
        ivUrl = $(R.id.iv_url);
    }

    @Override
    public void setData(FuliEntity.ResultsBean data) {
        super.setData(data);

        Log.i("Blues", data.toString());

        tvDesc.setText(data.getDesc());
        ivUrl.setLayoutParams(new LinearLayout.LayoutParams(ScreenUtil.getScreenWidth() * 2 / 3, ScreenUtil.getScreenHeight() / 3));
        Glide.with(getContext()).load(data.getUrl()).into(ivUrl);
        tvAuthor.setText(String.format("作者：%s", data.getWho()));
        tvSource.setText(String.format("来自：%s", data.getSource()));
        tvPTime.setText(String.format("日期：%s", data.getPublishedAt().substring(0, data.getPublishedAt().indexOf("T"))));

        ivUrl.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("url", data.getUrl());
            Log.i("Blues", data.getUrl());
            intent.setClass(getContext(), ShowImageActivity.class);
            getContext().startActivity(intent);
        });
    }
}
