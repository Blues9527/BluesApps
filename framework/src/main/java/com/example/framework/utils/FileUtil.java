package com.example.framework.utils;

import android.util.Log;

import java.io.File;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public final class FileUtil {

    private FileUtil() {
        throw new UnsupportedOperationException("please init Utils from FileUtil");
    }

    /**
     * @return 创建缓存目录
     */
    public static File getCacheDirectory() {
        File file = new File(Utils.getContext().getExternalCacheDir(), "Cache");
        if (!file.exists()) {
            boolean b = file.mkdirs();
            Log.e("Blues", "Cache" + "缓存文件夹不存在，创建" + (b ? "成功" : "失败"));
        } else {
            Log.e("Blues", "Cache" + "缓存文件夹已存在");
        }
        return file;
    }
}
