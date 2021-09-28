package com.blues.gankio.v1.view

import android.view.ViewGroup
import com.blues.R
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import android.content.Intent
import androidx.core.app.ActivityOptionsCompat
import android.app.Activity
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import coil.load
import com.blues.framework.dialog.WebViewDialog
import com.blues.gankio.v1.model.GankBean
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
 * User : Blues
 * Date : 2019/3/6
 */
class AndroidViewHolder(parent: ViewGroup?) :
    BaseViewHolder<GankBean.ResultsBean>(parent, R.layout.item_android) {

    private val tvDesc: TextView = itemView.findViewById(R.id.tv_desc)
    private val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
    private val tvDate: TextView = itemView.findViewById(R.id.tv_publish_time)
    private val tvPublisher: TextView = itemView.findViewById(R.id.tv_source)
    private val ivCover: ImageView = itemView.findViewById(R.id.iv_cover)
    private val clRoot: ConstraintLayout = itemView.findViewById(R.id.cl_root)

    override fun setData(data: GankBean.ResultsBean) {
        super.setData(data)
        tvDesc.text = data.desc
        tvAuthor.text = data.who
        if (data.images.isNotEmpty()) {
            ivCover.visibility = View.VISIBLE
            ivCover.load(data.images[0]) {
                placeholder(R.mipmap.ic_img_error)
                error(R.mipmap.ic_img_error)
            }

            ivCover.setOnClickListener {   //跳转到ShowImageActivity
                val intent = Intent(context, ShowImageActivity::class.java).putExtra("param", data)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation((context as Activity), ivCover, "transitionImage")
                context.startActivity(intent, options.toBundle())
            }
        }
        tvDate.text = "日期：${data.publishedAt.substring(0, data.publishedAt.indexOf("T"))}"
        tvPublisher.text = "来自：${data.source}"

        if (!TextUtils.isEmpty(data.url)) {
            clRoot.setOnClickListener {
                WebViewDialog(context, data.url).show()
            }
        }
    }
}