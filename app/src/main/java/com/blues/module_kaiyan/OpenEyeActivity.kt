package com.blues.module_kaiyan

import com.blues.R
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.blues.framework.base.BaseKoinActivity
import com.blues.framework.base.BaseViewPagerAdapter
import com.blues.module_kaiyan.hotrank.OEHotRankFragment
import com.blues.module_kaiyan.weeklyrank.OEWeeklyRankFragment
import com.blues.module_kaiyan.monthlyrank.OEMonthlyRankFragment
import com.blues.module_kaiyan.historicalrank.OEHistoricalRankFragment

/**
 * @author lanhuajian
 * create at 2020/5/4 22:28
 */
class OpenEyeActivity : BaseKoinActivity() {

    private val tabs = arrayOf("热门排行", "周排行", "月排行", "总排行")

    override fun getLayoutId(): Int = R.layout.activity_openeye

    override fun initData(savedInstanceState: Bundle?) {
        val mTab = findViewById<TabLayout>(R.id.tl_fragment_bottom)
        val mViewPager = findViewById<ViewPager>(R.id.vp_show)
        BaseViewPagerAdapter(this.supportFragmentManager, tabs.asList()).apply {
            addFragment(OEHotRankFragment())
            addFragment(OEWeeklyRankFragment())
            addFragment(OEMonthlyRankFragment())
            addFragment(OEHistoricalRankFragment())
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