package com.example.lanhuajian.blues.framework.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager {

    //-----------------单例-------------------
    private ThreadManager() {
    }

    private static class Holder {
        private static final ThreadManager INSTANCE = new ThreadManager();
    }

    public static ThreadManager getInstance() {
        return Holder.INSTANCE;
    }

    //-----------------单例-------------------


    //CPU 核数
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    //核心线程数量大小
    private static final int corePoolSize = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    //线程池最大容纳线程数
    private static final int maximumPoolSize = CPU_COUNT * 2 + 1;
    //线程空闲后的存活时长
    private static final int keepAliveTime = 30;

    //线程池
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(
            corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new SynchronousQueue<>()
    );

    //handler
    private Handler mHandler = new Handler(Looper.getMainLooper());


    //-------------------方法--------------------//

    /**
     * 使用handler切换主线程执行任务
     *
     * @param r runnable
     */
    public void runOnUiThread(Runnable r) {
        mHandler.post(r);
    }

    /**
     * 使用handler切换主线程执行任务，有延迟
     *
     * @param r runnable
     * @param d 延长时间
     */
    public void runOnUiThreadDelay(Runnable r, long d) {
        mHandler.postDelayed(r, d);
    }

    /**
     * 使用线程池去执行任务
     *
     * @param r runnable
     */
    public void executeRunnable(Runnable r) {
        executor.execute(r);
    }

    /**
     * 移除线程池中的任务
     *
     * @param r runnable
     */
    public void removeRunnable(Runnable r) {
        executor.remove(r);
    }
}
