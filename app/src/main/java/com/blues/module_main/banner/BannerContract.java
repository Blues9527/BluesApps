package com.blues.module_main.banner;

import com.blues.framework.base.BasePresenter;
import com.blues.framework.base.BaseView;
import com.blues.framework.http.HttpCallBack;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:17
 */

public interface BannerContract {
    interface iBannerContractView extends BaseView<iBannerContractPresenter> {

        void onSuccess(BannerEntity banner);

        void onFailure(String result);

        void onFetchMicroSuccess(MicroSpecEntity microSpec);

        void onFetchMicroFailed(String msg);

        void onFetchCategorySuccess(CategoryEntity category);

        void onFetchCategoryFailed(String msg);

        void onFetchCategoryCourseSuccess(CategoryCourseEntity categoryCourse);

        void onFetchCategoryCourseFailed(String msg);
    }

    interface iBannerContractPresenter extends BasePresenter {

        void getBanner();

        void getMicroSpec();

        void getCategory(String id);

        void getCategoryCourse(int pageIndex);
    }

    interface iBannerContractModel {

        Subscription getBanner(HttpCallBack<BannerEntity> callBack);

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
