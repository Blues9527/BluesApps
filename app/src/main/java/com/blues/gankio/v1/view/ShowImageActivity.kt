package com.blues.gankio.v1.view

import android.os.Bundle
import android.view.View
import com.blues.R
import com.jude.easyrecyclerview.EasyRecyclerView
import android.widget.TextView
import com.blues.gankio.v1.model.GankBean.ResultsBean
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blues.framework.base.BaseKoinActivity

/**
 * User : Blues
 * Date : 2019/4/17
 */
class ShowImageActivity : BaseKoinActivity() {

    override fun getLayoutId(): Int = R.layout.activity_show_image

    override fun initData(savedInstanceState: Bundle?) {
        val data = intent.getSerializableExtra("param") as ResultsBean

        val rvImg: EasyRecyclerView = findViewById(R.id.rv_show_img)

        val textView = findViewById<TextView>(R.id.tv_num)

        findViewById<View>(R.id.iv_back).setOnClickListener { finish() }

        PagerSnapHelper().attachToRecyclerView(rvImg.recyclerView)

        val mAdapter = ImagesAdapter(data.images)
        textView.text = "1/${data.images.size}"
        rvImg.apply {
            setLayoutManager(LinearLayoutManager(this@ShowImageActivity, LinearLayoutManager.HORIZONTAL, false))
            adapter = mAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val manager = recyclerView.layoutManager
                    if (manager is LinearLayoutManager) {

                        //第一个可见的位置
                        val firstPosition = manager.findFirstVisibleItemPosition()
                        textView.text = "${firstPosition + 1}/${data.images.size}"
                    }
                }
            })
        }
    }
}