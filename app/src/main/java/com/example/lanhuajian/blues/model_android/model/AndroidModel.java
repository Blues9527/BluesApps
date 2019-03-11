package com.example.lanhuajian.blues.model_android.model;

import com.example.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.model_android.api.AndroidAPI;
import com.example.lanhuajian.blues.model_android.contract.AndroidContract;

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
