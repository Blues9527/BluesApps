package com.example.lanhuajian.blues.application;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.lanhuajian.blues.database.course.CourseManger;
import com.example.lanhuajian.blues.framework.utils.ThreadManager;
import com.example.lanhuajian.blues.framework.utils.Utils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


/**
 * User : Blues
 * Date : 2019/3/6
 * Email : huajianlan@rastar.com
 */

public class BluesApplication extends MultiDexApplication {

    private RefWatcher refWatcher;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //当引入第三方jar包过多时，尽心dex分包处理
        MultiDex.install(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        refWatcher = setupLeakCanary();

        //初始化工具类
        Utils.init(this);

        //初始化数据库
        ThreadManager.getInstance().executeRunnable(() -> CourseManger.getInstance().initDataBase(getApplicationContext()));
    }

    private RefWatcher setupLeakCanary() {

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    //使用leak canary
    public static RefWatcher getRefWatcher(Context context) {
        BluesApplication application = (BluesApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}
