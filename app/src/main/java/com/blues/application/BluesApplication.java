package com.blues.application;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;

import com.blues.database.course.CourseManager;
import com.blues.framework.network.NetworkCallbackImpl;
import com.blues.framework.utils.ThreadManager;
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
        ThreadManager.getInstance().executeRunnable(() -> {
            CourseManager.getInstance().initDataBase(getApplicationContext());
        });

        //注册一下网络监听
        initNetworkListener();
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
