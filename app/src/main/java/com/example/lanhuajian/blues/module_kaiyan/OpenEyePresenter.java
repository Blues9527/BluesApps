package com.example.lanhuajian.blues.module_kaiyan;

import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.base.RxPresenter;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;

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
        subscribe(iModel.getRankList(new HttpCallBack<OpenEyeEntity>() {
            @Override
            public void onSuccess(OpenEyeEntity data) {
                iView.showRankList(data.getItemList());
            }

            @Override
            public void onFailure(String error) {
                iView.showRequestError(error);
            }
        }));
    }

    @Override
    public void getRankList(String strategy) {
        subscribe(iModel.getRankList(strategy, new HttpCallBack<OpenEyeEntity>() {
            @Override
            public void onSuccess(OpenEyeEntity data) {
                iView.showRankList(data.getItemList());
            }

            @Override
            public void onFailure(String error) {
                iView.showRequestError(error);
            }
        }));
    }

    @Override
    public void getSearchResult(String query) {
        subscribe(iModel.getSearchResult(query, new HttpCallBack<OpenEyeEntity>() {
            @Override
            public void onSuccess(OpenEyeEntity data) {
                iView.showSearchResult(data.getItemList());
            }

            @Override
            public void onFailure(String error) {
                iView.showRequestError(error);
            }
        }));
    }

    @Override
    public void getHotSearch() {
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
    }
}
