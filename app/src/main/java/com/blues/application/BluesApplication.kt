package com.blues.application

import ActivityUtil
import androidx.multidex.MultiDexApplication
import androidx.multidex.MultiDex
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Build.VERSION.SDK_INT
import coil.Coil
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.blues.adapter.ActivityLifecycleCallbacksAdapter
import com.blues.di.allModules
import com.blues.framework.http.OkHttpClientManager
import com.blues.framework.network.NetworkCallbackImpl
import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * User : Blues
 * Date : 2019/3/6
 * Email : huajianlan@rastar.com
 */
class BluesApplication : MultiDexApplication() {

    companion object {

        lateinit var app: Context
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base) //当引入第三方jar包过多时，尽心dex分包处理
        MultiDex.install(this)
        app = base
    }

    override fun onCreate() {
        super.onCreate()

        //注册一下网络监听
        initNetworkListener()

        //初始化Activity声明周期监听
        initActivityLifecycleListener()

        //初始化koin
        initKoin()

        //初始化coil
        initCoil()

        //注册mmkv
        MMKV.initialize(this)
    }

    private fun initNetworkListener() {
        NetworkCallbackImpl(app)
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@BluesApplication)
            androidLogger()
            modules(allModules)
        }
    }

    private fun initActivityLifecycleListener() {
        //批量管理activity
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacksAdapter() {

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                ActivityUtil.activities.add(activity)
            }

            override fun onActivityDestroyed(activity: Activity) {
                ActivityUtil.activities.remove(activity)
            }
        })
    }

    /**
     * 初始化coil
     */
    private fun initCoil() {
        ImageLoader.Builder(applicationContext).crossfade(true).componentRegistry {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder(applicationContext))
                } else {
                    add(GifDecoder())
                }
            }.okHttpClient {
                OkHttpClientManager.instance
            }.build().also {
                Coil.setImageLoader(it)
            }
    }
}