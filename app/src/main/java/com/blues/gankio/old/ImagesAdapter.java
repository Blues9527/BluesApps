package com.blues.gankio.old;

import android.text.TextUtils;
import android.widget.ImageView;

import com.blues.R;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.Nullable;

public class ImagesAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public ImagesAdapter(@Nullable List<String> data) {
        super(R.layout.item_item_image, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String url) {
        //设置每张图片的长度
        if (url != null && !TextUtils.isEmpty(url)) {
            Glide.with(mContext).load(url).error(R.mipmap.ic_network_error).into((ImageView) helper.getView(R.id.iv_item));

//            helper.getView(R.id.iv_item).setOnClickListener(v -> {
//                Intent intent = new Intent(mContext, ShowImageActivity.class);
//                intent.putExtra(UsedConstant.IMAGE_URL, url);
//                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, helper.getView(R.id.iv_item), "transitionImage");
//                mContext.startActivity(intent, options.toBundle());
//            });
        }
    }
}
