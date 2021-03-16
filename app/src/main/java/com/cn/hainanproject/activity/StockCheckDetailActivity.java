package com.cn.hainanproject.activity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.R;
import com.cn.hainanproject.adapter.CommonAdapter;
import com.cn.hainanproject.base.CommonViewHolder;
import com.cn.hainanproject.base.Constants;
import com.cn.hainanproject.base.MyApplication;
import com.cn.hainanproject.model.StocCheckLineListBean;
import com.cn.hainanproject.model.StockCheckListBean;
import com.cn.hainanproject.net.CallBackUtil;
import com.cn.hainanproject.net.OkhttpUtil;
import com.cn.hainanproject.utils.HighLightUtils;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.StatusBarUtils;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/2/23 库存盘点详情
 */
public class StockCheckDetailActivity extends AppCompatActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_common_title)
    TextView tvCommonTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_fun)
    ImageView ivFun;
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.tv_no)
    TextView tvNo;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.tv_statue)
    TextView tvStatue;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_own_company)
    TextView tvOwnCompany;
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.tv_dute)
    TextView tvDute;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.iv_contract_statue)
    ImageView ivContractStatue;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.nodata)
    ImageView nodata;
    private LoadingDialog ld;
    private String title;
    private StockCheckListBean.ResultBean.ResultlistBean listBean;
    private LinearLayoutManager layoutManager;
    private int currentPageNum=1;
    private boolean isRefresh;
    private String STOCKNUM;
    private String siteid;
    private CommonAdapter<StocCheckLineListBean.ResultBean.ResultlistBean> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_check_detail_acticity);
        ButterKnife.bind(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        if ((getIntent().getExtras().get("data") != null)) {
            listBean = (StockCheckListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("data");
            STOCKNUM=listBean.getSTOCKNUM();
            siteid=listBean.getSITEID();
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("title"))) {
            title = getIntent().getStringExtra("title");
        }
        ld = new LoadingDialog(this);
        initView();
    }

    private void initView() {
        tvCommonTitle.setText(title);
        SpannableString highlightNo = HighLightUtils.highlight(MyApplication.applicationContext, "盘点单号：" + listBean.getSTOCKNUM(), listBean.getSTOCKNUM(), "#03DAC5", 0, 0);
        tvNo.setText(highlightNo);
        tvDesc.setText("地点："+listBean.getSITEID());
        tvStatue.setText(listBean.getSTATUS());
        tvType.setText("实盘金额：" + listBean.getUDSUMCOST());
        tvOwnCompany.setVisibility(View.GONE);
        tvDute.setText("创建人：" + listBean.getCREATEBY());
        tvDate.setText("创建时间：" + listBean.getCREATEDATE());

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        getStockLine();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                getStockLine();


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                getStockLine();

            }
        });
    }


    private void getStockLine() {
        LogUtils.d("getPlanLine==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "UDSTOCKLINE");
        object.put("objectname", "UDSTOCKLINE");
        object.put("curpage", currentPageNum);
        object.put("showcount", 10);
        object.put("option", "read");
        object.put("orderby", "LINENUM asc");
        object.put("sqlSearch", "stocknum='" + STOCKNUM + "' " + " and type='O'");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                finishRefresh();
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                finishRefresh();
                if (response!=null){
                    final StocCheckLineListBean stocCheckLineListBean = JSONObject.parseObject(response, new TypeReference<StocCheckLineListBean>() {});
                    if (stocCheckLineListBean.getErrcode().equals("GLOBAL-S-0")) {
                        int total = stocCheckLineListBean.getResult().getTotalresult();
                        int totalpage = stocCheckLineListBean.getResult().getTotalpage();
                        if (total > 0) {
                            List<StocCheckLineListBean.ResultBean.ResultlistBean> list = stocCheckLineListBean.getResult().getResultlist();
                            LogUtils.d("222222 list.size()==" + list.size());
                            nodata.setVisibility(View.GONE);
                            if (currentPageNum == 1) {
                                if (adapter == null) {
                                    adapter = new CommonAdapter<StocCheckLineListBean.ResultBean.ResultlistBean>(MyApplication.applicationContext, R.layout.stock_check_line_item, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, final StocCheckLineListBean.ResultBean.ResultlistBean listBean) {
                                            CardView cardview = holder.getView(R.id.cardview);
                                            TextView tv_no = holder.getView(R.id.tv_no);
                                            TextView tv_eq_no = holder.getView(R.id.tv_eq_no);
                                            TextView tv_desc = holder.getView(R.id.tv_desc);
                                            TextView tv_store = holder.getView(R.id.tv_store);
                                            TextView tv_position = holder.getView(R.id.tv_position);
                                            TextView tv_kind = holder.getView(R.id.tv_kind);
                                            TextView tv_limits = holder.getView(R.id.tv_limits);
                                            TextView tv_cost = holder.getView(R.id.tv_cost);
                                            TextView tv_amount = holder.getView(R.id.tv_amount);
                                            TextView tv_stock_count = holder.getView(R.id.tv_stock_count);
                                            TextView tv_actually_count = holder.getView(R.id.tv_actually_count);
                                            TextView tv_diff_count = holder.getView(R.id.tv_diff_count);
                                            TextView tv_diff_money = holder.getView(R.id.tv_diff_money);

                                            SpannableString highlight = HighLightUtils.highlight(StockCheckDetailActivity.this, "序号：" + listBean.getLINENUM(), listBean.getLINENUM(), "#03DAC5", 0, 0);
                                            tv_no.setText(highlight);
                                            tv_eq_no.setText("备件编码："+listBean.getITEMNUM());
                                            tv_desc.setText("物料描述：" + listBean.getITEMNUMDESC());
                                            tv_store.setText("库房：" + listBean.getLOCATION());
                                            tv_position.setText("货位：" + listBean.getBINNUM());
                                            tv_kind.setText("分类：" + listBean.getHIERARCHYPATH());
                                            tv_limits.setText("使用范围：" + listBean.getUDRANGE());
                                            tv_cost.setText("平均成本：" + listBean.getUNITCOST());
                                            tv_amount.setText("实盘金额：" + listBean.getUDLINECOST());
                                            tv_stock_count.setText("库存量：" + listBean.getYPQUANTITY());
                                            tv_actually_count.setText("实盘量：" + listBean.getSPQUANTITY());
                                            tv_diff_count.setText("差异量：" + listBean.getCYQUANTITY());
                                            tv_diff_money.setText("差异金额：" + listBean.getCYLINECOST());

                                            holder.setTextSize(R.id.tv_no);
                                            holder.setTextSize(R.id.tv_eq_no);
                                            holder.setTextSize(R.id.tv_desc);
                                            holder.setTextSize(R.id.tv_store);
                                            holder.setTextSize(R.id.tv_position);
                                            holder.setTextSize(R.id.tv_kind);
                                            holder.setTextSize(R.id.tv_limits);
                                            holder.setTextSize(R.id.tv_cost);
                                            holder.setTextSize(R.id.tv_amount);
                                            holder.setTextSize(R.id.tv_stock_count);
                                            holder.setTextSize(R.id.tv_actually_count);


                                        }

                                    };
                                    recyclerView.setAdapter(adapter);

                                } else {
                                    adapter.setData(list);
                                    adapter.notifyDataSetChanged();
                                }
                            } else {
                                //不是第一页
                                if (currentPageNum <= totalpage) {
                                    adapter.addAllList(list);
                                    adapter.notifyDataSetChanged();
                                } else {
                                    ToastUtils.showShort("没有更多数据了");
                                }
                            }
                            if (adapter.getData().size() == 0) {
                                nodata.setVisibility(View.VISIBLE);

                            }

                        } else {
//                            refreshLayout.setVisibility(View.GONE);
                            nodata.setVisibility(View.VISIBLE);
                        }
                    }
                }


            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.ll_back)
    public void onViewClicked() {
        finish();
    }
    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }
}
