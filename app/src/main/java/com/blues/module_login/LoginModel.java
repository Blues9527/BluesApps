package com.blues.module_login;

import com.blues.framework.http.HttpCallBack;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:25
 */

public class LoginModel implements LoginContract.iLoginContractModel {
    @Override
    public Subscription doLogin(String username, String password, HttpCallBack<LoginResponse> callBack) {
        return LoginAPI.getInstance().doLogin(username, password, new Subscriber<LoginResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(LoginResponse httpResponse) {
                callBack.onSuccess(httpResponse);
            }
        });
    }
}
