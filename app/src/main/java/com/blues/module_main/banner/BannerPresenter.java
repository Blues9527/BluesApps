package com.blues.module_main.banner;

import com.blues.framework.base.BaseView;
import com.blues.framework.base.RxPresenter;
import com.blues.framework.http.HttpCallBack;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:25
 */

public class BannerPresenter extends RxPresenter implements BannerContract.iBannerContractPresenter {

    private BannerContract.iBannerContractView iView;
    private BannerContract.iBannerContractModel iModel;

    public BannerPresenter(BaseView mView) {
        super(mView);
        iView = (BannerContract.iBannerContractView) mView;
        iModel = new BannerModel();
    }

    @Override
    public void getBanner() {
        subscribe(iModel.getBanner(new HttpCallBack<BannerEntity>() {

            @Override
            public void onSuccess(BannerEntity data) {
                iView.onSuccess(data);
            }

            @Override
            public void onFailure(String error) {
                iView.onFailure(error);
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
    public void getCategoryCourse( int pageIndex) {
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
