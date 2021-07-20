package com.blues.module_main.view

import com.blues.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.jude.easyrecyclerview.EasyRecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.model_wanandroid.model.WanAndroidEntity.DataBean.DatasBean
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blues.model_wanandroid.view.WanAndroidViewHolder
import com.blues.module_main.model.WanAndroidBannerEntity
import com.blues.module_main.vm.WanAndroidBannerViewModel
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:27
 */
class MainPageFragment : Fragment() {

    private val bannerViewModel: WanAndroidBannerViewModel by viewModel()

    private var mHeader: MainPageHeaderView? = null
    override fun onPause() {
        super.onPause()
        mHeader?.onBannerPause()
    }

    override fun onResume() {
        super.onResume()
        mHeader?.onBannerResume()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_mainpage, container, false)
        initData(root)
        return root
    }

    fun initData(rootView: View) {

        bannerViewModel.getBanner()

        val ervMain: EasyRecyclerView = rootView.findViewById(R.id.erv_main)
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