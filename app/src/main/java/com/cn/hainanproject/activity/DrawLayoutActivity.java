package com.cn.hainanproject.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.cn.hainanproject.R;
import com.cn.hainanproject.adapter.DrawerAdapter;
import com.cn.hainanproject.fragment.Fragment1;
import com.cn.hainanproject.fragment.Fragment2;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by tzl
 * on 2021/6/9
 */
public class DrawLayoutActivity extends AppCompatActivity {
     DrawerLayout mDrawerLayout;
    TextView tv1,tv2;
    LinearLayout ll1;
    private ListView left_drawer;
    ArrayList<String> list=new ArrayList<>();
    DrawerAdapter drawerAdapter;
    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_layout_activity);
        mContext=this;
        list.add("工单管理");
        list.add("这是第二个fragment");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        left_drawer= (ListView) findViewById(R.id.left_drawer);
        left_drawer.setAdapter(new DrawerAdapter(this,list));
        left_drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Fragment1 contentFragment = new Fragment1(mContext);
                    Bundle args = new Bundle();
                    args.putString("text", list.get(position));
                    contentFragment.setArguments(args);
                    FragmentManager fm=getSupportFragmentManager();
                    fm.beginTransaction().replace(R.id.ly_content,contentFragment).commit();
                    mDrawerLayout.closeDrawer(left_drawer);

                }else {
                    Fragment2 contentFragment = new Fragment2();
                    Bundle args = new Bundle();
                    args.putString("text", list.get(position));
                    contentFragment.setArguments(args);
                    FragmentManager fm=getSupportFragmentManager();
                    fm.beginTransaction().replace(R.id.ly_content,contentFragment).commit();
                    mDrawerLayout.closeDrawer(left_drawer);
                }
            }
        });

        drawerAdapter = new DrawerAdapter(this, list);
//        DrawerAdapter.MyOnClickListener listener=new DrawerAdapter.MyOnClickListener() {
//            @Override
//            public void click(int position) {
//
//            }
//        };
//        drawerAdapter.setOnClick(listener);

//        tv1= (TextView) findViewById(R.id.tv1);
//        tv2= (TextView) findViewById(R.id.tv2);
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // 按钮按下，将抽屉打开
                mDrawerLayout.open();

            }
        });
//        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
//
//            }
//
//            @Override
//            public void onDrawerOpened(@NonNull View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerClosed(@NonNull View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//
//            }
//        });
//        tv1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Fragment1 contentFragment = new Fragment1();
//                Bundle args = new Bundle();
//                args.putString("text", "这是第一个fragment");
//                contentFragment.setArguments(args);
//                FragmentManager fm = getSupportFragmentManager();
//                fm.beginTransaction().replace(R.id.ly_content,contentFragment).commit();
//                mDrawerLayout.closeDrawer(ll1);
//
//            }
//        });
//        tv2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment2 contentFragment = new Fragment2();
//                Bundle args = new Bundle();
//                args.putString("text", "这是第二个fragment");
//                contentFragment.setArguments(args);
//                FragmentManager fm = getSupportFragmentManager();
//                fm.beginTransaction().replace(R.id.ly_content,contentFragment).commit();
//                mDrawerLayout.closeDrawer(ll1);
//            }
//        });
    }
}
