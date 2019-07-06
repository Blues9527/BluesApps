package com.example.lanhuajian.blues.module_personalpage;

import android.util.Log;

import com.example.lanhuajian.blues.framework.http.HttpCallBack;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:08
 */

public class PPModel implements UserInfoContract.iUserInfoModel {
    @Override
    public Subscription getUserInfo(HttpCallBack<UserInfoEntity> callBack) {
        return PPAPI.getInstance().getUserInfo(new Subscriber<UserInfoEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(UserInfoEntity userInfoEntity) {
                callBack.onSuccess(userInfoEntity);
            }
        });
    }
}
