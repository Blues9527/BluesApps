package com.blues.model_wanandroid.view

import android.view.ViewGroup
import com.blues.model_wanandroid.model.WanAndroidEntity.DataBean.DatasBean
import com.blues.R
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.blues.WebViewDialog
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
 * User : Blues
 * Date : 2019/3/6
 */
class WanAndroidViewHolder(parent: ViewGroup?) :
    BaseViewHolder<DatasBean>(parent, R.layout.item_wan_android) {

    private val ivCover: ImageView by lazy { itemView.findViewById(R.id.iv_cover) }
    private val tvTitle: TextView by lazy { itemView.findViewById(R.id.tv_title) }
    private val tvTag: TextView by lazy { itemView.findViewById(R.id.tv_tag) }
    private val tvDesc: TextView by lazy { itemView.findViewById(R.id.tv_desc) }
    private val tvAuthor: TextView by lazy { itemView.findViewById(R.id.tv_author) }
    private val tvDate: TextView by lazy { itemView.findViewById(R.id.tv_date) }
    private val clRoot: ConstraintLayout by lazy { itemView.findViewById(R.id.cl_root) }
    override fun setData(data: DatasBean) {
        super.setData(data)

        //设置cover
        if (!TextUtils.isEmpty(data.envelopePic)) {
            ivCover.visibility = View.VISIBLE
            Glide.with(context).load(data.envelopePic).into(ivCover)
        }
        with(data) {
            tvTitle.text = title
            tvTag.text = chapterName
            tvDesc.text = desc
            tvAuthor.text = author
            tvDate.text = niceDate
            clRoot.setOnClickListener { WebViewDialog(context, data.link).show() }
        }
    }
}