package com.example.lanhuajian.blues.module_study;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.base.BaseViewPagerAdapter;
import com.example.lanhuajian.blues.module_study.model_android.view.AndroidFragment;
import com.example.lanhuajian.blues.module_study.model_fuli.view.FuliFragment;
import com.example.lanhuajian.blues.module_study.model_ios.view._iOSFragment;
import com.example.lanhuajian.blues.module_study.model_web.view.WebFragment;


/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */

public class StudyPageFragment extends BaseFragment {

    private String[] tabs = {"Android", "iOS", "Web", "美女"};

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_studypage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TabLayout mTab = rootView.findViewById(R.id.tl_fragment_bottom);
        ViewPager mViewPager = rootView.findViewById(R.id.vp_show);

        BaseViewPagerAdapter mFragmentAdapter = new BaseViewPagerAdapter(getChildFragmentManager(), tabs);
        mFragmentAdapter.addFragment(new AndroidFragment());
        mFragmentAdapter.addFragment(new _iOSFragment());
        mFragmentAdapter.addFragment(new WebFragment());
        mFragmentAdapter.addFragment(new FuliFragment());

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
