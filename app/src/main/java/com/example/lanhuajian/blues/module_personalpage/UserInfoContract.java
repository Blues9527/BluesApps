package com.example.lanhuajian.blues.module_personalpage;

import com.example.lanhuajian.blues.framework.base.BasePresenter;
import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:01
 */

public interface UserInfoContract {

    interface iUserInfoView extends BaseView<iUserInfoPresenter> {

        void showUerInfo(UserInfoEntity.DataBean userInfo);

        void showError(String msg);

    }

    interface iUserInfoPresenter extends BasePresenter {

        void getUserInfo();

    }

    interface iUserInfoModel {
        Subscription getUserInfo(HttpCallBack<UserInfoEntity> callBack);
    }
}
