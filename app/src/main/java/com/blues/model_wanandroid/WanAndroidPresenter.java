package com.blues.model_wanandroid;

import com.blues.framework.base.BaseView;
import com.blues.framework.base.RxPresenter;
import com.blues.framework.http.HttpCallBack;
import com.blues.model_wanandroid.netease.CategoryCourseEntity;
import com.blues.model_wanandroid.netease.CategoryEntity;
import com.blues.model_wanandroid.netease.MicroSpecEntity;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:08
 */

public class WanAndroidPresenter extends RxPresenter implements WanAndroidContract.iWanAndroidPresenter {

    private WanAndroidContract.iWanAndroidModel iModel;
    private WanAndroidContract.iWanAndroidView iView;
    private static int mCurrentPage;

    public WanAndroidPresenter(BaseView mView) {
        super(mView);
        iView = (WanAndroidContract.iWanAndroidView) mView;
        iModel = new WanAndroidModel();
    }

    @Override
    public void initData() {
        getBanner();
        getWanAndroidPostList(mCurrentPage = 0);
    }

    @Override
    public void onLoadMore() {
        getWanAndroidPostList(mCurrentPage++);
    }

    @Override
    public void getWanAndroidPostList(int page) {
        subscribe(iModel.getWanAndroidPostList(page, new HttpCallBack<WanAndroidEntity>() {
            @Override
            public void onSuccess(WanAndroidEntity data) {
                if (data != null) {
                    iView.showWanAndroidPostList(data.getData().getDatas());
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showRequestError(error);
            }
        }));
    }

    @Override
    public void getBanner() {
        subscribe(iModel.getBanner(new HttpCallBack<WanAndroidBannerEntity>() {

            @Override
            public void onSuccess(WanAndroidBannerEntity data) {
                iView.onBannerReqSuccess(data);
            }

            @Override
            public void onFailure(String error) {
                iView.onBannerReqFailure(error);
            }
        }));
    }

    @Override
    public void getMicroSpec() {
        subscribe(iModel.getMicroSpec(new HttpCallBack<MicroSpecEntity>() {

            @Override
            public void onSuccess(MicroSpecEntity data) {
                iView.onFetchMicroSuccess(data);
            }

            @Override
            public void onFailure(String error) {
                iView.onFetchMicroFailed(error);
            }
        }));
    }

    @Override
    public void getCategory(String id) {
        subscribe(iModel.getCategory(id, new HttpCallBack<CategoryEntity>() {

            @Override
            public void onSuccess(CategoryEntity data) {
                iView.onFetchCategorySuccess(data);
            }

            @Override
            public void onFailure(String error) {
                iView.onFetchCategoryFailed(error);
            }
        }));
    }

    @Override
    public void getCategoryCourse(int pageIndex) {
        subscribe(iModel.getCategoryCourse(0, 0, 0, "480000003126038", pageIndex, 10, new HttpCallBack<CategoryCourseEntity>() {

            @Override
            public void onSuccess(CategoryCourseEntity data) {
                iView.onFetchCategoryCourseSuccess(data);
            }

            @Override
            public void onFailure(String error) {
                iView.onFetchCategoryCourseFailed(error);
            }
        }));
    }
}
