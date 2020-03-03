package com.blues.module_login;

import com.blues.framework.base.BaseView;
import com.blues.framework.base.RxPresenter;
import com.blues.framework.http.HttpCallBack;

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
        subscribe(iModel.doLogin(username, password, new HttpCallBack<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse data) {
                if (data.getErrorCode() == 0) {
                    iView.onSuccess(data);
                } else {
                    iView.onFailure(data.getErrorMsg());
                }

            }

            @Override
            public void onFailure(String error) {

            }
        }));
    }
}
