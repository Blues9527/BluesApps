package com.blues.kaiyan.list.view

import android.graphics.Rect
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
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.jude.easyrecyclerview.decoration.DividerDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.blues.framework.base.BaseKoinFragment
import com.blues.framework.utils.dp
import com.blues.kaiyan.list.vm.KaiyanViewModel
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * File: com.blues.module_kaiyan.main.view.KaiyanHotRankFragment.kt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021/7/30
 **/

class KaiyanHotRankFragment : BaseKoinFragment(), OnRefreshListener {

    private val hotrankViewModel: KaiyanViewModel by viewModel()

    private lateinit var hotRankSr: SmartRefreshLayout

    //private lateinit var v: View
    private lateinit var networkVS: ViewStub
    private lateinit var mAdapter: RecyclerArrayAdapter<KaiyanBean.ItemListBean>

    //fun showFinished() {
    //    hotRankSr.finishRefresh()
    //}
    //
    //fun showError() {
    //    try {
    //        v = networkVS.inflate()
    //        val blankLl = v.findViewById<LinearLayout>(R.id.error_blank)
    //        blankLl.setOnClickListener {
    //            mAdapter.clear()
    //            hotrankViewModel.getRankList()
    //        }
    //    } catch (e: Exception) {
    //        e.printStackTrace()
    //        v.visibility = View.VISIBLE
    //    }
    //}

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mAdapter.clear()
        hotrankViewModel.getRankList()
    }

    override fun collect() {
        lifecycleScope.launch {
            hotrankViewModel.rankList.collect{
                mAdapter.apply {
                    addAll(it.itemList)
                    notifyDataSetChanged()
                }
                hotRankSr.finishRefresh()
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_oe_hot_rank

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        hotrankViewModel.getRankList()

        hotRankSr = rootView.findViewById(R.id.sr_hotrank)
        networkVS = rootView.findViewById(R.id.view_stub_network)
        hotRankSr.apply {

            //设置 Header 为 经典 样式 带最后刷新时间
            setRefreshHeader(ClassicsHeader(requireContext()).setEnableLastTime(true))
            setEnableHeaderTranslationContent(true)
            setEnableRefresh(true)
            setOnRefreshListener(this@KaiyanHotRankFragment)
        }

        val decoration = DividerDecoration(R.color.color_gray, 1)
        val hotRankErv: EasyRecyclerView = rootView.findViewById(R.id.rv_hotrank)
        hotRankErv.apply {
            addItemDecoration(decoration)
            setLayoutManager(LinearLayoutManager(requireContext()))
            adapter = object : RecyclerArrayAdapter<KaiyanBean.ItemListBean>(requireContext()) {
                override fun OnCreateViewHolder(parent: ViewGroup,
                    viewType: Int): BaseViewHolder<*> {
                    return KaiyanHotRankViewHolder(parent)
                }
            }.also {
                mAdapter = it
            }
        }

        mAdapter.setNoMore(R.layout.view_load_no_more)
    }
}