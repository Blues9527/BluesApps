package com.example.lanhuajian.blues.module_kaiyan.detail;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class OEDetailRelatedViewHolder extends BaseViewHolder<OEDetailRelatedEntity.ItemListBean> {

    private LinearLayout itemText, itemVideo;
    private TextView tvText, tvTitle;
    private ImageView ivCover;

    public OEDetailRelatedViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_oe_detail_related);

        itemText = $(R.id.ll_item_text);
        itemVideo = $(R.id.ll_item_video);

        tvText = $(R.id.tv_text);
        tvTitle = $(R.id.tv_title);

        ivCover = $(R.id.iv_cover);

        itemText.setVisibility(View.GONE);
        itemVideo.setVisibility(View.GONE);
    }

    @Override
    public void setData(OEDetailRelatedEntity.ItemListBean data) {
        super.setData(data);

        if (TextUtils.equals(data.getType(), "textCard")) {
            itemText.setVisibility(View.VISIBLE);
            itemVideo.setVisibility(View.GONE);
            tvText.setText(data.getData().getText());

        } else if (TextUtils.equals(data.getType(), "videoSmallCard")) {
            itemText.setVisibility(View.GONE);
            itemVideo.setVisibility(View.VISIBLE);
            Glide.with(getContext()).load(data.getData().getCover().getFeed()).into(ivCover);
            tvTitle.setText(data.getData().getTitle());
        }
    }
}
