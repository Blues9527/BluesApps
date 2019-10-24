package com.example.lanhuajian.blues.module_main.banner;

import com.example.lanhuajian.blues.constant.RequestUrl;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.framework.http.HttpResponse;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:25
 */

public class BannerModel implements BannerContract.iBannerContractModel {

    @Override
    public Subscription getBanner(HttpCallBack<BannerEntity> callBack) {
        return BannerAPI.getInstance(RequestUrl.BASE_WANANDROID_URL).getBanner(new Subscriber<BannerEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(BannerEntity bannerEntity) {
                callBack.onSuccess(bannerEntity);
            }
        });
    }

    @Override
    public Subscription getMicroSpec(HttpCallBack<MicroSpecEntity> callBack) {
        return BannerAPI.getInstance(RequestUrl.BASE_NETEASE_URL).getMicroSpec(new Subscriber<MicroSpecEntity>() {
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
        return BannerAPI.getInstance(RequestUrl.BASE_NETEASE_URL).getCategory(id, new Subscriber<CategoryEntity>() {
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
        return BannerAPI.getInstance(RequestUrl.BASE_NETEASE_URL).getCategoryCourse(activityId, priceType, orderType, categoryId, pageIndex, pageSize, new Subscriber<CategoryCourseEntity>() {
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
