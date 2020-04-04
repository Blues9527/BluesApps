package com.blues.model_wanandroid.netease;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.blues.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * User : Blues
 * Date : 2019/10/21
 * Time : 16:41
 */

public class CategoryViewHolder extends BaseViewHolder<CategoryEntity.ResultBean.SectionDtoListBean.ElementDtoListBean> {

    private ImageView ivCategoryCover;
    private TextView tvCategoryTitle;

    public CategoryViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_category);
        ivCategoryCover = $(R.id.iv_category_teacher);
        tvCategoryTitle = $(R.id.tv_category_title);
    }

    @Override
    public void setData(CategoryEntity.ResultBean.SectionDtoListBean.ElementDtoListBean data) {
        super.setData(data);

        Glide.with(getContext()).load(data.getPhotoUrl()).into(ivCategoryCover);
        tvCategoryTitle.setText(data.getName());
    }
}
