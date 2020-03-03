package com.blues.module_study.model_fuli;

import com.blues.framework.base.BasePresenter;
import com.blues.framework.base.BaseView;
import com.blues.framework.http.HttpCallBack;
import com.blues.module_study.model_fuli.model.FuliEntity;

import java.util.List;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/11
 * Email : huajianlan@rastar.com
 */

public interface FuliContract {
    interface iContractView extends BaseView<iContractPresenter> {

        void setData(List<FuliEntity.ResultsBean> result);

    }

    interface iContractPresenter extends BasePresenter {

        void initData();

        void loadMore();

        void getData(int limit, int page);

    }

    interface iContractModel {

        Subscription getData(int limit, int page, HttpCallBack<FuliEntity> callBack);

    }
}
