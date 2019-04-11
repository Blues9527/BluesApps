package com.example.lanhuajian.blues.model_study.model_ios.model;

import com.example.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.model_study.model_ios.api.IOSAPI;
import com.example.lanhuajian.blues.model_study.model_ios.contract.IOSContract;

import rx.Subscriber;
import rx.Subscription;

public class IOSModel implements IOSContract.iContractModel {

    @Override
    public Subscription getData(int limit, int page, HttpCallBack<IOSEntity> callBack) {
        return IOSAPI.getInstance().getData(limit, page, new Subscriber<IOSEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(IOSEntity iosEntity) {
                callBack.onSuccess(iosEntity);
            }
        });
    }
}
