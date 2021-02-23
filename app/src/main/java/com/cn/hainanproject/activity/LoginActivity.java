package com.cn.hainanproject.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.R;
import com.cn.hainanproject.base.Constants;
import com.cn.hainanproject.model.LoginBean;
import com.cn.hainanproject.net.CallBackUtil;
import com.cn.hainanproject.net.OkhttpUtil;
import com.cn.hainanproject.utils.DateUtils;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.SharedPreferencesUtil;
import com.cn.hainanproject.utils.StatusBarUtils;
import com.scwang.wave.MultiWaveHeader;

import java.util.Arrays;
import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/2/2
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtUsername;
    ImageView ivClear1;
    EditText edtPassword;
    ImageView ivClear2;
    TextView tvLoginIn,tv_version,tv_current;
    boolean showPwd = false;
    String usernameTag;
    String pwdTag;
    String from;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.colorAccent);
        MultiWaveHeader waveHeader = findViewById(R.id.waveHeader);
        waveHeader.setVelocity(5.0f);

        edtUsername = findViewById(R.id.edt_username);
        ivClear1 = findViewById(R.id.iv_clear1);
        edtPassword = findViewById(R.id.edt_password);
        ivClear2 = findViewById(R.id.iv_clear2);
        tvLoginIn = findViewById(R.id.tv_login_in);
        tv_version= findViewById(R.id.tv_version);
        tv_version.setText("当前版本："+AppUtils.getAppVersionName());

        tv_current= findViewById(R.id.tv_current);
        tv_current.setText("当前环境：研发");

        if (TextUtils.isEmpty(SharedPreferencesUtil.getString(this, "loginid"))) {
            edtUsername.setText("");
            ivClear1.setVisibility(View.GONE);
        } else{
            edtUsername.setText(SharedPreferencesUtil.getString(this, "loginid"));
            ivClear1.setVisibility(View.VISIBLE);
        }
        if (TextUtils.isEmpty(SharedPreferencesUtil.getString(this, "pwd"))) {
            edtPassword.setText("");
            ivClear2.setVisibility(View.GONE);
        }else{
            edtPassword.setText(SharedPreferencesUtil.getString(this, "pwd"));
            ivClear2.setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(SharedPreferencesUtil.getString(this, "loginid"))&&!TextUtils.isEmpty(SharedPreferencesUtil.getString(this, "pwd"))){
            usernameTag=(SharedPreferencesUtil.getString(this, "loginid"));
            pwdTag=SharedPreferencesUtil.getString(this, "pwd");
        }

        if (!TextUtils.isEmpty(getIntent().getStringExtra("from"))) {//来自修改密码
            from = getIntent().getStringExtra("from");
            if (from.equals("ChangePwdActivity")) {
                edtUsername.setText("");
                edtPassword.setText("");
                ivClear1.setVisibility(View.GONE);
                ivClear2.setVisibility(View.GONE);
                usernameTag="";
                pwdTag="";
            }
        }

        init();




    }
    private void init() {

        ivClear1.setOnClickListener(this);
        ivClear2.setOnClickListener(this);
        tvLoginIn.setOnClickListener(this);
//        String span = "修改密码";
//        SpannableString spannableString=new SpannableString(span);
//        spannableString.setSpan(new ClickableSpan() {
//            @Override
//            public void onClick( View widget) {
//                Intent intent = new Intent(LoginActivity.this, ChangePwdActivity.class);
//                startActivity(intent);
//            }
//
//            @Override
//            public void updateDrawState( TextPaint ds) {
//                ds.setUnderlineText(true);
//                ds.setColor(Color.WHITE);
//            }
//        }, 0, span.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, span.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//设置字体大小
//        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffc000")), 0, span.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//设置字体颜色
//        tv_modify_pwd.setText(spannableString);
//        tv_modify_pwd.setMovementMethod(LinkMovementMethod.getInstance());
        edtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                usernameTag = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String toString = editable.toString();
                if (TextUtils.isEmpty(toString)) {
                    ivClear1.setVisibility(View.GONE);
                    tvLoginIn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_radis_30_gray));
                    tvLoginIn.setEnabled(false);
                } else {
                    ivClear1.setVisibility(View.VISIBLE);
                    if (!TextUtils.isEmpty(pwdTag)) {
                        tvLoginIn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_radis_30_accent));
                        tvLoginIn.setEnabled(true);
                    }

                }
            }
        });
        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pwdTag = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String toString = editable.toString();
                if (TextUtils.isEmpty(toString)) {
                    ivClear2.setVisibility(View.GONE);
                    tvLoginIn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_radis_30_gray));
                    tvLoginIn.setEnabled(false);
                } else {
                    ivClear2.setVisibility(View.VISIBLE);
                    if (!TextUtils.isEmpty(usernameTag)) {
                        tvLoginIn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_radis_30_accent));
                        tvLoginIn.setEnabled(true);
                    }

                }
            }
        });
        if (TextUtils.isEmpty(usernameTag) || TextUtils.isEmpty(pwdTag)) {
            tvLoginIn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_radis_30_gray));
            tvLoginIn.setEnabled(false);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void login(String name, final String pwd) {
        LogUtils.d("response222222 login");
        HashMap<String, String> map = new HashMap<>();
        map.put("loginid", name);
        map.put("password", pwd);
        map.put("imei", "android");
        String url = Constants.BASE_URL + Constants.LOGIN;
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "application/json;charset=UTF-8");
        OkhttpUtil.okHttpPost(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222 onFailure " + e.toString());
                ToastUtils.showShort("登陆失败");
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222 onResponse" + response);

                if (!response.isEmpty()) {
                    try {
                        LoginBean loginBean = JSONObject.parseObject(response, new TypeReference<LoginBean>() {});
                        if (loginBean.getErrcode().equals("USER-S-101")) {
                            SharedPreferencesUtil.setString(LoginActivity.this, "username", loginBean.getUsername());
                            SharedPreferencesUtil.setString(LoginActivity.this, "loginid", loginBean.getLoginid());
                            SharedPreferencesUtil.setString(LoginActivity.this, "pwd", pwd);
                            SharedPreferencesUtil.setString(LoginActivity.this, "personId", loginBean.getPersonid());
                            SharedPreferencesUtil.setString(LoginActivity.this, "logintime", DateUtils.getStringDate());

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            ToastUtils.showShort("登录成功");

                            finish();
                        } else {
                            ToastUtils.showShort(loginBean.getErrmsg());
                        }
                    }catch (com.alibaba.fastjson.JSONException exception){
                        ToastUtils.showShort(exception.toString());
                    }
                }

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_clear1:
                edtUsername.setText("");
                usernameTag = "";
                break;
            case R.id.iv_clear2:
                if (!showPwd) {
                    //显示
                    showPwd = true;
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    ivClear2.setBackgroundResource(R.drawable.eye_open);
                } else {
                    //隐藏
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showPwd = false;
                    ivClear2.setBackgroundResource(R.drawable.eye_close);
                }
                break;
            case R.id.tv_login_in:
                login(edtUsername.getText().toString(), edtPassword.getText().toString());
                break;
        }
    }
}
