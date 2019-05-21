package com.example.lanhuajian.blues.framework.http;

import com.example.lanhuajian.blues.framework.http.typeadapter.DoubleDefaultAdapter;
import com.example.lanhuajian.blues.framework.http.typeadapter.IntegerDefaultAdapter;
import com.example.lanhuajian.blues.framework.http.typeadapter.LongDefaultAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class RetrofitManager {

    private static String BASE_URL = "";
    private static Retrofit.Builder mRetrofitBuilder;
    private static Gson mGson;

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static Retrofit getInstance() {
        if (null == mRetrofitBuilder) {
            synchronized (RetrofitManager.class) {
                mRetrofitBuilder = new Retrofit.Builder()
                        .client(OkHttpClientManager.getInstance())
                        .addConverterFactory(GsonConverterFactory.create(buildGson()))
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
            }
        }
        return mRetrofitBuilder
                .baseUrl(getBaseUrl())
                .build();
    }

    /**
     * 增加后台返回""和"null"的处理
     * 1.int=>0
     * 2.double=>0.00
     * 3.long=>0L
     */
    public static Gson buildGson() {
        if (mGson == null) {
            synchronized (Gson.class) {
                if (mGson == null) {
                    mGson = new GsonBuilder()
                            .registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
                            .registerTypeAdapter(int.class, new IntegerDefaultAdapter())
                            .registerTypeAdapter(Double.class, new DoubleDefaultAdapter())
                            .registerTypeAdapter(double.class, new DoubleDefaultAdapter())
                            .registerTypeAdapter(Long.class, new LongDefaultAdapter())
                            .registerTypeAdapter(long.class, new LongDefaultAdapter())
                            .create();
                }
            }
        }
        return mGson;
    }
}
