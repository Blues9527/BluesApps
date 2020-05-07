package com.blues.framework.utils;

import android.content.Context;
import android.util.Log;

/**
 * User: Ranger
 * Date: 07/12/2017
 * Time: 4:51 PM
 * Desc: to get resources.
 */
public final class ResourcesUtils {
    private static final String ANIMATION = "anim";
    private static final String COLOR = "color";
    private static final String DRAWABLE = "drawable";
    private static final String MIPMAP = "mipmap";
    private static final String LAYOUT = "layout";
    private static final String MENU = "menu";
    private static final String STRING = "string";
    private static final String STYLE = "style";
    private static final String DIMEN = "dimen";
    private static final String ATTR = "attr";
    private static final String ID = "id";

    public static int getResourcesID(String name, String type, Context context) {
        int id = 0x7f000000;
        try {
            id = context.getResources().getIdentifier(name, type, context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("ResourcesUtils", "get resources exception. resources no found -->" +
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
