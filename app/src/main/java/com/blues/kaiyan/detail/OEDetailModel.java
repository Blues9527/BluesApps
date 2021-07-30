package com.blues.kaiyan.detail;

import com.blues.framework.http.HttpCallBack;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:08
 */

public class OEDetailModel implements OEDetailRelatedContract.iOEDetailRelatedModel {

    @Override
    public Subscription getRelatedVideos(String relatedId, HttpCallBack<OEDetailRelatedEntity> callBack) {
        return OEDetailAPI.getInstance().getRelatedVideos(relatedId, new Subscriber<OEDetailRelatedEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(OEDetailRelatedEntity oeDetailRelatedEntity) {
                callBack.onSuccess(oeDetailRelatedEntity);
            }
        });
    }
}
