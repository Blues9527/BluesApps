package com.blues.module_gank._new.girl;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blues.R;
import com.blues.module_gank._new.mvp.model.GankUniversalEntity;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

public class GankGirlsViewHolder extends BaseViewHolder<GankUniversalEntity.DataBean> {

    private TextView tvTitle, tvDesc, tvAuthor, tvDate, tvTag, tvLikes, tvViews;
    private ImageView ivCover;

    public GankGirlsViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_gank_girl);
        tvTitle = $(R.id.tv_title);
        tvDesc = $(R.id.tv_desc);
        tvAuthor = $(R.id.tv_author);
        tvDate = $(R.id.tv_date);
        tvTag = $(R.id.tv_tag);
        tvLikes = $(R.id.tv_likes);
        tvViews = $(R.id.tv_views);
        ivCover = $(R.id.iv_cover);
    }

    @Override
    public void setData(GankUniversalEntity.DataBean data) {
        super.setData(data);

        tvTitle.setText(data.getTitle());
        tvDesc.setText(data.getDesc());
        tvDate.setText(data.getPublishedAt());
        tvAuthor.setText(data.getAuthor());
        tvTag.setText(String.format("#%s#", data.getType()));
        tvLikes.setText(String.valueOf(data.getLikeCounts()));
        tvViews.setText(String.valueOf(data.getViews()));
        Glide.with(getContext()).load(data.getImages().get(0)).into(ivCover);
    }
}
