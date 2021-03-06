package com.blues.module_login;

import com.blues.constant.RequestUrl;
import com.blues.framework.http.RetrofitManager;
import com.blues.framework.utils.RxUtil;
import com.blues.module_gank.old.model_android.AndroidAPI;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:16
 */

public class LoginAPI {
    private static volatile LoginAPI instance;

    private LoginAPI() {
    }

    public static LoginAPI getInstance() {
        RetrofitManager.setBaseUrl(RequestUrl.BASE_WANANDROID_URL);
        if (null == instance) {
            synchronized (AndroidAPI.class) {
                if (null == instance) {
                    instance = new LoginAPI();
                }
            }
        }
        return instance;
    }

    public Subscription doLogin(String username, String password, Subscriber<LoginResponse> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(LoginContractRequest.class).doLogin(username, password);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
