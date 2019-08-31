package com.example.lanhuajian.blues.module_kaiyan;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.base.BaseViewPagerAdapter;
import com.example.lanhuajian.blues.module_kaiyan.historicalrank.OEHistoricalRankFragment;
import com.example.lanhuajian.blues.module_kaiyan.hotrank.OEHotRankFragment;
import com.example.lanhuajian.blues.module_kaiyan.monthlyrank.OEMonthlyRankFragment;
import com.example.lanhuajian.blues.module_kaiyan.weeklyrank.OEWeeklyRankFragment;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */

public class OpenEyeFragment extends BaseFragment {

    private String[] tabs = {"热门排行", "周排行", "月排行", "总排行"};

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_weibopage;
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
