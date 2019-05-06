package com.example.lanhuajian.blues.module_login.manager;

import android.text.TextUtils;

/**
 * User : Blues
 * Date : 2019/4/30
 * Time : 16:20
 */

public class LoginManager {


    private LoginCallBack mLoginCallBack;

    //静态内部类单例
    private static class LoginHolder {
        private static LoginManager INSTANCE = new LoginManager();
    }

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        return LoginHolder.INSTANCE;
    }

    //客户端参数校验
    private boolean checkNotNull(String... strings) {
        for (String str : strings) {
            if (TextUtils.isEmpty(str)) {
                mLoginCallBack.onFailure("参数不能为空");
                return false;
            }
        }
        return true;

    }

    //登录校验
    public void login(String account, String password, LoginCallBack mLoginCallBack) {
        this.mLoginCallBack = mLoginCallBack;
        //模拟校验逻辑，正确应是请求后端让后端进行校验，返回json串
        if (checkNotNull(account, password))
            if ("blues".equals(account) && password.equals("000000"))
                mLoginCallBack.onSuccess();
            else
                mLoginCallBack.onFailure("账号或密码错误");
    }


    //登录回调
    public interface LoginCallBack {
        void onSuccess();

        void onFailure(String msg);
    }
}
