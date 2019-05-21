package com.example.lanhuajian.blues.module_login;

import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.base.RxPresenter;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.framework.http.HttpResponse;

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
