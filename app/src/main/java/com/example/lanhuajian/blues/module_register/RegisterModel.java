package com.example.lanhuajian.blues.module_register;

import com.example.lanhuajian.blues.framework.http.HttpCallBack;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/11/26
 * Time : 17:25
 */

public class RegisterModel implements RegisterContract.iRegisterContractModel {

    @Override
    public Subscription doRegister(String username, String password, String repassword, HttpCallBack<RegisterResponse> callBack) {
        return RegisterAPI.getInstance().doRegister(username, password, repassword, new Subscriber<RegisterResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(RegisterResponse httpResponse) {
                callBack.onSuccess(httpResponse);
            }
        });
    }
}
