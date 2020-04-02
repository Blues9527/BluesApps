package com.blues.gifloader;

import android.content.Context;
import android.widget.ImageView;

import java.lang.ref.SoftReference;

public class GifRequest {

    //load(url)
    private String url;

    //loading(id)
    private int loadingResId;

    //listener(RequestListener)
    private GifRequestListener listener;

    //into(target)
    private SoftReference<ImageView> softReference;

    private Context context;

    public GifRequest(Context context) {
        this.context = context;
    }

    public GifRequest load(String url) {
        this.url = url;
        return this;
    }

    public GifRequest loading(int loadingResId) {
        this.loadingResId = loadingResId;
        return this;
    }

    public GifRequest listener(GifRequestListener listener) {
        this.listener = listener;
        return this;
    }

    public GifRequest into(ImageView target) {
        this.softReference = new SoftReference<>(target);
        GifLoader.getInstance().addBitmapRequest(this);
        return this;
    }

    public String getUrl() {
        return url;
    }

    public int getLoadingResId() {
        return loadingResId;
    }

    public GifRequestListener getListener() {
        return listener;
    }

    public ImageView getView() {
        return softReference.get();
    }

    public Context getContext() {
        return context;
    }
}
