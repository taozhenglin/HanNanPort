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
    String model;
    String carrier;
    public static String home = "1";

    private static String MQ_APP_KEY = "d70b21192f0f1e0843a9b5c2a7d2ed3a"; //美洽客服SDK AppKey
//    private static String MQ_APP_KEY = "6e6c5e2e4d872660dbaa1fe1fc5ecd21"; //美洽客服SDK AppKey，测试账号的key

    public static float fontSize = 1.0f;

    private boolean firsttimeOpenMianActivity = false;

    //判断是否是处于后天状态,在true表示现在处于后台状态
    public static boolean houtai = false;

    private static String ALI_HOT_APPID = "24800600-1";
    private static String ALI_HOT_APPSecre = "a6d0322147f15cd900e89d37369675d5";
    private static String ALI_HOT_RSA = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCWGO2SYvXoen/bvUDVa5/mkQiM407DL8eWCxTyVrJ8xn6xKx7lYPPhiu15kMh6thu1z8aoKvRThq++/W28hNE3F8PgA6vq2dRLH01fkEB5T22rpdf456f9bClerl7JWg8D6xEdJMgO2870qLXziJzzZMXpnBoiXlyZUANCi/wkj1RIY8l72P1JgQhdEnlSeou5+M2AdfY0/mxrSIQEUbeC/PtjWjmBBHM3MO9WEc2eilUQAI9oZIrCoU88LgkAvn3TnlNbrx6GPxBr1itLUhOThtutne+pscVhJi1gxCbZRJxzZL2/8zyV6w86iC8n0bIAiWeLmZ5IM3UOlqda9MFpAgMBAAECggEAE8BUAt9i3KTCDnho/6yZ7g1HwsJmquiuqt/qcblW43R7V3UFK8oGTbeqaETVHNC59MLSsW51mEgw+EEBH72ailVmQSQ6izz+4qPL2rdwxIXfOKcqNGbHhGGnT/5CGtzu/OUB64Pbj5j9MtTAnLtta9nm8UbJaZxhMwuEYk1pcKX4CIkDAWES68PIMHPeKQrcIfQbE8OsLekrDjDPolEu8kbWaDk6CJMV3ihmndj11ffodKk/A+x7yrRzuARh4jEXl1NW9RZLAjihqeSmwkao5pr2UIUpltzuyvegUXes+/QOJpfE57V7ol7Q1OfQNIpwLmgeKxBJgY/aTYKHoEitwQKBgQDSiywFD4+OiPDepFa8Q90ldbq9RyBXLz+iwKM8q3e3S/lgek4QoH5pDzjECDGHPhLYjwjEhlHr6lbnZhHJ3d6E91UXMa7eWDbmFawHEkS2PlOIr4uhOmpfayZvE1TyOBM4b0zCV9uCNoz1oPf/Z924wJaujhp3s4SdQSIDvlepjwKBgQC2gN4iJ8W+Kc3KIVcW6kAnqtNJdbDQXuC33/aPcnmMOTeXnRDXm0QRPlf30uAqYuiSdBf67/rhmZbrgNpovKvpaX9uQk4j56F1x322xyPUoJp7Bc4WghVcOjOnPBlI8ed5EqQ6HbEJ7n5NQmPdN1NMlD5Xh8EImpReSu/5fq65hwKBgEuaF+N1U/o9qCh6YH7X65gg7z46RR2pZLNfcv49IA7cpB6FrHSB/QJiqeKSgp5qpr/GlMJk7RPGoRAUcbzIA7hBS/e5Km7CxGvYSl57q9q5BKvnRT9Ox5Wd1z45dd5ITnaMWMbMX5EhX3pwI709obtOxIzHkC99cdg55Cnt9nJ3AoGAA019t5yEpZZYFQpZax6+Hnmm7TNmCb9NzcYNzjbCIFmAugurnFtA9hbsvJ1iVSIJF21mabIiFicTZhuk2DRh4A16suIcS+YLM/hyO/aKnXRylztZqWqdPFgJS0N5KarHB5fgxPR4mbdpLbi/2ecAaOhd4HOieKdje/lbMmaqfs0CgYAwtnEi7uNYguoPfLrqr1QC7zBpgd/GPZn598MJA24+wTsaVXLrbG1zQJdrq9hCv+Iqbgzs4pGI6QWIZ0Br1UbvfIggQpa0PcnCasyIftPc9BykZ1ib7l/h6DdgPS8xnGXVyUR3Lj9wfLaogATKpAhpGX3IFXwzvqb5AEyQDHa4Tw==";

    private Handler handler;
    private NotificationManager mNotificationManager;

    {
        //微信
//        PlatformConfig.setWeixin("wxbc4ff4062316dd5a", "562874951b68170cfb29a8c804439552");
//        //新浪微博
//        PlatformConfig.setSinaWeibo("2155990679", "4362d83385240ce1634feeae91b7af59", "http://sns.whalecloud.com/sina2/callback");
//        // QQ
//        PlatformConfig.setQQZone("1105399488", "6ioLvN4HzluZiNgj");
//
//        PlatformConfig.setDing("dingoa9otpmzrwzgbeg5p2");
    }


    //填写您在闪验平台申请的appid和AppKey
    public static final String appId = "579xUuz8";
    public static final String appKey = "1RA4ziYy";


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

