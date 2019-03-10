package com.example.lanhuajian.blues.view;


import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.framework.utils.ScreenUtil;
import com.example.framework.utils.SizeUtil;
import com.example.lanhuajian.blues.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.util.List;

public class CSubViewHolder extends BaseViewHolder<List<String>> {

    private ImageView ivItem;

    public CSubViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_item_image);

        ivItem = $(R.id.iv_item);
    }

    @Override
    public void setData(List<String> data) {
        super.setData(data);

        int width = ScreenUtil.getScreenWidth();
        ivItem.setLayoutParams(new ViewGroup.LayoutParams(width / 3, SizeUtil.dp2px(150)));

        if (data != null) {
            if (data.size() != 0) {
                for (String url : data) {

                    Glide.with(getContext()).load(url).placeholder(R.drawable.shape_place_holder).into(ivItem);
                }
            }
        }

    }
}
