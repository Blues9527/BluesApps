package com.blues.gankio.v2.view

import android.widget.TextView
import com.blues.R
import android.os.Bundle
import android.text.TextUtils
import android.text.Html
import android.widget.ImageView
import coil.load
import com.blues.framework.base.BaseKoinActivity
import com.blues.gankio.v2.vm.GankioViewModel
import org.markdown4j.Markdown4jProcessor
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException

class GankPostDetailActivity : BaseKoinActivity() {

    private val gankioViewModel: GankioViewModel by viewModel()

    private lateinit var tvTitle: TextView
    private lateinit var tvAuthor: TextView
    private lateinit var tvDate: TextView
    private lateinit var tvTag: TextView
    private lateinit var tvLikes: TextView
    private lateinit var tvComments: TextView
    private lateinit var tvViews: TextView
    private lateinit var tvDesc: TextView
    private lateinit var tvContents: TextView
    private lateinit var ivContent: ImageView

    override fun observe() {
        gankioViewModel.postDetail.observe(this) {
            it.data?.let { postDetail ->
                tvTitle.text = postDetail.title
                tvAuthor.text = postDetail.author
                tvDate.text = postDetail.publishedAt
                tvTag.text = "#${postDetail.type}#"
                tvLikes.text = postDetail.likeCounts.toString()
                tvComments.text = postDetail.likeCount.toString()
                tvViews.text = postDetail.views.toString()
                if (!TextUtils.isEmpty(postDetail.content)) {
                    tvContents.text = Html.fromHtml(postDetail.content, Html.FROM_HTML_MODE_LEGACY)
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

    override fun getLayoutId(): Int = R.layout.activity_gank_detail

    override fun initData(savedInstanceState: Bundle?) {
        val postId = intent.getStringExtra("postId") //初始化数据
        if (postId != null && !TextUtils.isEmpty(postId)) {
            gankioViewModel.getPostDetail(postId)
        }

        tvTitle = findViewById(R.id.tv_title)
        tvAuthor = findViewById(R.id.tv_author)
        tvDate = findViewById(R.id.tv_date)
        tvTag = findViewById(R.id.tv_tag)
        tvLikes = findViewById(R.id.tv_likes)
        tvComments = findViewById(R.id.tv_comments)
        tvViews = findViewById(R.id.tv_views)
        tvDesc = findViewById(R.id.tv_desc)
        tvContents = findViewById(R.id.tv_content)
        ivContent = findViewById(R.id.iv_content)
    }
}