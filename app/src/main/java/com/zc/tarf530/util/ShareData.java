package com.zc.tarf530.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Kevin on 2015/8/14.
 */
public class ShareData {
    private static final String SP_NAME = "jianguan_sharedata";
    private static Context context;
    private static SharedPreferences sp;

    public static void init(Context initContext) {
        if (sp == null) {
            context = initContext;
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
    }
    public static void removeAll() {
        if (sp == null)
            return ;
        sp.edit().clear().commit();
    }

    public static int getShareIntData(String key) {
        if (sp == null)
            return 0;
        return sp.getInt(key, 0);
    }

    public static int getShareIntData(String key, int defValue) {
        if (sp == null)
            return 0;
        return sp.getInt(key, defValue);
    }

    public static void setShareIntData(String key, int value) {
        if (sp == null)
            return;
        sp.edit().putInt(key, value).commit();
    }

    public static String getShareStringData(String key) {
        if (sp == null)
            return "";
        return sp.getString(key, "");
    }

    public static String getShareStringData(String key, String value) {
        if (sp == null)
            return "";
        return sp.getString(key, value);
    }

    public static void setShareStringData(String key, String value) {
        if (sp == null)
            return;
        sp.edit().putString(key, value).commit();
    }

    public static boolean getShareBooleanData(String key) {
        if (sp == null)
            return false;
        return sp.getBoolean(key, false);
    }

    public static boolean getShareBooleanDataDefaultTrue(String key) {
        if (sp == null)
            return false;
        return sp.getBoolean(key, true);
    }

    public static void setShareBooleanData(String key, boolean value) {
        if (sp == null)
            return;
        sp.edit().putBoolean(key, value).commit();
    }

    public static float getShareFloatData(String key) {
        if (sp == null)
            return 0f;
        return sp.getFloat(key, 0f);
    }

    public static void setShareFloatData(String key, float value) {
        if (sp == null)
            return;
        sp.edit().putFloat(key, value).commit();
    }

    public static long getShareLongData(String key) {
        if (sp == null)
            return 0l;
        return sp.getLong(key, 0l);
    }

    public static void setShareLongData(String key, long value) {
        if (sp == null)
            return;
        sp.edit().putLong(key, value).commit();
    }

    public static void remove(String key) {
        if (sp == null)
            return;
        sp.edit().remove(key).commit();
    }

    public static boolean contains(String key) {
        if (sp == null)
            return false;
        return sp.contains(key);
    }

//    /**
//     * 存储对象
//     * @param key key
//     * @param obj 对象
//     */
//    public static void setObj(String key, Object obj) {
//        if (sp == null || obj == null)
//            return;
//        //1、Object---->String
//        Gson gson = new Gson();
//        String jsonStr = gson.toJson(obj);
//        //2、String---->xml
//        setShareStringData(key, jsonStr);
//        //3、commit
//        sp.edit().apply();
//    }
//
//    /**
//     * 获取对象
//     * @param key key
//     * @param c clazz
//     * @return
//     */
//    public static Object getObj(String key, Class c) {
//        String str = getShareStringData(key);
//        Gson gson = new Gson();
//        Object obj = gson.fromJson(str, c);
//        return obj;
//    }

    // public static void clear() {
    // sp.edit().clear().commit();
    // }

}