//        switch (Constants.HTTP_YUMING) {
//            case 1://正式环境
//                Constants.BASE_URL = "https://api.kepuchina.cn";
//                Constants.BASE_URL_H5 = "https://h5.kepuchina.cn";
//                Constants.BASE_URL_ZT = "https://zt.kepuchina.cn";
//                Constants.DeBug = false;
//                break;
//
//            case 2://预发布环境
//                Constants.BASE_URL = "https://api.kepuchina.com.cn";
//                Constants.BASE_URL_H5 = "https://h5.kepuchina.com.cn"; //积分规则专用
//                Constants.BASE_URL_ZT = "https://zt-yufa.kepuchina.cn";
//                Constants.DeBug = true;
//                break;
//
//            case 3://测试环境
//                Constants.BASE_URL = "https://api.kepuchina.vip";
//                Constants.BASE_URL_H5 = "https://h5.kepuchina.vip";
//                Constants.BASE_URL_ZT = "https://zt-test.kepuchina.cn";
//                Constants.DeBug = true;
//                break;
//        }

//        MultiDex.install(this);
        //阿里热修复
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
        //初始化蒲公英sdk
//        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        int totalresult = SharedPreferencesUtil.getInt(this, "waitdototalresult");
//        LogUtils.d("totalresult== "+totalresult );
//
//        model= android.os.Build.MODEL;//手机型号
//        carrier= Build.MANUFACTURER;//手机厂商
//        LogUtils.d("model== "+model + "       carrier="+carrier);
//        Notification.Builder builder = new Notification.Builder(getApplicationContext())
//                .setContentTitle("待办事项")
//                .setContentText("")
//                .setSmallIcon(R.mipmap.luncher_48);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            LogUtils.d("==Build.VERSION.SDK_INT >= Build.VERSION_CODES.O");
//
//            setupNotificationChannel();
//            builder.setChannelId(NOTIFICATION_CHANNEL);
//        }

