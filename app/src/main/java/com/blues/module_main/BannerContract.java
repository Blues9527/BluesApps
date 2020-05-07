package com.blues.module_main;

import com.blues.framework.base.BasePresenter;
import com.blues.framework.base.BaseView;
import com.blues.framework.http.HttpCallBack;
import com.blues.model_wanandroid.WanAndroidBannerEntity;

import rx.Subscription;

/**
 * @author lanhuajian
 * create at 2020/5/4 21:58
 */
public interface BannerContract {

    interface iBannerView extends BaseView<iBannerPresenter> {

        void showRequestError(String msg);

        void onBannerReqSuccess(WanAndroidBannerEntity banner);

        void onBannerReqFailure(String result);
    }

    interface iBannerPresenter extends BasePresenter {
        void getBanner();
    }

    interface iBannerModel {
        Subscription getBanner(HttpCallBack<WanAndroidBannerEntity> callBack);
    }
}
