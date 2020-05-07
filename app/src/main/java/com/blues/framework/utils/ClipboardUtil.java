package com.blues.framework.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;

public final class ClipboardUtil {
    private ClipboardUtil() {
    }

    private static final ClipboardImpl IMPL;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            IMPL = new HoneycombClipboardImpl();
        } else {
            IMPL = new BaseClipboardImpl();
        }
    }

    static class BaseClipboardImpl implements ClipboardImpl {
        BaseClipboardImpl() {
        }

        public void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
            ((ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE)).setText(charSequence2);
        }
    }

    static class HoneycombClipboardImpl implements ClipboardImpl {
        HoneycombClipboardImpl() {
        }

        public void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
            ((ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
        }
    }

    public static void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (context != null && charSequence != null && charSequence2 != null) {
            try {
                IMPL.setText(context, charSequence, charSequence2);
            } catch (Throwable unused) {
                unused.printStackTrace();
            }
        }
    }

    interface ClipboardImpl {
        void setText(Context ctx, CharSequence c1, CharSequence c2);
    }
}
