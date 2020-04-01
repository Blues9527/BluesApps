package com.blues.framework.lrucache;

import androidx.collection.LruCache;
import android.text.TextUtils;

/**
 * User : Blues
 * Date : 2019/4/10
 * Time : 10:59
 */

public class LruCacheUtils<T> {
    private LruCache<String, T> lruCache;
    private final String TAG = this.getClass().getSimpleName();

    public LruCacheUtils() {
        int cacheMemory = (int) (Runtime.getRuntime().maxMemory() / 8);
        lruCache = new LruCache<>(cacheMemory);
    }

    /**
     * 添加到lrucache
     *
     * @param key
     * @param t
     */
    public T addToLruCache(String key, T t) {
        if (!TextUtils.isEmpty(key)) {
            return lruCache.put(key, t);
        }
        return null;
    }

    /**
     * 从lrucache里移除bitmap
     *
     * @param key
     */
    public T removeFromLruCache(String key) {

        if (!TextUtils.isEmpty(key)) {
            return lruCache.remove(key);
        }
        return null;
    }

    /**
     * 从lrucache里取出bitmap
     *
     * @param key
     */
    public T getValueFormLruCache(String key) {
        if (!TextUtils.isEmpty(key)) {
            return lruCache.get(key);
        }
        return null;
    }
}
