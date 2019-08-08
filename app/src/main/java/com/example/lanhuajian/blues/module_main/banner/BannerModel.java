package com.example.lanhuajian.blues.module_main.banner;

import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.framework.http.HttpResponse;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:25
 */

public class BannerModel implements BannerContract.iBannerContractModel {

    @Override
    public Subscription getBanner(HttpCallBack<BannerEntity> callBack) {
        return BannerAPI.getInstance().getBanner(new Subscriber<BannerEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(BannerEntity bannerEntity) {
                callBack.onSuccess(bannerEntity);
            }
        });
    }
}