//        Notification notification = builder.build();
//        if (totalresult > 0) {
//            if (carrier.equals("Xiaomi")){
//                LogUtils.d("model== Xiaomi" );
//                ShortcutBadger.applyNotification(this, notification, totalresult);
//            }else {
//                ShortcutBadger.applyCount(this, totalresult); //for 1.1.4+
//            }
//        }else{
//            ShortcutBadger.removeCount(this);
//        }
//        Notification.Builder builder = new Notification.Builder(getApplicationContext())
//                .setContentTitle("")
//                .setContentText("")
//                .setSmallIcon(R.drawable.ic_launcher);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            setupNotificationChannel();
//
//            builder.setChannelId(NOTIFICATION_CHANNEL);
//        }
//        Notification notification = builder.build();
//        ShortcutBadger.applyNotification(getApplicationContext(), notification, badgeCount);
//        ShortcutBadger.with(getApplicationContext()).count(badgeCount); //for 1.1.3
//        String username = SharedPreferencesUtil.getString(this, "username");
//        String pwd = SharedPreferencesUtil.getString(this, "pwd");
//        LogUtils.d("222222 username = " + username + "\npwd=" + pwd);
////        if (!StringUtils.isEmpty(username)) {
////            login(username, pwd);
////        } else {
////            Intent intent = new Intent(this, LoginActivity.class);Wai
////            startActivity(intent);
////        }


        //初始化友盟
//        initUMeng();

        String processName = getProcessName(applicationContext,
                android.os.Process.myPid());

//        if (processName != null) {
//            boolean defaultProcess = processName
//                    .equals("com.sevenplus.chinascience");
//            if (defaultProcess) {
//                //必要的初始化资源操作
//
//                new Runnable() {
//                    @Override
//                    public void run() {
//
//                        // queryAndLoadNewPatch不可放在attachBaseContext 中，否则无网络权限，建议放在后面任意时刻，如onCreate中
//                        if (!Constants.DeBug) {
//                            SophixManager.getInstance().queryAndLoadNewPatch();
//                        }
//
//                        UpdateHelper.init(MyApplication.this);
//                        JLog.init(MyApplication.this).setDebug(true);
//
//                        //初始化友盟
////                initUMeng();
//                        //图片选择器的图片加载
//                        Fresco.initialize(getApplicationContext());
//
//                        if (!Constants.DeBug) {
//
//                            /**
//                             * Bugly
//                             */
//                            Context context = getApplicationContext();
//                            String packageName = context.getPackageName();
//                            String processName = getProcessName(android.os.Process.myPid());
//                            CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
//                            strategy.setUploadProcess(processName == null || processName.equals(packageName));
//                            CrashReport.initCrashReport(context, "6a80483449", true, strategy);
//                            LoginData user1 = (LoginData) SharedPreferencesUtil.getObject(context, "user1");
//                            if (null != user1) {
//                                CrashReport.setUserId(context, user1.getUid());//设置用户uid
//                            }
//
//
//                            /**
//                             * 初始化听云
//                             */
//                            NBSAppAgent.setLicenseKey("a70e99cc94e04c5893086ade3d341b55").withLocationServiceEnabled(true).startInApplication(getApplicationContext());
//                        }
//
//                        //推荐sdk初始化
//                        BfdAgent.onInit(applicationContext,
//                                "55ddf25e165f80c4d47cfc4670ad0544", "null", "http", true);
//
//                        initMeiqiaSDK();
//
//                        NineGridView.setImageLoader(new GildImageLoader());
//                        initFileDownloader(MyApplication.this);
//
//                        /**
//                         * 闪验登录初始化
//                         */
////                initOnekeyLogin();
//
//                        requestPermission(Permission.READ_PHONE_STATE);
//                    }
//                }.run();
//
//            }
//        }


//        if (Constants.DeBug) {
//            LeakCanary.install(this);
//        }
    }



//    @TargetApi(Build.VERSION_CODES.O)
//    private void setupNotificationChannel() {
//        NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL, "com.cn.beisanproject",
//                NotificationManager.IMPORTANCE_DEFAULT);
//
//        mNotificationManager.createNotificationChannel(channel);
//    }

    //    public void testNotify(View v) {
//        NotificationCompat.Builder builder;
//        //8.0
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            builder = new NotificationCompat.Builder(this, getChannelId());
//        } else {
//            builder = new NotificationCompat.Builder(this, null);
//            //8.0以下版本桌面红点显示
//            // TODO: 2018/8/2
//        }
//
//        builder.setSmallIcon(R.mipmap.luncher_48)
//                .setDefaults(Notification.DEFAULT_ALL)
//                .setTicker("title")
//                .setAutoCancel(true)
//                .setContentTitle("contentTitle")
//                .setContentText("contentText");
//        mNotificationManager.notify(123, builder.build());
//    }
    @RequiresApi(api = Build.VERSION_CODES.O)
