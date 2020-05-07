package com.blues;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.blues.framework.base.BaseActivity;
import com.blues.framework.utils.HelperUtil;
import com.blues.module_kaiyan.OpenEyeFragment;
import com.blues.module_main.MainPageFragment;
import com.blues.module_gank.old.StudyPageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private long mLastMillis;
    private Fragment mCurrentFragment;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        fragmentList.add(new MainPageFragment());
        fragmentList.add(new StudyPageFragment());
        fragmentList.add(new OpenEyeFragment());

        //先设置监听再添加tab，selected 标识就能起作用

        BottomNavigationView bottomView = findViewById(R.id.bottom_view);
        bottomView.setOnNavigationItemSelectedListener(this);

        showFragment(null, fragmentList.get(0));
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
            } else {
                //返回退出界面，但不销毁
                moveTaskToBack(true);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                showFragment(mCurrentFragment, fragmentList.get(0));
                break;
            case R.id.menu_study:
                showFragment(mCurrentFragment, fragmentList.get(1));
                break;
            case R.id.menu_open_eye:
                showFragment(mCurrentFragment, fragmentList.get(2));
                break;
        }
        return true;
    }

    private void showFragment(Fragment from, Fragment to) {
        if (to == null) return;
        FragmentTransaction transaction = mContext.getSupportFragmentManager().beginTransaction();
        boolean isAdded = to.isAdded();
        if (!isAdded) {
            if (from != null) {
                transaction.hide(from)
                        .add(R.id.fl_container, to, null)
                        .show(to)
                        .commitAllowingStateLoss();
            } else {
                transaction.add(R.id.fl_container, to, null)
                        .show(to)
                        .commitAllowingStateLoss();
            }
        } else {
            if (from != null) {
                transaction.hide(from)
                        .show(to)
                        .commitAllowingStateLoss();
            } else {
                transaction.show(to)
                        .commitAllowingStateLoss();
            }
        }

        mCurrentFragment = to;
    }
}
