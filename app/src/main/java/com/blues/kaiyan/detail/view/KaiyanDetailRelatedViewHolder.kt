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
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
 * User : Blues
 * Date : 2019/3/6
 */
class KaiyanDetailRelatedViewHolder(parent: ViewGroup?) :
    BaseViewHolder<KaiyanDetailBean.ItemListBean>(parent, R.layout.item_oe_detail_related) {

    private val itemText = itemView.findViewById<LinearLayout>(R.id.ll_item_text)
    private val itemVideo = itemView.findViewById<LinearLayout>(R.id.ll_item_video)
    private val tvText: TextView = itemView.findViewById(R.id.tv_text)
    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private val ivCover: ImageView = itemView.findViewById(R.id.iv_cover)

    override fun setData(item: KaiyanDetailBean.ItemListBean) {
        super.setData(item)

        with(item) {
            if (TextUtils.equals(type, "textCard")) {
                itemText.visibility = View.VISIBLE
                itemVideo.visibility = View.GONE
                tvText.text = data?.text
            } else if (TextUtils.equals(type, "videoSmallCard")) {
                itemText.visibility = View.GONE
                itemVideo.visibility = View.VISIBLE
                ivCover.load(data?.cover?.feed)
                tvTitle.text = data?.title
            }
        }

    }
}