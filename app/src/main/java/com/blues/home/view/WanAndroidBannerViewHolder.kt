package com.blues.home.view

import android.view.ViewGroup
import android.widget.ImageView
import com.blues.R
import com.blues.framework.utils.simpleLoad
import com.blues.home.model.WanAndroidBannerEntity
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
 * File: com.blues.module_main.view.WanAndroidBannerViewHolder
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-29
 **/

class WanAndroidBannerViewHolder(parent: ViewGroup?) :
    BaseViewHolder<WanAndroidBannerEntity.DataBean>(parent, R.layout.item_banner) {

    private val ivBanner: ImageView = itemView.findViewById(R.id.iv_banner)

    override fun setData(data: WanAndroidBannerEntity.DataBean) {
        super.setData(data)
        ivBanner.simpleLoad(data.imagePath)
    }

}