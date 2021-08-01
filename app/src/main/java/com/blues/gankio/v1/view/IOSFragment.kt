package com.blues.gankio.v1.view

import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
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

class IOSFragment : BaseKoinFragment(), OnRefreshListener {

    private val iOSViewModel: GankViewModel by viewModel()

    private lateinit var iOSSr: SmartRefreshLayout
    private lateinit var mAdapter: RecyclerArrayAdapter<GankBean.ResultsBean>

    override fun observe() {
        iOSViewModel.listData.observe(this) {
            it.results?.let { list ->
                mAdapter.apply {
                    addAll(list)
                    notifyDataSetChanged()
                    iOSSr.finishRefresh()
                }
            }
        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mAdapter.clear()
        iOSViewModel.initData(GankType.IOS.type)
    }

    override fun getLayoutId(): Int = R.layout.fragment_ios

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        iOSSr = rootView.findViewById<SmartRefreshLayout>(R.id.sr_ios)
            .apply { //设置 Header 为 经典 样式 带最后刷新时间
                setRefreshHeader(ClassicsHeader(requireContext()).setEnableLastTime(true))
                setEnableHeaderTranslationContent(true)
                setEnableRefresh(true)
                setOnRefreshListener(this@IOSFragment)
            }

        onRefresh(iOSSr)

        //iOSViewModel.initData(GankType.IOS.type)

        rootView.findViewById<EasyRecyclerView>(R.id.rv_ios).apply {
            setLayoutManager(LinearLayoutManager(requireContext()))
            adapter = object : RecyclerArrayAdapter<GankBean.ResultsBean>(requireContext()) {
                override fun OnCreateViewHolder(parent: ViewGroup,
                    viewType: Int): BaseViewHolder<*> {
                    return IOSViewHolder(parent)
                }
            }.also { mAdapter = it }
        }

        mAdapter.apply {
            setNoMore(R.layout.view_load_no_more)
            setMore(R.layout.view_loading_more, object : OnMoreListener {
                override fun onMoreShow() {
                    iOSViewModel.loadMore(GankType.IOS.type)
                }

                override fun onMoreClick() {}
            })
        }
    }
}