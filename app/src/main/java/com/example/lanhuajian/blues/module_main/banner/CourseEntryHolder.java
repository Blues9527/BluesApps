package com.example.lanhuajian.blues.module_main.banner;

import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.utils.ScreenUtil;
import com.example.lanhuajian.blues.framework.utils.SizeUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * User : Blues
 * Date : 2019/8/8
 * Time : 15:49
 */

public class CourseEntryHolder extends BaseViewHolder<CourseEntry> {

    private ImageView ivIcon;
    private TextView tvTitle;

    public CourseEntryHolder(ViewGroup parent) {
        super(parent, R.layout.item_course_entry);

        ivIcon = $(R.id.iv_entry_icon);
        tvTitle = $(R.id.tv_entry_title);
        LinearLayout llContainer = $(R.id.ll_course_entry);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.width = ScreenUtil.getScreenWidth() / 4;
        params.topMargin = SizeUtil.dp2px(5);
        params.bottomMargin = SizeUtil.dp2px(5);

        llContainer.setLayoutParams(params);
    }

    @Override
    public void setData(CourseEntry data) {
        super.setData(data);

        Glide.with(getContext()).load(data.getEntryIcon()).into(ivIcon);
        tvTitle.setText(data.getEntryTitle());
    }
}