//    public String getChannelId() {
//        final String channelId = "123";
//        final String channelName = "com.cn.beisanproject";
//
//        NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
//        channel.enableLights(true);//显示桌面红点
//        channel.setLightColor(Color.RED);
//        channel.setShowBadge(true);
//        mNotificationManager.createNotificationChannel(channel);
//        return channel.getId();
//    }
//    public void login(String name, final String pwd) {
//        LogUtils.d("response222222 login");
//        HashMap<String, String> map = new HashMap<>();
//        map.put("loginid", name);
//        map.put("password", pwd);
//        map.put("imei", "android");
//        String url = Constants.BASE_URL + Constants.LOGIN;
//        JSONObject object = new JSONObject();
////        object.put("loginid", name);
////        object.put("password", pwd);
////        object.put("imei", "android");
//
//        HashMap<String, String> headermap = new HashMap<>();
//        headermap.put("Content-Type", "text/plan;charset=UTF-8");
//        OkhttpUtil.okHttpPost(url, map, headermap, new CallBackUtil.CallBackString() {
//            @Override
//            public void onFailure(Call call, Exception e) {
//                LogUtils.d("222222 onFailure " + e.toString());
//                ToastUtils.showShort("登陆失败");
//
//            }
//
//            @Override
//            public void onResponse(String response) {
//                LogUtils.d("222222 onResponse" + response);
//
//                if (!response.isEmpty()) {
//                    LoginBean loginBean = JSONObject.parseObject(response, new TypeReference<LoginBean>() {
//                    });
//                    if (loginBean.getErrcode().equals("USER-S-101")) {
//                        SharedPreferencesUtil.setString(applicationContext, "username", loginBean.getResult().getUserLoginDetails().getUserName());
//                        SharedPreferencesUtil.setString(applicationContext, "pwd", pwd);
//                        SharedPreferencesUtil.setString(applicationContext, "personId", loginBean.getResult().getUserLoginDetails().getPersonId());
//                        SharedPreferencesUtil.saveObject(applicationContext, "userLoginDetails", loginBean.getResult().getUserLoginDetails());
//                        LogUtils.d("userLoginDetails=" + loginBean.getResult().getUserLoginDetails());
//
//                        Intent intent = new Intent(applicationContext, MainActivity.class);
//                        startActivity(intent);
//                    } else {
//                        ToastUtils.showShort(loginBean.getErrmsg());
//                    }
//                }
//
//            }
//        });
//
//    }

    /**
     * 闪验一键登录
     */
//    private void initOnekeyLogin() { //三者方法不能更换
//        //闪验sdk本地数据初始化
//        OneKeyLoginManager.getInstance().set(getApplicationContext(), appId, appKey);
//        setListener();
//        //权限判断
//        requestPermission(Permission.READ_PHONE_STATE);
//    }

//    private void setListener() {
//        //闪验SDK网络初始化回调(code==1022成功)
//        OneKeyLoginManager.getInstance().setShanyanInitListener(new ShanyanInitListener() {
//            @Override
//            public void getInitStatus(int code, String result) {
//                Log.e("TTT", "初始化code=" + code + "        result=" + result);
//
//            }
//        });
//        //闪验SDK预取号回调(code==1022成功 )
//        OneKeyLoginManager.getInstance().setShanyanPreInitiaListener(new ShanyanPreInitiaListener() {
//            @Override
//            public void getPreInitiaStatus(int code, String result) {
//                Log.e("TTT", "预取号code=" + code + "        result=" + result);
//            }
//        });
//    }


