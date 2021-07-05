package com.cn.hainanproject.base;

import android.app.ActivityManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegate;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.SharedPreferencesUtil;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;


/**
 * 基础MyApplication类
 *
 * @author luhaixu
 */
public class MyApplication extends Application {
    public static String TAG = "MyApplication";
    public static Context applicationContext;
    private static MyApplication instance;
    private static final String NOTIFICATION_CHANNEL = "com.cn.beisanproject";

    private boolean firsttimeOpenMianActivity = false;

    //判断是否是处于后天状态,在true表示现在处于后台状态
    public static boolean houtai = false;



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (!Constants.DeBug) {
//            hotfix();
        }

    }

    /**
     * 热修复
     */
//    private void hotfix() {
//        SophixManager.getInstance().setContext(this)
//                .setAppVersion(Constants.VER_LOC)
//                .setSecretMetaData(ALI_HOT_APPID, ALI_HOT_APPSecre, ALI_HOT_RSA)
//                .setAesKey("123456kepu654321")
//                .setEnableDebug(true)
//                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
//                    @Override
//                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
//                        // 补丁加载回调通知
//                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
////                            ToastUtil.show(getApplicationContext(),"恭喜部分问题已经修复");
//                            // 表明补丁加载成功
//                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
//                            // 表明新补丁生效需要重启. 开发者可提示用户或者强制重启;
//                            // 建议: 用户可以监听进入后台事件, 然后应用自杀);
//                            houtai = true;
//                            //  SophixManager.getInstance().killProcessSafely();
//                        } else if (code == PatchStatus.CODE_LOAD_FAIL) {
//                            // 内部引擎异常, 推荐此时清空本地补丁, 防止失败补丁重复加载
//                            SophixManager.getInstance().cleanPatches();
//                        } else {
//                            // 其它错误信息, 查看PatchStatus类说明
//                        }
//                    }
//                }).initialize();
//    }
    @Override
    public void onCreate() {
        super.onCreate();
        disableAPIDialog();
        applicationContext = this;
        instance = this;
        // 默认设置为日间模式
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);


        String processName = getProcessName(applicationContext,
                android.os.Process.myPid());
    }

    public static MyApplication getInstance() {
        return instance;
    }


    public boolean isFirsttimeOpenMianActivity() {
        return firsttimeOpenMianActivity;
    }

    public void setFirsttimeOpenMianActivity(boolean firsttimeOpenMianActivity) {
        this.firsttimeOpenMianActivity = firsttimeOpenMianActivity;
    }


    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }



    /**
     * 反射 禁止弹窗
     */
    private void disableAPIDialog() {
        if (Build.VERSION.SDK_INT < 28) return;
        try {
            Class clazz = Class.forName("android.app.ActivityThread");
            Method currentActivityThread = clazz.getDeclaredMethod("currentActivityThread");
            currentActivityThread.setAccessible(true);
            Object activityThread = currentActivityThread.invoke(null);
            Field mHiddenApiWarningShown = clazz.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return null;
    }

}