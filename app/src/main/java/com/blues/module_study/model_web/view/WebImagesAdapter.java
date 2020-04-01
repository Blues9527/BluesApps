package com.blues.module_study.model_web.view;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.blues.constant.UsedConstant;
import com.blues.framework.utils.ScreenUtil;
import com.blues.framework.utils.SizeUtil;
import com.blues.module_study.ShowImageActivity;
import com.blues.R;

import java.util.List;

public class WebImagesAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public WebImagesAdapter(@Nullable List<String> data) {
        super(R.layout.item_item_image, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String url) {

        //设置每张图片的长度
        int width = ScreenUtil.getScreenWidth();
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(width / 4, SizeUtil.dp2px(150));
        params.setMargins(SizeUtil.dp2px(5), SizeUtil.dp2px(5), SizeUtil.dp2px(5), 0);
        helper.getView(R.id.iv_item).setLayoutParams(params);

        if (url != null && !TextUtils.isEmpty(url)) {
            Glide.with(mContext).load(url).placeholder(R.drawable.shape_place_holder).into((ImageView) helper.getView(R.id.iv_item));

            helper.getView(R.id.iv_item).setOnClickListener(v -> {
                Intent intent = new Intent(mContext, ShowImageActivity.class);
                intent.putExtra(UsedConstant.IMAGE_URL, url);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, helper.getView(R.id.iv_item), "transitionImage");
                mContext.startActivity(intent, options.toBundle());
            });
        }
    }
}
