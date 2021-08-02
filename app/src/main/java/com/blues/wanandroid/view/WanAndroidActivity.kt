package com.blues.wanandroid.view

import com.blues.R
import android.os.Bundle
import android.view.ViewGroup
import com.jude.easyrecyclerview.EasyRecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.blues.framework.base.BaseKoinActivity
import com.blues.wanandroid.model.WanAndroidEntity
import com.blues.wanandroid.vm.WanAndroidViewModel
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter.OnMoreListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class WanAndroidActivity : BaseKoinActivity() {

    private val postViewModel by viewModel<WanAndroidViewModel>()

    private lateinit var mAdapter: RecyclerArrayAdapter<WanAndroidEntity.DataBean.DatasBean>

    override fun getLayoutId(): Int = R.layout.activity_wanandroid

    override fun observe() {
        postViewModel.wanAndroidEntity.observe(this) {
            mAdapter.apply {
                addAll(it.data.datas)
                notifyDataSetChanged()
            }
        }
    }

    override fun initData(savedInstanceState: Bundle?) {

        postViewModel.initData()

        val ervMain = findViewById<EasyRecyclerView>(R.id.erv_wanandroid).apply {
            setLayoutManager(LinearLayoutManager(this@WanAndroidActivity))
        }
        mAdapter = object : RecyclerArrayAdapter<WanAndroidEntity.DataBean.DatasBean>(this) {
            override fun OnCreateViewHolder(parent: ViewGroup?,
                                            viewType: Int): BaseViewHolder<*> = WanAndroidViewHolder(parent)

        }.apply {
            setMore(R.layout.view_loading_more, object : OnMoreListener {
                override fun onMoreShow() {
                }

                override fun onMoreClick() {}
            })

            setNoMore(R.layout.view_load_no_more)
        }
                .also {
                    ervMain.adapter = it
                }
    }
}