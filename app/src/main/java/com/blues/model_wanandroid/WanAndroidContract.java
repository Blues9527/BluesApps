package com.blues.model_wanandroid;

import com.blues.framework.base.BasePresenter;
import com.blues.framework.base.BaseView;
import com.blues.framework.http.HttpCallBack;
import com.blues.model_wanandroid.netease.CategoryCourseEntity;
import com.blues.model_wanandroid.netease.CategoryEntity;
import com.blues.model_wanandroid.netease.MicroSpecEntity;

import java.util.List;

import rx.Subscription;

/**
 * @author lanhuajian
 * create at 2020/4/4 21:46
 */

public interface WanAndroidContract {

    interface iWanAndroidView extends BaseView<iWanAndroidPresenter> {

        void showWanAndroidPostList(List<WanAndroidEntity.DataBean.DatasBean> wanAndroidList);

        void showRequestError(String msg);

        void onBannerReqSuccess(WanAndroidBannerEntity banner);

        void onBannerReqFailure(String result);

        void onFetchMicroSuccess(MicroSpecEntity microSpec);

        void onFetchMicroFailed(String msg);

        void onFetchCategorySuccess(CategoryEntity category);

        void onFetchCategoryFailed(String msg);

        void onFetchCategoryCourseSuccess(CategoryCourseEntity categoryCourse);

        void onFetchCategoryCourseFailed(String msg);
    }

    interface iWanAndroidPresenter extends BasePresenter {

        void initData();

        void onLoadMore();

        void getWanAndroidPostList(int page);

        void getBanner();

        void getMicroSpec();

        void getCategory(String id);

        void getCategoryCourse(int pageIndex);
    }

    interface iWanAndroidModel {
        Subscription getWanAndroidPostList(int page, HttpCallBack<WanAndroidEntity> callBack);

        Subscription getBanner(HttpCallBack<WanAndroidBannerEntity> callBack);

        Subscription getMicroSpec(HttpCallBack<MicroSpecEntity> callBack);

        Subscription getCategory(String id, HttpCallBack<CategoryEntity> callBack);

        Subscription getCategoryCourse(int activityId,
                                       int priceType,
                                       int orderType,
                                       String categoryId,
                                       int pageIndex,
                                       int pageSize, HttpCallBack<CategoryCourseEntity> callBack);

    }
}
