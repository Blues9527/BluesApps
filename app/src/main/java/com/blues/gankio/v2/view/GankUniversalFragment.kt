package com.blues.gankio.v2.view

import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.gankio.v2.model.GankioUniversalBean
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.jude.easyrecyclerview.EasyRecyclerView
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import androidx.recyclerview.widget.LinearLayoutManager
import com.blues.framework.base.BaseKoinFragment
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter.OnMoreListener
import com.blues.gankio.v2.vm.GankioViewModel
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class GankUniversalFragment(private val type: String) : BaseKoinFragment() {

    private val gankioViewModel: GankioViewModel by viewModel()

    private lateinit var srGank: SmartRefreshLayout
    private lateinit var mAdapter: RecyclerArrayAdapter<GankioUniversalBean.DataBean>

    override fun collect() {
        lifecycleScope.launch {
            gankioViewModel.list.collect {
                mAdapter.apply {
                    addAll(it.data)
                    notifyDataSetChanged()
                    srGank.finishRefresh()
                }
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_gank_universal

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        gankioViewModel.getCategoryPostList(type = type)

        rootView.findViewById<EasyRecyclerView>(R.id.rv_gank).apply {
            setLayoutManager(LinearLayoutManager(requireContext()))
            adapter = object :
                RecyclerArrayAdapter<GankioUniversalBean.DataBean>(requireContext()) {
                override fun OnCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): BaseViewHolder<*> {
                    return GankViewHolder(parent)
                }
            }.also { mAdapter = it }
        }
        srGank = rootView.findViewById<SmartRefreshLayout>(R.id.sr_gank).apply {
            setRefreshHeader(ClassicsHeader(requireContext()).setEnableLastTime(true))
            setEnableHeaderTranslationContent(true)
        }

        mAdapter.apply {
            setNoMore(R.layout.view_load_no_more)
            setMore(R.layout.view_loading_more, object : OnMoreListener {
                override fun onMoreShow() {
                    gankioViewModel.getCategoryPostList(type = type)
                }

                override fun onMoreClick() {}
            })
        }
    }
}