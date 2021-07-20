package com.blues.model_wanandroid.view

import android.content.Context
import android.view.ViewGroup
import com.blues.model_wanandroid.model.WanAndroidEntity
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter

/**
 * File: com.blues.model_wanandroid.ui.WanAndroidRecyclerArrayAdapter
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16 22:14
 **/

class WanAndroidRecyclerArrayAdapter(context: Context) :
    RecyclerArrayAdapter<WanAndroidEntity.DataBean.DatasBean>(context) {

    override fun OnCreateViewHolder(parent: ViewGroup?,
        viewType: Int): BaseViewHolder<*> = WanAndroidViewHolder(parent)
}