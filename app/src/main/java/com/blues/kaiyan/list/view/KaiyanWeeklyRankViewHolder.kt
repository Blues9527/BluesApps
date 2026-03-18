package com.blues.kaiyan.list.view

import com.blues.framework.utils.TimeFormatUtil.formatTime
import android.view.ViewGroup
import com.blues.kaiyan.list.model.KaiyanBean
import com.blues.R
import android.widget.TextView
import android.content.Intent
import com.blues.kaiyan.detail.view.KaiyanDetailActivity
import androidx.core.app.ActivityOptionsCompat
import android.app.Activity
import android.widget.ImageView
import coil.load
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import java.lang.StringBuilder

/**
 * File: com.blues.kaiyan.list.view.KaiyanWeeklyRankViewHolder.kt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021/7/30
 **/

class KaiyanWeeklyRankViewHolder(parent: ViewGroup?) :
    BaseViewHolder<KaiyanBean.ItemListBean>(parent, R.layout.item_oe_hotrank_list) {

    private val ivAvatar: ImageView = itemView.findViewById(R.id.iv_avatar)
    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private val tvTags: TextView = itemView.findViewById(R.id.tv_tags)
    private val tvCategory: TextView = itemView.findViewById(R.id.tv_category)
    private val coverHotRank: ImageView = itemView.findViewById(R.id.iv_hotrank_cover)

    override fun setData(item: KaiyanBean.ItemListBean) {
        super.setData(item)

        val sb = StringBuilder()

        item.data?.apply {
            ivAvatar.load(author?.icon)
            coverHotRank.load(cover?.detail)

            tvTitle.text = title
            for (tagsBean in tags) {
                sb.append(tagsBean.name + "/")
            }
            tvTags.text = "#$sb${formatTime(duration)}"
            tvCategory.text = "#${category}"

        }

        coverHotRank.setOnClickListener {
            val intent = Intent(context, KaiyanDetailActivity::class.java).putExtra("itemDetail",
                    item)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation((context as Activity),
                    coverHotRank, "transitionOEObject")
            context.startActivity(intent, options.toBundle())
        }
    }

}