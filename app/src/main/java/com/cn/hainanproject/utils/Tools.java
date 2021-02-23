package com.cn.hainanproject.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import com.cn.hainanproject.base.Constants;
import com.cn.hainanproject.base.MyApplication;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.SENSOR_SERVICE;


/**
 * APP内部方法类
 */
public class Tools {
    /**
     * 判断当前手机设备是否已经联网
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断是否存在光传感器来判断是否为模拟器
     * 部分真机也不存在温度和压力传感器。其余传感器模拟器也存在。
     *
     * @return true 为模拟器
     */
    public static Boolean notHasLightSensorManager(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        Sensor sensor8 = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT); //光
        if (null == sensor8) {
            return true;
        } else {
            return false;
        }
    }


    /*** 判断蓝牙是否有效来判断是否为模拟器* * @return true 为模拟器*/
    public static boolean notHasBlueTooth() {
        BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
        if (ba == null) {
            return true;
        } else {// 如果有蓝牙不一定是有效的。获取蓝牙名称，若为null 则默认为模拟器       
            String name = ba.getName();
            if (TextUtils.isEmpty(name)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 判断是否包含SIM卡
     *
     * @return 状态
     */
    public static boolean ishasSimCard(Context context) {
        TelephonyManager telMgr = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
        int simState = telMgr.getSimState();
        boolean result = true;
        switch (simState) {
            case TelephonyManager.SIM_STATE_ABSENT:
                result = false; // 没有SIM卡
                break;
            case TelephonyManager.SIM_STATE_UNKNOWN:
                result = false;
                break;
        }
        return result;
    }


    /**
     * 判断当前手机设备是否已经联网
     * wifi返回      1
     * 移动数据返回  2
     * 没网返回      0
     */
    public static int getNetworkState(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        // Wifi
        NetworkInfo.State state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return Constants.NETWORN_WIFI;
        }

        // 3G

        state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return Constants.NETWORN_MODEL;
        }
        return Constants.NETWORN_NONE;
    }


    /**
     * 判断当前手机设备是否在wifi的环境下
     */
    public static boolean isWifiConnected(Context context) {
        if (context != null) {

            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mNetworkInfo.isAvailable() && mNetworkInfo.isConnected()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 获取手机设备信息
     */
    public static String getPhoneInfo() {
        String equipmentName = null;
        String mtype = Build.MODEL;// 手机型号
        String mtyb = Build.BRAND;//手机品牌
        equipmentName = mtyb + " " + mtype;
        return equipmentName;
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }


    /**
     * 获取当前应用的版本名称
     */
    public static String getVersionName(Context mContext) throws Exception {
        PackageManager mPackageManager = mContext.getPackageManager();
        PackageInfo mPackInfo = mPackageManager.getPackageInfo(mContext.getPackageName(), 0);
        return mPackInfo.versionName;
    }

    /**
     * 获取当前应用的版本号
     */
    public static int getVersionCode(Context mContext) throws Exception {
        PackageManager mPackageManager = mContext.getPackageManager();
        PackageInfo mPackInfo = mPackageManager.getPackageInfo(mContext.getPackageName(), 0);
        return mPackInfo.versionCode;
    }

    /**
     * 获取设备的UUID
     *
     * @param context
     * @return
     */
    @SuppressLint("HardwareIds")
    public static String getUUID(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, androidId;
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {

            assert tm != null;
            tmDevice = "" + tm.getDeviceId();
            tmSerial = "" + tm.getSimSerialNumber();
            androidId = "" + Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
            return deviceUuid.toString();
        } else {
            androidId = "" + Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            return androidId;
        }
    }

    /**
     * 包装Toast
     *
     * @param context         - 当前上下文
     * @param customdataresid - 提示内容STRING资源ID
     * @author hly
     */
    public static void CustomToast(Context context, int customdataresid) {
        Toast mToast = null;
        if (context != null) {
            if (mToast == null) mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
            mToast.setText(context.getResources().getString(customdataresid));
            mToast.show();
        }
    }


    /**
     * 匹配后的文本点击事件
     *
     * @author hly
     */
    public static class LinkTouchMovementMethod extends LinkMovementMethod {
        private static LinkTouchMovementMethod sInstance;
        private static int mColorNormal;
        private static int mColorPress;
        private ClickableSpan mPressedSpan;

        public static MovementMethod getInstance(int colorNormal, int colorPress) {
            if (sInstance == null) {
                sInstance = new LinkTouchMovementMethod();
                mColorNormal = colorNormal;
                mColorPress = colorPress;
            }
            return sInstance;
        }

        private ClickableSpan getPressedSpan(TextView textView, Spannable buffer, MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            x -= textView.getTotalPaddingLeft();
            y -= textView.getTotalPaddingTop();
            x += textView.getScrollX();
            y += textView.getScrollY();
            Layout layout = textView.getLayout();
            int line = layout.getLineForVertical(y);
            int off = layout.getOffsetForHorizontal(line, x);
            ClickableSpan[] link = buffer.getSpans(off, off, ClickableSpan.class);
            if (link.length > 0) {
                return link[0];
            }
            return null;
        }

        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
            int action = event.getAction();
            LinearLayout parent = (LinearLayout) widget.getParent();
            if (action == MotionEvent.ACTION_DOWN) {
                mPressedSpan = getPressedSpan(widget, buffer, event);
                if (mPressedSpan != null) {
                    buffer.setSpan(new ForegroundColorSpan(mColorPress), buffer.getSpanStart(mPressedSpan), buffer.getSpanEnd(mPressedSpan), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Selection.setSelection(buffer, buffer.getSpanStart(mPressedSpan), buffer.getSpanEnd(mPressedSpan));
                    return true;
                }
            } else if (action == MotionEvent.ACTION_MOVE) {
                ClickableSpan clickableSpan = getPressedSpan(widget, buffer, event);
                if (mPressedSpan != null && mPressedSpan != clickableSpan) {
                    buffer.setSpan(new ForegroundColorSpan(mColorNormal), buffer.getSpanStart(mPressedSpan), buffer.getSpanEnd(mPressedSpan), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Selection.removeSelection(buffer);
                    mPressedSpan = null;
                    return true;
                }
            } else {
                if (mPressedSpan != null) {
                    mPressedSpan.onClick(widget);
                    buffer.setSpan(new ForegroundColorSpan(mColorNormal), buffer.getSpanStart(mPressedSpan), buffer.getSpanEnd(mPressedSpan), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Selection.removeSelection(buffer);
                    mPressedSpan = null;
                }
            }
            parent.onTouchEvent(event);
            return Touch.onTouchEvent(widget, buffer, event);
        }
    }
    /**
     * 动态内容转换(匹配表情以及相关事件添加)
     * @param text - 文本内容
     * @return - {@link SpannableString}
     *
     * @author hly
     */
    /*public static SpannableString replaceText(Context context, String text) {
        Emotions mEmotions = null;
		Pattern mPattern = Pattern.compile("\\[([^\\]]+)\\]");
		Matcher mMatcher = mPattern.matcher(text);
		SpannableString mSString = new SpannableString(text);
		while (mMatcher.find()) {
			if (mEmotions == null) {
				mEmotions = new Emotions();
			}
			Integer mExpressionDraId = mEmotions.emotions.get(mMatcher.group());
			if (mExpressionDraId != null) {
				Drawable mDrawable = context.getResources().getDrawable(mExpressionDraId);
				mDrawable.setBounds(0, 0, (int) ((context.getResources().getDisplayMetrics().density) * 18 + 0.5f), (int) ((context.getResources().getDisplayMetrics().density) * 18 + 0.5f));
				mSString.setSpan(new CustomImageSpan(mDrawable), mMatcher.start(), mMatcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
		mPattern = Pattern.compile("#[^#]+#");
		mMatcher = mPattern.matcher(text);
		while (mMatcher.find()) {
			mSString.setSpan(new TagClickableSpan(context, mMatcher.group()), mMatcher.start(), mMatcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			mSString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.dynamic_content_clickablespan_backselector)), mMatcher.start(), mMatcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
		return mSString;
	}*/


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        if (null != context && dpValue > 0) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        } else {
            return (int) dpValue;
        }

    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将 sp 转换为 px， 保证尺寸大小不变
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int sp2px(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue * fontScale + 0.5f);
    }

    /**
     * 该方法会自动判断当前屏幕上是否有软键盘，
     * 如果有，就隐藏，如没有，就显示软键盘
     */
    public static void controlSoftKeyboard(Context context) {
        // 获取InputMethodManager的实例
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 若界面上软键盘打开，则关闭界面上的软键盘
     *
     * @author HuangHaiFei
     * @date 2015-4-8
     */
    public static void closeSoftKeyBoard(Activity activity) {
        View view = activity.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void showSoftKeyboardLate(Activity context, EditText editText) {
        if (editText == null || context == null) return;
        InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);

    }


    /**
     * EditText获取焦点，并将软键盘打开
     */
    public static void setEditTextFocusable(Context context, EditText et) {
        et.setFocusable(true);
        et.setFocusableInTouchMode(true);
        et.requestFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (et != null)
            imm.showSoftInput(et, InputMethodManager.SHOW_FORCED);
    }

    /**
     * EditText失去焦点，并关闭软键盘
     */
    public static void setViewFocusable(Context context, EditText et, View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        et.clearFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (et != null)
            imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }

    /**
     * 验证中英文
     *
     * @author HuangHaiFei
     * @date 2015-5-19
     */
    public static boolean verification(String str) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\u4e00-\u9fa5]+$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    /**
     * 判断手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNum(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isPhoneNum(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\\\d{8}$");
        Matcher m = p.matcher(mobiles);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证是否含有特殊字符
     * 只含有汉字、数字、字母、 下划线位置不限
     * 若含有特殊字符，则返回false
     */
    public static boolean isChcek(String str) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9-\\_\\·\u4e00-\u9fa5-]+$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    /**
     * 验证是否含有特殊字符
     *
     * @author HuangHaiFei
     * @date 2014-12-11
     * 只含有数字、字母
     * 若含有特殊字符，则返回false
     */
    public static boolean isCheckPsd(String str) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }


    /**
     * 字体加粗
     *
     * @author HuangHaiFei
     * @date 2015-7-30
     */
    public static void bold(TextView textView) {
        TextPaint tp = textView.getPaint();
        tp.setFakeBoldText(true);
    }

    /**
     * 把date转换为String
     */
    public static String dateString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String dateString = sdf.format(date);
        return dateString;
    }

    /**
     * 把date转换为String
     */
    public static String dateString2(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String dateString = sdf.format(date);
        return dateString;
    }

    public static String dateToString(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd", Locale.getDefault());
        String dateString = sdf.format(date);
        return dateString;
    }


    //    /**
    //     * 把String 数据转换为date
    //     */
    //    public static Date stringToDate(String dateStr) throws java.text.ParseException {
    //            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
    //            Date date = sdf.parse(dateStr);
    //            return date;
    //    }

    public static CharSequence noTrailingwhiteLines(CharSequence text) {

        while (text.charAt(text.length() - 1) == '\n') {
            text = text.subSequence(0, text.length() - 1);
        }
        return text;
    }

    /**
     * MD5加密
     *
     * @author HuangHaiFei
     * @date 2015-4-1
     */
    public static String getMD5(String value) {
        MessageDigest md = null;
        try {
            byte[] valueByte = value.getBytes();
            md = MessageDigest.getInstance("MD5");
            md.update(valueByte);
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        if (md != null) {
            return toHex(md.digest());
        } else {
            return null;
        }
    }

    // 将传递进来的字节数组转换成十六进制的字符串形式并返回
    private static String toHex(byte[] buffer) {
        StringBuffer sb = new StringBuffer(buffer.length * 2);
        for (int i = 0; i < buffer.length; i++) {
            sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
            sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
        }
        return sb.toString();
    }

    /**
     * 半角全角化
     *
     * @param input - 待转的字符串
     * @return 全角字符串
     */
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * 判断是否是发送手机验证码的号码
     * 以106开头的号码
     *
     * @param mobile
     * @return
     * @author HuangHaiFei
     */
    public static boolean isMobileCode(String mobile) {
        Pattern p = Pattern.compile("^106\\d+$");
        Matcher m = p.matcher(mobile);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取屏幕宽度
     */
    public static int getheight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }

    /**
     * 保存在手机里面的文件名
     */
    private static final String FILE_NAME = "share_date";


    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    public static void setSP(Context context, String key, Object object) {

        String type = object.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if ("String".equals(type)) {
            editor.putString(key, (String) object);
        } else if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) object);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) object);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) object);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) object);
        }

        editor.commit();
    }


    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object getSP(Context context, String key, Object defaultObject) {
        String type = defaultObject.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        if ("String".equals(type)) {
            return sp.getString(key, (String) defaultObject);
        } else if ("Integer".equals(type)) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if ("Boolean".equals(type)) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if ("Float".equals(type)) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if ("Long".equals(type)) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }

    private static String[] known_qemu_drivers = {"goldfish"};

    /**
     * 检查驱动文件判断是否是模拟器
     *
     * @return
     */
    public static Boolean CheckQEmuDriverFile() {
        File driver_file = new File("/proc/tty/drivers");
        if (driver_file.exists() && driver_file.canRead()) {
            byte[] data = new byte[(int) driver_file.length()];
            try {
                InputStream inStream = new FileInputStream(driver_file);
                inStream.read(data);
                inStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String driver_data = new String(data);
            for (String known_qemu_driver : known_qemu_drivers) {
                if (driver_data.indexOf(known_qemu_driver) != -1) {

                    return true;
                }
            }
        }

        return false;
    }


    private static String readCpuInfo() {
        String result = "";
        try {
            String[] args = {"/system/bin/cat", "/proc/cpuinfo"};
            ProcessBuilder cmd = new ProcessBuilder(args);

            Process process = cmd.start();
            StringBuffer sb = new StringBuffer();
            String readLine = "";
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
            while ((readLine = responseReader.readLine()) != null) {
                sb.append(readLine);
            }
            responseReader.close();
            result = sb.toString().toLowerCase();
        } catch (Exception ex) {
        }
        return result;
    }

    /**
     * 通过读取模拟器CPU的信息获取是模拟器还是真机
     *
     * @return true是模拟器, false是真机
     */
    public static boolean checkCupInfo() {
        String cpuInfo = readCpuInfo();
        if ((cpuInfo.contains("intel") || cpuInfo.contains("amd"))) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * javabean to json
     *
     * @return
     */
//    public static <T> String javabeanToJson(T t) {
//        Gson gson = new Gson();
//        String json = gson.toJson(t);
//        return json;
//    }

    /**
     * json to javabean
     *
     * @param json
     */
   /* public static <T> T  jsonToJavaBean(String json,T t) {
        Gson gson = new Gson();
         t = gson.fromJson(json, t.class);//对于javabean直接给出class实例
        return t;
    }*/

    /**
     * 得到自定义的progressDialog
     *
     * @param context
     * @param msg
     * @return
     */
//    public static Dialog createLoadingDialog(Context context, String msg) {
//
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
//        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
//        // main.xml中的ImageView
//        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
//        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
//        // 加载动画
//        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
//                context, R.anim.loading_animation);
//        // 使用ImageView显示动画
//        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
//        tipTextView.setText(msg);// 设置加载信息
//
//        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
//
//        loadingDialog.setCancelable(false);// 不可以用“返回键”取消
//        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
//
//
//        return loadingDialog;
//    }

    /**
     * 关闭dialog
     */
    public static void closeDialog(Dialog mDialog) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }


    /**
     * URL加密串
     *
     * @return 加密后的串
     */
    /**
     * URL加密串
     *
     * @return 加密后的串
     */
    @SuppressLint("HardwareIds")
//    public static synchronized String getSignHttpSign
//    (TreeMap<String, String> mapA, String path) {
//        String sn = "";
//        String time = System.currentTimeMillis() / 1000 + "";
//        Constants.NEW_URL = Constants.BASE_URL + path + "?timestamp=" + time;
//        TreeMap<String, String> map = new TreeMap<>();
//        map.put("timestamp", time);
//        map.put("path", path);
//        map.put("v", Constants.VER_LOC);
//        map.put("from", Constants.ANROID);
//        map.put("unique_identifier", Build.SERIAL);
//
//        if (!Tools.getUUID(MyApplication.getInstance().getApplicationContext()).equals("")) {
//            map.put("uuid", Tools.getUUID(MyApplication.getInstance().getApplicationContext()));
//        }
//
//        if (!SharedPreferencesUtil.getString(MyApplication.getInstance().getApplicationContext(), Constants.TOKEN).equals("")) {
//            map.put("token", SharedPreferencesUtil.getString(MyApplication.getInstance().getApplicationContext(), Constants.TOKEN));
//        }
//        map.putAll( );
//
//        Iterator<String> iter = map.keySet().iterator();
//
//        while (iter.hasNext()) {
//
//            String key = iter.next();
//            String value = map.get(key);
//
//            if (sn.length() > 0) {
//                sn = sn + "&" + key + "=" + value;
//            } else {
//                sn = key + "=" + value;
//            }
//        }
//
//        sn = sn + "&secretkey=PC3937!@*&YZF";
//        sn = getMD5(getMD5(sn));
//        return sn + "";
//    }


    /**
     * 判断对象的字符字符串是否为空的
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (null != str && !"".equals(str)) {
            return false;
        }
        return true;
    }


    /**
     * 拼接Url
     *
     * @param
     * @return
     */
    public static String changeUrl(Context context, String url) {
        if (SharedPreferencesUtil.getObject(context, "ParamMapSetting") != null) {

            Map<String, String> map = (Map<String, String>) SharedPreferencesUtil.getObject(context, "ParamMapSetting");
            if (map.size() > 0) {
                Set set = map.keySet();
                Iterator iterator = set.iterator();

                while (iterator.hasNext()) {
                    String key = (String) iterator.next();

                    if (url.contains(key)) {
                        String value = map.get(key);
                        if (url.contains("?")) {
                            url = url + "&" + value;
                        } else {
                            url = url + "?" + value;
                        }
                    }
                }
            }
        }
        if (null != Build.SERIAL) {

            if (url.contains("?")) {
                url = url + "&unique_identifier=" + Build.SERIAL;
            } else {
                url = url + "?unique_identifier=" + Build.SERIAL;
            }
        }
        return url;
    }


    /**
     * 拼接Url
     *
     * @param
     * @return
     */
//    public static String urlToken(Context context, String url) {
//
//        if (null != SharedPreferencesUtil.getString(MyApplication.getInstance().getApplicationContext(), Constants.TOKEN)) {
//
//            String token = SharedPreferencesUtil.getString(MyApplication.getInstance().getApplicationContext(), Constants.TOKEN);
//
//            if (url.contains("token")) {
//                return url;
//            } else {
//                if (url.contains("?")) {
//                    url = url + "&token=" + token;
//                } else {
//                    url = url + "?token=" + token;
//                }
//            }
//        }
//        return url;
//    }


//    public static String urlvison(Context context, String url) {
//        String verLoc = Constants.VER_LOC;
//        if (url.contains("version")) {
//            return url;
//        } else {
//            if (url.contains("?")) {
//                url = url + "&version=" + verLoc;
//            } else {
//                url = url + "?version=" + verLoc;
//            }
//        }
//        Log.d("222222", "urlvison  url = " + url);
//        return url;
//    }


    public static String urlunique_identifier(Context context, String url) {
        String unique_identifier = Build.SERIAL;
        if (url.contains("unique_identifier")) {
            return url;
        } else {
            if (url.contains("?")) {
                url = url + "&unique_identifier=" + unique_identifier;
            } else {
                url = url + "?unique_identifier=" + unique_identifier;
            }
        }
        return url;
    }


    public static String dateToStringThree() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String dateString = sdf.format(System.currentTimeMillis());
        String[] strs = dateString.split("-");
        String datafinal = strs[0] + "/" + strs[1] + "/" + strs[2] + "/";
        return datafinal;
    }


    // 获取渠道号
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getChannel() {
        String channel = "";
        try {
            ApplicationInfo info = MyApplication.getInstance().getApplicationContext().getPackageManager().getApplicationInfo(MyApplication.getInstance().getApplicationContext().getPackageName(), PackageManager.GET_META_DATA);
            if (info != null && info.metaData != null) {
                String metaData = info.metaData.getString("UMENG_CHANNEL");
                if (!metaData.isEmpty()) {
                    channel = metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channel;
    }


    //设置状态栏颜色 true 是黑色 false 是白色
    public static void changStatusIconCollor(Activity context, boolean setDark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decorView = context.getWindow().getDecorView();
            if (decorView != null) {
                int vis = decorView.getSystemUiVisibility();
                if (setDark) {
                    vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                } else {
                    vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                }
                decorView.setSystemUiVisibility(vis);
            }
        }
    }

    /**
     * 将数字类型的字符串转换为带两个小数点的字符串 如 15->0.15   150->1.50 1500->15.00
     *
     * @param s
     * @return
     */
    public static String getFormatDouble(String s) {
        double d = Double.parseDouble(s);
        String format = String.format("%.2f", d / 100);
        return format;
    }

    /**
     * 将数字类型的字符串转换为带两个小数点的整形字符串 如 15->15.00   150->150.00 1500->1500.00
     *
     * @param s
     * @return
     */
    public static String getFormatDoubleNo(String s) {
        double d = Double.parseDouble(s);
        String format = String.format("%.2f", d);
        return format;
    }


    /**
     * 获取粘贴面板
     *
     * @param context
     * @return
     */
    public static String getTextFromClip(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        //判断剪切版时候有内容
        if (!clipboardManager.hasPrimaryClip())
            return "";
        ClipData clipData = clipboardManager.getPrimaryClip();
        if (null != clipData.getItemAt(0).coerceToText(context)) {
            //获取 text
            String text = clipData.getItemAt(0).coerceToText(context).toString();
            return text;
        } else {
            return "";
        }
    }

    /**
     * 判断是否是全面屏
     */
    private volatile static boolean mHasCheckAllScreen;
    private volatile static boolean mIsAllScreenDevice;

    public static boolean isAllScreenDevice(Context context) {
        if (mHasCheckAllScreen) {
            return mIsAllScreenDevice;
        }
        mHasCheckAllScreen = true;
        mIsAllScreenDevice = false;
        // 低于 API 21的，都不会是全面屏。。。
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return false;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            Display display = windowManager.getDefaultDisplay();
            Point point = new Point();
            display.getRealSize(point);
            float width, height;
            if (point.x < point.y) {
                width = point.x;
                height = point.y;
            } else {
                width = point.y;
                height = point.x;
            }
            if (height / width >= 1.97f) {
                mIsAllScreenDevice = true;
            }
        }
        return mIsAllScreenDevice;
    }


    /**
     * 判断是否登录操作
     */
//    public static boolean isIfLogin(Context context, boolean isLogin) {
//
//        if (!SharedPreferencesUtil.getString(MyApplication.getInstance().getApplicationContext(), Constants.TOKEN).equals("")) {//已经登陆
//
//            return true;
//        } else {
//            if (isLogin) {
//                context.startActivity(new Intent(context, LoginActivity.class));
//            }
//            return false;
//        }
//    }


    /**
     * 微博短链接正则表达式
     */

    public static SpannableString setTextHighLight(String content) {

        final String regex_http = "http(s)?://([a-zA-Z|\\d]+\\.)+[a-zA-Z|\\d]+(/[a-zA-Z|\\d|\\-|\\+|_./?%=]*)?";
        final String regex_at = "@[\\u4e00-\\u9fa5\\w\\-]+";
        final String regex_sharp = "#([^\\#|.]+)#";
        final String regex_emoji = "\\[[a-zA-Z0-9\\u4e00-\\u9fa5]+\\]";

        SpannableString result = new SpannableString(content);

//        if (content.contains("@")) {
//            Pattern p = Pattern.compile(regex_at);
//            Matcher m = p.matcher(result);
//            while (m.find()) {
//                int start = m.start();
//                int end = m.end();
//                result.setSpan(
//                        (new ForegroundColorSpan(Color.parseColor("#33b5e5"))),
//                        start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//            }
//        }

        if (content.contains("#")) {
            Pattern p = Pattern.compile(regex_sharp);
            Matcher m = p.matcher(result);
            while (m.find()) {
                int start = m.start();
                int end = m.end();
                result.setSpan(
                        (new ForegroundColorSpan(Color.parseColor("#2890FF"))),
                        start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                break;
            }
        }

//        if (content.contains("http://")) {
//            Pattern p = Pattern.compile(regex_http);
//            Matcher m = p.matcher(result);
//            while (m.find()) {
//                int start = m.start();
//                int end = m.end();
//                result.setSpan(
//                        (new ForegroundColorSpan(Color.parseColor("#33b5e5"))),
//                        start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//            }
//        }

        return result;
    }


    public static boolean isApplicationBroughtToBackground(final Activity context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }


    /**
     * 权限检验
     * @param permissions
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("WrongConstant")
    public static boolean checkPermissions(String[] permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        for (String permission : permissions) {
            if (PermissionChecker.checkSelfPermission(MyApplication.getInstance().getApplicationContext(), permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;

    }
    /**
     * URL加密串
     *
     * @return 加密后的串
     */
    /**
     * URL加密串
     *
     * @return 加密后的串
     */
    @SuppressLint("HardwareIds")
    public static synchronized String getSignHttpSign
    (TreeMap<String, String> mapA, String path) {
        String sn = "";
        String time = System.currentTimeMillis() / 1000 + "";
//        Constants.NEW_URL = Constants.BASE_URL + path ;
        TreeMap<String, String> map = new TreeMap<>();
//        map.put("timestamp", time);
        map.put("path", path);
//        map.put("v", Constants.VER_LOC);
//        map.put("from", Constants.ANROID);
//        map.put("unique_identifier", android.os.Build.SERIAL);
//
//        if (!Tools.getUUID(MyApplication.getInstance().getApplicationContext()).equals("")) {
//            map.put("uuid", Tools.getUUID(MyApplication.getInstance().getApplicationContext()));
//        }
//
//        if (!SharedPreferencesUtil.getString(MyApplication.getInstance().getApplicationContext(), Constants.TOKEN).equals("")) {
//            map.put("token", SharedPreferencesUtil.getString(MyApplication.getInstance().getApplicationContext(), Constants.TOKEN));
//        }
        map.putAll(mapA);

        Iterator<String> iter = map.keySet().iterator();

        while (iter.hasNext()) {

            String key = iter.next();
            String value = map.get(key);

            if (sn.length() > 0) {
                sn = sn + "&" + key + "=" + value;
            } else {
                sn = key + "=" + value;
            }
        }

//        sn = sn + "&secretkey=PC3937!@*&YZF";
//        sn = getMD5(getMD5(sn));
        return sn + "";
    }
}


