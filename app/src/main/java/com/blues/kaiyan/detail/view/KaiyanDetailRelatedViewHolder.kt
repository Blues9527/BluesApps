package com.blues.kaiyan.detail.view

import android.view.ViewGroup
import com.blues.kaiyan.detail.model.KaiyanDetailBean
import com.blues.R
import android.widget.LinearLayout
import android.widget.TextView
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import coil.load
import com.bumptech.glide.Glide
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
 * User : Blues
 * Date : 2019/3/6
 */
class KaiyanDetailRelatedViewHolder(parent: ViewGroup?) :
    BaseViewHolder<KaiyanDetailBean.ItemListBean>(parent, R.layout.item_oe_detail_related) {

    private val itemText = itemView.findViewById<LinearLayout>(R.id.ll_item_text).apply {
        visibility = View.GONE
    }
    private val itemVideo = itemView.findViewById<LinearLayout>(R.id.ll_item_video).apply {
        visibility = View.GONE
    }
    private val tvText: TextView = itemView.findViewById(R.id.tv_text)
    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private val ivCover: ImageView = itemView.findViewById(R.id.iv_cover)

    override fun setData(data: KaiyanDetailBean.ItemListBean) {
        super.setData(data)

        if (TextUtils.equals(data.type, "textCard")) {
            itemText.visibility = View.VISIBLE
            itemVideo.visibility = View.GONE
            tvText.text = data.data.text
        } else if (TextUtils.equals(data.type, "videoSmallCard")) {
            itemText.visibility = View.GONE
            itemVideo.visibility = View.VISIBLE
            ivCover.load(data.data.cover.feed)
            //Glide.with(context).load(data.data.cover.feed).into(ivCover)
            tvTitle.text = data.data.title
        }
    }
}