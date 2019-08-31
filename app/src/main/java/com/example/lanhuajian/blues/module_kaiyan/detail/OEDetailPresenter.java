package com.example.lanhuajian.blues.module_kaiyan.detail;

import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.base.RxPresenter;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeContract;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeEntity;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeModel;

import java.util.List;

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
