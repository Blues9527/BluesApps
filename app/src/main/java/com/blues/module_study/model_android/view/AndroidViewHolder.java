package com.blues.module_study.model_android.view;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blues.R;
import com.blues.WebViewDialog;
import com.blues.module_study.ShowImageActivity;
import com.blues.module_study.model_android.model.AndroidEntity;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;

/**
 * User : Blues
 * Date : 2019/3/6
 */

public class AndroidViewHolder extends BaseViewHolder<AndroidEntity.ResultsBean> {

    private TextView tvDesc, tvAuthor, tvDate, tvPublisher;
    private ImageView ivCover;
    private ConstraintLayout clRoot;

    public AndroidViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_android);

        tvDesc = $(R.id.tv_desc);
        tvAuthor = $(R.id.tv_author);
        clRoot = $(R.id.cl_root);
        ivCover = $(R.id.iv_cover);
        tvDate = $(R.id.tv_publish_time);
        tvPublisher = $(R.id.tv_source);
    }

    @Override
    public void setData(AndroidEntity.ResultsBean data) {
        super.setData(data);

        tvDesc.setText(data.getDesc());
        tvAuthor.setText(data.getWho());

        if (data.getImages() != null && data.getImages().size() != 0) {
            ivCover.setVisibility(View.VISIBLE);
            Glide.with(getContext()).load(data.getImages().get(0)).placeholder(R.mipmap.ic_img_error).into(ivCover);

            ivCover.setOnClickListener(v -> {
                //跳转到ShowImageActivity
                Intent intent = new Intent(getContext(), ShowImageActivity.class);
                intent.putExtra("param", data);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(), ivCover, "transitionImage");
                getContext().startActivity(intent, options.toBundle());
            });
        }

        tvDate.setText(String.format("日期：%s", data.getPublishedAt().substring(0, data.getPublishedAt().indexOf("T"))));
        tvPublisher.setText(String.format("来自：%s", data.getSource()));

        if (!TextUtils.isEmpty(data.getUrl())) {
            clRoot.setOnClickListener(v -> new WebViewDialog(getContext(), data.getUrl()).show());
        }
    }
}
