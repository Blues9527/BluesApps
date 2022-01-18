package com.blues.kaiyan.list.view

import com.scwang.smartrefresh.layout.SmartRefreshLayout
import android.view.ViewStub
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.kaiyan.list.model.KaiyanBean
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.jude.easyrecyclerview.EasyRecyclerView
import com.blues.constant.KaiYanType
import com.jude.easyrecyclerview.decoration.DividerDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.blues.framework.base.BaseKoinFragment
import com.blues.kaiyan.list.vm.KaiyanViewModel
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * File: com.blues.kaiyan.list.view.KaiyanHistoricalRankFragment.kt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021/7/30
 **/

class KaiyanHistoricalRankFragment : BaseKoinFragment(), OnRefreshListener {

    private val historicViewModel: KaiyanViewModel by viewModel()

    private lateinit var hotRankSr: SmartRefreshLayout

    //private lateinit var v: View
    private lateinit var networkVS: ViewStub
    private lateinit var mAdapter: RecyclerArrayAdapter<KaiyanBean.ItemListBean>

    override fun collect() {
        lifecycleScope.launch {
            historicViewModel.videos.collect {
                mAdapter.apply {
                    addAll(it.itemList)
                    notifyDataSetChanged()
                }
                hotRankSr.finishRefresh()
            }
        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mAdapter.clear()
        historicViewModel.getRankListVideos(KaiYanType.HISTORICAL)
    }

    override fun getLayoutId(): Int = R.layout.fragment_oe_hot_rank

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {
        historicViewModel.getRankListVideos(KaiYanType.HISTORICAL)

        val decoration = DividerDecoration(R.color.color_gray, 1)

        rootView.findViewById<EasyRecyclerView>(R.id.rv_hotrank).apply {
            addItemDecoration(decoration)
            setLayoutManager(LinearLayoutManager(requireContext()))
            adapter = object : RecyclerArrayAdapter<KaiyanBean.ItemListBean>(requireContext()) {
                override fun OnCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): BaseViewHolder<*> {
                    return KaiyanHistoricalRankViewHolder(parent)
                }
            }.also { mAdapter = it }
        }

        hotRankSr = rootView.findViewById<SmartRefreshLayout>(R.id.sr_hotrank).apply {
            setRefreshHeader(ClassicsHeader(requireContext()).setEnableLastTime(true))
            setEnableRefresh(true)
            setOnRefreshListener(this@KaiyanHistoricalRankFragment)
            setEnableHeaderTranslationContent(true)
        }

        networkVS = rootView.findViewById(R.id.view_stub_network) //设置 Header 为 经典 样式 带最后刷新时间

        mAdapter.setNoMore(R.layout.view_load_no_more)
    }
}