package com.blues.model_wanandroid;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blues.R;
import com.blues.WebViewDialog;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * User : Blues
 * Date : 2019/3/6
 */

public class WanAndroidViewHolder extends BaseViewHolder<WanAndroidEntity.DataBean.DatasBean> {

    private ImageView ivCover;
    private TextView tvTitle, tvTag, tvDesc, tvAuthor, tvDate;
    private ConstraintLayout clRoot;

    public WanAndroidViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_wan_android);

        ivCover = $(R.id.iv_cover);
        tvTitle = $(R.id.tv_title);
        tvTag = $(R.id.tv_tag);
        tvDesc = $(R.id.tv_desc);
        tvAuthor = $(R.id.tv_author);
        tvDate = $(R.id.tv_date);
        clRoot = $(R.id.cl_root);
    }

    @Override
    public void setData(WanAndroidEntity.DataBean.DatasBean data) {
        super.setData(data);

        //设置cover
        if (!TextUtils.isEmpty(data.getEnvelopePic())) {
            ivCover.setVisibility(View.VISIBLE);
            Glide.with(getContext()).load(data.getEnvelopePic()).into(ivCover);
        }

        tvTitle.setText(data.getTitle());

        tvTag.setText(data.getChapterName());

        tvDesc.setText(data.getDesc());

        tvAuthor.setText(data.getAuthor());

        tvDate.setText(data.getNiceDate());

        clRoot.setOnClickListener(v -> new WebViewDialog(getContext(), data.getLink()).show());
    }
}
