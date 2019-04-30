package com.example.lanhuajian.blues.module_study.model_ios.contract;

import com.example.framework.base.BasePresenter;
import com.example.framework.base.BaseView;
import com.example.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.module_study.model_ios.model.IOSEntity;

import java.util.List;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/11
 * Email : huajianlan@rastar.com
 */

public interface IOSContract {
    interface iContractView extends BaseView<iContractPresenter> {

        void setData(List<IOSEntity.ResultsBean> result);

    }

    interface iContractPresenter extends BasePresenter {

        void initData();

        void loadMore();

        void getData(int limit, int page);

    }

    interface iContractModel {

        Subscription getData(int limit, int page, HttpCallBack<IOSEntity> callBack);

    }
}
