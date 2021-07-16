package com.blues.application;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;

import com.blues.framework.network.NetworkCallbackImpl;
import com.blues.framework.utils.ActivityManagerUtil;
import com.blues.framework.utils.Utils;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;


/**
 * User : Blues
 * Date : 2019/3/6
 * Email : huajianlan@rastar.com
 */

public class BluesApplication extends MultiDexApplication {

//    private RefWatcher refWatcher;

    private Context mActivity;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //当引入第三方jar包过多时，尽心dex分包处理
        MultiDex.install(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();

//        refWatcher = setupLeakCanary();

        //初始化工具类
        Utils.init(this);

        //初始化数据库
//        ThreadManager.getInstance().executeRunnable(() -> {
//            CourseManager.getInstance().initDataBase(getApplicationContext());
//        });

        //注册一下网络监听
        initNetworkListener();


        //批量管理activity
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                ActivityManagerUtil.activityList.add(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ActivityManagerUtil.activityList.remove(activity);
            }
        });
    }

    private void initNetworkListener() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            ConnectivityManager.NetworkCallback callback = new NetworkCallbackImpl(mActivity);
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            NetworkRequest request = builder.build();
            ConnectivityManager manager = (ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE);
            if (manager != null) {
                manager.registerNetworkCallback(request, callback);
            }
        }
    }

//    private RefWatcher setupLeakCanary() {
//
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return RefWatcher.DISABLED;
//        }
//        return LeakCanary.install(this);
//    }

    //使用leak canary
//    public static RefWatcher getRefWatcher(Context context) {
//        BluesApplication application = (BluesApplication) context.getApplicationContext();
//        return application.refWatcher;
//    }
}
