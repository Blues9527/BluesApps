package com.blues.gankio.v1.view

import android.view.ViewGroup
import com.blues.gankio.v1.model.ArticleBean.ArticleDetailBean
import com.blues.R
import android.widget.TextView
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:39
 */
class ArticleHolder(parent: ViewGroup?) :
    BaseViewHolder<ArticleDetailBean>(parent, R.layout.item_article_mp) {

    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)

    override fun setData(data: ArticleDetailBean) {
        super.setData(data)
        tvTitle.text = data.title
    }
}