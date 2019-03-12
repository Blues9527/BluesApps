package com.example.lanhuajian.blues.model_web.model;

import com.example.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.model_web.api.WebAPI;
import com.example.lanhuajian.blues.model_web.contract.WebContract;

import rx.Subscriber;
import rx.Subscription;

public class WebModel implements WebContract.iContractModel {

    @Override
    public Subscription getData(int limit, int page, HttpCallBack<WebEntity> callBack) {
        return WebAPI.getInstance().getData(limit, page, new Subscriber<WebEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(WebEntity iosEntity) {
                callBack.onSuccess(iosEntity);
            }
        });
    }
}
