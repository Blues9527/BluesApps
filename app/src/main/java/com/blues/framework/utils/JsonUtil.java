package com.blues.framework.utils;

import com.google.gson.Gson;

/**
 * User : Blues
 * Date : 2019/8/13
 * Time : 16:35
 */

public final class JsonUtil {

    private JsonUtil() {

    }

    public static <T> T convertToEntity(String source, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(source, clazz);
    }

}
