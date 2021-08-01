package com.blues.gankio.v2.view

import android.view.ViewGroup
import com.blues.gankio.v2.model.GankioUniversalBean
import com.blues.R
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import android.content.Intent
import androidx.core.app.ActivityOptionsCompat
import android.app.Activity
import android.view.View
import android.widget.ImageView
import com.jude.easyrecyclerview.adapter.BaseViewHolder

class GankViewHolder(parent: ViewGroup?) :
    BaseViewHolder<GankioUniversalBean.DataBean>(parent, R.layout.item_gank) {

    private val ivPreview: ImageView = itemView.findViewById(R.id.iv_preview)
    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
    private val tvViews: TextView = itemView.findViewById(R.id.tv_views)
    private val tvLikes: TextView = itemView.findViewById(R.id.tv_likes)
    private val tvPTime: TextView = itemView.findViewById(R.id.tv_publish_time)
    private val clRoot: ConstraintLayout = itemView.findViewById(R.id.cl_root)

    override fun setData(data: GankioUniversalBean.DataBean) {
        super.setData(data)
        tvTitle.text = data.title
        tvAuthor.text = "作者：${data.author}"
        if (data.images.size != 0) {
            Glide.with(context).load(data.images[0]).placeholder(R.mipmap.ic_img_error)
                .into(ivPreview)
        } else {
            Glide.with(context).load(R.mipmap.ic_img_error).placeholder(R.mipmap.ic_img_error)
                .into(ivPreview)
        }
        tvViews.text = data.views.toString()
        tvLikes.text = data.likeCounts.toString()
        tvPTime.text = "日期:${data.publishedAt}"
        clRoot.setOnClickListener { v: View? ->
            val intent = Intent(context, GankPostDetailActivity::class.java).putExtra("postId", data._id)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation((context as Activity), clRoot, "transitionGank")
            context.startActivity(intent, options.toBundle())
        }
    }
}