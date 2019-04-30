package com.example.lanhuajian.blues.module_study.model_web.view;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.WebViewDialog;
import com.example.lanhuajian.blues.module_study.model_web.model.WebEntity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

public class WebViewHolder extends BaseViewHolder<WebEntity.ResultsBean> {

    private ImageView ivAvatar;
    private TextView tvDesc, tvAuthor, tvSource, tvPTime, tvUrl;
    private EasyRecyclerView rvImages;

    public WebViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_test);

        rvImages = $(R.id.rv_images);
        tvDesc = $(R.id.tv_desc);
        tvAuthor = $(R.id.tv_author);
        tvSource = $(R.id.tv_source);
        tvPTime = $(R.id.tv_publish_time);
        ivAvatar = $(R.id.iv_avatar);
        tvUrl = $(R.id.tv_url);
    }

    @Override
    public void setData(WebEntity.ResultsBean data) {
        super.setData(data);

        Log.i("Blues", data.toString());

        tvDesc.setText(data.getDesc());
        tvUrl.setText(data.getUrl());
        tvAuthor.setText(String.format("作者：%s", data.getWho()));
        tvSource.setText(String.format("来自：%s", data.getSource()));
        tvPTime.setText(String.format("日期：%s", data.getPublishedAt().substring(0, data.getPublishedAt().indexOf("T"))));

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvImages.setLayoutManager(layoutManager);
        rvImages.setAdapter(new WebImagesAdapter(data.getImages()));

        tvUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new WebViewDialog(getContext(), data.getUrl()).show();
            }
        });
    }
}