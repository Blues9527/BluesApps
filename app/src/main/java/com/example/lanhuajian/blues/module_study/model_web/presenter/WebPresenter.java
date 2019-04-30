package com.example.lanhuajian.blues.module_study.model_web.presenter;

import com.example.framework.base.BaseView;
import com.example.framework.base.RxPresenter;
import com.example.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.module_study.model_web.contract.WebContract;
import com.example.lanhuajian.blues.module_study.model_web.model.WebEntity;
import com.example.lanhuajian.blues.module_study.model_web.model.WebModel;

public class WebPresenter extends RxPresenter implements WebContract.iContractPresenter {

    private WebContract.iContractModel mModel;
    private WebContract.iContractView mView;

    private static final int LIMIT = 10;
    private int mCurrentPage = 1;

    public WebPresenter(BaseView mView) {
        super(mView);
        this.mView = (WebContract.iContractView) mView;
        mModel = new WebModel();
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
        subscribe(mModel.getData(limit, page, new HttpCallBack<WebEntity>() {
            @Override
            public void onSuccess(WebEntity data) {
                mView.setData(data.getResults());
            }

            @Override
            public void onFailure(String error) {
            }
        }));
    }
}
