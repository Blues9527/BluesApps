package com.example.lanhuajian.blues.framework.lrucache;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.util.LruCache;
import android.widget.Toast;

/**
 * User : Blues
 * Date : 2019/4/10
 * Time : 10:59
 */

public class LruCacheUtils {
    private LruCache<String, Bitmap> lruCache;
    private Activity mActivity;

    public LruCacheUtils(Activity mActivity) {
        this.mActivity = mActivity;
        int cacheMemory = (int) (Runtime.getRuntime().maxMemory() / 8);
        lruCache = new LruCache<String, Bitmap>(cacheMemory) {
            @Override
            protected int sizeOf(@NonNull String key, @NonNull Bitmap value) {
                return value.getByteCount() / 1024;
            }
        };
    }

    /**
     * 将bitmap添加到lrucache
     *
     * @param key
     * @param bitmap
     */
    public void addBitmapToLruCache(String key, Bitmap bitmap) {
        if (getBitmapFormLruCache(key) == null) {
            lruCache.put(key, bitmap);
        } else {
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(mActivity, "bitmap already exit!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * 从lrucache里移除bitmap
     *
     * @param key
     */
    public void removeBitmapFromLruCache(String key) {
        if (null != key) {
            lruCache.remove(key);
        }
    }

    /**
     * 从lrucache里取出bitmap
     *
     * @param key
     * @return
     */
    public Bitmap getBitmapFormLruCache(String key) {
        if (null != key) {
            return lruCache.get(key);
        }
        return null;
    }
}
