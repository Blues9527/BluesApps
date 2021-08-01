package com.blues.kaiyan.list.view

import com.blues.R
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.blues.framework.base.BaseKoinActivity
import com.blues.framework.base.BaseViewPagerAdapter

/**
 * @author lanhuajian
 * create at 2020/5/4 22:28
 */
class KaiyanActivity : BaseKoinActivity() {

    private val tabs = arrayOf("热门排行", "周排行", "月排行", "总排行")

    override fun getLayoutId(): Int = R.layout.activity_openeye

    override fun initData(savedInstanceState: Bundle?) {
        val mTab = findViewById<TabLayout>(R.id.tl_fragment_bottom)
        val mViewPager = findViewById<ViewPager>(R.id.vp_show)
        BaseViewPagerAdapter(this.supportFragmentManager, tabs.asList()).apply {
            addFragment(KaiyanHotRankFragment())
            addFragment(KaiyanWeeklyRankFragment())
            addFragment(KaiyanMonthlyRankFragment())
            addFragment(KaiyanHistoricalRankFragment())
        }.also {
            mViewPager.apply {
                adapter = it
                currentItem = 0
                offscreenPageLimit = 1
            }
        }
        mTab.setupWithViewPager(mViewPager, false)
    }
}