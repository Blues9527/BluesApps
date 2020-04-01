package com.blues.framework.lrucache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import android.util.Log;

import com.blues.framework.http.OkHttpClientManager;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * User : Blues
 * Date : 2019/4/10
 * Time : 11:54
 */

public class DownloadImageThread extends Thread {

    private LruCacheUtils utils;
    private String url;
    private DownloadCallBack mCallBack;

    public DownloadImageThread(String url, DownloadCallBack callBack) {
        this(null, url, callBack);
    }


    public DownloadImageThread(@Nullable LruCacheUtils utils,String url, DownloadCallBack callBack) {
        this.utils = utils;
        this.url = url;
        mCallBack = callBack;
    }

    @Override
    public void run() {
        OkHttpClientManager.getInstance().newCall(new Request.Builder().get().url(url).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("Blues", "download error");
                e.printStackTrace();
                mCallBack.onFailure("download error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("Blues", "download success");

                mCallBack.onSuccess(BitmapFactory.decodeStream(response.body().byteStream()));
                Log.i("Blues", String.valueOf(response.body().byteStream()));
            }
        });

    }

    public interface DownloadCallBack {
        void onSuccess(Bitmap bitmap);

        void onFailure(String msg);
    }
}
