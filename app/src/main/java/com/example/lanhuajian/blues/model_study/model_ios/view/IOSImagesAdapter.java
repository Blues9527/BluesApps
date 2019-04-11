package com.example.lanhuajian.blues.model_study.model_ios.view;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.framework.utils.ScreenUtil;
import com.example.framework.utils.SizeUtil;
import com.example.lanhuajian.blues.R;

import java.util.List;

public class IOSImagesAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public IOSImagesAdapter(@Nullable List<String> data) {
        super(R.layout.item_item_image, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String url) {

        //设置每张图片的长度
        int width = ScreenUtil.getScreenWidth();
        helper.getView(R.id.iv_item).setLayoutParams(new ViewGroup.LayoutParams(width / 3, SizeUtil.dp2px(150)));

        if (url != null && !TextUtils.isEmpty(url)) {
            Glide.with(mContext).load(url).placeholder(R.drawable.shape_place_holder).into((ImageView) helper.getView(R.id.iv_item));
        }
    }
}
