package com.example.lanhuajian.blues;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.lanhuajian.blues.framework.base.BaseActivity;
import com.example.lanhuajian.blues.framework.base.BaseViewPagerAdapter;
import com.example.lanhuajian.blues.module_main.MainPageFragment;
import com.example.lanhuajian.blues.module_personalpage.PersonalPageFragment;
import com.example.lanhuajian.blues.module_study.StudyPageFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private String[] tabs = {"home", "study", "mine"};

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        TabLayout mTab = findViewById(R.id.tl_activity_bottom);
        ViewPager mViewPager = findViewById(R.id.vp_show);

        BaseViewPagerAdapter mFragmentAdapter = new BaseViewPagerAdapter(getSupportFragmentManager(), tabs);
        mFragmentAdapter.addFragment(new MainPageFragment());
        mFragmentAdapter.addFragment(new StudyPageFragment());
        mFragmentAdapter.addFragment(new PersonalPageFragment());

        mTab.setupWithViewPager(mViewPager, false);
        mViewPager.setAdapter(mFragmentAdapter);
        mViewPager.setCurrentItem(0);
    }

    @Override
    public void setListener() {
    }

}
