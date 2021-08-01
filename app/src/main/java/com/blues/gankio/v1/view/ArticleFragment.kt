package com.blues.gankio.v1.view

import com.blues.framework.utils.FileUtil.getAssetsFile
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.jude.easyrecyclerview.EasyRecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.blues.WebViewDialog
import com.blues.framework.base.BaseKoinFragment
import com.blues.gankio.v1.model.ArticleBean
import com.jude.easyrecyclerview.adapter.BaseViewHolder

class ArticleFragment : BaseKoinFragment() {

    private lateinit var mAdapter: RecyclerArrayAdapter<ArticleBean.ArticleDetailBean>

    override fun getLayoutId(): Int = R.layout.fragment_article

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        rootView.findViewById<EasyRecyclerView>(R.id.ev_article).apply {
            setLayoutManager(LinearLayoutManager(requireContext()))
            adapter = object :
                RecyclerArrayAdapter<ArticleBean.ArticleDetailBean>(requireContext()) {
                override fun OnCreateViewHolder(parent: ViewGroup,
                    viewType: Int): BaseViewHolder<*> {
                    return ArticleHolder(parent)
                }
            }.also { mAdapter = it }
        }

        val io = getAssetsFile(requireContext(), "article.json")
        val article = Gson().fromJson(io, ArticleBean::class.java)
        mAdapter.apply {
            addAll(article.articleDetail)
            notifyDataSetChanged()
            setOnItemClickListener { position: Int -> WebViewDialog(requireContext(), article.articleDetail[position].url).show() }
        }
    }
}