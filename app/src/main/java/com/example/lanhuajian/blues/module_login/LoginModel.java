package com.example.lanhuajian.blues.module_login;

import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.framework.http.HttpResponse;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:25
 */

public class LoginModel implements LoginContract.iLoginContractModel {
    @Override
    public Subscription doLogin(String username, String password, HttpCallBack<HttpResponse> callBack) {
        return LoginAPI.getInstance().doLogin(username, password, new Subscriber<HttpResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(HttpResponse httpResponse) {
                callBack.onSuccess(httpResponse);
            }
        });
    }
}
