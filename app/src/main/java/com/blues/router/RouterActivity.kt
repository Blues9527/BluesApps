package com.blues.router

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blues.R
import com.blues.article.EverydayArticleActivity
import com.blues.framework.base.BaseKoinActivity
import com.blues.gankio.v2.view.GankActivity
import com.blues.wanandroid.view.WanAndroidActivity

/**
 * File: com.blues.router.RouterActivity.kt
 * Description: 中间页Activity
 *
 * @author: lanhuajian
 * @time: 2022/2/25
 **/

class RouterActivity : BaseKoinActivity() {

    private val mRecyclerViewItemList = mutableListOf<Pair<String, Class<*>>>(
        Pair("干货", GankActivity::class.java),
        Pair("玩安卓", WanAndroidActivity::class.java),
        Pair("每日一文", EverydayArticleActivity::class.java)
    )

    private val mRecyclerView: RecyclerView by lazy {
        findViewById(R.id.rv_router)
    }

    override fun getLayoutId(): Int = R.layout.activity_router

    override fun initData(savedInstanceState: Bundle?) {
        val mAdapter = object : RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
                ViewHolder(
                    LayoutInflater.from(this@RouterActivity).inflate(R.layout.item_router, null)
                )

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.mTextView.text = mRecyclerViewItemList[position].first

                holder.mFlLayout.setOnClickListener {
                    startActivity(
                        Intent(
                            this@RouterActivity,
                            mRecyclerViewItemList[position].second
                        )
                    )
                }
            }

            override fun getItemCount(): Int = mRecyclerViewItemList.size
        }

        with(mRecyclerView) {
            layoutManager = LinearLayoutManager(this@RouterActivity)
            adapter = mAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@RouterActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTextView: TextView = itemView.findViewById(R.id.tv_router_name)
        val mFlLayout: FrameLayout = itemView.findViewById(R.id.fl_layout)
    }
}