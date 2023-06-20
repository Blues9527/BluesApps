package com.blues.article

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.TextView
import androidx.core.widget.NestedScrollView
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

    private val mTvTitle: TextView by lazy {
        findViewById(R.id.tv_article_title)
    }
    private val mTvArticle: TextView by lazy {
        findViewById(R.id.tv_article_info)
    }
    private val mTvArticleContent: TextView by lazy {
        findViewById(R.id.tv_article_detail)
    }

    private val mNsvArticle: NestedScrollView by lazy {
        findViewById(R.id.nsv_article)
    }

    override fun getLayoutId() = R.layout.activity_everyday_article

    override fun initData(savedInstanceState: Bundle?) {
        //获取当日文章数据
        articleViewModel.getTodayArticle()

        mNsvArticle.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            run {
                Log.d(
                    "Blues",
                    "scrollX:$scrollX  scrollY:$scrollY  oldScrollX:$oldScrollX  oldScrollY$oldScrollY"
                )
            }
        })
    }

    override fun collect() {
        lifecycleScope.launchWhenCreated {
            articleViewModel.everydayArticleFlow.collect {
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