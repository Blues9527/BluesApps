package com.blues.module_study.model_web;

import com.blues.framework.base.BasePresenter;
import com.blues.framework.base.BaseView;
import com.blues.framework.http.HttpCallBack;
import com.blues.module_study.model_web.model.WebEntity;

import java.util.List;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/11
 * Email : huajianlan@rastar.com
 */

public interface WebContract {
    interface iContractView extends BaseView<iContractPresenter> {

        void setData(List<WebEntity.ResultsBean> result);

    }

    interface iContractPresenter extends BasePresenter {

        void initData();

        void loadMore();

        void getData(int limit, int page);

    }

    interface iContractModel {

        Subscription getData(int limit, int page, HttpCallBack<WebEntity> callBack);

    }
}
