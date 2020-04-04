package com.blues.model_wanandroid;

import com.blues.constant.RequestUrl;
import com.blues.framework.http.HttpCallBack;
import com.blues.model_wanandroid.netease.CategoryCourseEntity;
import com.blues.model_wanandroid.netease.CategoryEntity;
import com.blues.model_wanandroid.netease.MicroSpecEntity;

import rx.Subscriber;
import rx.Subscription;

/**
 * @author lanhuajian
 * create at 2020/4/4 21:46
 */

public class WanAndroidModel implements WanAndroidContract.iWanAndroidModel {

    @Override
    public Subscription getWanAndroidPostList(int page, HttpCallBack<WanAndroidEntity> callBack) {
        return WanAndroidAPI.getInstance(RequestUrl.BASE_WANANDROID_URL).getPostList(page, new Subscriber<WanAndroidEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(WanAndroidEntity wanAndroidEntity) {
                callBack.onSuccess(wanAndroidEntity);
            }
        });
    }

    @Override
    public Subscription getBanner(HttpCallBack<WanAndroidBannerEntity> callBack) {
        return WanAndroidAPI.getInstance(RequestUrl.BASE_WANANDROID_URL).getBanner(new Subscriber<WanAndroidBannerEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(WanAndroidBannerEntity bannerEntity) {
                callBack.onSuccess(bannerEntity);
            }
        });
    }

    @Override
    public Subscription getMicroSpec(HttpCallBack<MicroSpecEntity> callBack) {
        return WanAndroidAPI.getInstance(RequestUrl.BASE_NETEASE_URL).getMicroSpec(new Subscriber<MicroSpecEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(MicroSpecEntity microSpecEntity) {
                callBack.onSuccess(microSpecEntity);
            }
        });
    }

    @Override
    public Subscription getCategory(String id, HttpCallBack<CategoryEntity> callBack) {
        return WanAndroidAPI.getInstance(RequestUrl.BASE_NETEASE_URL).getCategory(id, new Subscriber<CategoryEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(CategoryEntity categoryEntity) {
                callBack.onSuccess(categoryEntity);
            }
        });
    }

    @Override
    public Subscription getCategoryCourse(int activityId, int priceType, int orderType, String categoryId, int pageIndex, int pageSize, HttpCallBack<CategoryCourseEntity> callBack) {
        return WanAndroidAPI.getInstance(RequestUrl.BASE_NETEASE_URL).getCategoryCourse(activityId, priceType, orderType, categoryId, pageIndex, pageSize, new Subscriber<CategoryCourseEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(CategoryCourseEntity categoryCourseEntity) {
                callBack.onSuccess(categoryCourseEntity);
            }
        });
    }
}
