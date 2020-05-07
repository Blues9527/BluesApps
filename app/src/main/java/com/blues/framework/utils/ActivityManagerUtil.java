package com.blues.framework.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ActivityManagerUtil {

    public static List<Activity> activityList = new LinkedList<>();

    private ActivityManagerUtil() {

    }


    /**
     * 统一管理activity跳转
     *
     * @param clazz
     * @param params
     * @param <V>
     */
    public static <V> void start(Class<? extends Activity> clazz, Map<String, V> params) {
        Activity currentActivity = activityList.get(activityList.size() - 1);
        Intent intent = new Intent(currentActivity, clazz);

        if (params != null) {
            for (String key : params.keySet()) {
                V value = params.get(key);
                if (value instanceof Integer) {
                    intent.putExtra(key, ((Integer) value).intValue());
                } else if (value instanceof Boolean) {
                    intent.putExtra(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Long) {
                    intent.putExtra(key, ((Long) value).longValue());
                } else if (value instanceof Short) {
                    intent.putExtra(key, ((Short) value).shortValue());
                } else if (value instanceof String) {
                    intent.putExtra(key, value.toString());
                } else if (value instanceof Character) {
                    intent.putExtra(key, ((Character) value).charValue());
                } else if (value instanceof Byte) {
                    intent.putExtra(key, ((Byte) value).byteValue());
                } else if (value instanceof Float) {
                    intent.putExtra(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    intent.putExtra(key, ((Double) value).doubleValue());
                } else if (value instanceof CharSequence) {
                    intent.putExtra(key, (CharSequence) value);
                } else if (value instanceof Bundle) {
                    intent.putExtra(key, (Bundle) value);
                } else if (value instanceof int[]) {
                    intent.putExtra(key, (int[]) value);
                } else if (value instanceof boolean[]) {
                    intent.putExtra(key, (boolean[]) value);
                } else if (value instanceof byte[]) {
                    intent.putExtra(key, (byte[]) value);
                } else if (value instanceof short[]) {
                    intent.putExtra(key, (short[]) value);
                } else if (value instanceof long[]) {
                    intent.putExtra(key, (long[]) value);
                } else if (value instanceof double[]) {
                    intent.putExtra(key, (double[]) value);
                } else if (value instanceof char[]) {
                    intent.putExtra(key, (char[]) value);
                } else if (value instanceof float[]) {
                    intent.putExtra(key, (float[]) value);
                } else if (value instanceof String[]) {
                    intent.putExtra(key, (String[]) value);
                } else if (value instanceof CharSequence[]) {
                    intent.putExtra(key, (CharSequence[]) value);
                } else if (value instanceof Parcelable) {
                    intent.putExtra(key, (Parcelable) value);
                } else if (value instanceof Parcelable[]) {
                    intent.putExtra(key, (Parcelable[]) value);
                } else if (value instanceof Serializable) {
                    intent.putExtra(key, (Serializable) value);
                }
            }
        }
        currentActivity.startActivity(intent);
    }

    /**
     * finish指定activity
     *
     * @param clazz
     */
    public static void finish(Class<? extends Activity> clazz) {
        for (Activity activity : activityList) {
            if (clazz.equals(activity.getClass())) {
                activity.finish();
            }
        }
    }
}
