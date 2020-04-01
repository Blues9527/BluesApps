package com.blues.module_study.model_android.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blues.R;
import com.blues.WebViewDialog;
import com.blues.module_study.ShowImageActivity;
import com.blues.module_study.model_android.model.AndroidEntity;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import androidx.core.app.ActivityOptionsCompat;

/**
 * User : Blues
 * Date : 2019/3/6
 */

public class AndroidViewHolder extends BaseViewHolder<AndroidEntity.ResultsBean> {

    private TextView tvDesc, tvAuthor;
    private ImageView ivCover;
    private RelativeLayout rlRoot;

    public AndroidViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_android);

        tvDesc = $(R.id.tv_desc);
        tvAuthor = $(R.id.tv_author);
        rlRoot = $(R.id.rl_root);
        ivCover = $(R.id.iv_cover);
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

        rlRoot.setOnClickListener(v -> new WebViewDialog(getContext(), data.getUrl()).show());
    }
}
