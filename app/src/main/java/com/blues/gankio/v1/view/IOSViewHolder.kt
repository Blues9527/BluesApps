package com.blues.gankio.v1.view

import android.view.ViewGroup
import android.widget.ImageView
import com.blues.R
import android.widget.TextView
import com.jude.easyrecyclerview.EasyRecyclerView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.blues.WebViewDialog
import com.blues.gankio.v1.model.GankBean
import com.jude.easyrecyclerview.adapter.BaseViewHolder

class IOSViewHolder(parent: ViewGroup?) :
    BaseViewHolder<GankBean.ResultsBean>(parent, R.layout.item_test) {

    private val ivAvatar: ImageView = itemView.findViewById(R.id.iv_avatar)
    private val tvDesc: TextView = itemView.findViewById(R.id.tv_desc)
    private val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
    private val tvSource: TextView = itemView.findViewById(R.id.tv_source)
    private val tvPTime: TextView = itemView.findViewById(R.id.tv_publish_time)
    private val rvImages: EasyRecyclerView = itemView.findViewById(R.id.rv_images)
    private val rlRoot: RelativeLayout = itemView.findViewById(R.id.rl_root)

    override fun setData(data: GankBean.ResultsBean) {
        super.setData(data)
        tvDesc.text = data.desc
        tvAuthor.text = "作者：${data.who}"
        tvSource.text = "来自：${data.source}"
        tvPTime.text = "日期：${data.publishedAt.substring(0, data.publishedAt.indexOf("T"))}"

        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        rvImages.setLayoutManager(layoutManager)
        rvImages.adapter = IOSImagesAdapter(data.images)
        rlRoot.setOnClickListener { WebViewDialog(context, data.url).show() }
    }
}