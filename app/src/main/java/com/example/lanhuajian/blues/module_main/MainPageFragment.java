package com.example.lanhuajian.blues.module_main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.module_login.view.LoginActivity;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:27
 */

public class MainPageFragment extends BaseFragment {

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_mainpage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView.findViewById(R.id.tv_tologin).setOnClickListener(v -> startActivity(new Intent(mContext, LoginActivity.class)));

    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }
}