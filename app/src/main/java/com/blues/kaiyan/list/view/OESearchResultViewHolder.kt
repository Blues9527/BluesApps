package com.blues.kaiyan.list.view

import android.view.ViewGroup
import android.widget.ImageView
import com.blues.R
import android.widget.TextView
import com.blues.kaiyan.list.model.OpenEyeEntity
import com.bumptech.glide.Glide
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
* File: com.blues.kaiyan.list.view.OESearchResultViewHolder.kt
* Description: xxx
*
* @author: lanhuajian
* @time: 2021/7/30
**/

class OESearchResultViewHolder(parent: ViewGroup?) :
    BaseViewHolder<OpenEyeEntity.ItemListBean.DataBean>(parent, R.layout.item_search_result) {

    private val ivCover: ImageView = itemView.findViewById(R.id.iv_search_result_cover)
    private val tvTitle: TextView = itemView.findViewById(R.id.tv_search_result_title)

    override fun setData(data: OpenEyeEntity.ItemListBean.DataBean) {
        Glide.with(context).load(data.cover.detail).into(ivCover)
        tvTitle.text = data.title
    }
}