package com.blues.gankio.v1

import com.chad.library.adapter.base.BaseQuickAdapter
import com.blues.R
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import coil.load
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseViewHolder

class ImagesAdapter(data: List<String?>?) :
    BaseQuickAdapter<String?, BaseViewHolder>(R.layout.item_item_image, data) {

    override fun convert(helper: BaseViewHolder, url: String?) {

        //设置每张图片的长度
        if (url != null && !TextUtils.isEmpty(url)) {
            (helper.getView<View>(R.id.iv_item) as ImageView).load(url){

            }
            Glide.with(mContext).load(url).error(R.mipmap.ic_network_error)
                .into((helper.getView<View>(R.id.iv_item) as ImageView))

            //            helper.getView(R.id.iv_item).setOnClickListener(v -> {
            //                Intent intent = new Intent(mContext, ShowImageActivity.class);
            //                intent.putExtra(UsedConstant.IMAGE_URL, url);
            //                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, helper.getView(R.id.iv_item), "transitionImage");
            //                mContext.startActivity(intent, options.toBundle());
            //            });
        }
    }
}