package com.example.lanhuajian.blues.module_main.banner;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User : Blues
 * Date : 2019/10/21
 * Time : 16:41
 */

public class CategoryCourseViewHolder extends BaseViewHolder<CategoryCourseEntity.ResultBean.CourseDtoListBean> {

    private ImageView ivCategoryCourseCover;
    private TextView tvCategoryCourseTitle, tvCategoryCoursePrice;

    public CategoryCourseViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_categorycourse);
        ivCategoryCourseCover = $(R.id.iv_categorycourse_cover);
        tvCategoryCourseTitle = $(R.id.tv_categorycourse_title);
        tvCategoryCoursePrice = $(R.id.tv_categorycourse_price);
    }

    @Override
    public void setData(CategoryCourseEntity.ResultBean.CourseDtoListBean data) {
        super.setData(data);

        Glide.with(getContext()).load(data.getYktCourseCardv().getMiddlePhotoUrl()).error(R.mipmap.ic_img_error).into(ivCategoryCourseCover);
        tvCategoryCourseTitle.setText(data.getYktCourseCardv().getName());
        if (data.getYktCourseCardv().getPrice() == 0) {
            tvCategoryCoursePrice.setText("免费");
        } else {
            tvCategoryCoursePrice.setText(String.format("￥ %s", String.valueOf(data.getYktCourseCardv().getPrice())));
        }
    }
}
