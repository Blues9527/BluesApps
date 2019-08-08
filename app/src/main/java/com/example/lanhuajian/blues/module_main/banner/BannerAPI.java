package com.example.lanhuajian.blues.module_main.banner;

import com.example.lanhuajian.blues.constant.RequestUrl;
import com.example.lanhuajian.blues.framework.http.HttpResponse;
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

    public static BannerAPI getInstance() {
        RetrofitManager.setBaseUrl(RequestUrl.BASE_WANANDROID_URL);
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
}
