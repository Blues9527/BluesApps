package com.example.lanhuajian.blues.module_main.banner;

import android.util.Log;
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

public class MicroSpecViewHolder extends BaseViewHolder<MicroSpecEntity.ResultBean> {

    private ImageView ivMicroTeacher;
    private TextView tvMicroTime, tvMicroTitle, tvMicroTeacherDesc;

    public MicroSpecViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_microspec);
        ivMicroTeacher = $(R.id.iv_micro_teacher);
        tvMicroTime = $(R.id.tv_micro_time);
        tvMicroTitle = $(R.id.tv_micro_title);
        tvMicroTeacherDesc = $(R.id.tv_micro_teacher_desc);
    }

    @Override
    public void setData(MicroSpecEntity.ResultBean data) {
        super.setData(data);

        Log.i("Bluesss", "进入此页面");

        Glide.with(getContext()).load(data.getImgUrl()).into(ivMicroTeacher);
        tvMicroTime.setText(new SimpleDateFormat("yyyy年MM月dd日 w晚上hh:mm").format(new Date(data.getLiveStartTime())));
        tvMicroTitle.setText(data.getProductName());
        tvMicroTeacherDesc.setText(String.format("讲师:%s", data.getInstructor()));
    }
}
