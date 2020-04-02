package com.blues.module_kaiyan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.framework.base.BaseViewPagerAdapter;
import com.blues.module_kaiyan.historicalrank.OEHistoricalRankFragment;
import com.blues.module_kaiyan.hotrank.OEHotRankFragment;
import com.blues.module_kaiyan.monthlyrank.OEMonthlyRankFragment;
import com.blues.module_kaiyan.weeklyrank.OEWeeklyRankFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */

public class OpenEyeFragment extends BaseFragment {

    private String[] tabs = {"热门排行", "周排行", "月排行", "总排行"};

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_openeye;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TabLayout mTab = rootView.findViewById(R.id.tl_fragment_bottom);
        ViewPager mViewPager = rootView.findViewById(R.id.vp_show);

        BaseViewPagerAdapter mFragmentAdapter = new BaseViewPagerAdapter(getChildFragmentManager(), tabs);
        mFragmentAdapter.addFragment(new OEHotRankFragment());
        mFragmentAdapter.addFragment(new OEWeeklyRankFragment());
        mFragmentAdapter.addFragment(new OEMonthlyRankFragment());
        mFragmentAdapter.addFragment(new OEHistoricalRankFragment());

        mTab.setupWithViewPager(mViewPager, false);
        mViewPager.setAdapter(mFragmentAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(1);
    }

    @Override
    public void lazyFetchData() {
    }

    @Override
    public void setListener() {
    }
}
