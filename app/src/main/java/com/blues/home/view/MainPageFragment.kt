package com.blues.home.view

import com.blues.R
import android.os.Bundle
import android.view.LayoutInflater
import com.jude.easyrecyclerview.EasyRecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.wanandroid.model.WanAndroidEntity.DataBean.DatasBean
import android.view.ViewGroup
import com.blues.framework.base.BaseKoinFragment
import com.blues.wanandroid.view.WanAndroidViewHolder
import com.blues.home.model.WanAndroidBannerEntity
import com.blues.home.vm.WanAndroidBannerViewModel
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:27
 */
class MainPageFragment : BaseKoinFragment() {

    private val bannerViewModel: WanAndroidBannerViewModel by viewModel()

    private var mHeader: MainPageHeaderView? = null

    override fun getLayoutId(): Int = R.layout.fragment_mainpage

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {
        bannerViewModel.getBanner()

        rootView.apply {
            val ervMain: EasyRecyclerView = findViewById(R.id.erv_main)
            var mAdapter: RecyclerArrayAdapter<DatasBean?>

            ervMain.apply {
                setLayoutManager(LinearLayoutManager(requireActivity()))
                adapter = object : RecyclerArrayAdapter<DatasBean?>(requireActivity()) {
                    override fun OnCreateViewHolder(parent: ViewGroup,
                        viewType: Int): BaseViewHolder<*> {
                        return WanAndroidViewHolder(parent)
                    }
                }.also { mAdapter = it }
            }
            mAdapter.addHeader(MainPageHeaderView(requireActivity()).also { mHeader = it })

            bannerViewModel.wanAndroidBanner.observe(requireActivity(), { wanAndroidBannerEntity: WanAndroidBannerEntity? ->
                run {
                    wanAndroidBannerEntity?.let {
                        mHeader?.initBanner(requireActivity(), it)
                    }
                }
            })
        }
    }
}