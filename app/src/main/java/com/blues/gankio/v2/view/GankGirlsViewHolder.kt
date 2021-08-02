package com.blues.gankio.v2.view

import android.view.ViewGroup
import android.widget.ImageView
import com.blues.gankio.v2.model.GankioUniversalBean
import com.blues.R
import android.widget.TextView
import coil.load
import com.bumptech.glide.Glide
import com.jude.easyrecyclerview.adapter.BaseViewHolder

class GankGirlsViewHolder(parent: ViewGroup?) :
    BaseViewHolder<GankioUniversalBean.DataBean>(parent, R.layout.item_gank_girl) {

    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private val tvDesc: TextView = itemView.findViewById(R.id.tv_desc)
    private val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
    private val tvDate: TextView = itemView.findViewById(R.id.tv_date)
    private val tvTag: TextView = itemView.findViewById(R.id.tv_tag)
    private val tvLikes: TextView = itemView.findViewById(R.id.tv_likes)
    private val tvViews: TextView = itemView.findViewById(R.id.tv_views)
    private val ivCover: ImageView = itemView.findViewById(R.id.iv_cover)

    override fun setData(data: GankioUniversalBean.DataBean) {
        super.setData(data)
        tvTitle.text = data.title
        tvDesc.text = data.desc
        tvDate.text = data.publishedAt
        tvAuthor.text = data.author
        tvTag.text = "#${data.type}#"
        tvLikes.text = data.likeCounts.toString()
        tvViews.text = data.views.toString()
        //Glide.with(context).load(data.images[0]).into(ivCover)
        ivCover.load(data.images[0])
    }

}