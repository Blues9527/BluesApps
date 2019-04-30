package com.example.lanhuajian.blues.module_study.model_fuli.model;

import com.example.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.module_study.model_fuli.api.FuliAPI;
import com.example.lanhuajian.blues.module_study.model_fuli.contract.FuliContract;

import rx.Subscriber;
import rx.Subscription;

public class FuliModel implements FuliContract.iContractModel {

    @Override
    public Subscription getData(int limit, int page, HttpCallBack<FuliEntity> callBack) {
        return FuliAPI.getInstance().getData(limit, page, new Subscriber<FuliEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(FuliEntity iosEntity) {
                callBack.onSuccess(iosEntity);
            }
        });
    }
}