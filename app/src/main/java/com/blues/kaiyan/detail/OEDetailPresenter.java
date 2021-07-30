package com.blues.kaiyan.detail;

import com.blues.framework.base.BaseView;
import com.blues.framework.base.RxPresenter;
import com.blues.framework.http.HttpCallBack;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:08
 */

public class OEDetailPresenter extends RxPresenter implements OEDetailRelatedContract.iOEDetailRelatedPresenter {

    private OEDetailRelatedContract.iOEDetailRelatedModel iModel;
    private OEDetailRelatedContract.iOEDetailRelatedView iView;

    public OEDetailPresenter(BaseView mView) {
        super(mView);
        iView = (OEDetailRelatedContract.iOEDetailRelatedView) mView;
        iModel = new OEDetailModel();
    }

    @Override
    public void getRelatedVideos(String relatedId) {
        subscribe(iModel.getRelatedVideos(relatedId, new HttpCallBack<OEDetailRelatedEntity>() {
            @Override
            public void onSuccess(OEDetailRelatedEntity data) {
                iView.showRelatedVideos(data.getItemList());
            }

            @Override
            public void onFailure(String error) {
            }
        }));
    }
}
