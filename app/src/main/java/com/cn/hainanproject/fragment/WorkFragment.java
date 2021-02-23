package com.cn.hainanproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cn.hainanproject.R;
import com.cn.hainanproject.activity.AssertPurchaseListActivity;
import com.cn.hainanproject.activity.GridActivity;
import com.cn.hainanproject.activity.LoginActivity;
import com.cn.hainanproject.activity.MainActivity;
import com.cn.hainanproject.activity.StockMoveListActivity;
import com.cn.hainanproject.view.TestActivity;

/**
 * Created by tzl
 * on 2021/2/2
 */
public class WorkFragment extends Fragment {
    private final Context mContext;

    public WorkFragment(Context context) {
        mContext=context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmrnt2,container,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, GridActivity.class));
            }
        });
        return view;    }
}
