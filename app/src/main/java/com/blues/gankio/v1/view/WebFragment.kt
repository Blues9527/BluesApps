package com.blues.gankio.v1.view

import com.scwang.smartrefresh.layout.SmartRefreshLayout
import android.view.ViewStub
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import com.jude.easyrecyclerview.EasyRecyclerView
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import androidx.recyclerview.widget.LinearLayoutManager
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter.OnMoreListener
import com.blues.framework.base.BaseKoinFragment
import com.blues.gankio.v1.api.GankType
import com.blues.gankio.v1.model.GankBean
import com.blues.gankio.v1.vm.GankViewModel
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class WebFragment : BaseKoinFragment(), OnRefreshListener {

    private val webViewModel: GankViewModel by viewModel()

    private lateinit var webSr: SmartRefreshLayout
    private var networkVS: ViewStub? = null
    private lateinit var mAdapter: RecyclerArrayAdapter<GankBean.ResultsBean>

    override fun collect() {
        webViewModel.listData.observe(this) {
            it.results?.let { list ->
                mAdapter.apply {
                    addAll(list)
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mAdapter.clear()
        webViewModel.initData(GankType.WEB.type)
    }

    override fun getLayoutId(): Int = R.layout.fragment_web

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        val iOSErv: EasyRecyclerView = rootView.findViewById(R.id.rv_web)
        networkVS = rootView.findViewById(R.id.view_stub_network)
        webSr = rootView.findViewById(R.id.sr_web)
        webSr.apply { //设置 Header 为 经典 样式 带最后刷新时间
            setRefreshHeader(ClassicsHeader(requireContext()).setEnableLastTime(true))
            setEnableHeaderTranslationContent(true)
            setEnableRefresh(true)
            setOnRefreshListener(this@WebFragment)
        }

        iOSErv.setLayoutManager(LinearLayoutManager(requireContext()))
        iOSErv.adapter = object : RecyclerArrayAdapter<GankBean.ResultsBean>(requireContext()) {
            override fun OnCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
                return WebViewHolder(parent)
            }
        }.also { mAdapter = it }
        mAdapter.apply {
            setNoMore(R.layout.view_load_no_more)
            setMore(R.layout.view_loading_more, object : OnMoreListener {
                override fun onMoreShow() {
                    webViewModel.loadMore(GankType.WEB.type)
                }

                override fun onMoreClick() {}
            })
        }
    }
}