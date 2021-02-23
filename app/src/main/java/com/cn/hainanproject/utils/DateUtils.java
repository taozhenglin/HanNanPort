package com.cn.hainanproject.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;


import com.cn.hainanproject.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Created by luhaixu on 2017/4/17.
 */
public class DateUtils {

    /*
     * 将时间戳转换为时间（时间戳为10位）
     */
    public static String stampToDate(String s) {
        if (TextUtils.isEmpty(s)) {
            return s;
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt * 1000);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String stampToDate2(String s) {
        if (TextUtils.isEmpty(s)) {
            return s;
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        long lt = new Long(s);
        Date date = new Date(lt * 1000);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String stampToDate1(String s) {
        if (TextUtils.isEmpty(s)) {
            return s;
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM");
        long lt = new Long(s);
        Date date = new Date(lt * 1000);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyyMMdd HH:mm:ss
     */
    public static String getStringDate1() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyyMMdd HH:mm:ss
     */
    public static String getStringDate2() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    /*
     * 将时间戳转换为时间（时间戳为10位）
     */
    public static String stampToDateHH(String s) {
        if (TextUtils.isEmpty(s)) {
            return s;
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt * 1000);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String stampToDateMeeting(String s) {
        if (TextUtils.isEmpty(s)) {
            return s;
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        long lt = new Long(s);
        Date date = new Date(lt * 1000);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String stampToDateMeet(String s) {
        if (TextUtils.isEmpty(s)) {
            return s;
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt * 1000);
        res = simpleDateFormat.format(date);
        return res;
    }

    @SuppressWarnings("deprecation")
    public static String getDistanceTime(String time) {
        if (TextUtils.isEmpty(time)) {
            return time;
        }
        long time2 = new Long(time);
        Date now = new Date();
        long day = 0;//天数
        long hour = 0;//小时
        long min = 0;//分钟
        long sec = 0;//秒
        try {
            long time1 = now.getTime();
            time2 = time2 * 1000l;
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000));
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String rs = "";
        if (min == 0) {
            rs = "刚刚";
            return rs;
        }
        if (hour == 0) {
            rs = min + "分钟前";
            return rs;
        }
        if (day == 0 && hour <= 4) {
            rs = hour + "小时前";
            return rs;
        }
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");//
        String d = format.format(time2);
        Date date = null;
        try {
            date = format.parse(d);//把字符类型的转换成日期类型的！
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        if (now.getDate() - date.getDate() == 0) {//当前时间和时间戳转换来的时间的天数对比
            DateFormat df2 = new SimpleDateFormat("HH:mm");
            rs = "今天  " + df2.format(time2);
            return rs;
        } else if (now.getDate() - date.getDate() == 1) {
            DateFormat df2 = new SimpleDateFormat("HH:mm");
            rs = "昨天  " + df2.format(time2);
            return rs;
        } else {
            DateFormat df2 = new SimpleDateFormat("MM月dd日 HH:mm");
            rs = df2.format(time2);
            return rs;
        }
    }


    public static String getDistanceTimenewChat(Context contenxt, String time) {
        if (TextUtils.isEmpty(time)) {
            return time;
        }
        long time2 = new Long(time);
        Date now = new Date();
        long day = 0;//天数
        long hour = 0;//小时
        long min = 0;//分钟
        long sec = 0;//秒
        try {
            long time1 = now.getTime();
            time2 = time2 * 1000l;
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000));
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String rs = "";

        ContentResolver mResolver = contenxt.getContentResolver();
//获得系统时间制
        String timeFormat = android.provider.Settings.System.getString(mResolver, android.provider.Settings.System.TIME_12_24);
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");//
        String d = format.format(time2);
        Date date = null;
        boolean is24 = true;
        if (is24(contenxt)) {
            is24 = true;

        } else {
            is24 = false;
        }
        try {
            date = format.parse(d);//把字符类型的转换成日期类型的！
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        if (now.getDate() - date.getDate() == 0) {//当前时间和时间戳转换来的时间的天数对比

            DateFormat df2 = new SimpleDateFormat(!is24 ? "a hh:mm" : "HH:mm");
            rs = df2.format(time2);
            return rs;


        } else if (now.getDate() - date.getDate() == 1) {
            DateFormat df2 = new SimpleDateFormat(!is24 ? "a hh:mm" : "HH:mm");
            rs = "昨天" + df2.format(time2);
            return rs;
        } else if (now.getDate() - date.getDate() < 7) {
            DateFormat df2 = new SimpleDateFormat(!is24 ? "EEEE  a hh:mm" : "EEEE HH:mm");
            rs = df2.format(time2);
            return rs;
        } else {

            DateFormat df2 = new SimpleDateFormat(!is24 ? "yyyy年MM月dd日 a hh:mm" : "yyyy年MM月dd日 HH:mm");
            rs = df2.format(time2);
            return rs;

        }
    }

    public static boolean is24(Context ctx) {
        ContentResolver cv = ctx.getContentResolver();
        String strTimeFormat = android.provider.Settings.System.getString(cv,
                android.provider.Settings.System.TIME_12_24);
        if (strTimeFormat != null && "24".equals(strTimeFormat)) {//strTimeFormat某些rom12小时制时会返回null
            return true;
        } else return false;
    }


    /**
     * 获取系统10位的系统时间，精确到秒数
     *
     * @return
     */
    public static long getCurrentTimeStamp() {
        return System.currentTimeMillis();
    }

    /**
     * 计算时间差
     *
     * @param starTime 开始时间
     * @param endTime  结束时间
     *                 返回类型 ==1----天，时，分。 ==2----时
     * @return 返回时间差
     */
    public static String getTimeDifference(Context context, long starTime, long endTime) {
        String timeString = "";
        try {
            Date parse = new Date(starTime);
            Date parse1 = new Date(endTime);
            long diff = parse1.getTime() - parse.getTime();

            long day = diff / (24 * 60 * 60 * 1000);
            long hour = (diff / (60 * 60 * 1000) - day * 24);
            long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            long ms = (diff - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
                    - min * 60 * 1000 - s * 1000);
            long hour1 = diff / (60 * 60 * 1000);
            long min1 = ((diff / (60 * 1000)) - hour1 * 60);
            if (day == 0) {
                if (hour1 == 0) {
                    if (0 <= min1 && min1 <= 5) {
                        timeString = context.getString(R.string.just);
                    } else if (min1 > 5 && min1 <= 15) {
                        timeString = context.getString(R.string.just_15);
                    } else if (min1 > 15 && min1 <= 30) {
                        timeString = context.getString(R.string.just_30);
                    } else {
                        timeString = context.getString(R.string.just_1hour);
                    }
                } else {
                    timeString = hour1 + context.getString(R.string.An_hour_ago);
                }
            } else {
                timeString = day + context.getString(R.string.Days_ago);
            }

            Log.d("slj", day + "天" + hour + "小时" + min + "分" + s + "秒");

        } catch (Exception e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;

    }

    /**
     * 时间比对
     */
    public static boolean getTimeDifference(String currenttime, String endTime) {
        if (TextUtils.isEmpty(currenttime) || TextUtils.isEmpty(endTime)) {
            return false;
        }
        long diff;
        Date parse1 = null;
        Date parse2 = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            parse1 = dateFormat.parse(currenttime);
            parse2 = dateFormat.parse(endTime);
//            diff = parse1.getTime() - parse2.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("222222", "currenttime=" + currenttime + "   endTime" + endTime);
        if (parse1.getTime() > parse2.getTime()) {
            Log.d("222222", "点击的是以前的日子");
        } else {
            Log.d("222222", "点击的是今天以及以后的日子");
        }
        return parse1.getTime() > parse2.getTime();

    }


    public static String getTimestampString(Date var0) {
        if (var0 == null) {
            return "";
        }
        String var1 = null;
        String var2 = Locale.getDefault().getLanguage();
        boolean var3 = var2.startsWith("zh");
        long var4 = var0.getTime();
        if (isSameDay(var4)) {
            if (var3) {
                var1 = "aa hh:mm";
            } else {
                var1 = "hh:mm aa";
            }
        } else if (isYesterday(var4)) {
            if (!var3) {
                return "Yesterday " + (new SimpleDateFormat("hh:mm aa", Locale.ENGLISH)).format(var0);
            }

            var1 = "昨天aa hh:mm";
        } else if (var3) {
            var1 = "M月d日aa hh:mm";
        } else {
            var1 = "MMM dd hh:mm aa";
        }

        return var3 ? (new SimpleDateFormat(var1, Locale.CHINESE)).format(var0) : (new SimpleDateFormat(var1, Locale.ENGLISH)).format(var0);
    }

    public static boolean isCloseEnough(long var0, long var2) {
        long var4 = var0 - var2;
        if (var4 < 0L) {
            var4 = -var4;
        }

        return var4 < 30000L;
    }

    private static boolean isSameDay(long var0) {
        TimeInfo var2 = getTodayStartAndEndTime();
        return var0 > var2.getStartTime() && var0 < var2.getEndTime();
    }

    private static boolean isYesterday(long var0) {
        TimeInfo var2 = getYesterdayStartAndEndTime();
        return var0 > var2.getStartTime() && var0 < var2.getEndTime();
    }

    public static Date StringToDate(String var0, String var1) {
        SimpleDateFormat var2 = new SimpleDateFormat(var1);
        Date var3 = null;

        try {
            var3 = var2.parse(var0);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return var3;
    }

    public static String toTime(int var0) {
        var0 /= 1000;
        int var1 = var0 / 60;
        boolean var2 = false;
        if (var1 >= 60) {
            int var4 = var1 / 60;
            var1 %= 60;
        }

        int var3 = var0 % 60;
        return String.format("%02d:%02d", new Object[]{Integer.valueOf(var1), Integer.valueOf(var3)});
    }

    public static String toTimeBySecond(int var0) {
        int var1 = var0 / 60;
        boolean var2 = false;
        if (var1 >= 60) {
            int var4 = var1 / 60;
            var1 %= 60;
        }

        int var3 = var0 % 60;
        return String.format("%02d:%02d", new Object[]{Integer.valueOf(var1), Integer.valueOf(var3)});
    }


    public static TimeInfo getYesterdayStartAndEndTime() {
        Calendar var0 = Calendar.getInstance();
        var0.add(Calendar.DAY_OF_MONTH, -1);//5
        var0.set(Calendar.HOUR_OF_DAY, 0);//11
        var0.set(Calendar.MINUTE, 0);//12
        var0.set(Calendar.SECOND, 0);//13
        var0.set(Calendar.MILLISECOND, 0);//Calendar.MILLISECOND
        Date var1 = var0.getTime();
        long var2 = var1.getTime();
        Calendar var4 = Calendar.getInstance();
        var4.add(Calendar.DAY_OF_MONTH, -1);//5
        var4.set(Calendar.HOUR_OF_DAY, 23);//11
        var4.set(Calendar.MINUTE, 59);//12
        var4.set(Calendar.SECOND, 59);//13
        var4.set(Calendar.MILLISECOND, 999);//Calendar.MILLISECOND
        Date var5 = var4.getTime();
        long var6 = var5.getTime();
        TimeInfo var8 = new TimeInfo();
        var8.setStartTime(var2);
        var8.setEndTime(var6);
        return var8;
    }

    public static TimeInfo getTodayStartAndEndTime() {
        Calendar var0 = Calendar.getInstance();
        var0.set(Calendar.HOUR_OF_DAY, 0);
        var0.set(Calendar.MINUTE, 0);
        var0.set(Calendar.SECOND, 0);
        var0.set(Calendar.MILLISECOND, 0);
        Date var1 = var0.getTime();
        long var2 = var1.getTime();
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
        Calendar var5 = Calendar.getInstance();
        var5.set(Calendar.HOUR_OF_DAY, 23);
        var5.set(Calendar.MINUTE, 59);
        var5.set(Calendar.SECOND, 59);
        var5.set(Calendar.MILLISECOND, 999);
        Date var6 = var5.getTime();
        long var7 = var6.getTime();
        TimeInfo var9 = new TimeInfo();
        var9.setStartTime(var2);
        var9.setEndTime(var7);
        return var9;
    }

    public static TimeInfo getBeforeYesterdayStartAndEndTime() {
        Calendar var0 = Calendar.getInstance();
        var0.add(Calendar.DAY_OF_MONTH, -2);
        var0.set(Calendar.HOUR_OF_DAY, 0);
        var0.set(Calendar.MINUTE, 0);
        var0.set(Calendar.SECOND, 0);
        var0.set(Calendar.MILLISECOND, 0);
        Date var1 = var0.getTime();
        long var2 = var1.getTime();
        Calendar var4 = Calendar.getInstance();
        var4.add(Calendar.DAY_OF_MONTH, -2);
        var4.set(Calendar.HOUR_OF_DAY, 23);
        var4.set(Calendar.MINUTE, 59);
        var4.set(Calendar.SECOND, 59);
        var4.set(Calendar.MILLISECOND, 999);
        Date var5 = var4.getTime();
        long var6 = var5.getTime();
        TimeInfo var8 = new TimeInfo();
        var8.setStartTime(var2);
        var8.setEndTime(var6);
        return var8;
    }

    public static TimeInfo getCurrentMonthStartAndEndTime() {
        Calendar var0 = Calendar.getInstance();
        var0.set(Calendar.DATE, 1);
        var0.set(Calendar.HOUR_OF_DAY, 0);
        var0.set(Calendar.MINUTE, 0);
        var0.set(Calendar.SECOND, 0);
        var0.set(Calendar.MILLISECOND, 0);
        Date var1 = var0.getTime();
        long var2 = var1.getTime();
        Calendar var4 = Calendar.getInstance();
        Date var5 = var4.getTime();
        long var6 = var5.getTime();
        TimeInfo var8 = new TimeInfo();
        var8.setStartTime(var2);
        var8.setEndTime(var6);
        return var8;
    }

    public static TimeInfo getLastMonthStartAndEndTime() {
        Calendar var0 = Calendar.getInstance();
        var0.add(Calendar.MONTH, -1);
        var0.set(Calendar.DATE, 1);
        var0.set(Calendar.HOUR_OF_DAY, 0);
        var0.set(Calendar.MINUTE, 0);
        var0.set(Calendar.SECOND, 0);
        var0.set(Calendar.MILLISECOND, 0);
        Date var1 = var0.getTime();
        long var2 = var1.getTime();
        Calendar var4 = Calendar.getInstance();
        var4.add(Calendar.MONTH, -1);
        var4.set(Calendar.DATE, 1);
        var4.set(Calendar.HOUR_OF_DAY, 23);
        var4.set(Calendar.MINUTE, 59);
        var4.set(Calendar.SECOND, 59);
        var4.set(Calendar.MILLISECOND, 999);
        var4.roll(Calendar.DATE, -1);
        Date var5 = var4.getTime();
        long var6 = var5.getTime();
        TimeInfo var8 = new TimeInfo();
        var8.setStartTime(var2);
        var8.setEndTime(var6);
        return var8;
    }

    public static String getStringTime(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sdf.format(date);
        return startTime;
    }

    public static String getTimestampStr() {
        return Long.toString(System.currentTimeMillis());
    }


    public static class TimeInfo {
        private long startTime;
        private long endTime;

        public TimeInfo() {
        }

        public long getStartTime() {
            return this.startTime;
        }

        public void setStartTime(long var1) {
            this.startTime = var1;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public void setEndTime(long var1) {
            this.endTime = var1;
        }
    }


    public static int getWeekByDateStr(String strDate) {
        if (TextUtils.isEmpty(strDate)) {
            return -1;
        }
        int num = 0;
        int year = Integer.parseInt(strDate.substring(0, 4));
        int month = Integer.parseInt(strDate.substring(5, 7));
        int day = Integer.parseInt(strDate.substring(8, 10));

        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);

        String week = "";
        int weekIndex = c.get(Calendar.DAY_OF_WEEK);

        switch (weekIndex) {
            case 1:
                week = "SUNDAY";//周日
                num = 0;
                break;
            case 2:
                week = "MONDAY";//周一
                num = 1;
                break;
            case 3:
                week = "TUESDAY";//周二
                num = 2;
                break;
            case 4:
                week = "WEDNESDAY";//周三
                num = 3;
                break;
            case 5:
                week = "THURSDAY";//周四
                num = 4;
                break;
            case 6:
                week = "FRIDAY";//周五
                num = 5;
                break;
            case 7:
                week = "SATURDAY";//周六
                num = 6;
                break;
            default:
                break;
        }
        Log.d("222222", "week=" + week + "            num=" + num);
        return num;
    }


}
