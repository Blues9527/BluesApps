package com.example.lanhuajian.blues.module_personalpage;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.framework.utils.FileUtil;
import com.example.lanhuajian.blues.framework.utils.JsonUtil;
import com.example.lanhuajian.blues.framework.widget.AvatarView;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.mock.CourseListEntity;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */

public class PersonalPageFragment extends BaseFragment implements UserInfoContract.iUserInfoView {

    private AvatarView avatar;
    private UserInfoContract.iUserInfoPresenter iPresenter;

    private TextView tvUserName, tvUserId, tvSchool, tvMajor;

    private TextView tvTest;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_personalpage;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        Log.i("Blues", "isVisibleToUser --> " + isVisibleToUser);
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mPresenter = new PPPresenter(this);
        iPresenter.getUserInfo();

        avatar = rootView.findViewById(R.id.custom_avatar);
        tvUserName = rootView.findViewById(R.id.tv_username);
        tvUserId = rootView.findViewById(R.id.tv_userid);
        tvSchool = rootView.findViewById(R.id.tv_school);
        tvMajor = rootView.findViewById(R.id.tv_major);

        tvTest = rootView.findViewById(R.id.tv_test);

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

        CourseListEntity entity = JsonUtil.convertToEntity(FileUtil.readJson("mock_course.json"), CourseListEntity.class);

        tvTest.setText(entity.getMessage());
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
