package com.blues.framework.utils;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/**
 * 尺寸相关工具类
 */
public final class SizeUtil {

    private SizeUtil() {
    }

    /**
     * dp转px
     *
     * @param dpValue dp值
     * @return px值
     */
    public static int dp2px(float dpValue) {
        final float scale = Utils.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获取到View尺寸的监听
     */
    public interface onGetSizeListener {
        void onGetSize(View view);
    }
}
