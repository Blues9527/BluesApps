package com.example.lanhuajian.blues.module_kaiyan.detail;

import com.example.lanhuajian.blues.framework.base.BasePresenter;
import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeEntity;

import java.util.List;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:01
 */

public interface OEDetailRelatedContract {

    interface iOEDetailRelatedView extends BaseView<iOEDetailRelatedPresenter> {

        void showRelatedVideos(List<OEDetailRelatedEntity.ItemListBean> openEyeRelatedList);
    }

    interface iOEDetailRelatedPresenter extends BasePresenter {

        void getRelatedVideos(String relatedId);

    }

    interface iOEDetailRelatedModel {
        Subscription getRelatedVideos(String relatedId, HttpCallBack<OEDetailRelatedEntity> callBack);
    }
}