//    private void requestPermission(String... permissions) {
//        AndPermission.with(this)
//                .permission(permissions)
//                .onGranted(new Action() {
//                    @TargetApi(Build.VERSION_CODES.M)
//                    @Override
//                    public void onAction(List<String> permissions) {
//
//                        //网络数据初始化
////                        OneKeyLoginManager.getInstance().init();
//                        //闪验SDK预取号
////                        OneKeyLoginManager.getInstance().PreInitiaStart();
//                    }
//                })
//                .onDenied(new Action() {
//                    @Override
//                    public void onAction(@NonNull List<String> permissions) {
//
//                    }
//                })
//                .start();
//    }


    /**
     * 初始化友盟信息
     */
//    private void initUMeng() {
////        初始化友盟
//        UMConfigure.init(applicationContext, UMConfigure.DEVICE_TYPE_PHONE, "584105e30b2f59b17062fbb6ac8303dd");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
//        if (Constants.DeBug) {
//            UMConfigure.setLogEnabled(true);
//        } else {
//            UMConfigure.setLogEnabled(false);
//        }
//        //初始化友盟推送
//        final PushAgent mPushAgent = PushAgent.getInstance(MyApplication.this);
//        //相应的处理行为放在主线程
//        handler = new Handler(getMainLooper());
//
//        //友盟消息自定义行为
//
//        mPushAgent.setNotificationClickHandler(notificationClickHandler);
//
//        mPushAgent.setMessageHandler(messageHandler);
//
//        //注册推送服务，每次调用register方法都会回调该接口
//        mPushAgent.register(new IUmengRegisterCallback() {
//            @Override
//            public void onSuccess(String deviceToken) {
//                //注册成功会返回device token
//                Log.i("AAAAAAAAAAAAAAAAAAAA", "友盟推送注册成功，返回device token:" + deviceToken);
////                uploadDeviceToken(deviceToken);
//            }
//
//            @Override
//            public void onFailure(String s, String s1) {
//                Log.i("AAAAAAAAAAAAAAAAAA", "友盟推送注册失败，返回s:" + s + "   s1:" + s1);
//            }
//        });
//
//
////        友盟渠道分析
//        if (Constants.DeBug) {
//            MobclickAgent.setDebugMode(true);
//        } else {
//            MobclickAgent.setDebugMode(false);
//        }
//        //美团打包失效
//        String channel = ChannelUtil.getChannel(MyApplication.this, "default channel");//获取渠道名
//
//        MobclickAgent.openActivityDurationTrack(false);
//        //普通统计场景类型
//        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
//        MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(this,
//                "584105e30b2f59b17062fbb6ac8303dd", channel, MobclickAgent.EScenarioType.E_UM_NORMAL, true));
//    }


//    private void initMeiqiaSDK() {
//        MQManager.setDebugMode(true);
//
//        // 替换成自己的key
////        String meiqiaKey = "a71c257c80dfe883d92a64dca323ec20";
//        MQConfig.init(this, MQ_APP_KEY, new OnInitCallback() {
//            @Override
//            public void onSuccess(String clientId) {
//                Log.i("MQ", "美洽初始化成功");
//            }
//
//            @Override
//            public void onFailure(int code, String message) {
//                Log.i("MQ", "美洽初始化失败...");
//            }
//        });
//
//        // 可选
////        customMeiqiaSDK();
//    }
    public static MyApplication getInstance() {
        return instance;
    }


    public boolean isFirsttimeOpenMianActivity() {
        return firsttimeOpenMianActivity;
    }

    public void setFirsttimeOpenMianActivity(boolean firsttimeOpenMianActivity) {
        this.firsttimeOpenMianActivity = firsttimeOpenMianActivity;
    }


    //友盟信息处理
