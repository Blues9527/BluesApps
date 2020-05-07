package com.blues.module_main;

import com.blues.framework.base.BaseView;
import com.blues.framework.base.RxPresenter;
import com.blues.framework.http.HttpCallBack;
import com.blues.model_wanandroid.WanAndroidBannerEntity;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:08
 */

public class BannerPresenter extends RxPresenter implements BannerContract.iBannerPresenter {

    private BannerContract.iBannerModel iModel;
    private BannerContract.iBannerView iView;

    public BannerPresenter(BaseView mView) {
        super(mView);
        iView = (BannerContract.iBannerView) mView;
        iModel = new BannerModel();
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
}
