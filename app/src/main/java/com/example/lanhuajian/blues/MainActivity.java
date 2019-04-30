package com.example.lanhuajian.blues;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.framework.base.BaseActivity;
import com.example.lanhuajian.blues.module_main.MainPageFragment;
import com.example.lanhuajian.blues.module_personalpage.PersonalPageFragment;
import com.example.lanhuajian.blues.module_study.StudyPageFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private TabLayout mTab;
    private ViewPager mViewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] tabs = {"主页", "学习", "个人"};
    private final String TAG = "Blues";

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mTab = findViewById(R.id.tl_activity_bottom);
        mViewPager = findViewById(R.id.vp_show);

        fragments.add(new MainPageFragment());
        fragments.add(new StudyPageFragment());
        fragments.add(new PersonalPageFragment());

        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(getSupportFragmentManager()) {
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
//            mTab.getTabAt(i).setIcon();
        }

    }


    @Override
    public void setListener() {
    }
}
