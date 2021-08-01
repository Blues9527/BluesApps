package com.blues.gankio.v1

import android.content.Context
import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.blues.framework.base.BaseViewPagerAdapter
import com.blues.gankio.v1.view.VideoFragment
import com.blues.gankio.v1.view.AndroidFragment
import com.blues.gankio.v1.view.IOSFragment
import com.blues.gankio.v1.view.WebFragment
import com.blues.gankio.v1.view.ArticleFragment
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import android.widget.TextView
import android.view.Gravity
import android.view.View
import com.blues.framework.base.BaseKoinFragment
import java.util.*

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */
class StudyPageFragment : BaseKoinFragment() {

    private val tabs = arrayOf("Video", "Android", "iOS", "Web", "Blues")
    private val fragments = arrayOf(VideoFragment(), AndroidFragment(), IOSFragment(), WebFragment(), ArticleFragment())

    private fun getTabView(context: Context, text: String): View {
        val textView = TextView(context)
        textView.gravity = Gravity.CENTER
        textView.text = text
        return textView
    }

    override fun getLayoutId(): Int = R.layout.fragment_studypage

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        val mTab: TabLayout = rootView.findViewById(R.id.tl_fragment_bottom)
        val mViewPager: ViewPager = rootView.findViewById(R.id.vp_show)
        val mFragmentAdapter = BaseViewPagerAdapter(childFragmentManager, tabs.asList())
        fragments.map { mFragmentAdapter.addFragment(it) }
        mViewPager.apply {
            adapter = mFragmentAdapter
            offscreenPageLimit = 1
            addOnPageChangeListener(TabLayoutOnPageChangeListener(mTab))
        }

        mTab.apply {
            addOnTabSelectedListener(object : TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    mViewPager.currentItem = tab.position
                    val view = tab.customView
                    if (view is TextView) {
                        view.setTextColor(view.getResources().getColor(R.color.color_light_blue))
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    val view = tab.customView
                    if (view is TextView) {
                        view.setTextColor(view.getResources().getColor(R.color.color_black))
                    }
                }

                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
            setSelectedTabIndicatorColor(mTab.resources.getColor(R.color.color_light_blue)) //因为fragment不销毁，所以添加新tabs前最好把旧的都移除掉先，否则就会出现重复的
            removeAllTabs()
        }
        for (i in tabs.indices) {
            mTab.addTab(mTab.newTab().setCustomView(getTabView(requireContext(), tabs[i])), i == 0)
        }
    }
}