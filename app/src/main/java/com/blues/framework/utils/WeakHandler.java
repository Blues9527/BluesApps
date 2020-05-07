package com.blues.framework.utils;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

public class WeakHandler extends Handler {
    private WeakReference<IHandler> mRef;

    public interface IHandler {
        void handlerMessage(Message message);
    }

    public WeakHandler(IHandler iHandler) {
        this(Looper.getMainLooper(), iHandler);
    }

    public WeakHandler(Looper looper, IHandler iHandler) {
        super(looper);
        this.mRef = new WeakReference<IHandler>(iHandler);
    }

    @Override
    public void handleMessage(Message msg) {
        IHandler iHandler = mRef.get();
        if (iHandler != null && msg != null) {
            iHandler.handlerMessage(msg);
        }
    }
}
