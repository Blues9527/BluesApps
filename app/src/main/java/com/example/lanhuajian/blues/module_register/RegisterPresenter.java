package com.example.lanhuajian.blues.module_register;

import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.base.RxPresenter;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:25
 */

public class RegisterPresenter extends RxPresenter implements RegisterContract.iRegisterContractPresenter {

    private RegisterContract.iRegisterContractView iView;
    private RegisterContract.iRegisterContractModel iModel;

    public RegisterPresenter(BaseView mView) {
        super(mView);
        iView = (RegisterContract.iRegisterContractView) mView;
        iModel = new RegisterModel();
    }


    @Override
    public void doRegister(String username, String password, String repassword) {
        subscribe(iModel.doRegister(username, password, repassword, new HttpCallBack<RegisterResponse>() {
            @Override
            public void onSuccess(RegisterResponse data) {
                if (data.getErrorCode() == 0) {
                    iView.onSuccess(data);
                } else {
                    iView.onFailure(data.getErrorMsg());
                }
            }

            @Override
            public void onFailure(String error) {

            }
        }));
    }
}
