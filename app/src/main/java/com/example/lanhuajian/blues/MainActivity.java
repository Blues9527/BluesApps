package com.example.lanhuajian.blues;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.lanhuajian.blues.framework.base.BaseActivity;
import com.example.lanhuajian.blues.framework.base.BaseViewPagerAdapter;
import com.example.lanhuajian.blues.module_main.MainPageFragment;
import com.example.lanhuajian.blues.module_personalpage.PersonalPageFragment;
import com.example.lanhuajian.blues.module_study.StudyPageFragment;


public class MainActivity extends BaseActivity {

    private String[] tabs = {"主页", "学习", "我的"};
    private int[] icons = {R.drawable.ic_svg_home, R.drawable.ic_svg_book, R.drawable.ic_svg_user};

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

        mViewPager.setAdapter(mFragmentAdapter);
        mTab.setupWithViewPager(mViewPager, false);
        for (int i = 0; i < tabs.length; i++) {
            mTab.getTabAt(i).setText(tabs[i]).setIcon(icons[i]);
        }
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(1);
    }

    @Override
    public void setListener() {
    }

}
