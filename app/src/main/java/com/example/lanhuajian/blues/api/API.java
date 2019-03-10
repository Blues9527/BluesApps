package com.example.lanhuajian.blues.api;

import com.example.framework.http.RetrofitManager;
import com.example.framework.utils.RxUtil;
import com.example.lanhuajian.blues.model.Entity;
import com.example.lanhuajian.blues.request.ContractRequest;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class API {

    private static volatile API instance;

    private API() {
    }

    public static API getInstance() {
        RetrofitManager.setBaseUrl("http://gank.io");
        if (null == instance) {
            synchronized (API.class) {
                if (null == instance) {
                    instance = new API();
                }
            }
        }
        return instance;
    }

    public Subscription getData(int limit, int page, Subscriber<Entity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(ContractRequest.class).getData(limit, page);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
