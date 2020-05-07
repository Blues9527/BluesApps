package com.blues.module_main;

import com.blues.constant.RequestUrl;
import com.blues.framework.http.HttpCallBack;
import com.blues.model_wanandroid.WanAndroidBannerEntity;

import rx.Subscriber;
import rx.Subscription;

/**
 * @author lanhuajian
 * create at 2020/4/4 21:46
 */

public class BannerModel implements BannerContract.iBannerModel {

    @Override
    public Subscription getBanner(HttpCallBack<WanAndroidBannerEntity> callBack) {
        return BannerAPI.getInstance(RequestUrl.BASE_WANANDROID_URL).getBanner(new Subscriber<WanAndroidBannerEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(WanAndroidBannerEntity bannerEntity) {
                callBack.onSuccess(bannerEntity);
            }
        });
    }
}
