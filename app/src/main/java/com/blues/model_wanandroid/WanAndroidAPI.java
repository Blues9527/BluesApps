package com.blues.model_wanandroid;

import com.blues.framework.http.RetrofitManager;
import com.blues.framework.utils.RxUtil;
import com.blues.model_wanandroid.netease.CategoryCourseEntity;
import com.blues.model_wanandroid.netease.CategoryEntity;
import com.blues.model_wanandroid.netease.MicroSpecEntity;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * @author lanhuajian
 * create at 2020/4/4 21:47
 */

public class WanAndroidAPI {

    private static volatile WanAndroidAPI instance;

    private WanAndroidAPI() {
    }

    public static WanAndroidAPI getInstance(String url) {
        RetrofitManager.setBaseUrl(url);
        if (null == instance) {
            synchronized (WanAndroidAPI.class) {
                if (null == instance) {
                    instance = new WanAndroidAPI();
                }
            }
        }
        return instance;
    }

    //获取帖子列表
    public Subscription getPostList(int page, Subscriber<WanAndroidEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(WanAndroidContractReq.class).getPostList(page);
        return RxUtil.setSubscribe(observable, subscriber);
    }

    public Subscription getBanner(Subscriber<WanAndroidBannerEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(WanAndroidContractReq.class).getBanner();
        return RxUtil.setSubscribe(observable, subscriber);
    }

    public Subscription getMicroSpec(Subscriber<MicroSpecEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(WanAndroidContractReq.class).getMicroSpec();
        return RxUtil.setSubscribe(observable, subscriber);
    }

    public Subscription getCategory(String id, Subscriber<CategoryEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(WanAndroidContractReq.class).getCategory(id);
        return RxUtil.setSubscribe(observable, subscriber);
    }

    public Subscription getCategoryCourse(int activityId,
                                          int priceType,
                                          int orderType,
                                          String categoryId,
                                          int pageIndex,
                                          int pageSize, Subscriber<CategoryCourseEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(WanAndroidContractReq.class).getCategoryCourse(activityId, priceType, orderType, categoryId, pageIndex, pageSize);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
