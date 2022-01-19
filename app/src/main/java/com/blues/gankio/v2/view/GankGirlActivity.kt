package com.blues.gankio.v2.view

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.gankio.v2.model.GankioUniversalBean
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.blues.R
import android.os.Bundle
import com.blues.gankio.v2.constant.GankioConstant
import androidx.recyclerview.widget.PagerSnapHelper
import com.jude.easyrecyclerview.EasyRecyclerView
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.blues.framework.base.BaseKoinActivity
import com.blues.gankio.v2.vm.GankioViewModel
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter.OnMoreListener
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class GankGirlActivity : BaseKoinActivity(), OnRefreshListener {

    private val gankioViewModel: GankioViewModel by viewModel()

    private lateinit var mAdapter: RecyclerArrayAdapter<GankioUniversalBean.DataBean>
    private val srGirl: SmartRefreshLayout by lazy {
        findViewById(R.id.sr_gank_girl)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mAdapter.clear()
        gankioViewModel.getCategoryPostList(GankioConstant.GIRL, GankioConstant.GIRL, page = 1)
    }

    override fun collect() {
        lifecycleScope.launch {
            gankioViewModel.list.collect {
                mAdapter.apply {
                    addAll(it.data)
                    notifyDataSetChanged()
                }
                srGirl.finishRefresh()
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_gank_girl

    override fun initData(savedInstanceState: Bundle?) {

        gankioViewModel.getCategoryPostList(GankioConstant.GIRL, GankioConstant.GIRL)

        val ervGirl = findViewById<EasyRecyclerView>(R.id.erv_gank_girls).apply {
            setLayoutManager(LinearLayoutManager(this@GankGirlActivity))
            adapter = object :
                RecyclerArrayAdapter<GankioUniversalBean.DataBean>(this@GankGirlActivity) {
                override fun OnCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): BaseViewHolder<*> {
                    return GankGirlsViewHolder(parent)
                }
            }.also { mAdapter = it }
        }

        PagerSnapHelper().attachToRecyclerView(ervGirl.recyclerView)

        srGirl.apply {

            //设置 Header 为 经典 样式 带最后刷新时间
            setRefreshHeader(ClassicsHeader(this@GankGirlActivity).setEnableLastTime(true))

            setEnableHeaderTranslationContent(true)

            setEnableRefresh(true)
            setOnRefreshListener(this@GankGirlActivity)
        }

        mAdapter.setMore(R.layout.view_loading_more, object : OnMoreListener {
            override fun onMoreShow() {
                gankioViewModel.loadCategoryPostListMore(GankioConstant.GIRL, GankioConstant.GIRL)
            }

            override fun onMoreClick() {}
        })
        mAdapter.setNoMore(R.layout.view_load_no_more)
    }
}