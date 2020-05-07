package com.blues.module_main;

import com.blues.framework.http.RetrofitManager;
import com.blues.framework.utils.RxUtil;
import com.blues.model_wanandroid.WanAndroidBannerEntity;
import com.blues.model_wanandroid.WanAndroidContractReq;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * @author lanhuajian
 * create at 2020/4/4 21:47
 */

public class BannerAPI {

    private static volatile BannerAPI instance;

    private BannerAPI() {
    }

    public static BannerAPI getInstance(String url) {
        RetrofitManager.setBaseUrl(url);
        if (null == instance) {
            synchronized (BannerAPI.class) {
                if (null == instance) {
                    instance = new BannerAPI();
                }
            }
        }
        return instance;
    }

    public Subscription getBanner(Subscriber<WanAndroidBannerEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(WanAndroidContractReq.class).getBanner();
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
