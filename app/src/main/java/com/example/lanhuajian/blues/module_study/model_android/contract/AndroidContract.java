package com.example.lanhuajian.blues.module_study.model_android.contract;

import com.example.lanhuajian.blues.framework.base.BasePresenter;
import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.module_study.model_android.model.AndroidEntity;


import java.util.List;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public interface AndroidContract {
    interface iContractView extends BaseView<iContractPresenter> {

        void setData(List<AndroidEntity.ResultsBean> result);

    }

    interface iContractPresenter extends BasePresenter {

        void initData();

        void loadMore();

        void getData(int limit, int page);

    }

    interface iContractModel {

        Subscription getData(int limit, int page, HttpCallBack<AndroidEntity> callBack);

    }
}
