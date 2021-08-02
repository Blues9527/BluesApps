package com.blues.gankio.v2.view

import android.content.Context
import com.blues.framework.widget.endlessbannerview.BannerView
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.blues.R
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.view.Gravity
import com.blues.framework.base.BaseViewPagerAdapter
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import android.os.Looper
import android.view.View
import android.widget.LinearLayout
import com.blues.framework.widget.endlessbannerview.BannerAdapter
import com.blues.WebViewDialog
import com.blues.framework.base.BaseKoinActivity
import com.blues.framework.utils.dp
import com.blues.gankio.v2.vm.GankioViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList

class GankActivity : BaseKoinActivity() {

    private val gankioViewModel: GankioViewModel by viewModel()

    private lateinit var mBanner: BannerView
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager

    private val mTabs: MutableList<String> = ArrayList()

    private fun getTabView(context: Context, text: String): View {
        val textView = TextView(context)
        textView.gravity = Gravity.CENTER
        textView.text = text
        return textView
    }

    override fun observe() {
        gankioViewModel.banner.observe(this) { bean ->
            startBannerLoop(bean.data.map { it.image } as MutableList<String>, bean.data.map { it.url } as MutableList<String>)
        }

        gankioViewModel.category.observe(this) {

            for (data in it.data) {
                mTabs.add(data.title)
            }

            val mFragmentAdapter = BaseViewPagerAdapter(supportFragmentManager, mTabs)
            for (data in it.data) {
                mFragmentAdapter.addFragment(GankUniversalFragment(data.type))
            }

            mViewPager.apply {
                adapter = mFragmentAdapter
                offscreenPageLimit = 1
                addOnPageChangeListener(TabLayoutOnPageChangeListener(mTabLayout))
            }
            mTabLayout.addOnTabSelectedListener(object :
                TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    mViewPager.currentItem = tab.position
                    val view = tab.customView
                    if (view is TextView) {
                        view.setTextColor(view.getResources()
                                .getColor(R.color.color_light_blue))
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    val view = tab.customView
                    if (view is TextView) {
                        view.setTextColor(view.getResources()
                                .getColor(R.color.color_black))
                    }
                }

                override fun onTabReselected(tab: TabLayout.Tab) {}
            })

            mTabLayout.setSelectedTabIndicatorColor(mTabLayout.resources.getColor(R.color.color_light_blue)) //因为fragment不销毁，所以添加新tabs前最好把旧的都移除掉先，否则就会出现重复的
            mTabLayout.removeAllTabs()
            for (i in mTabs.indices) {
                mTabLayout.addTab(mTabLayout.newTab()
                        .setCustomView(getTabView(this, mTabs[i])), i == 0)
            }
        }
    }

    private fun startBannerLoop(images: MutableList<String>, urls: MutableList<String>) {
        Handler(Looper.getMainLooper()).post {
            val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 185f.dp.toInt())
            mBanner.apply {
                setPlayDelay(3000)
                setHintPadding(10f.dp.toInt(), 0, 10f.dp.toInt(), 10f.dp.toInt())
                setAnimationDuration(1000)
                layoutParams = lp
            }
            BannerAdapter(this, images, mBanner).apply {
                setItemClickListener(object : BannerAdapter.ItemClickListener {
                    override fun onClick(realPosition: Int) {
                        WebViewDialog(this@GankActivity, urls[realPosition]).show()
                    }
                })
            }
                    .also { //开启轮播
                        mBanner.setAdapter(it)
                    }
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_gank

    override fun initData(savedInstanceState: Bundle?) {
        mTabLayout = findViewById(R.id.tl_gank_top)
        mBanner = findViewById(R.id.bv_header)
        mViewPager = findViewById(R.id.vp_show)

        gankioViewModel.requestData()
    }

    override fun onResume() {
        super.onResume()
        mBanner.resume()
    }

    override fun onPause() {
        super.onPause()
        mBanner.pause()
    }
}