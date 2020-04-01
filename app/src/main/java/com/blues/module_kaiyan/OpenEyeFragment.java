package com.blues.module_kaiyan;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blues.framework.base.BaseFragment;
import com.blues.R;
import com.blues.framework.base.BaseViewPagerAdapter;
import com.blues.module_kaiyan.historicalrank.OEHistoricalRankFragment;
import com.blues.module_kaiyan.hotrank.OEHotRankFragment;
import com.blues.module_kaiyan.monthlyrank.OEMonthlyRankFragment;
import com.blues.module_kaiyan.search.OpenEyeSearchActivity;
import com.blues.module_kaiyan.weeklyrank.OEWeeklyRankFragment;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */

public class OpenEyeFragment extends BaseFragment {

    private String[] tabs = {"热门排行", "周排行", "月排行", "总排行"};
    private ImageView ivSearch;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_openeye;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TabLayout mTab = rootView.findViewById(R.id.tl_fragment_bottom);
        ViewPager mViewPager = rootView.findViewById(R.id.vp_show);
        ivSearch = rootView.findViewById(R.id.iv_search);

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
        ivSearch.setOnClickListener(v -> {
            Intent intent = new Intent(getmContext(), OpenEyeSearchActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getmContext(), ivSearch, "transitionSearch");
            startActivity(intent, options.toBundle());
        });
    }
}
