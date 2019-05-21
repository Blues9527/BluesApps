package com.example.lanhuajian.blues.framework.http;

import android.util.Log;

import com.example.lanhuajian.blues.framework.utils.FileUtil;
import com.example.lanhuajian.blues.framework.utils.NetWorkUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class OkHttpClientManager {

    private static volatile OkHttpClient instance;

    private static Cache cache = new Cache(FileUtil.getCacheDirectory(), 100 * 1024 * 1024);

    public static OkHttpClient getInstance() {
        if (instance == null) {
            synchronized (OkHttpClientManager.class) {
                if (instance == null) {
                    instance = new OkHttpClient.Builder()
                            //添加拦截器
                            .addInterceptor(interceptor)
                            .addInterceptor(loggingInterceptor)
                            .addNetworkInterceptor(networkInterceptor)
                            //设置连接、读写超时时间
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            //错误重连
                            .retryOnConnectionFailure(true)
                            .cache(cache)
                            .build();
                }
            }
        }
        return instance;
    }

    //打印请求连接和参数
    public static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Log.e("Blues", message);
        }
    }).setLevel(HttpLoggingInterceptor.Level.BODY);


    // 云端响应头拦截器，用来配置缓存策略
    private static final Interceptor networkInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            if (NetWorkUtil.isConnected()) {
                Log.e("Blues", "有网络");
                request = request.newBuilder()
                        //走网络
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
            } else {
                Log.e("Blues", "无网络");
                request = request.newBuilder()
                        //只走缓存
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }

            Response originalResponse = chain.proceed(request);

            Response response;
            if (NetWorkUtil.isConnected()) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                int maxAge = 0; //在线缓存不可读取
                response = originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .removeHeader("Pragma")
                        .build();
            } else {
                //无网络时
                int maxStale = 60 * 60 * 24 * 365; //缓存保存时间为365天
                response = originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
            }
            return response;
        }
    };

    /**
     * 云端响应头拦截器
     * 用于添加统一请求头  请按照自己的需求添加
     */
    private static final Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request originalRequest = chain.request();

            HttpUrl httpUrl = originalRequest
                    .url()
                    .newBuilder()
                    // add common parameter
                    .addQueryParameter("token", "")
                    .build();

            Request authorised = originalRequest
                    .newBuilder()
                    // add common header
//                    .addHeader("cookie", COOKIE)
                    .addHeader("user-agent", "Android")
//                    .url(httpUrl)
                    .build();
            return chain.proceed(authorised);
        }
    };
}
