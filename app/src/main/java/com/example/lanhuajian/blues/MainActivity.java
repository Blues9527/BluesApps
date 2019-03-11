package com.example.lanhuajian.blues;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.framework.base.BaseActivity;
import com.example.lanhuajian.blues.model_android.contract.AndroidContract;
import com.example.lanhuajian.blues.model_android.model.AndroidEntity;
import com.example.lanhuajian.blues.model_android.presenter.AndroidPresenter;
import com.example.lanhuajian.blues.model_android.view.AndroidFragment;
import com.example.lanhuajian.blues.model_fuli.view.FuliFragment;
import com.example.lanhuajian.blues.model_ios.view._iOSFragment;
import com.example.lanhuajian.blues.model_web.view.WebFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements AndroidContract.iContractView {

    private TabLayout mTab;
    private ViewPager mViewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] tabs = {"Android", "iOS", "前端", "福利"};

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mTab = findViewById(R.id.tl_bottom);
        mViewPager = findViewById(R.id.vp_show);

        mPresenter = new AndroidPresenter(this);


        fragments.add(new AndroidFragment());
        fragments.add(new _iOSFragment());
        fragments.add(new WebFragment());
        fragments.add(new FuliFragment());

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
        }


    }

    @Override
    public void setListener() {

    }

    @Override
    public void setData(List<AndroidEntity.ResultsBean> result) {


    }

    @Override
    public void setPresenter(AndroidContract.iContractPresenter presenter) {

    }

    @Override
    public void showBegin() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFinished() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }
}
