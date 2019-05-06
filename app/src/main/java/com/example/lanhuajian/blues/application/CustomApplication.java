package com.example.lanhuajian.blues.application;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.framework.utils.Utils;


/**
 * User : Blues
 * Date : 2019/3/6
 * Email : huajianlan@rastar.com
 */

public class CustomApplication extends MultiDexApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化工具类
        Utils.init(this);
    }
}
