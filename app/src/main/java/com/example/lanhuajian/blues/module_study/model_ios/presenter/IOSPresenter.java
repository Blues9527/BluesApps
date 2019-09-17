package com.example.lanhuajian.blues.module_study.model_ios.presenter;

import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.base.RxPresenter;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.module_study.model_ios.IOSContract;
import com.example.lanhuajian.blues.module_study.model_ios.model.IOSEntity;
import com.example.lanhuajian.blues.module_study.model_ios.model.IOSModel;

public class IOSPresenter extends RxPresenter implements IOSContract.iContractPresenter {

    private IOSContract.iContractModel iModel;
    private IOSContract.iContractView iView;

    private static final int LIMIT = 10;
    private int mCurrentPage = 1;

    public IOSPresenter(BaseView iView) {
        super(iView);
        this.iView = (IOSContract.iContractView) iView;
        iModel = new IOSModel();
    }

    @Override
    public void initData() {
        getData(LIMIT, mCurrentPage = 1);
    }

    @Override
    public void loadMore() {
        getData(LIMIT, ++mCurrentPage);
    }

    @Override
    public void getData(int limit, int page) {
        iView.showBegin();
        iView.showLoading();
        subscribe(iModel.getData(limit, page, new HttpCallBack<IOSEntity>() {
            @Override
            public void onSuccess(IOSEntity data) {
                if (data != null) {
                    iView.setData(data.getResults());
                } else {
                    iView.showEmpty();
                }
                iView.showFinished();
            }

            @Override
            public void onFailure(String error) {
                iView.showError();
                iView.showFinished();
            }
        }));
    }
}
