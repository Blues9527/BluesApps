package com.blues.kaiyan.list.view

import android.app.Activity
import android.content.Intent
import android.view.ViewGroup
import android.widget.ImageView
import com.blues.R
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import coil.load
import com.blues.kaiyan.detail.view.KaiyanDetailActivity
import com.blues.kaiyan.list.model.KaiyanBean
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
 * File: com.blues.kaiyan.list.view.KaiyanSearchResultViewHolder.kt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021/7/30
 **/

class KaiyanSearchResultViewHolder(parent: ViewGroup?) :
    BaseViewHolder<KaiyanBean.ItemListBean>(parent, R.layout.item_search_result) {

    private val ivCover: ImageView = itemView.findViewById(R.id.iv_search_result_cover)
    private val tvTitle: TextView = itemView.findViewById(R.id.tv_search_result_title)

    override fun setData(
        item: KaiyanBean.ItemListBean
    ) {

        item.data?.let {
            tvTitle.text = it.title
            ivCover.load(it.cover?.detail)
        }

        ivCover.setOnClickListener {
            val intent = Intent(context, KaiyanDetailActivity::class.java).putExtra("itemDetail",
                item)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation((context as Activity),
                ivCover, "transitionOEObject")
            context.startActivity(intent, options.toBundle())
        }
    }
}