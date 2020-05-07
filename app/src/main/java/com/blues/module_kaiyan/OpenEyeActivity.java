package com.blues.module_kaiyan;

import android.os.Bundle;

import com.blues.R;
import com.blues.framework.base.BaseActivity;
import com.blues.framework.base.BaseViewPagerAdapter;
import com.blues.module_kaiyan.historicalrank.OEHistoricalRankFragment;
import com.blues.module_kaiyan.hotrank.OEHotRankFragment;
import com.blues.module_kaiyan.monthlyrank.OEMonthlyRankFragment;
import com.blues.module_kaiyan.weeklyrank.OEWeeklyRankFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

import androidx.viewpager.widget.ViewPager;

/**
 * @author lanhuajian
 * create at 2020/5/4 22:28
 */
public class OpenEyeActivity extends BaseActivity {

    private String[] tabs = {"热门排行", "周排行", "月排行", "总排行"};

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_openeye;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        TabLayout mTab = findViewById(R.id.tl_fragment_bottom);
        ViewPager mViewPager = findViewById(R.id.vp_show);

        BaseViewPagerAdapter mFragmentAdapter = new BaseViewPagerAdapter(mContext.getSupportFragmentManager(), Arrays.asList(tabs));
        mFragmentAdapter.addFragment(new OEHotRankFragment());
        mFragmentAdapter.addFragment(new OEWeeklyRankFragment());
        mFragmentAdapter.addFragment(new OEMonthlyRankFragment());
        mFragmentAdapter.addFragment(new OEHistoricalRankFragment());

        mTab.setupWithViewPager(mViewPager, false);
        mViewPager.setAdapter(mFragmentAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(1);
    }
}
