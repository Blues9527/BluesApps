package com.example.lanhuajian.blues.application;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.lanhuajian.blues.framework.utils.Utils;


/**
 * User : Blues
 * Date : 2019/3/6
 * Email : huajianlan@rastar.com
 */

public class BluesApplication extends MultiDexApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //当引入第三方jar包过多时，尽心dex分包处理
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化工具类
        Utils.init(this);
    }
}
