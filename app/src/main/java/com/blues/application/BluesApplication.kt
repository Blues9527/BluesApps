package com.blues.application

import ActivityUtil
import androidx.multidex.MultiDexApplication
import androidx.multidex.MultiDex
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Build
import com.blues.framework.network.NetworkCallbackImpl
import android.net.NetworkRequest
import android.net.ConnectivityManager
import com.blues.adapter.ActivityLifecycleCallbacksAdapter
import com.blues.di.allModules
import com.blues.framework.utils.Utils
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * User : Blues
 * Date : 2019/3/6
 * Email : huajianlan@rastar.com
 */
class BluesApplication : MultiDexApplication() {

    private val mActivity: Context? = null
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base) //当引入第三方jar包过多时，尽心dex分包处理
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        //初始化工具类
        Utils.init(this)

        //注册一下网络监听
        //initNetworkListener()

        //初始化Activity声明周期监听
        initActivityLifecycleListener()

        //初始化koin
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@BluesApplication)
            androidLogger()
            modules(allModules)
        }
    }

    private fun initActivityLifecycleListener() { //批量管理activity
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacksAdapter() {

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                activity?.let {
                    ActivityUtil.activities.add(activity)
                }
            }

            override fun onActivityDestroyed(activity: Activity?) {
                activity?.let {
                    ActivityUtil.activities.remove(activity)
                }
            }
        })
    }

    private fun initNetworkListener() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            val callback = NetworkCallbackImpl(mActivity)
            val request = NetworkRequest.Builder()
                .build()
            val manager = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            manager.registerNetworkCallback(request, callback)
        }
    }
}