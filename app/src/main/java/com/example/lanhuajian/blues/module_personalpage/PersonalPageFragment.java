package com.example.lanhuajian.blues.module_personalpage;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.framework.widget.AvatarView;
import com.example.lanhuajian.blues.R;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */

public class PersonalPageFragment extends BaseFragment implements UserInfoContract.iUserInfoView {

    private AvatarView avatar;
    private UserInfoContract.iUserInfoPresenter iPresenter;

    private TextView tvUserName, tvUserId, tvSchool, tvMajor;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_personalpage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        avatar = rootView.findViewById(R.id.custom_avatar);
        tvUserName = rootView.findViewById(R.id.tv_username);
        tvUserId = rootView.findViewById(R.id.tv_userid);
        tvSchool = rootView.findViewById(R.id.tv_school);
        tvMajor = rootView.findViewById(R.id.tv_major);


        mPresenter = new PPPresenter(this);

        iPresenter.getUserInfo();

        avatar.setBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.iv_my_avatar));
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void showUerInfo(UserInfoEntity.DataBean userInfo) {

        Log.i("Blues", userInfo.toString());

        tvUserName.setText(userInfo.getUsername());
        tvUserId.setText(String.valueOf(userInfo.getUser_id()));
        tvSchool.setText(userInfo.getSchool());
        tvMajor.setText(userInfo.getMajor());
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void setPresenter(UserInfoContract.iUserInfoPresenter presenter) {
        iPresenter = presenter;
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
