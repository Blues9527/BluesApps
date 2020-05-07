package com.blues.module_gank.old.model_fuli.view;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blues.R;
import com.blues.constant.UsedConstant;
import com.blues.framework.utils.ScreenUtil;
import com.blues.module_gank.old.ShowImageActivity;
import com.blues.module_gank.old.model_fuli.model.FuliEntity;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import androidx.core.app.ActivityOptionsCompat;

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

//        tvDesc.setText(data.getDesc());
        ivUrl.setLayoutParams(new LinearLayout.LayoutParams(ScreenUtil.getScreenWidth() * 2 / 3, ScreenUtil.getScreenHeight() / 3));
        Glide.with(ivUrl.getContext()).load(data.getUrl()).placeholder(R.mipmap.ic_img_error).into(ivUrl);
        tvAuthor.setText(String.format("作者：%s", data.getWho()));
        tvSource.setText(String.format("来自：%s", data.getSource()));
        tvPTime.setText(String.format("日期：%s", data.getPublishedAt().substring(0, data.getPublishedAt().indexOf("T"))));

        ivUrl.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ShowImageActivity.class);
            intent.putExtra(UsedConstant.IMAGE_URL, data.getUrl());
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(), ivUrl, "transitionImage");
            getContext().startActivity(intent, options.toBundle());
        });
    }
}
