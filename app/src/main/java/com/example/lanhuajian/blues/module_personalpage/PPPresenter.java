package com.example.lanhuajian.blues.module_personalpage;

import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.base.RxPresenter;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:08
 */

public class PPPresenter extends RxPresenter implements UserInfoContract.iUserInfoPresenter {

    private UserInfoContract.iUserInfoModel iModel;
    private UserInfoContract.iUserInfoView iView;

    public PPPresenter(BaseView mView) {
        super(mView);
        iView = (UserInfoContract.iUserInfoView) mView;
        iModel = new PPModel();
    }

    @Override
    public void getUserInfo() {
        subscribe(iModel.getUserInfo(new HttpCallBack<UserInfoEntity>() {
            @Override
            public void onSuccess(UserInfoEntity data) {
                iView.showUerInfo(data.getData());
            }

            @Override
            public void onFailure(String error) {
                iView.showError(error);
            }
        }));
    }
}
