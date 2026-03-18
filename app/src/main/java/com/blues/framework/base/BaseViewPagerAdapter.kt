package com.blues.framework.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList

/**
 * User : Blues
 * Date : 2019/6/27
 * Time : 11:26
 */
class BaseViewPagerAdapter(fm: FragmentManager?, private val titles: List<String>) :
    FragmentPagerAdapter(fm!!) {

    private val fragments: MutableList<Fragment> = ArrayList()

    override fun getItem(i: Int): Fragment {
        return fragments[i]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}