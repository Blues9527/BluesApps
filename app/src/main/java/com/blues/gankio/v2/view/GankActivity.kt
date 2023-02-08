package com.blues.gankio.v2.view

import android.content.Context
import com.blues.framework.widget.endlessbannerview.BannerView
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.blues.R
import android.os.Bundle
import android.widget.TextView
import android.view.Gravity
import com.blues.framework.base.BaseViewPagerAdapter
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import com.blues.framework.widget.endlessbannerview.BannerAdapter
import com.blues.framework.dialog.WebViewDialog
import com.blues.framework.base.BaseKoinActivity
import com.blues.framework.utils.dp
import com.blues.gankio.v2.vm.GankioViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList

class GankActivity : BaseKoinActivity() {

    private val gankioViewModel: GankioViewModel by viewModel()

    private val mBanner: BannerView by lazy {
        findViewById(R.id.bv_header)
    }
    private val mTabLayout: TabLayout by lazy {
        findViewById(R.id.tl_gank_top)
    }
    private val mViewPager: ViewPager by lazy {
        findViewById(R.id.vp_show)
    }

    private val mTabs: MutableList<String> = ArrayList()

    private fun getTabView(context: Context, textStr: String): View = TextView(context).apply {
        gravity = Gravity.CENTER
        text = textStr
    }

    override fun collect() {
        lifecycleScope.launch {
            gankioViewModel.banner.collect { bean ->
                startBannerLoop(bean.data.map { it.image } as MutableList<String>,
                    bean.data.map { it.url } as MutableList<String>)
            }
        }

        lifecycleScope.launch {
            gankioViewModel.category.collect {

                val mFragmentAdapter = BaseViewPagerAdapter(supportFragmentManager, mTabs)

                it.data.forEach { data ->
                    mTabs.add(data.title)

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

                        tab.customView.takeIf { view ->
                            view is TextView
                        }?.let { view ->
                            (view as TextView).setTextColor(
                                view.getResources().getColor(R.color.color_light_blue, null)
                            )
                        }
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab) {

                        tab.customView.takeIf { view ->
                            view is TextView
                        }?.let { view ->
                            (view as TextView).setTextColor(
                                view.getResources().getColor(R.color.color_black, null)
                            )
                        }
                    }

                    override fun onTabReselected(tab: TabLayout.Tab) {}
                })

                with(mTabLayout) {
                    setSelectedTabIndicatorColor(
                        resources.getColor(
                            R.color.color_light_blue,
                            null
                        )
                    )

                    //因为fragment不销毁，所以添加新tabs前最好把旧的都移除掉先，否则就会出现重复的
                    removeAllTabs()

                    for (i in mTabs.indices) {
                        addTab(
                            newTab().setCustomView(getTabView(this@GankActivity, mTabs[i])),
                            i == 0
                        )
                    }
                }
            }
        }

    }

    private fun startBannerLoop(images: MutableList<String>, urls: MutableList<String>) {
        CoroutineScope(Dispatchers.Main).launch {
            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                185f.dp.toInt()
            )
            mBanner.apply {
                setPlayDelay(3000)
                setHintPadding(10f.dp.toInt(), 0, 10f.dp.toInt(), 10f.dp.toInt())
                setAnimationDuration(1000)
                layoutParams = lp
            }
            BannerAdapter(this@GankActivity, images, mBanner).apply {
                setItemClickListener(object : BannerAdapter.ItemClickListener {
                    override fun onClick(realPosition: Int) {
                        WebViewDialog(this@GankActivity, urls[realPosition]).show()
                    }
                })
            }.also { //开启轮播
                mBanner.setAdapter(it)
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_gank

    override fun initData(savedInstanceState: Bundle?) {
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