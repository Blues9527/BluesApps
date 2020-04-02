package com.blues.gifloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class GifDispatcher extends Thread {

    private final String TAG = this.getClass().getSimpleName();

    //fileName - suffix
    private HashMap<String, String> hashMap = new HashMap<>();

    //线程切换
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    //阻塞队列进行存储请求
    private LinkedBlockingQueue<GifRequest> linkedBlockingQueue;

    public GifDispatcher(LinkedBlockingQueue<GifRequest> linkedBlockingQueue) {
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    @Override
    public void run() {
        //线程没有被中断
        while (!isInterrupted()) {
            try {
                GifRequest gifRequest = linkedBlockingQueue.take();
                //占位图的加载
                loadPlaceHolder(gifRequest);
                //从服务器/缓存加载图片
                downloadGif(gifRequest);
                //将bitmap加载到image view
                loadIntoImageView(gifRequest);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将gif加载进入image view
     *
     * @param gifRequest
     */
    private void loadIntoImageView(final GifRequest gifRequest) {
        Log.i(TAG, "loadIntoImageView");
        if (!TextUtils.isEmpty(gifRequest.getUrl()) && gifRequest.getView() != null) {
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    showGifImpl(gifRequest.getContext(), gifRequest.getView(), gifRequest.getUrl());
                }
            });
        }
    }

    /**
     * 加载真正的gif
     *
     * @param gifRequest
     * @return
     */
    private void downloadGif(GifRequest gifRequest) {
        Log.i(TAG, "downloadGif");
        String uri = gifRequest.getUrl();
        if (FileUtil.fileExits(gifRequest.getContext(), MD5Utils.md5(uri))) {
            Log.i(TAG, MD5Utils.md5(uri) + " is already exits!");
            return;
        }
        FileOutputStream fos = null;
        InputStream is = null;
        if (!TextUtils.isEmpty(uri)) {
            try {
                URL url = new URL(uri);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(5000);
                connection.setConnectTimeout(5000);
                connection.connect();

                is = connection.getInputStream();
                if (gifRequest.getListener() != null) {
                    if (is != null) {
                        gifRequest.getListener().onSuccess();
                    } else {
                        gifRequest.getListener().onFailure();
                    }
                }

                int len = 0;
                StringBuffer child = new StringBuffer();
                child.append(MD5Utils.md5(uri));
                //TODO 去做content-type类型判断
                if (TextUtils.equals(connection.getContentType(), "image/gif")) {
                    //使用NDK加载
                    //进行本地缓存
                    //缓存目录是系统的缓存目录，清除应用缓存时会被清掉，gif名称 md5(url).gif
                    if (!hashMap.containsKey(MD5Utils.md5((uri)))) {
                        hashMap.put(MD5Utils.md5((uri)), ".gif");
                    }
                    child.append(".gif");

                } else if (TextUtils.equals(connection.getContentType(), "image/jpeg")) {
                    //普通类型的直接用bitmap加载
                    if (!hashMap.containsKey(MD5Utils.md5((uri)))) {
                        hashMap.put(MD5Utils.md5((uri)), ".jpeg");
                    }
                    child.append(".jpeg");
                } else if (TextUtils.equals(connection.getContentType(), "image/png")) {
                    //普通类型的直接用bitmap加载
                    if (!hashMap.containsKey(MD5Utils.md5((uri)))) {
                        hashMap.put(MD5Utils.md5((uri)), ".png");
                    }
                    child.append(".png");
                } else {
                    Log.i(TAG, "parse error, msg: unknown content-type");
                }
                File file = new File(FileUtil.getExternalCacheDir(gifRequest.getContext()), child.toString());
                Log.i(TAG, "cached gif:->> " + child.toString());

                byte[] buf = new byte[128];
                fos = new FileOutputStream(file);
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                //刷新缓冲区
                fos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //关闭流，防止内存泄漏
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 加载占位图
     *
     * @param gifRequest
     */
    private void loadPlaceHolder(final GifRequest gifRequest) {
        Log.i(TAG, "loadPlaceHolder");
        if (!(gifRequest.getLoadingResId() > 0) && gifRequest.getView() != null) {
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    gifRequest.getView().setImageResource(gifRequest.getLoadingResId());
                }
            });

        }
    }

    /**
     * 处理图片渲染和gif循环播放的handler
     */
    private static class GifLoaderHandler extends Handler {

        private GifHandler gifHandler;
        private Bitmap bitmap;
        private int currentIndex;
        private int maxIndex;
        private ImageView iv;

        public GifLoaderHandler(GifHandler gifHandler, Bitmap bitmap, int currentIndex,
                                int maxIndex, ImageView iv) {
            this.gifHandler = gifHandler;
            this.bitmap = bitmap;
            this.currentIndex = currentIndex;
            this.maxIndex = maxIndex;
            this.iv = iv;
        }


        @Override
        public void handleMessage(Message msg) {
            if (gifHandler != null) {
                long delay_time = gifHandler.renderFrame(bitmap, currentIndex);
                currentIndex++;
                if (currentIndex >= maxIndex) {
                    currentIndex = 0;
                }
                iv.setImageBitmap(bitmap);
                sendEmptyMessageDelayed(1, delay_time);
            }
        }
    }

    /**
     * NDK加载gif的实现方法
     *
     * @param iv
     * @param url
     */
    private void showGifImpl(Context context, ImageView iv, String url) {

        File gifFile = FileUtil.getFile(context, MD5Utils.md5(url));

        if (gifFile != null && gifFile.exists()) {
            String filePath = gifFile.getAbsolutePath();
            Log.i(TAG, "filePath--->>" + filePath);
            //gif使用ndk加载
            if (filePath.endsWith(".gif")) {
                Log.i(TAG, "load gif");
                GifHandler gifHandler = new GifHandler(filePath);

                //获取gif图片宽高
                int width = gifHandler.getWidth();
                int height = gifHandler.getHeight();

                //获取gif图片帧数

                //创建空的bitmap
                Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

                //渲染图片返回延迟
                int currentIndex = 0;
                long delay_time = gifHandler.renderFrame(bitmap, currentIndex);
                int maxIndex = gifHandler.getLength();
                iv.setImageBitmap(bitmap);

                //根据延时时长发送空的消息
                if (delay_time != 0L) {
                    GifLoaderHandler handler = new GifLoaderHandler(gifHandler, bitmap, currentIndex, maxIndex, iv);
                    handler.sendEmptyMessageDelayed(1, delay_time);
                }
            } else {
                Log.i(TAG, "load other");
                iv.setImageBitmap(BitmapFactory.decodeFile(filePath));
            }
        } else {
            //TODO 如果图片下载失败后的处理
            Toast.makeText(context, "图片加载失败", Toast.LENGTH_SHORT).show();
        }
    }
}
