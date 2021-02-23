package com.cn.hainanproject.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.hainanproject.R;
import com.cn.hainanproject.utils.NetWorkUtil;
import com.cn.hainanproject.utils.StatusBarUtils;
import com.scwang.smart.refresh.footer.BallPulseFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.header.DropBoxHeader;
import com.scwang.smart.refresh.header.FunGameHitBlockHeader;
import com.scwang.smart.refresh.header.PhoenixHeader;
import com.scwang.smart.refresh.header.TaurusHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleMultiListener;
import com.scwang.smart.refresh.layout.util.SmartUtil;
import com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper;
import com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.header.DeliveryHeader;

/**
 * Created by tzl
 * on 2020/12/16
 */
public abstract  class BaseListActivity extends AppCompatActivity implements View.OnClickListener {
     TextView tv_search;
     EditText edt_search;
     RecyclerView recyclerView;
     SmartRefreshLayout refreshLayout;
     RecyclerView.LayoutManager layoutManager;
     LinearLayout ll_back;
     public TextView tv_common_title;
     TextView tv_title;
    ImageView iv_fun;
    ImageView nodata;
    ImageView iv_warm2;
    LinearLayout ll_top;
     View include2;
    ImageView iv_search1,iv_search2;
     Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_list_activity);
        mContext=BaseListActivity.this;
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(BaseListActivity.this, R.color.white);

        ll_back = findViewById(R.id.ll_back);
        ll_back.setOnClickListener(BaseListActivity.this);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_title = findViewById(R.id.tv_title);
        iv_fun= findViewById(R.id.iv_fun);
        edt_search=findViewById(R.id.edt_search);

        tv_search=findViewById(R.id.tv_search);
        tv_search.setOnClickListener(BaseListActivity.this);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(BaseListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = findViewById(R.id.refreshLayout);
        nodata=findViewById(R.id.nodata);
        iv_warm2=findViewById(R.id.iv_warm2);
//        ll_top=findViewById(R.id.ll_top);
        include2=findViewById(R.id.include2);
        if (!NetWorkUtil.isConnected(BaseListActivity.this)){
            iv_warm2.setVisibility(View.VISIBLE);
            include2.setVisibility(View.GONE);
        }
        refreshLayout.setPrimaryColorsId(R.color.wathet, android.R.color.white);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }
        refreshLayout.setOnMultiListener(new SimpleMultiListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(3000);
            }
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
            }
            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
                if (newState == RefreshState.None) {
                    if (oldState == RefreshState.LoadFinish) {
                        RefreshFooter refreshFooter = refreshLayout.getRefreshFooter();
                        if (refreshFooter instanceof RefreshFooterWrapper) {
                            View footerView = refreshFooter.getView();
                            if (footerView instanceof TaurusHeader) {
                                refreshLayout.setRefreshFooter(new RefreshFooterWrapper(new DropBoxHeader(BaseListActivity.this)));
                            } else if (footerView instanceof DropBoxHeader) {
                                refreshLayout.setRefreshFooter(new RefreshFooterWrapper(new DeliveryHeader(BaseListActivity.this)));
                            } else if (footerView instanceof com.scwang.smart.refresh.header.DeliveryHeader) {
                                refreshLayout.setRefreshFooter(new RefreshFooterWrapper(new BezierCircleHeader(BaseListActivity.this)));
                            } else {
                                refreshLayout.setRefreshFooter(new BallPulseFooter(BaseListActivity.this));
                            }
                        }
                    } else if (oldState == RefreshState.RefreshFinish) {
                        RefreshHeader refreshHeader = refreshLayout.getRefreshHeader();
                        if (refreshHeader instanceof RefreshHeaderWrapper) {
                            refreshLayout.setRefreshHeader(new PhoenixHeader(BaseListActivity.this), ViewGroup.LayoutParams.MATCH_PARENT, SmartUtil.dp2px(100));
                        } else if (refreshHeader instanceof PhoenixHeader) {
                            refreshLayout.setRefreshHeader(new DeliveryHeader(BaseListActivity.this), ViewGroup.LayoutParams.MATCH_PARENT, SmartUtil.dp2px(150));
                        } else if (refreshHeader instanceof DeliveryHeader) {
                                refreshLayout.setRefreshHeader(new FunGameHitBlockHeader(BaseListActivity.this));
                        } else if (refreshHeader instanceof FunGameHitBlockHeader) {
                            refreshLayout.setRefreshHeader(new ClassicsHeader(BaseListActivity.this));
                        } else {
                            refreshLayout.setRefreshHeader(new RefreshHeaderWrapper(new BallPulseFooter(BaseListActivity.this)));
                        }
                    }
                }
            }
        });
//        refreshLayout.setRefreshHeader(new DeliveryHeader(BaseListActivity.this));
//        refreshLayout.setRefreshFooter( new RefreshFooterWrapper(new BezierCircleHeader(BaseListActivity.this)));
        initView();
        initEvent();
    }

    public abstract void initView();
    public abstract void initEvent();
}
