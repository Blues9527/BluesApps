package com.blues.framework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

import androidx.annotation.NonNull;

public class WeakContainer<E> implements Iterable<E> {

    private final WeakHashMap<E, Object> mMap = new WeakHashMap<>();
    private final Object mValue = new Object();

    /**
     * 清空
     */
    public void clear() {
        mMap.clear();
    }

    /**
     * 获取大小
     *
     * @return
     */
    public int size() {
        return mMap.size();
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean isEmpty() {
        return mMap.isEmpty();
    }

    /**
     * 判断包含
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return mMap.containsKey(e);
    }

    /**
     * 添加
     *
     * @param e
     */
    public void add(E e) {
        if (e == null) {
            mMap.size();
        } else {
            mMap.put(e, mValue);
        }
    }

    /**
     * 移除
     *
     * @param e
     */
    public void remove(E e) {
        if (e == null) {
            mMap.size();
        } else {
            mMap.remove(e);
        }
    }

    /**
     * 取出一个并从map移除
     *
     * @return
     */
    public E peek() {
        E e = null;
        if (mMap.size() == 0) {
            return null;
        }
        Iterator<E> it = mMap.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                E next = it.next();
                if (next != null) {
                    e = next;
                    break;
                }
            } else {
                break;
            }
        }
        mMap.remove(e);
        return e;
    }

    @NonNull
    @Override
    public Iterator<E> iterator() {
        ArrayList arrayList = new ArrayList(mMap.size());
        for (E next : mMap.keySet()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList.iterator();
    }
}
