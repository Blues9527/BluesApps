package com.blues.module_gank.old.model_fuli.presenter;

import com.blues.framework.base.BaseView;
import com.blues.framework.base.RxPresenter;
import com.blues.framework.http.HttpCallBack;
import com.blues.module_gank.old.model_fuli.FuliContract;
import com.blues.module_gank.old.model_fuli.model.FuliEntity;
import com.blues.module_gank.old.model_fuli.model.FuliModel;

public class FuliPresenter extends RxPresenter implements FuliContract.iContractPresenter {

    private FuliContract.iContractModel mModel;
    private FuliContract.iContractView iView;

    private static final int LIMIT = 10;
    private int mCurrentPage = 1;

    public FuliPresenter(BaseView iView) {
        super(iView);
        this.iView = (FuliContract.iContractView) iView;
        mModel = new FuliModel();
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
        subscribe(mModel.getData(limit, page, new HttpCallBack<FuliEntity>() {
            @Override
            public void onSuccess(FuliEntity data) {
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
