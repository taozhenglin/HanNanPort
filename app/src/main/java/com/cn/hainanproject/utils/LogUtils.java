package com.cn.hainanproject.utils;

import android.os.Environment;
import android.util.Log;

import com.cn.hainanproject.base.Constants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by tzl on 2020/6/22.
 * log进行封装
 */

public class LogUtils {
    private static boolean isLogAll = Constants.DeBug;
    private static boolean LOGV = true;
    private static boolean LOGD = true;
    private static boolean LOGI = true;
    private static boolean LOGW = true;
    private static boolean LOGE = true;
    private static int LOG_MAXLENGTH = 10000;
    private static SimpleDateFormat logfile = new SimpleDateFormat("yyyy-MM-dd");// 日志文件格式
    private static SimpleDateFormat myLogSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 日志的输出格式
    private static String MYLOG_PATH_SDCARD_DIR = "/sdcard/kantu/log";// 日志文件在sdcard中的路径
    private static String MYLOGFILEName = "Log.txt";// 本类输出的日志文件名称








    public static void v(String tag, String mess) {
        if (LOGV && isLogAll) {
            Log.v(tag, mess);
        }
    }

    public static void d(String tag, String mess) {
        if (LOGD && isLogAll) {
            Log.d(tag, mess);
        }
    }

    public static void i(String tag, String mess) {
        if (LOGI && isLogAll) {
            Log.i(tag, mess);
        }
    }

    public static void w(String tag, String mess) {
        if (LOGW && isLogAll) {
            Log.w(tag, mess);
        }
    }

    public static void e(String tag, String mess) {
        if (LOGE && isLogAll) {
            Log.e(tag, mess);
        }
    }


//    public static void v(String mess) {
//        if (LOGV) { Log.v(getTag(), mess); }
//    }
//    public static void d(String mess) {
//        if (LOGD) { Log.d(getTag(), mess); }
//    }
//    public static void i(String mess) {
//        if (LOGI) { Log.i(getTag(), mess); }
//    }
//    public static void w(String mess) {
//        if (LOGW) { Log.w(getTag(), mess); }
//    }
//    public static void e(String mess) {
//        if (LOGE) { Log.e(getTag(), mess); }
//    }
//

    /**
     * 在调试程序时，我们会经常打印一些信息，
     * 包括方法名/行号之类的，下面一个方法就可以省去这些麻烦
     *
     * @param mess
     */
    public static void v(String mess) {
        if (LOGV && isLogAll) {
            Log.v(getTag(), buildMessage(mess));
        }
    }

    public static void d(String mess) {
        if (LOGD && isLogAll) {
            Log.d(getTag(), buildMessage(mess));
        }
    }

    public static void i(String mess) {
        if (LOGI && isLogAll) {
            Log.i(getTag(), buildMessage(mess));
        }
    }

    public static void w(String mess) {
        if (LOGW && isLogAll) {
            Log.w(getTag(), buildMessage(mess));
        }
    }

    public static void e(String mess) {
        if (LOGE && isLogAll) {
            Log.e(getTag(), buildMessage(mess));
        }
    }


    private static String getTag() {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
        String callingClass = "";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogUtils.class)) {
                callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass
                        .lastIndexOf('.') + 1);
                break;
            }
        }
        return callingClass;
    }


    private static String buildMessage(String msg) {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
        String caller = "";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogUtils.class)) {
                caller = trace[i].getMethodName();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Thread.currentThread()
                .getId(), caller, msg);
    }

    public static void longD(String tagName, String msg) {
        if (true) {
            int strLength = msg.length();
            int start = 0;
            int end = LOG_MAXLENGTH;
            for (int i = 0; i < msg.length(); i++) {
                if (strLength > end) {
                    Log.d(tagName + i, msg.substring(start, end));
                    start = end;
                    end = end + LOG_MAXLENGTH;
                } else {
                    Log.d(tagName + i, msg.substring(start, strLength));
                    break;
                }
            }
        }


    }
    /**

     * 打开日志文件并写入日志

     * @param mylogtype

     * @param tag

     * @param text

     */

    private static void writeLogtoFile(String mylogtype, String tag, String text) {// 新建或打开日志文件

        Date nowtime = new Date();

        String needWriteFiel = logfile.format(nowtime);

        String needWriteMessage = myLogSdf.format(nowtime) + "    " + mylogtype + "    " + tag + "    " + text;

        File dirPath = Environment.getExternalStorageDirectory();



        File dirsFile = new File(MYLOG_PATH_SDCARD_DIR);

        if (!dirsFile.exists()){

            dirsFile.mkdirs();

        }

        //Log.i("创建文件","创建文件");

        File file = new File(dirsFile.toString(), needWriteFiel + MYLOGFILEName);// MYLOG_PATH_SDCARD_DIR

        if (!file.exists()) {

            try {

                //在指定的文件夹中创建文件

                file.createNewFile();

            } catch (Exception e) {

            }

        }



        try {

            FileWriter filerWriter = new FileWriter(file, true);// 后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖

            BufferedWriter bufWriter = new BufferedWriter(filerWriter);

            bufWriter.write(needWriteMessage);

            bufWriter.newLine();

            bufWriter.close();

            filerWriter.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}