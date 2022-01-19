package com.blues.gankio.v2.view

import android.widget.TextView
import com.blues.R
import android.os.Bundle
import android.text.TextUtils
import android.text.Html
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import coil.load
import com.blues.framework.base.BaseKoinActivity
import com.blues.gankio.v2.vm.GankioViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.markdown4j.Markdown4jProcessor
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException

class GankPostDetailActivity : BaseKoinActivity() {

    private val gankioViewModel: GankioViewModel by viewModel()

    private val tvTitle: TextView by lazy { findViewById(R.id.tv_title) }
    private val tvAuthor: TextView by lazy { findViewById(R.id.tv_author) }
    private val tvDate: TextView by lazy { findViewById(R.id.tv_date) }
    private val tvTag: TextView by lazy { findViewById(R.id.tv_tag) }
    private val tvLikes: TextView by lazy { findViewById(R.id.tv_likes) }
    private val tvComments: TextView by lazy { findViewById(R.id.tv_comments) }
    private val tvViews: TextView by lazy { findViewById(R.id.tv_views) }
    private val tvDesc: TextView by lazy { findViewById(R.id.tv_desc) }
    private val tvContents: TextView by lazy { findViewById(R.id.tv_content) }
    private val ivContent: ImageView by lazy { findViewById(R.id.iv_content) }

    override fun collect() {
        lifecycleScope.launch {
            gankioViewModel.postDetail.collect {
                it.data?.let { postDetail ->
                    tvTitle.text = postDetail.title
                    tvAuthor.text = postDetail.author
                    tvDate.text = postDetail.publishedAt
                    tvTag.text = "#${postDetail.type}#"
                    tvLikes.text = postDetail.likeCounts.toString()
                    tvComments.text = postDetail.likeCount.toString()
                    tvViews.text = postDetail.views.toString()
                    if (!TextUtils.isEmpty(postDetail.content)) {
                        tvContents.text =
                            Html.fromHtml(postDetail.content, Html.FROM_HTML_MODE_LEGACY)
                    } else {
                        try {
                            val html = Markdown4jProcessor().process(postDetail.markdown)
                            tvContents.text = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                    ivContent.load(postDetail.images[0])
                }
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_gank_detail

    override fun initData(savedInstanceState: Bundle?) {
        //初始化数据
        intent.getStringExtra("postId")?.let {
            if (!TextUtils.isEmpty(it)) {
                gankioViewModel.getPostDetail(it)
            }
        }
    }
}