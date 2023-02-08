package com.blues.article

import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.blues.R
import com.blues.framework.base.BaseKoinActivity
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * 每日一文activity
 */
class EverydayArticleActivity : BaseKoinActivity() {

    private val articleViewModel by viewModel<EverydayArticleViewModel>()

    private lateinit var mTvTitle: TextView
    private lateinit var mTvArticle: TextView
    private lateinit var mTvArticleContent: TextView

    override fun getLayoutId() = R.layout.activity_everyday_article

    override fun initData(savedInstanceState: Bundle?) {
        //获取当日文章数据
        articleViewModel.getTodayArticle()

        mTvTitle = findViewById(R.id.tv_article_title)
        mTvArticle = findViewById(R.id.tv_article_info)
        mTvArticleContent = findViewById(R.id.tv_article_detail)
    }

    override fun collect() {
        lifecycleScope.launchWhenCreated {
            articleViewModel.wanAndroidEntity.collect {
                with(it.data!!) {
                    //设置标题
                    mTvTitle.text = title

                    //设置作者和字数
                    mTvArticle.text = "作者:$author 字数:$wc"

                    //设置文章内容
                    mTvArticleContent.text = Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY)
                }
            }
        }
    }
}