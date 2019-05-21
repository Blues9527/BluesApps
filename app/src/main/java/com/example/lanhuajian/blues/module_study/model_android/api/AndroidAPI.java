package com.example.lanhuajian.blues.module_study.model_android.api;

import com.example.lanhuajian.blues.framework.http.RetrofitManager;
import com.example.lanhuajian.blues.framework.utils.RxUtil;
import com.example.lanhuajian.blues.constant.RequestUrl;
import com.example.lanhuajian.blues.module_study.model_android.model.AndroidEntity;
import com.example.lanhuajian.blues.module_study.model_android.request.AndroidContractRequest;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class AndroidAPI {

    private static volatile AndroidAPI instance;

    private AndroidAPI() {
    }

    public static AndroidAPI getInstance() {
        RetrofitManager.setBaseUrl(RequestUrl.BASE_URL);
        if (null == instance) {
            synchronized (AndroidAPI.class) {
                if (null == instance) {
                    instance = new AndroidAPI();
                }
            }
        }
        return instance;
    }

    public Subscription getData(int limit, int page, Subscriber<AndroidEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(AndroidContractRequest.class).getData(limit, page);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
