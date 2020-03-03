package com.blues.module_kaiyan.search;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.blues.R;
import com.blues.module_kaiyan.OpenEyeEntity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * User : Blues
 * Date : 2019/8/28
 * Time : 18:30
 */

public class OESearchResultViewHolder extends BaseViewHolder<OpenEyeEntity.ItemListBean.DataBean> {

    private ImageView ivCover;
    private TextView tvTitle;

    public OESearchResultViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_search_result);

        ivCover = $(R.id.iv_search_result_cover);
        tvTitle = $(R.id.tv_search_result_title);
    }

    @Override
    public void setData(OpenEyeEntity.ItemListBean.DataBean data) {

        Glide.with(getContext()).load(data.getCover().getDetail()).into(ivCover);
        tvTitle.setText(data.getTitle());
    }
}