//    UmengMessageHandler messageHandler = new UmengMessageHandler() {
//        @Override
//        public Notification getNotification(Context context, UMessage uMessage) {
////            EventBus.getDefault().post("getNotices");
////            Log.d("kp", "---->>message = " + "getNotification收到消息了");
////            Log.d("kp", "---->>message = " + uMessage.extra.toString());
////            if (uMessage.extra.get("name").equals("tzl")){
////                Log.d("kp", "---->>message = " + "收到特殊消息了");
////                return null;
////            }else {
////                Log.d("kp", "---->>message = " + "收到普通消息了");
////                return super.getNotification(context, uMessage);
////            }
//            return super.getNotification(context, uMessage);
//        }
//
//        @Override
//        public void dealWithNotificationMessage(Context context, UMessage uMessage) {
//            Log.d("kp", "---->>message = " + uMessage.extra.toString());
//            if (uMessage.extra.get("content-available").equals("1")) {//消息相关
//                if (uMessage.extra.get("red_notice").equals("1")) {//展示小红点
//                    Log.d("kp", "---->>message = " + "收到特殊消息了");
//                    EventBus.getDefault().post("getNotices");
//                }
//
//                return;
//            } else if (uMessage.extra.get("content-available").equals("0")) {//除消息之外的
//                Log.d("kp", "---->>message = " + "收到普通消息了");
//                super.dealWithNotificationMessage(context, uMessage);
//            }
//        }
//    };
    //友盟通知点击处理
//    UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler() {
//        @Override
//        public void dealWithCustomAction(final Context context, final UMessage uMessage) {
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//
//                    if (null != uMessage && !TextUtils.isEmpty(uMessage.extra.toString())) {
//                        Gson gson = new Gson();
//                        String strExtra = uMessage.extra.toString();
//
//                        NotifyBean bean = gson.fromJson(strExtra, new TypeToken<NotifyBean>() {
//                        }.getType());
//                        if (null != bean) {
//                            if (TextUtils.isEmpty(bean.getType()) || TextUtils.isEmpty(bean.getInfo())) {
//                                return;
//                            }
//                            String type = bean.getType();
//                            String info = bean.getInfo();
//                            notifyIntent(type, info);
//                        }
//                    }
//                }
//            });
//        }
//    };

    /**
     * 通过相关信息跳转
     *
     * @param type
     * @param info
     */
//    private void notifyIntent(String type, String info) {
//        Intent intent = null;
//        if (type.equals(NotifyBean.TYPE_NEWS)) {
//            intent = new Intent(MyApplication.getInstance().getApplicationContext(), InformationActivity2.class);
//            intent.putExtra("ar_id", info);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//        } else if (type.equals(NotifyBean.TYPE_VIDEO)) {
//            intent = new Intent(MyApplication.getInstance().getApplicationContext(), VideoActivity2.class);
//            intent.putExtra("ar_id", info);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//        }
//    }


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


//    private void initFileDownloader(MyApplication myApplication) {
//        // 1、创建Builder
//        FileDownloadConfiguration.Builder builder = new FileDownloadConfiguration.Builder(myApplication);
//
//        // 2.配置Builder
//        // 配置下载文件保存的文件夹
//        builder.configFileDownloadDir(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator +
//                "KePuChina");
//        // 配置同时下载任务数量，如果不配置默认为2
//        builder.configDownloadTaskSize(3);
//        // 配置失败时尝试重试的次数，如果不配置默认为0不尝试
//        builder.configRetryDownloadTimes(5);
//        // 开启调试模式，方便查看日志等调试相关，如果不配置默认不开启
//        builder.configDebugMode(true);
//        // 配置连接网络超时时间，如果不配置默认为15秒
//        builder.configConnectTimeout(25000);// 25秒
//
//        // 3、使用配置文件初始化FileDownloader
//        FileDownloadConfiguration configuration = builder.build();
//        FileDownloader.init(configuration);
//    }

    /**
     * Picasso 加载
     */
//    class GildImageLoader implements NineGridView.ImageLoader {
//
//        @Override
//        public void onDisplayImage(Context context, ImageView imageView, String url) {
//            Glide.with(context).load(url)//
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_563x318)//
//                    .error(R.mipmap.default_563x318)//
//                    .into(imageView);
//        }
//
//        @Override
//        public Bitmap getCacheImage(String url) {
//            return null;
//        }
//    }


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