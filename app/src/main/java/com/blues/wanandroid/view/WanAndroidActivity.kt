package com.blues.wanandroid.view

import com.blues.R
import android.os.Bundle
import com.jude.easyrecyclerview.EasyRecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.blues.framework.base.BaseKoinActivity
import com.blues.wanandroid.model.WanAndroidEntity
import com.blues.wanandroid.vm.WanAndroidViewModel
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter.OnMoreListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class WanAndroidActivity : BaseKoinActivity() {

    private val postViewModel by viewModel<WanAndroidViewModel>()

    private var mAdapter: RecyclerArrayAdapter<WanAndroidEntity.DataBean.DatasBean>? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_wanandroid
    }

    override fun initData(savedInstanceState: Bundle?) {

        postViewModel.initData()

        val ervMain = findViewById<EasyRecyclerView>(R.id.erv_wanandroid)
        ervMain.setLayoutManager(LinearLayoutManager(this))
        mAdapter = WanAndroidRecyclerArrayAdapter(this).apply {
            setMore(R.layout.view_loading_more, object : OnMoreListener {
                override fun onMoreShow() {
                }

                override fun onMoreClick() {}
            })

            setNoMore(R.layout.view_load_no_more)
        }
        ervMain.adapter = mAdapter

        postViewModel.wanAndroidEntity.observe(this) {
            (mAdapter as WanAndroidRecyclerArrayAdapter).addAll(it.data.datas)
        }
    }
}