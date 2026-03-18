package com.blues.gankio.v2.view

import android.view.ViewGroup
import android.widget.ImageView
import com.blues.gankio.v2.model.GankioUniversalBean
import com.blues.R
import android.widget.TextView
import coil.load
import coil.request.CachePolicy
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import java.util.UUID

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

        // 使用picsum.photos替代原来的gank.io图片
        // 使用随机UUID确保每次加载不同的图片
        val imageUrl = if (data.images.isNotEmpty() && !data.images[0].isNullOrEmpty()) {
            // 如果原数据有图片，使用picsum的图片尺寸服务
            val randomId = (1..1000).random()
            "https://picsum.photos/seed/$randomId/800/600"
        } else {
            // 使用随机图片ID
            val randomId = (1..1000).random()
            "https://picsum.photos/seed/$randomId/800/600"
        }

        ivCover.load(imageUrl) {
            crossfade(true)
            placeholder(R.drawable.shape_place_holder)
            error(R.drawable.shape_place_holder)
            memoryCachePolicy(CachePolicy.DISABLED)
        }
    }

}
