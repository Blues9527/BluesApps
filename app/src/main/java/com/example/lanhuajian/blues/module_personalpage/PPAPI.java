package com.example.lanhuajian.blues.module_personalpage;

import com.example.lanhuajian.blues.constant.RequestUrl;
import com.example.lanhuajian.blues.framework.http.RetrofitManager;
import com.example.lanhuajian.blues.framework.utils.RxUtil;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:04
 */

public class PPAPI {

    private static volatile PPAPI instance;

    private PPAPI() {
    }

    public static PPAPI getInstance() {
        RetrofitManager.setBaseUrl(RequestUrl.BASE_MOCK_URL);
        if (null == instance) {
            synchronized (PPAPI.class) {
                if (null == instance) {
                    instance = new PPAPI();
                }
            }
        }
        return instance;
    }

    public Subscription getUserInfo(Subscriber<UserInfoEntity> subscriber) {

        Observable observable = RetrofitManager.getInstance().create(UserInfoContractReq.class).getUserInfo();

        return RxUtil.setSubscribe(observable, subscriber);
    }
}
