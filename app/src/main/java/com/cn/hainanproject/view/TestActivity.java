package com.cn.hainanproject.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cn.hainanproject.R;
import com.cn.hainanproject.utils.StatusBarUtils;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.colorAccent);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new RecyclerViewFragment())
                    .commit();
        }
    }
}
