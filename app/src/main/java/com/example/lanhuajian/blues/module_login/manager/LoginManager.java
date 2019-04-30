package com.example.lanhuajian.blues.module_login.manager;

import android.text.TextUtils;

/**
 * User : Blues
 * Date : 2019/4/30
 * Time : 16:20
 */

public class LoginManager {

    private LoginCallBack mLoginCallBack;

    private static class LoginHolder {
        private static LoginManager INSTANCE = new LoginManager();
    }

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        return LoginHolder.INSTANCE;
    }

    private boolean checkNotNull(String... strings) {
        for (String str : strings) {
            if (TextUtils.isEmpty(str)) {
                mLoginCallBack.onFailure("参数不能为空");
                return false;
            }
        }
        return true;

    }

    public void login(String account, String password, LoginCallBack mLoginCallBack) {
        this.mLoginCallBack = mLoginCallBack;
        if (checkNotNull(account, password))
            if ("blues".equals(account) && password.equals("000000"))
                mLoginCallBack.onSuccess();
            else
                mLoginCallBack.onFailure("账号或密码错误");
    }


    public interface LoginCallBack {
        void onSuccess();

        void onFailure(String msg);
    }
}
