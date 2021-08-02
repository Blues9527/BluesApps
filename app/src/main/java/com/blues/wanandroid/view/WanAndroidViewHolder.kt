package com.blues.wanandroid.view

import android.view.ViewGroup
import com.blues.wanandroid.model.WanAndroidEntity.DataBean.DatasBean
import com.blues.R
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import coil.load
import com.bumptech.glide.Glide
import com.blues.WebViewDialog
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
 * User : Blues
 * Date : 2019/3/6
 */
class WanAndroidViewHolder(parent: ViewGroup?) :
    BaseViewHolder<DatasBean>(parent, R.layout.item_wan_android) {

    private var ivCover: ImageView = itemView.findViewById(R.id.iv_cover)
    private var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private var tvTag: TextView = itemView.findViewById(R.id.tv_tag)
    private var tvDesc: TextView = itemView.findViewById(R.id.tv_desc)
    private var tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
    private var tvDate: TextView = itemView.findViewById(R.id.tv_date)
    private var clRoot: ConstraintLayout = itemView.findViewById(R.id.cl_root)

    override fun setData(data: DatasBean) {
        super.setData(data)

        //设置cover
        if (!TextUtils.isEmpty(data.envelopePic)) {
            ivCover.visibility = View.VISIBLE
            ivCover.load(data.envelopePic)

            //Glide.with(context).load(data.envelopePic).into(ivCover)
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