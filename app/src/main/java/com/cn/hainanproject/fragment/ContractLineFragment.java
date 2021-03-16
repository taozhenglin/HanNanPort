package com.cn.hainanproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.R;
import com.cn.hainanproject.activity.PurContractDetailActivity;
import com.cn.hainanproject.activity.PurchaseContractListActivity;
import com.cn.hainanproject.adapter.CommonAdapter;
import com.cn.hainanproject.base.CommonViewHolder;
import com.cn.hainanproject.base.Constants;
import com.cn.hainanproject.base.MyApplication;
import com.cn.hainanproject.model.ContractLineListBean;
import com.cn.hainanproject.model.PurchseContractListBean;
import com.cn.hainanproject.net.CallBackUtil;
import com.cn.hainanproject.net.OkhttpUtil;
import com.cn.hainanproject.utils.HighLightUtils;
import com.cn.hainanproject.utils.LogUtils;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/2/20
 */
public class ContractLineFragment extends Fragment {

    private final Context mContext;
    private final PurchseContractListBean.ResultBean.ResultlistBean mBean;
    private RefreshLayout refreshLayout;
    RecyclerView.LayoutManager layoutManager;
    private boolean isRefresh;
    private int currentPageNum = 1;
    private LoadingDialog ld;
    private ImageView nodata;
    RecyclerView recyclerView;
    private CommonAdapter<ContractLineListBean.ResultBean.ResultlistBean> adapter;

    public ContractLineFragment(Context context, PurchseContractListBean.ResultBean.ResultlistBean listBean) {
        mContext = context;
        mBean = listBean;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contract_line_fragment, container, false);
        nodata=view.findViewById(R.id.nodata);
        recyclerView=view.findViewById(R.id.recyclerView);
        refreshLayout=view.findViewById(R.id.refreshLayout);
        layoutManager=new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ld=new LoadingDialog(mContext);
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
        object.put("appid", "CONTRACTLINE");
        object.put("objectname", "CONTRACTLINE");
        object.put("curpage", currentPageNum);
        object.put("showcount", 10);
        object.put("option", "read");
        object.put("sqlSearch", "contractnum = " + "'"+mBean.getCONTRACTNUM()+"'" + "and revisionnum =" + "'"+0+"'" + " and orgid = " + "'"+mBean.getORGID()+"'");

//        object.put("orderby", "STARTDATE DESC");
        JSONObject searchobj = new JSONObject();//模糊查询
//        searchobj.put("CONTRACTNUM", edt_search.getText().toString());
//        searchobj.put("DESCRIPTION", edt_search.getText().toString());
//        searchobj.put("HTYF", edt_search_contract.getText().toString());
//        object.put("sinorsearch", searchobj);
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
                if (response != null) {
                    final ContractLineListBean contractLineListBean = JSONObject.parseObject(response, new TypeReference<ContractLineListBean>() {});
                    if (contractLineListBean.getErrcode().equals("GLOBAL-S-0")) {
                        int total = contractLineListBean.getResult().getTotalresult();
                       int totalpage = contractLineListBean.getResult().getTotalpage();
                        if (total > 0) {
                            List<ContractLineListBean.ResultBean.ResultlistBean> list = contractLineListBean.getResult().getResultlist();
                            LogUtils.d("222222 list.size()==" + list.size());
                            nodata.setVisibility(View.GONE);
                            if (currentPageNum == 1) {
                                if (adapter == null) {
                                    adapter = new CommonAdapter<ContractLineListBean.ResultBean.ResultlistBean>(MyApplication.applicationContext, R.layout.contract_line_list_item, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, final ContractLineListBean.ResultBean.ResultlistBean listBean) {
                                            CardView cardview = holder.getView(R.id.cardview);
                                            TextView tv_empty = holder.getView(R.id.tv_empty);
                                            TextView tv_no = holder.getView(R.id.tv_no);
                                            TextView tv_item_num = holder.getView(R.id.tv_item_num);
                                            TextView tv_item_desc = holder.getView(R.id.tv_item_desc);
                                            TextView tv_model = holder.getView(R.id.tv_model);
                                            TextView tv_unit = holder.getView(R.id.tv_unit);
                                            TextView tv_brand = holder.getView(R.id.tv_brand);
                                            TextView tv_count = holder.getView(R.id.tv_count);
                                            TextView tv_price = holder.getView(R.id.tv_price);
                                            TextView tv_total = holder.getView(R.id.tv_total);
                                            SpannableString highlightNo = HighLightUtils.highlight(MyApplication.applicationContext, "行编号：" + listBean.getCONTRACTLINENUM(), listBean.getCONTRACTLINENUM(), "#03DAC5", 0, 0);
                                            tv_no.setText(highlightNo);
                                            tv_item_num.setText("物资编码：" + listBean.getITEMNUM());
                                            tv_item_desc.setText("物资描述：" + listBean.getITEMDESC());
                                            tv_model.setText("规格型号：" + listBean.getITEMXH());
                                            tv_unit.setText("订购单位：" + listBean.getORDERUNIT());
                                            tv_brand.setText("品牌：" + listBean.getITEMPP());
                                            tv_count.setText("数量：" + listBean.getORDERQTY());
                                            tv_price.setText("单价：" + listBean.getUNITCOST());
                                            tv_total.setText("总价：" + listBean.getLINECOST());

                                            holder.setTextSize(R.id.tv_no);
                                            holder.setTextSize(R.id.tv_item_num);
                                            holder.setTextSize(R.id.tv_item_desc);
                                            holder.setTextSize(R.id.tv_model);
                                            holder.setTextSize(R.id.tv_unit);
                                            holder.setTextSize(R.id.tv_brand);
                                            holder.setTextSize(R.id.tv_count);
                                            holder.setTextSize(R.id.tv_price);
                                            holder.setTextSize(R.id.tv_total);


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
                    } else {
                        ToastUtils.showShort(R.string.GETDATAFAILED);
                    }
                }

            }
        });
    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }


}
