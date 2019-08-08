package com.example.lanhuajian.blues.module_main.banner;

import com.example.lanhuajian.blues.framework.base.BasePresenter;
import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.framework.http.HttpResponse;

import java.util.List;

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

    }

    interface iBannerContractPresenter extends BasePresenter {

        void getBanner();

    }

    interface iBannerContractModel {

        Subscription getBanner(HttpCallBack<BannerEntity> callBack);

    }
}
