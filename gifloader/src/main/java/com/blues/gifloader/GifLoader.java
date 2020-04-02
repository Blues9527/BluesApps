package com.blues.gifloader;

import android.util.Log;

import java.util.concurrent.LinkedBlockingQueue;

public class GifLoader {

    private final String TAG = this.getClass().getSimpleName();

    private static volatile GifLoader instance;
    private LinkedBlockingQueue<GifRequest> linkedBlockingQueue = new LinkedBlockingQueue<>();
    private GifDispatcher[] gifDispatchers;

    private GifLoader() {
        start();
    }

    public static GifLoader getInstance() {
        if (instance == null) {
            synchronized (GifLoader.class) {
                if (instance == null) {
                    instance = new GifLoader();
                }
            }
        }
        return instance;
    }

    public void addBitmapRequest(GifRequest gifRequest) {
        Log.i(TAG, "addBitmapRequest");
        if (gifRequest == null) {
            return;
        }
        if (!linkedBlockingQueue.contains(gifRequest)) {
            linkedBlockingQueue.add(gifRequest);
        }
    }

    private void start() {
        Log.i(TAG, "start");
        stop();
        startAllDispatcher();
    }

    public void stop() {
        Log.i(TAG, "stop");
        if (gifDispatchers != null && gifDispatchers.length > 0) {
            for (GifDispatcher dispatcher : gifDispatchers) {
                if (!dispatcher.isInterrupted()) {
                    dispatcher.interrupt();
                }
            }
        }
    }

    private void startAllDispatcher() {
        Log.i(TAG, "startAllDispatcher");
        int threadCount = Runtime.getRuntime().availableProcessors();
        gifDispatchers = new GifDispatcher[threadCount];
        for (int i = 0; i < threadCount; i++) {
            GifDispatcher dispatcher = new GifDispatcher(linkedBlockingQueue);
            dispatcher.start();
            gifDispatchers[i] = dispatcher;
        }
    }
}
