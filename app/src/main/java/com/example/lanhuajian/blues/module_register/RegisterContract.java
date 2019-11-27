package com.example.lanhuajian.blues.module_register;

import com.example.lanhuajian.blues.framework.base.BasePresenter;
import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/11/26
 * Time : 15:51
 */

public interface RegisterContract {

    interface iRegisterContractView extends BaseView<iRegisterContractPresenter> {

        void onSuccess(RegisterResponse result);

        void onFailure(String result);

    }

    interface iRegisterContractPresenter extends BasePresenter {

        void doRegister(String username, String password, String repassword);

    }

    interface iRegisterContractModel {

        Subscription doRegister(String username, String password, String repassword, HttpCallBack<RegisterResponse> callBack);

    }
}
