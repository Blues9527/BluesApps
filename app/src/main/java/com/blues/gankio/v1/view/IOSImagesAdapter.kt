package com.blues.gankio.v1.view

import com.blues.framework.utils.ScreenUtil.screenWidth
import com.chad.library.adapter.base.BaseQuickAdapter
import com.blues.R
import android.view.ViewGroup.MarginLayoutParams
import android.text.TextUtils
import android.content.Intent
import androidx.core.app.ActivityOptionsCompat
import android.app.Activity
import android.view.View
import android.widget.ImageView
import coil.load
import com.blues.constant.IMAGE_URL
import com.blues.framework.utils.dp
import com.chad.library.adapter.base.BaseViewHolder

class IOSImagesAdapter(data: List<String?>?) :
    BaseQuickAdapter<String?, BaseViewHolder>(R.layout.item_item_image, data) {

    override fun convert(helper: BaseViewHolder, url: String?) {

        //设置每张图片的长度
        val width = screenWidth
        val params = MarginLayoutParams(width / 4, 150f.dp.toInt()).apply {
            setMargins(5f.dp.toInt(), 5f.dp.toInt(), 5f.dp.toInt(), 0)
        }
        helper.getView<View>(R.id.iv_item).layoutParams = params

        url?.let {
            if (!TextUtils.isEmpty(url)) {

                (helper.getView<View>(R.id.iv_item) as ImageView).load(url){
                    placeholder(R.drawable.shape_place_holder)
                    error(R.drawable.shape_place_holder)
                }

                //Glide.with(helper.getView<View>(R.id.iv_item).context).load(url)
                //    .placeholder(R.drawable.shape_place_holder)
                //    .into((helper.getView<View>(R.id.iv_item) as ImageView))

                helper.getView<View>(R.id.iv_item).setOnClickListener {
                    val intent = Intent(mContext, ShowImageActivity::class.java).putExtra(IMAGE_URL, url)
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation((mContext as Activity), helper.getView(R.id.iv_item), "transitionImage")
                    mContext.startActivity(intent, options.toBundle())
                }
            }
        }
    }
}