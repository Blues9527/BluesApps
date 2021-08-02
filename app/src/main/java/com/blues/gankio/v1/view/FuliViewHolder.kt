package com.blues.gankio.v1.view

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import com.blues.R
import com.blues.constant.IMAGE_URL
import com.blues.framework.utils.ScreenUtil.screenHeight
import com.blues.framework.utils.ScreenUtil.screenWidth
import com.blues.gankio.v1.ShowImageActivity
import com.blues.gankio.v1.model.GankBean
import com.bumptech.glide.Glide
import com.jude.easyrecyclerview.adapter.BaseViewHolder

class FuliViewHolder(parent: ViewGroup?) :
    BaseViewHolder<GankBean.ResultsBean>(parent, R.layout.item_fuli) {

    private val ivAvatar: ImageView = itemView.findViewById(R.id.tv_author)
    private val ivUrl: ImageView = itemView.findViewById(R.id.iv_url)
    private val tvDesc: TextView = itemView.findViewById(R.id.tv_desc)
    private val tvAuthor: TextView = itemView.findViewById(R.id.iv_avatar)
    private val tvSource: TextView = itemView.findViewById(R.id.tv_source)
    private val tvPTime: TextView = itemView.findViewById(R.id.tv_publish_time)

    override fun setData(data: GankBean.ResultsBean) {
        super.setData(data)

        //        tvDesc.setText(data.getDesc());
        ivUrl.layoutParams = LinearLayout.LayoutParams(screenWidth * 2 / 3, screenHeight / 3)
        Glide.with(ivUrl.context).load(data.url).placeholder(R.mipmap.ic_img_error).into(ivUrl)
        tvAuthor.text = "作者：${data.who}"
        tvSource.text = "来自：${data.source}"
        tvPTime.text = "日期：${data.publishedAt.substring(0, data.publishedAt.indexOf("T"))}"
        ivUrl.setOnClickListener {
            val intent = Intent(context, ShowImageActivity::class.java).putExtra(IMAGE_URL, data.url)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation((context as Activity), ivUrl, "transitionImage")
            context.startActivity(intent, options.toBundle())
        }
    }
}