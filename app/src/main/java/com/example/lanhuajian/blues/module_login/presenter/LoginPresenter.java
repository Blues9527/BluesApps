package com.example.lanhuajian.blues.module_login.presenter;

import com.example.framework.base.BaseView;
import com.example.framework.base.RxPresenter;
import com.example.framework.http.HttpCallBack;
import com.example.framework.http.HttpResponse;
import com.example.lanhuajian.blues.module_login.manager.LoginContract;
import com.example.lanhuajian.blues.module_login.model.LoginModel;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:25
 */

public class LoginPresenter extends RxPresenter implements LoginContract.iLoginContractPresenter {

    private LoginContract.iLoginContractView iView;
    private LoginContract.iLoginContractModel iModel;

    public LoginPresenter(BaseView mView) {
        super(mView);
        iView = (LoginContract.iLoginContractView) mView;
        iModel = new LoginModel();
    }

    @Override
    public void doLogin(String username, String password) {
        subscribe(iModel.doLogin(username, password, new HttpCallBack<HttpResponse>() {
            @Override
            public void onSuccess(HttpResponse data) {
                iView.onSuccess(data);
            }

            @Override
            public void onFailure(String error) {
                iView.onFailure(error);
            }
        }));
    }
}
