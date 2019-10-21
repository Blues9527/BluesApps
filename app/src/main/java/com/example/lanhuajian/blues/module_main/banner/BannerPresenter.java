package com.example.lanhuajian.blues.module_main.banner;

import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.base.RxPresenter;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.framework.http.HttpResponse;

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
}
