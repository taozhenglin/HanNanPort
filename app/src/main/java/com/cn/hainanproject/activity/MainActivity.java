package com.cn.hainanproject.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cn.hainanproject.R;
import com.cn.hainanproject.fragment.FunctionFragment;
import com.cn.hainanproject.fragment.PersonalFragment;
import com.cn.hainanproject.fragment.WorkFragment;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.SharedPreferencesUtil;
import com.cn.hainanproject.utils.StatusBarUtils;
import com.cn.hainanproject.view.MyPagerTransition;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mTextMessage;
    ViewPager viewpager;
    List<Fragment> lists;
    private FragmentPagerAdapter mAdapter;
    private BottomNavigationView navigation;
    private TextView tv_common_title;
    private TextView tv_back;
    private ImageView iv_back;
    public String[] mTopBarTitle = {"导航中心", "待办任务管理", "个人中心"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_back = findViewById(R.id.tv_back);
        iv_back = findViewById(R.id.iv_back);
        tv_back.setVisibility(View.GONE);
        iv_back.setVisibility(View.GONE);
        tv_common_title.setText(mTopBarTitle[0]);
//        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);

        viewpager = findViewById(R.id.viewpager);
        lists = new ArrayList<>();
        FunctionFragment functionFragment1 = new FunctionFragment(this);
        WorkFragment functionFragment2 = new WorkFragment(this);
        PersonalFragment functionFragment3 = new PersonalFragment(this);
        navigation = findViewById(R.id.nav_view);
        displayItemNum(navigation, 1, SharedPreferencesUtil.getInt(this,"waitdocount"));
        lists.add(functionFragment1);
        lists.add(functionFragment2);
        lists.add(functionFragment3);
        mAdapter = new MyFragnentPagerAdapter(getSupportFragmentManager(), lists);
        viewpager.setAdapter(mAdapter);
        viewpager.addOnPageChangeListener(mPageChangeListener);
        viewpager.setPageTransformer(false,new MyPagerTransition());
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    Log.d("222222", String.valueOf(R.string.title_home));
                    viewpager.setCurrentItem(0);
                    tv_common_title.setText(mTopBarTitle[0]);
                    return true;
                case R.id.navigation_dashboard:
                    Log.d("222222", String.valueOf(R.string.title_dashboard));
//                    mTextMessage.setText(R.string.title_dashboard);
                    viewpager.setCurrentItem(1);
                    tv_common_title.setText(mTopBarTitle[1]);

                    return true;
                case R.id.navigation_notifications:
                    Log.d("222222", String.valueOf(R.string.title_notifications));
//                    mTextMessage.setText(R.string.title_notifications);
                    viewpager.setCurrentItem(2);
                    tv_common_title.setText(mTopBarTitle[2]);

                    return true;
            }
            return false;
        }

    };
    ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            tv_common_title.setText(mTopBarTitle[position]);
            if (position == 0) {
                navigation.setSelectedItemId(R.id.navigation_home);

            } else if (position == 1) {
                navigation.setSelectedItemId(R.id.navigation_dashboard);

            } else
                navigation.setSelectedItemId(R.id.navigation_notifications);

        }


        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private class MyFragnentPagerAdapter extends FragmentPagerAdapter {
        public MyFragnentPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> list) {
            super(supportFragmentManager);
            list = lists;

        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return lists.get(position);
        }

        @Override
        public int getCount() {
            return lists.size();
        }
    }

    @SuppressLint("RestrictedApi")
    public static void displayItemNum(final BottomNavigationView mBottomNavigationView, final int mPosition, final int mCount) {
        try {
            final int maxSize = mBottomNavigationView.getItemIconSize();
            if (mPosition > maxSize || mPosition < 0) {
                return;
            }
            //Acquisition child View BottomNavigationMenuView Objects
            final BottomNavigationMenuView menuView = (BottomNavigationMenuView) mBottomNavigationView.getChildAt(0);
            final View mTab = menuView.getChildAt(mPosition);
            final BottomNavigationItemView itemView = (BottomNavigationItemView) mTab;
            View mBadge = itemView.getChildAt(3);
            if (mBadge == null) {
                //避免重复添加创建
                mBadge = LayoutInflater.from(mBottomNavigationView.getContext()).inflate(R.layout.bottom_bar_item_badge, menuView, false);
                itemView.addView(mBadge);
            }
            final TextView mTv = mBadge.findViewById(R.id.tv_msg_count);
            if (mCount <= 0) {
                mTv.setVisibility(View.GONE);
                mTv.setText(String.format("%s", mCount));
            } else {
                mTv.setVisibility(View.VISIBLE);
                if (mCount > 99) {
                    mTv.setText(String.format("%s+", 99));
                } else {
                    mTv.setText(String.format("%s", mCount));
                }
            }

        } catch (Exception e) {
            LogUtils.d("222222", e.getMessage());
            e.printStackTrace();
        }
    }

}