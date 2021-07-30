package com.blues.kaiyan.list.view

import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.blues.framework.base.BaseKoinFragment
import com.blues.framework.base.BaseViewPagerAdapter

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */
class OpenEyeFragment : BaseKoinFragment() {

    private val tabs = arrayOf("热门排行", "周排行", "月排行", "总排行")

    override fun getLayoutId(): Int = R.layout.fragment_openeye

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {
        val mTab: TabLayout = rootView.findViewById(R.id.tl_fragment_bottom)
        val mViewPager: ViewPager = rootView.findViewById(R.id.vp_show)
        BaseViewPagerAdapter(childFragmentManager, tabs.asList()).apply {
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