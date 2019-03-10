package com.example.lanhuajian.blues.model;

import com.example.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.api.API;
import com.example.lanhuajian.blues.contract.Contract;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class CModel implements Contract.iContractModel {

    @Override
    public Subscription getData(int limit, int page, final HttpCallBack<Entity> callBack) {
        return API.getInstance().getData(limit, page, new Subscriber<Entity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(Entity entity) {
                callBack.onSuccess(entity);
            }
        });
    }
}
