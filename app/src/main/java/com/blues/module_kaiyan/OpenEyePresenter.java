package com.blues.module_kaiyan;

import com.blues.framework.base.BaseView;
import com.blues.framework.base.RxPresenter;
import com.blues.framework.http.HttpCallBack;

import java.util.List;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:08
 */

public class OpenEyePresenter extends RxPresenter implements OpenEyeContract.iOpenEyePresenter {

    private OpenEyeContract.iOpenEyeModel iModel;
    private OpenEyeContract.iOpenEyeView iView;

    public OpenEyePresenter(BaseView mView) {
        super(mView);
        iView = (OpenEyeContract.iOpenEyeView) mView;
        iModel = new OpenEyeModel();
    }

    @Override
    public void getRankList() {
        iView.showBegin();
        iView.showLoading();
        subscribe(iModel.getRankList(new HttpCallBack<OpenEyeEntity>() {
            @Override
            public void onSuccess(OpenEyeEntity data) {
                if (data != null) {
                    iView.showRankList(data.getItemList());
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showRequestError(error);
            }
        }));
        iView.showFinished();
    }

    @Override
    public void getRankList(String strategy) {
        iView.showBegin();
        iView.showLoading();
        subscribe(iModel.getRankList(strategy, new HttpCallBack<OpenEyeEntity>() {
            @Override
            public void onSuccess(OpenEyeEntity data) {
                if (data != null) {
                    iView.showRankList(data.getItemList());
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showRequestError(error);

            }
        }));
        iView.showFinished();
    }

    @Override
    public void getSearchResult(String query) {
        iView.showBegin();
        iView.showLoading();
        subscribe(iModel.getSearchResult(query, new HttpCallBack<OpenEyeEntity>() {
            @Override
            public void onSuccess(OpenEyeEntity data) {
                if (data != null) {
                    iView.showSearchResult(data.getItemList());
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showRequestError(error);
            }
        }));
        iView.showFinished();
    }

    @Override
    public void getHotSearch() {
        iView.showBegin();
        iView.showLoading();
        subscribe(iModel.getHotSearch(new HttpCallBack<List<String>>() {
            @Override
            public void onSuccess(List<String> searches) {
                iView.showHotSearch(searches);
            }

            @Override
            public void onFailure(String error) {
                iView.showRequestError(error);
            }
        }));
        iView.showFinished();
    }
}
