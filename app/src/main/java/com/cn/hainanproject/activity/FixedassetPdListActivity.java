package com.cn.hainanproject.activity;

import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.R;
import com.cn.hainanproject.adapter.CommonAdapter;
import com.cn.hainanproject.base.CommonViewHolder;
import com.cn.hainanproject.base.Constants;
import com.cn.hainanproject.base.MyApplication;
import com.cn.hainanproject.model.FixedassetPdListBean;
import com.cn.hainanproject.model.PostData;
import com.cn.hainanproject.model.PurchseMonthPlanListBean;
import com.cn.hainanproject.net.CallBackUtil;
import com.cn.hainanproject.net.OkhttpUtil;
import com.cn.hainanproject.utils.HighLightUtils;
import com.cn.hainanproject.utils.LogUtils;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/2/20
 */
public class FixedassetPdListActivity extends BaseListActivity{
    private int currentPageNum = 1;

    //    private EditText edt_search_contract;
    private boolean isRefresh = true;//是否刷新数据
    private TextView tv_search;
    private int totalpage;
    private LoadingDialog ld;
    private CommonAdapter<FixedassetPdListBean.ResultBean.ResultlistBean> adapter;
    @Override
    public void initView() {
        tv_common_title.setText("固定资产盘点");
        edt_search.setHint("盘点单号/描述");
    }

    public void initEvent() {
        ld = new LoadingDialog(this);
        query();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                query();


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                query();
            }
        });

    }
    private void query() {

        LogUtils.d("query");
        ld.show();
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "FIXPD");
        object.put("objectname", "FIXPD");
        object.put("curpage", currentPageNum);
        object.put("showcount", 10);
        object.put("option", "read");
//        object.put("orderby", "STARTDATE DESC");
        JSONObject searchobj = new JSONObject();//模糊查询
        searchobj.put("FIXPDNUM", edt_search.getText().toString());
        searchobj.put("DESCRIPTION", edt_search.getText().toString());
//        searchobj.put("HTYF", edt_search_contract.getText().toString());
        object.put("sinorsearch", searchobj);
//        object.put("sqlSearch", "LB='采购合同'  and nvl(UDCGHTLX,'1') <> '采购订单'");
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
                final FixedassetPdListBean fixedassetPdListBean = JSONObject.parseObject(response, new TypeReference<FixedassetPdListBean>() {});
                if (fixedassetPdListBean.getErrcode().equals("GLOBAL-S-0")) {
                    int total=fixedassetPdListBean.getResult().getTotalresult();
                    totalpage = fixedassetPdListBean.getResult().getTotalpage();
                    if (total > 0) {
                        List<FixedassetPdListBean.ResultBean.ResultlistBean> list = fixedassetPdListBean.getResult().getResultlist();
                        LogUtils.d("222222 list.size()==" + list.size());
                        nodata.setVisibility(View.GONE);
                        if (currentPageNum == 1) {
                            if (adapter == null) {
                                adapter = new CommonAdapter<FixedassetPdListBean.ResultBean.ResultlistBean>(MyApplication.applicationContext, R.layout.equipment_list_item, list) {
                                    @Override
                                    public void convert(CommonViewHolder holder, final FixedassetPdListBean.ResultBean.ResultlistBean listBean) {
                                        CardView cardview = holder.getView(R.id.cardview);
                                        TextView tv_empty = holder.getView(R.id.tv_empty);
                                        TextView tv_no = holder.getView(R.id.tv_no);
                                        TextView tv_statue = holder.getView(R.id.tv_statue);
                                        ImageView iv_contract_statue=holder.getView(R.id.iv_contract_statue);
                                        TextView tv_type = holder.getView(R.id.tv_type);
                                        TextView tv_own_company = holder.getView(R.id.tv_own_company);
                                        TextView tv_desc = holder.getView(R.id.tv_desc);
                                        TextView tv_dute = holder.getView(R.id.tv_dute);
                                        TextView tv_date = holder.getView(R.id.tv_date);
                                        SpannableString highlightNo = HighLightUtils.highlight(MyApplication.applicationContext, "盘点单号：" + listBean.getFIXPDNUM(), edt_search.getText().toString(), "#03DAC5", 0, 0);
                                        tv_no.setText(highlightNo);
                                        SpannableString highlight = HighLightUtils.highlight(MyApplication.applicationContext, "备注：" + listBean.getMEMO(), edt_search.getText().toString(), "#03DAC5", 0, 0);
                                        tv_desc.setText(highlight);
                                        holder.setStatues(listBean.getPDZT(),iv_contract_statue,tv_statue);
                                        tv_type.setText("盘点开始日期：" + listBean.getSTARTDATE());
                                        tv_own_company.setText("盘点结束日期：" + listBean.getENDDATE());
                                        tv_dute.setText("盘点人：" + listBean.getPDUSER());
                                        tv_date.setText("创建日期：" + listBean.getPDZTDATE());

                                        holder.setTextSize(R.id.tv_empty);
                                        holder.setTextSize(R.id.tv_no);
                                        holder.setTextSize(R.id.tv_statue);
                                        holder.setTextSize(R.id.tv_type);
                                        holder.setTextSize(R.id.tv_desc);
                                        holder.setTextSize(R.id.tv_own_company);
                                        holder.setTextSize(R.id.tv_dute);
                                        holder.setTextSize(R.id.tv_date);

                                        holder.setOnClickListener(R.id.cardview, new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
//                                                startActivity(new Intent(PurchaseMonthPlanListActivity.this,PurchaseOrderDetailActivity.class).putExtra("data",listBean).putExtra("title","采购订单详情"));
                                            }
                                        });
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
                    }
                    else {
//                            refreshLayout.setVisibility(View.GONE);
                        nodata.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_search:
                currentPageNum = 1;
                query();
                break;
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotify(PostData postData) {
        if (postData.getTag().equals("采购月度计划")) {
            query();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
