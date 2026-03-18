package com.blues.gankio.v1.view

import com.scwang.smartrefresh.layout.SmartRefreshLayout
import android.view.ViewStub
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FuliFragment : BaseKoinFragment(), OnRefreshListener {

    private val fuliViewModel: GankViewModel by viewModel()

    private lateinit var fuliSr: SmartRefreshLayout
    private var networkVS: ViewStub? = null
    private lateinit var mAdapter: RecyclerArrayAdapter<GankBean.ResultsBean>

    override fun collect() {
        lifecycleScope.launch {
            fuliViewModel.listData.collect {
                it.results.let { list ->
                    mAdapter.apply {
                        addAll(list)
                        notifyDataSetChanged()
                    }
                    fuliSr.finishRefresh()
                }
            }
        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mAdapter.clear()
        fuliViewModel.initData(GankType.PICTURE.type)
    }

    override fun getLayoutId(): Int = R.layout.fragment_fuli

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        val fuliErv: EasyRecyclerView = rootView.findViewById(R.id.rv_fuli)
        fuliSr = rootView.findViewById<SmartRefreshLayout>(R.id.sr_fuli).apply {

            //设置 Header 为 经典 样式 带最后刷新时间
            setRefreshHeader(ClassicsHeader(requireContext()).setEnableLastTime(true))
            setEnableHeaderTranslationContent(true)
            setEnableRefresh(true)
            setOnRefreshListener(this@FuliFragment)
        }
        onRefresh(fuliSr)

        networkVS = rootView.findViewById(R.id.view_stub_network)

        fuliErv.setLayoutManager(LinearLayoutManager(requireContext()))
        fuliErv.adapter = object : RecyclerArrayAdapter<GankBean.ResultsBean>(requireContext()) {
            override fun OnCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
                return FuliViewHolder(parent)
            }
        }.also { mAdapter = it }

        mAdapter.apply {
            setNoMore(R.layout.view_load_no_more)
            setMore(R.layout.view_loading_more, object : OnMoreListener {
                override fun onMoreShow() {
                    fuliViewModel.loadMore(GankType.PICTURE.type)
                }

                override fun onMoreClick() {}
            })
        }
    }
}