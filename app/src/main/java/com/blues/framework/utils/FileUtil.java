package com.blues.framework.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

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

    /**
     * @param path
     */
    public static String read(String path) throws IOException {

        //用StringBuffer 线程安全
        StringBuffer sb = new StringBuffer();
        //先读成文件的形式
        File file = new File(path);
        //通过文件流来读
        FileInputStream fios = new FileInputStream(file);
        //用于循环
        int len;
        //定义一个字节数组，用于存放读出来的内容
        byte[] bytes = new byte[1024];
        //while循环通过fios读数据
        while ((len = fios.read(bytes)) != -1) {
            //将读出来的数据存入StringBuffer，默认使用utf-8 中文字符集
            sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
        }
        //流用完后记得要关闭
        fios.close();

        return sb.toString();
    }

    /**
     * 从assets文件中读取json数据
     * @param fileName json格式文件名
     * @return json字符串
     */
    public static String readJson(String fileName) {
        //用StringBuffer 线程安全
        StringBuilder sb = new StringBuilder();
        InputStream in = null;
        try {
            in = Utils.getContext().getResources().getAssets().open(fileName);
            //用于循环
            int len;
            //定义一个字节数组，用于存放读出来的内容
            byte[] bytes = new byte[1024];
            //while循环通过in读数据
            while ((len = in.read(bytes)) != -1) {
                //将读出来的数据存入StringBuilder，默认使用utf-8 中文字符集
                sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 获取Asset沐流文件数据
     *
     * @param ctx
     * @param fileName
     * @return
     */
    public static String getAssetsFile(Context ctx, String fileName) {
        String result = null;
        try {
            AssetManager assetManager = ctx.getAssets();
            InputStream is = assetManager.open(fileName);
            int length = is.available();
            byte[] buffer = new byte[length];
            int sum = is.read(buffer);
            if (sum != 0) {
                result = new String(buffer, "utf8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
