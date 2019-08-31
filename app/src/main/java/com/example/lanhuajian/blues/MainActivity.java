package com.example.lanhuajian.blues;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

import com.example.lanhuajian.blues.framework.base.BaseActivity;
import com.example.lanhuajian.blues.framework.base.BaseViewPagerAdapter;
import com.example.lanhuajian.blues.framework.utils.HelperUtil;
import com.example.lanhuajian.blues.module_main.MainPageFragment;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeFragment;
import com.example.lanhuajian.blues.module_study.StudyPageFragment;


public class MainActivity extends BaseActivity {

    private String[] tabs = {"主页", "学习", "开眼"};
    private int[] icons = {R.drawable.ic_svg_home, R.drawable.ic_svg_book, R.drawable.ic_svg_user};
    private long mLastMillis;

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
        mFragmentAdapter.addFragment(new OpenEyeFragment());

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

    @Override
    public void onBackPressed() {
        HelperUtil.showSimpleLog("on back press");

        long currentMillis = System.currentTimeMillis();
        if (currentMillis - mLastMillis > 2000) {
            mLastMillis = currentMillis;
            HelperUtil.showToastShort("再按一次退出程序");
            return;
        }

        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long currentMillis = System.currentTimeMillis();
            if (currentMillis - mLastMillis > 2000) {
                mLastMillis = currentMillis;
                HelperUtil.showToastShort("再按一次退出程序");
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
