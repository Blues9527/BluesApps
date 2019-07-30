package com.example.lanhuajian.blues.framework.lrucache;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * User : Blues
 * Date : 2019/4/10
 * Time : 11:54
 */

public class DownloadImageThread extends Thread {

    private Activity act;
    private LruCacheUtils utils;
    private ImageView target;
    private String url;


    public DownloadImageThread(Activity act, LruCacheUtils utils, ImageView target, String url) {
        this.act = act;
        this.utils = utils;
        this.target = target;
        this.url = url;
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        InputStream ios = null;
        try {
            URL req = new URL(url);
            connection = (HttpURLConnection) req.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setUseCaches(true);
            connection.connect();

            ios = connection.getInputStream();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                final Bitmap bitmap = BitmapFactory.decodeStream(ios);
                //使用url作为key值
                utils.addBitmapToLruCache(url, bitmap);
                //切换主线更新ui
                act.runOnUiThread(() -> target.setImageBitmap(bitmap));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
            if (null != ios) {
                try {
                    ios.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
