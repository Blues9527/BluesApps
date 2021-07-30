package com.blues.gankio._new.mvp.view;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blues.R;
import com.blues.gankio._new.detail.GankPostDetailActivity;
import com.blues.gankio._new.mvp.model.GankUniversalEntity;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;

public class GankViewHolder extends BaseViewHolder<GankUniversalEntity.DataBean> {

    private ImageView ivPreview;
    private TextView tvTitle, tvAuthor, tvViews, tvLikes, tvPTime;
    private ConstraintLayout clRoot;

    public GankViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_gank);

        tvTitle = $(R.id.tv_title);
        tvAuthor = $(R.id.tv_author);
        tvViews = $(R.id.tv_views);
        tvLikes = $(R.id.tv_likes);
        tvPTime = $(R.id.tv_publish_time);
        ivPreview = $(R.id.iv_preview);
        clRoot = $(R.id.cl_root);
    }

    @Override
    public void setData(GankUniversalEntity.DataBean data) {
        super.setData(data);

        tvTitle.setText(data.getTitle());
        tvAuthor.setText(String.format("作者：%s", data.getAuthor()));

        if (data.getImages().size() != 0) {
            Glide.with(getContext()).load(data.getImages().get(0)).placeholder(R.mipmap.ic_img_error).into(ivPreview);
        } else {
            Glide.with(getContext()).load(R.mipmap.ic_img_error).placeholder(R.mipmap.ic_img_error).into(ivPreview);
        }

        tvViews.setText(String.valueOf(data.getViews()));
        tvLikes.setText(String.valueOf(data.getLikeCounts()));
        tvPTime.setText(String.format("日期:%s", data.getPublishedAt()));

        clRoot.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), GankPostDetailActivity.class);
            intent.putExtra("postId", data.get_id());
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) getContext(), clRoot, "transitionGank");
            getContext().startActivity(intent, options.toBundle());
        });
    }
}
