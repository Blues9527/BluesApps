package com.example.lanhuajian.blues.framework.utils;

import android.content.Context;
import android.util.Log;

/**
 * User: Ranger
 * Date: 07/12/2017
 * Time: 4:51 PM
 * Desc: to get resources.
 */
public final class ResourcesUtils {
    public static String ANIMATION = "anim";
    public static String COLOR = "color";
    public static String DRAWABLE = "drawable";
    public static String MIPMAP = "mipmap";
    public static String LAYOUT = "layout";
    public static String MENU = "menu";
    public static String STRING = "string";
    public static String STYLE = "style";
    public static String DIMEN = "dimen";
    public static String ATTR = "attr";
    public static String ID = "id";

    public static int getResourcesID(String name, String type, Context context) {
        int id = 0x7f000000;
        try {
            id = context.getResources().getIdentifier(name, type, context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("ThirdSDK", "get resources exception. resources no found -->" +
                    "\nname --> " + name +
                    "\ntype --> " + type);
        }
        return id;
    }

    public static int getAnimationID(String name, Context ctx) {
        return getResourcesID(name, ANIMATION, ctx);
    }

    public static int getColorID(String name, Context ctx) {
        return getResourcesID(name, COLOR, ctx);
    }

    public static int getDrawableID(String name, Context ctx) {
        return getResourcesID(name, DRAWABLE, ctx);
    }

    public static int getMipmapID(String name, Context ctx) {
        return getResourcesID(name, MIPMAP, ctx);
    }

    public static int getLayoutID(String name, Context ctx) {
        return getResourcesID(name, LAYOUT, ctx);
    }

    public static int getMenuID(String name, Context ctx) {
        return getResourcesID(name, MENU, ctx);
    }

    public static int getStringID(String name, Context ctx) {
        return getResourcesID(name, STRING, ctx);
    }

    public static int getStyleID(String name, Context ctx) {
        return getResourcesID(name, STYLE, ctx);
    }

    public static int getDimenID(String name, Context ctx) {
        return getResourcesID(name, DIMEN, ctx);
    }

    public static int getAttrID(String name, Context ctx) {
        return getResourcesID(name, ATTR, ctx);
    }

    public static int getID(String name, Context ctx) {
        return getResourcesID(name, ID, ctx);
    }
}
