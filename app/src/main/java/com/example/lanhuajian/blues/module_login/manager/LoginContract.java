package com.example.lanhuajian.blues.module_login.manager;

import com.example.framework.base.BasePresenter;
import com.example.framework.base.BaseView;
import com.example.framework.http.HttpCallBack;
import com.example.framework.http.HttpResponse;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:17
 */

public interface LoginContract {
    interface iLoginContractView extends BaseView<iLoginContractPresenter> {

        void onSuccess(HttpResponse result);

        void onFailure(String result);

    }

    interface iLoginContractPresenter extends BasePresenter {

        void doLogin(String username, String password);

    }

    interface iLoginContractModel {

        Subscription doLogin(String username, String password, HttpCallBack<HttpResponse> callBack);

    }
}
