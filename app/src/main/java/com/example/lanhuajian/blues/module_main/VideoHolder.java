package com.example.lanhuajian.blues.module_main;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.utils.SizeUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:39
 */

public class VideoHolder extends BaseViewHolder<VideoEntity.DataBean> {

    private ImageView ivCover;
    private TextView tvTime;
    private TextView tvTitle;
    private TextView tvAuthor;

    public VideoHolder(ViewGroup parent) {
        super(parent, R.layout.item_video_mp);

        ivCover = $(R.id.iv_cover);
        tvTime = $(R.id.tv_time);
        tvTitle = $(R.id.tv_title);
        tvAuthor = $(R.id.tv_author);
    }

    @Override
    public void setData(VideoEntity.DataBean data) {
        super.setData(data);
        Glide.with(getContext()).load(data.getCover_url()).placeholder(R.drawable.shape_place_holder).into(ivCover);
        tvTime.setText(data.getVideo_time());
        tvTitle.setText(data.getVideo_title());
        tvAuthor.setText(data.getVideo_author());
    }
}
