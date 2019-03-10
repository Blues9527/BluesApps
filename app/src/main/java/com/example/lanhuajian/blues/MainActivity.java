package com.example.lanhuajian.blues;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.framework.base.BaseActivity;
import com.example.lanhuajian.blues.contract.Contract;
import com.example.lanhuajian.blues.model.Entity;
import com.example.lanhuajian.blues.presenter.CPresenter;
import com.example.lanhuajian.blues.view.fragments.AndroidFragment;
import com.example.lanhuajian.blues.view.fragments.FuliFragment;
import com.example.lanhuajian.blues.view.fragments.WebFragment;
import com.example.lanhuajian.blues.view.fragments._iOSFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements Contract.iContractView {

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

        mPresenter = new CPresenter(this);


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
    public void setData(List<Entity.ResultsBean> result) {


    }

    @Override
    public void setPresenter(Contract.iContractPresenter presenter) {

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
