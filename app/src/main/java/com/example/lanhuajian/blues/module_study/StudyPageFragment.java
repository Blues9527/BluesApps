package com.example.lanhuajian.blues.module_study;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.module_study.model_android.view.AndroidFragment;
import com.example.lanhuajian.blues.module_study.model_fuli.view.FuliFragment;
import com.example.lanhuajian.blues.module_study.model_ios.view._iOSFragment;
import com.example.lanhuajian.blues.module_study.model_web.view.WebFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */

public class StudyPageFragment extends BaseFragment {
    private TabLayout mTab;
    private ViewPager mViewPager;
    private List<Fragment> fragments = new ArrayList<>();

    private String[] tabs = {"Android", "iOS", "Web", "Fuli"};

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_studypage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mTab = rootView.findViewById(R.id.tl_fragment_bottom);
        mViewPager = rootView.findViewById(R.id.vp_show);

        fragments.add(new AndroidFragment());
        fragments.add(new _iOSFragment());
        fragments.add(new WebFragment());
        fragments.add(new FuliFragment());

        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(getChildFragmentManager()) {
                    @Override
                    public Fragment getItem(int i) {
                        return fragments.get(i);
                    }

                    @Override
                    public int getCount() {
                        return fragments.size();
                    }
                };

        mTab.setupWithViewPager(mViewPager, false);
        mViewPager.setAdapter(fragmentPagerAdapter);
        mViewPager.setCurrentItem(0);

        for (int i = 0; i < tabs.length; i++) {
            mTab.getTabAt(i).setText(tabs[i]);
        }
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }
}
