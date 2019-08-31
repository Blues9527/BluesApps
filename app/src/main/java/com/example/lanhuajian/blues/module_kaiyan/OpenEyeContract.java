package com.example.lanhuajian.blues.module_kaiyan;

import com.example.lanhuajian.blues.framework.base.BasePresenter;
import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;

import java.util.List;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:01
 */

public interface OpenEyeContract {

    interface iOpenEyeView extends BaseView<iOpenEyePresenter> {

        void showRankList(List<OpenEyeEntity.ItemListBean> openEyeList);

        void showRequestError(String msg);

        void showHotSearch(List<String> searches);

        void showSearchResult(List<OpenEyeEntity.ItemListBean> openEyeList);
    }

    interface iOpenEyePresenter extends BasePresenter {

        void getRankList();

        void getRankList(String strategy);

        void getSearchResult(String query);

        void getHotSearch();
    }

    interface iOpenEyeModel {
        Subscription getRankList(HttpCallBack<OpenEyeEntity> callBack);

        Subscription getRankList(String strategy, HttpCallBack<OpenEyeEntity> callBack);

        Subscription getSearchResult(String query, HttpCallBack<OpenEyeEntity> callBack);

        Subscription getHotSearch(HttpCallBack<List<String>> callBack);
    }
}
