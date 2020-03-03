package com.blues.module_kaiyan;

import com.blues.framework.http.HttpCallBack;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:08
 */

public class OpenEyeModel implements OpenEyeContract.iOpenEyeModel {

    @Override
    public Subscription getRankList(HttpCallBack<OpenEyeEntity> callBack) {
        return OpenEyeAPI.getInstance().getRankList(new Subscriber<OpenEyeEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(OpenEyeEntity openEyeEntity) {
                callBack.onSuccess(openEyeEntity);
            }
        });
    }

    @Override
    public Subscription getRankList(String strategy, HttpCallBack<OpenEyeEntity> callBack) {
        return OpenEyeAPI.getInstance().getRankList(strategy, new Subscriber<OpenEyeEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(OpenEyeEntity openEyeEntity) {
                callBack.onSuccess(openEyeEntity);
            }
        });
    }

    @Override
    public Subscription getSearchResult(String query, HttpCallBack<OpenEyeEntity> callBack) {
        return OpenEyeAPI.getInstance().getSearchResult( query, new Subscriber<OpenEyeEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(OpenEyeEntity openEyeEntity) {
                callBack.onSuccess(openEyeEntity);
            }
        });
    }

    @Override
    public Subscription getHotSearch(HttpCallBack<List<String>> callBack) {
        return OpenEyeAPI.getInstance().getHotSearch(new Subscriber<List<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(List<String> strings) {
                callBack.onSuccess(strings);
            }
        });
    }
}
