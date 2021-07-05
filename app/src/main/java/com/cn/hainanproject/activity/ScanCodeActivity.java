package com.cn.hainanproject.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.R;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.StatusBarUtils;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

/**
 * Created by tzl
 * on 2021/6/21
 */
public class ScanCodeActivity extends AppCompatActivity implements QRCodeView.Delegate, View.OnClickListener{
    private ZXingView mZXingView;
    private LinearLayout ll_back;
    private TextView tv_common_title;
    private TextView tv_pici_no;
    private TextView tv_count;
    List<String> list;
     ImageView iv_fun;
    private boolean close = true;
    private PopupWindow pop;
    private TextView tv_finish;
    private String from;
    private LinearLayout ll_button;
    private List<JSONObject> jsonlist;
    private LoadingDialog ld;
    Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        ld = new LoadingDialog(this);
        mContext=this;
        mZXingView = findViewById(R.id.zxingview);
        mZXingView.setDelegate(this);
        ll_back = findViewById(R.id.ll_back);
        ll_back.setOnClickListener(this);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("设备点巡检");
        iv_fun = findViewById(R.id.iv_fun);
        ll_button = findViewById(R.id.ll_button);
        iv_fun.setBackground(getResources().getDrawable(R.drawable.light));
        iv_fun.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
//                if (list.size() > 0) {
//                    if (pop!=null&&pop.isShowing()){
//                        pop.dismiss();
//                    }
//
//                } else
                    finish();
                break;
            case R.id.tv_finish:


                break;
            case R.id.iv_fun:
                if (close) {
                    mZXingView.openFlashlight(); // 打开闪光灯
                    close = false;
                } else {
                    mZXingView.closeFlashlight(); // 关闭闪光灯
                    close = true;
                }
                break;
        }
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        if (!StringUtils.isEmpty(result)){
            LogUtils.d("222222", "result:" + result);
            mZXingView.stopCamera();
            vibrate();
            startActivity(new Intent(mContext,ScanResultActivity.class).putExtra("result",result));
        }

    }
    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }
    @Override
    protected void onStart() {
        super.onStart();

        mZXingView.startCamera(); // 打开后置摄像头开始预览，但是并未开始识别
//        mZXingView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT); // 打开前置摄像头开始预览，但是并未开始识别
        mZXingView.changeToScanBarcodeStyle(); // 切换成扫描条码样式
        mZXingView.setType(BarcodeType.ALL, null); // 只识别一维条码
        mZXingView.startSpotAndShowRect(); // 显示扫描框，并开始识别
    }

    @Override
    protected void onStop() {
        mZXingView.stopCamera(); // 关闭摄像头预览，并且隐藏扫描框
        mZXingView.closeFlashlight(); // 关闭闪光灯
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mZXingView.onDestroy(); // 销毁二维码扫描控件
        mZXingView.closeFlashlight(); // 关闭闪光灯

        super.onDestroy();
    }
    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {
// 这里是通过修改提示文案来展示环境是否过暗的状态，接入方也可以根据 isDark 的值来实现其他交互效果
        String tipText = mZXingView.getScanBoxView().getTipText();
        String ambientBrightnessTip = "\n环境过暗，请打开闪光灯";
        if (isDark) {
            if (!tipText.contains(ambientBrightnessTip)) {
                mZXingView.getScanBoxView().setTipText(tipText + ambientBrightnessTip);
            }
        } else {
            if (tipText.contains(ambientBrightnessTip)) {
                tipText = tipText.substring(0, tipText.indexOf(ambientBrightnessTip));
                mZXingView.getScanBoxView().setTipText(tipText);
            }
        }
    }
    @Override
    public void onScanQRCodeOpenCameraError() {
        LogUtils.d("222222", "打开相机出错");
    }
    public void requestPermission() {
        //申请WRITE_EXTERNAL_STORAGE权限
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
    }

}
