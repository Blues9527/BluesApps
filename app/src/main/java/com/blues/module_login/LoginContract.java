package com.blues.module_login;

import com.blues.framework.base.BasePresenter;
import com.blues.framework.base.BaseView;
import com.blues.framework.http.HttpCallBack;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:17
 */

public interface LoginContract {
    interface iLoginContractView extends BaseView<iLoginContractPresenter> {

        void onSuccess(LoginResponse result);

        void onFailure(String result);

    }

    interface iLoginContractPresenter extends BasePresenter {

        void doLogin(String username, String password);

    }

    interface iLoginContractModel {

        Subscription doLogin(String username, String password, HttpCallBack<LoginResponse> callBack);

    }
}
