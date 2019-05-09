package com.example.lanhuajian.blues.module_login.manager;

import com.example.framework.http.HttpResponse;
import com.example.framework.http.RetrofitManager;
import com.example.framework.utils.RxUtil;
import com.example.lanhuajian.blues.constant.RequestUrl;
import com.example.lanhuajian.blues.module_study.model_android.api.AndroidAPI;

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
        RetrofitManager.setBaseUrl(RequestUrl.BASE_LOCAL_URL);
        if (null == instance) {
            synchronized (AndroidAPI.class) {
                if (null == instance) {
                    instance = new LoginAPI();
                }
            }
        }
        return instance;
    }

    public Subscription doLogin(String username, String password, Subscriber<HttpResponse> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(LoginContractRequest.class).doLogin(username, password);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
