package com.cn.hainanproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.AppUtils;

import com.cn.hainanproject.R;
import com.cn.hainanproject.activity.LoginActivity;
import com.cn.hainanproject.base.Constants;
import com.cn.hainanproject.model.PostData;
import com.cn.hainanproject.utils.SharedPreferencesUtil;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by tzl
 * on 2020/12/14
 */
public class PersonalFragment extends Fragment implements View.OnClickListener {
    private final Context mContext;
    LinearLayout ll_font;
    LinearLayout ll_mode;
    LinearLayout ll_pwd;
    private String[] stringItems1 = new String[]{"小", "常规", "大"};
    private TextView tv_font,tv_name,tv_account,tv_version,tv_logintime;
    private TextView tv_login_out;
    PostData postData;
    public PersonalFragment(Context context) {
        mContext = context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_fragmnt, container, false);
        tv_name = view.findViewById(R.id.tv_name);
        tv_account = view.findViewById(R.id.tv_account);
        tv_logintime = view.findViewById(R.id.tv_logintime);
        ll_font = view.findViewById(R.id.ll_font);
        ll_mode = view.findViewById(R.id.ll_mode);
        tv_font = view.findViewById(R.id.tv_font);
        ll_pwd = view.findViewById(R.id.ll_pwd);
        tv_version= view.findViewById(R.id.tv_version);
        tv_login_out = view.findViewById(R.id.tv_login_out);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ll_font.setOnClickListener(this);
        ll_mode.setOnClickListener(this);
        ll_pwd.setOnClickListener(this);
        tv_login_out.setOnClickListener(this);
        tv_name.setText(SharedPreferencesUtil.getString(mContext,"username"));
        tv_account.setText(SharedPreferencesUtil.getString(mContext,"personId"));
        tv_version.setText(AppUtils.getAppVersionName());
        tv_logintime.setText(SharedPreferencesUtil.getString(mContext,"logintime"));
        switch ((int) SharedPreferencesUtil.getFloat(mContext, Constants.FONT_SIZE)){
            case 14:
                tv_font.setText("小");
                break;
            case 16:
                tv_font.setText("常规");
                break;
            case 18:
                tv_font.setText("大");
                break;
        }
        postData=new PostData();
        postData.setTag("query");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_font:
                final ActionSheetDialog dialog = new ActionSheetDialog(mContext, stringItems1, ll_font);
                dialog.isTitleShow(false)
                        .title("字体选择")
                        .titleTextSize_SP(14)
                        .titleTextColor(Color.parseColor("#0000ff"))
                        .cancelText("取消")
                        .cancelText(getResources().getColor(R.color.gry33))
                        .itemTextColor(getResources().getColor(R.color.colorAccent))
                        .layoutAnimation(null)
                        .show();
                dialog.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0://小
                                tv_font.setText(stringItems1[position]);
                                SharedPreferencesUtil.setFloat(mContext, Constants.FONT_SIZE, 14);
                                EventBus.getDefault().post(postData);
                                break;
                            case 1://常规
                                tv_font.setText(stringItems1[position]);
                                SharedPreferencesUtil.setFloat(mContext, Constants.FONT_SIZE, 16);
                                EventBus.getDefault().post(postData);

                                break;
                            case 2://大
                                tv_font.setText(stringItems1[position]);
                                SharedPreferencesUtil.setFloat(mContext, Constants.FONT_SIZE, 18);
                                EventBus.getDefault().post(postData);


                                break;
                        }
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.ll_pwd:
//                Intent intent = new Intent(mContext, ChangePwdActivity.class);
//                startActivity(intent);
                break;
            case R.id.tv_login_out:
                mContext.startActivity(new Intent(mContext, LoginActivity.class));
                getActivity().finish();
                break;
        }
    }
}
