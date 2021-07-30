package com.blues.kaiyan.list.view

import android.view.ViewGroup
import com.blues.R
import android.widget.TextView
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
* File: com.blues.kaiyan.list.view.OEHotSearchViewHolder.kt
* Description: xxx
*
* @author: lanhuajian
* @time: 2021/7/30
**/

class OEHotSearchViewHolder(parent: ViewGroup?) :
    BaseViewHolder<String?>(parent, R.layout.item_hot_search) {

    private val tvHotSearch: TextView = itemView.findViewById(R.id.tv_hot_search)

    override fun setData(data: String?) {
        tvHotSearch.text = data
    }
}