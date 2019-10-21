package com.example.lanhuajian.blues.module_main.banner;

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

public class BannerAPI {
    private static volatile BannerAPI instance;

    private BannerAPI() {
    }

    public static BannerAPI getInstance(String url) {
        RetrofitManager.setBaseUrl(url);
        if (null == instance) {
            synchronized (AndroidAPI.class) {
                if (null == instance) {
                    instance = new BannerAPI();
                }
            }
        }
        return instance;
    }


    public Subscription getBanner(Subscriber<BannerEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(BannerContractRequest.class).getBanner();
        return RxUtil.setSubscribe(observable, subscriber);
    }

    public Subscription getMicroSpec(Subscriber<MicroSpecEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(BannerContractRequest.class).getMicroSpec();
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
