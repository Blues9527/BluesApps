package com.example.lanhuajian.blues.module_study.model_fuli.presenter;

import com.example.framework.base.BaseView;
import com.example.framework.base.RxPresenter;
import com.example.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.module_study.model_fuli.contract.FuliContract;
import com.example.lanhuajian.blues.module_study.model_fuli.model.FuliEntity;
import com.example.lanhuajian.blues.module_study.model_fuli.model.FuliModel;

public class FuliPresenter extends RxPresenter implements FuliContract.iContractPresenter {

    private FuliContract.iContractModel mModel;
    private FuliContract.iContractView mView;

    private static final int LIMIT = 10;
    private int mCurrentPage = 1;

    public FuliPresenter(BaseView mView) {
        super(mView);
        this.mView = (FuliContract.iContractView) mView;
        mModel = new FuliModel();
    }

    @Override
    public void initData() {
        getData(LIMIT, mCurrentPage = 1);
    }

    @Override
    public void loadMore() {
        getData(LIMIT, mCurrentPage++);
    }

    @Override
    public void getData(int limit, int page) {
        subscribe(mModel.getData(limit, page, new HttpCallBack<FuliEntity>() {
            @Override
            public void onSuccess(FuliEntity data) {
                mView.setData(data.getResults());
            }

            @Override
            public void onFailure(String error) {
            }
        }));
    }
}
