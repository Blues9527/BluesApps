package com.example.lanhuajian.blues.module_register;

import com.example.lanhuajian.blues.constant.RequestUrl;
import com.example.lanhuajian.blues.framework.http.RetrofitManager;
import com.example.lanhuajian.blues.framework.utils.RxUtil;
import com.example.lanhuajian.blues.module_study.model_android.AndroidAPI;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:16
 */

public class RegisterAPI {
    private static volatile RegisterAPI instance;

    private RegisterAPI() {
    }

    public static RegisterAPI getInstance() {
        RetrofitManager.setBaseUrl(RequestUrl.BASE_WANANDROID_URL);
        if (null == instance) {
            synchronized (AndroidAPI.class) {
                if (null == instance) {
                    instance = new RegisterAPI();
                }
            }
        }
        return instance;
    }

    public Subscription doRegister(String username, String password, String repassword, Subscriber<RegisterResponse> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(RegisterContractRequest.class).doRegister(username, password, repassword);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
