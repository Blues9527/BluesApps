package com.blues.module_study.model_android.model;

import com.blues.framework.http.HttpCallBack;
import com.blues.module_study.model_android.AndroidAPI;
import com.blues.module_study.model_android.AndroidContract;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class AndroidModel implements AndroidContract.iContractModel {

    @Override
    public Subscription getData(int limit, int page, final HttpCallBack<AndroidEntity> callBack) {
        return AndroidAPI.getInstance().getData(limit, page, new Subscriber<AndroidEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(AndroidEntity entity) {
                callBack.onSuccess(entity);
            }
        });
    }
}
