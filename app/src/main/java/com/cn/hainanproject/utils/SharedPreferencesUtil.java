package com.cn.hainanproject.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;


import com.cn.hainanproject.base.Constants;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Created by luhaixu on 16/3/25.
 */
public class SharedPreferencesUtil {

    public static final String AVATAR = "avatar";

    /**
     * 基本功能：保存String类型数据到SharedPreferences
     *
     * @param context
     * @param key
     * @param value
     */

    public static void setString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();// 获取编辑器
        editor.putString(key, value);
        editor.commit();// 提交修改
    }


    /**
     * 基本功能：取得SharedPreferences中存储的String类型数据
     *
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        String signature = sharedPreferences.getString(key, "");
        return signature;
    } /**
     * 基本功能：取得SharedPreferences中存储的String类型数据
     *
     * @param context
     * @param key
     * @return
     */
    public static String getString2(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        String signature = sharedPreferences.getString(key, "0");
        return signature;
    }

    /**
     * 基本功能：存储的Int类型数据到SharedPreferences
     *
     * @param context
     * @param key
     * @return
     */
    public static void setInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();// 获取编辑器
        editor.putInt(key, value);
        editor.commit();// 提交修改
    }


    public static void setFloat(Context context, String key, float value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();// 获取编辑器
        editor.putFloat(key, value);
        editor.commit();// 提交修改
    }


    /**
     * 基本功能：存储的boolean类型数据到SharedPreferences
     *
     * @param context
     * @param key
     * @return
     */
    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();// 获取编辑器
        editor.putBoolean(key, value);
        editor.commit();// 提交修改
    }

    /**
     * 基本功能：取得SharedPreferences中存储的Int类型数据
     *
     * @param context
     * @param key
     * @return
     */
    public static int getInt(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        int signature = sharedPreferences.getInt(key, 0);
        return signature;
    }


    public static float getFloat(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        float signature = sharedPreferences.getFloat(key, 14.0f);
        return signature;
    }


    /**
     * 基本功能：取得SharedPreferences中存储的boolean类型数据
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        boolean signature = sharedPreferences.getBoolean(key, false);
        return signature;
    }


    /**
     * writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject 方法可以还原它
     * 最后，用Base64.encode将字节文件转换成Base64编码保存在String中
     *
     * @param object 待加密的转换为String的对象
     * @return String   加密后的String
     */
    private static String Object2String(Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            String string = new String(Base64.encode(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
            objectOutputStream.close();
            return string;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用Base64解密String，返回Object对象
     *
     * @param objectString 待解密的String
     * @return object      解密后的object
     */
    private static Object String2Object(String objectString) {
        byte[] mobileBytes = Base64.decode(objectString.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mobileBytes);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 使用SharedPreference保存对象
     *
     * @param key        储存对象的key
     * @param saveObject 储存的对象
     */
    public static void saveObject(Context context, String key, Object saveObject) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String string = Object2String(saveObject);
        editor.putString(key, string);
        editor.commit();
    }

    /**
     * 获取SharedPreference保存的对象
     *
     * @param key 储存对象的key
     * @return object 返回根据key得到的对象
     */
    public static Object getObject(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        String string = sharedPreferences.getString(key, null);
        if (string != null) {
            Object object = String2Object(string);
            return object;
        } else {
            return null;
        }
    }

    public static void clear(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }



}
