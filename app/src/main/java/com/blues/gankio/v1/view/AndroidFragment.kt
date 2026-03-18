package com.blues.gankio.v1.view

import com.scwang.smartrefresh.layout.SmartRefreshLayout
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

class AndroidFragment : BaseKoinFragment(), OnRefreshListener {

    private val androidViewModel: GankViewModel by viewModel()

    private lateinit var androidSr: SmartRefreshLayout
    private lateinit var mAdapter: RecyclerArrayAdapter<GankBean.ResultsBean>

    override fun collect() {
        lifecycleScope.launch {
            androidViewModel.listData.collect {
                it.results.let { list ->
                    mAdapter.apply {
                        addAll(list)
                        notifyDataSetChanged()
                    }
                }
            }
        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mAdapter.clear()
        androidViewModel.initData(GankType.ANDROID.type)
    }

    override fun getLayoutId(): Int = R.layout.fragment_android

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        //初始化数据
        androidViewModel.initData(GankType.ANDROID.type)

        rootView.findViewById<EasyRecyclerView>(R.id.rv_android).apply {
            setLayoutManager(LinearLayoutManager(requireContext()))
            adapter = object : RecyclerArrayAdapter<GankBean.ResultsBean>(requireContext()) {
                override fun OnCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): BaseViewHolder<*> {
                    return AndroidViewHolder(parent)
                }
            }.also { mAdapter = it }
        }
        androidSr = rootView.findViewById<SmartRefreshLayout>(R.id.sr_android)
            .apply { //设置 Header 为 经典 样式 带最后刷新时间
                setRefreshHeader(ClassicsHeader(requireContext()).setEnableLastTime(true))
                setEnableHeaderTranslationContent(true)
                setEnableRefresh(true)
                setOnRefreshListener(this@AndroidFragment)
            }

        mAdapter.apply {
            setNoMore(R.layout.view_load_no_more)
            setMore(R.layout.view_loading_more, object : OnMoreListener {
                override fun onMoreShow() {
                    androidViewModel.loadMore(GankType.ANDROID.type)
                }

                override fun onMoreClick() {}
            })
        }
    }
}