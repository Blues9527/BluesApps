package com.example.lanhuajian.blues.module_kaiyan.historicalrank;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.utils.TimeFormatUtil;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeEntity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * User : Blues
 * Date : 2019/3/6
 */

public class OEHistoricalRankViewHolder extends BaseViewHolder<OpenEyeEntity.ItemListBean> {

    private ImageView ivAvatar;
    private TextView tvTitle, tvTags, tvCategory;
    private ImageView coverHotRank;

    public OEHistoricalRankViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_oe_hotrank_list);

        ivAvatar = $(R.id.iv_avatar);
        tvTitle = $(R.id.tv_title);
        coverHotRank = $(R.id.iv_hotrank_cover);
        tvTags = $(R.id.tv_tags);
        tvCategory = $(R.id.tv_category);

    }

    @Override
    public void setData(OpenEyeEntity.ItemListBean data) {
        super.setData(data);
        StringBuilder sb = new StringBuilder();
        Glide.with(getContext()).load(data.getData().getAuthor().getIcon()).into(ivAvatar);
        Glide.with(getContext()).load(data.getData().getCover().getDetail()).into(coverHotRank);
        tvTitle.setText(data.getData().getTitle());

        for (OpenEyeEntity.ItemListBean.DataBean.TagsBean tagsBean : data.getData().getTags()) {
            sb.append(tagsBean.getName() + "/");
        }
        tvTags.setText(String.format("#%s%s", sb, TimeFormatUtil.formatTime(data.getData().getDuration())));
        tvCategory.setText(String.format("#%s", data.getData().getCategory()));
    }
}
