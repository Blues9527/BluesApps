package com.example.lanhuajian.blues.module_study.model_web.presenter;

import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.base.RxPresenter;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.module_study.model_web.WebContract;
import com.example.lanhuajian.blues.module_study.model_web.model.WebEntity;
import com.example.lanhuajian.blues.module_study.model_web.model.WebModel;

public class WebPresenter extends RxPresenter implements WebContract.iContractPresenter {

    private WebContract.iContractModel iModel;
    private WebContract.iContractView iView;

    private static final int LIMIT = 10;
    private int mCurrentPage = 1;

    public WebPresenter(BaseView iView) {
        super(iView);
        this.iView = (WebContract.iContractView) iView;
        iModel = new WebModel();
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
        subscribe(iModel.getData(limit, page, new HttpCallBack<WebEntity>() {
            @Override
            public void onSuccess(WebEntity data) {
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
