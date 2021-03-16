package com.cn.hainanproject.fragment;

import android.content.Context;
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
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.R;
import com.cn.hainanproject.activity.PurContractDetailActivity;
import com.cn.hainanproject.activity.PurchaseOrderDetailActivity;
import com.cn.hainanproject.adapter.CommonAdapter;
import com.cn.hainanproject.base.CommonViewHolder;
import com.cn.hainanproject.base.Constants;
import com.cn.hainanproject.base.MyApplication;
import com.cn.hainanproject.model.ContractLineListBean;
import com.cn.hainanproject.model.PurchseAttachBean;
import com.cn.hainanproject.model.PurchseContractListBean;
import com.cn.hainanproject.model.PurchseOrderListBean;
import com.cn.hainanproject.net.CallBackUtil;
import com.cn.hainanproject.net.OkhttpUtil;
import com.cn.hainanproject.utils.HighLightUtils;
import com.cn.hainanproject.utils.LogUtils;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/2/20
 */
public class AttachFragment extends Fragment {
    private final int mFlag;
    String vonder;
    PurchseOrderListBean.ResultBean.ResultlistBean mBean1;

     final Context mContext;
      PurchseContractListBean.ResultBean.ResultlistBean mBean;
     RefreshLayout refreshLayout;
    RecyclerView.LayoutManager layoutManager;
     boolean isRefresh;
    private int currentPageNum = 1;
    private LoadingDialog ld;
    private ImageView nodata;
    RecyclerView recyclerView;
    private CommonAdapter<PurchseAttachBean.ResultBean.ResultlistBean> adapter;
    private int contractid;
    String contractnum;
    String orgid;

    public AttachFragment(Context context, PurchseContractListBean.ResultBean.ResultlistBean listBean,int flag) {
        mContext=context;
        ld=new LoadingDialog(mContext);
        mBean=listBean;
        mFlag=flag;
        contractid=mBean.getCONTRACTID();
         contractnum = mBean.getCONTRACTNUM();
         orgid = mBean.getORGID();
         vonder=mBean.getVENDOR();
    }

    public AttachFragment(Context context, PurchseOrderListBean.ResultBean.ResultlistBean listBean,int flag) {
        mContext=context;
        ld=new LoadingDialog(mContext);
        mBean1=listBean;
        mFlag=flag;

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
        getContractAttach();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                getContractAttach();


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                getContractAttach();

            }
        });
    }
    private void getContractAttach() {
        ld.show();
        LogUtils.d("getContractDetail");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "DOCLINKS");
        object.put("objectname", "DOCLINKS");
        object.put("curpage", currentPageNum);
        object.put("showcount", 10);
        object.put("option", "read");
        object.put("orderby", "CREATEDATE DESC");
        String sqlSearch = null;
        if (mFlag==1){//采购合同
             sqlSearch = " (ownertable='PURCHVIEW' and ownerid=%s) " +
                    "or (ownertable='RFQLINE' and ownerid in (select rfqlineid from rfqline where contractnum=%s and orgid=%s))" +
                    " or (ownertable='PRLINE' and ownerid in (select prlineid from prline where contractnum=%s and orgid=%s)) " +
                    "or (ownertable='COMPANIES' and ownerid = (select companiesid from companies where company=%s and orgid=%s)) ";
            sqlSearch = String.format(sqlSearch, "'" + contractid + "'", "'" + contractnum + "'", "'" + orgid + "'", "'" +  contractnum + "'", "'" + orgid + "'", "'" +vonder  + "'", "'" + orgid + "'");

        }if (mFlag==2){//采购订单
            sqlSearch=" (ownertable='PO' and ownerid=%s) ";
            sqlSearch = String.format(sqlSearch, "'" + mBean1.getPOID() + "'");

        }

        object.put("sqlSearch", sqlSearch);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
                finishRefresh();
            }

            @Override
            public void onResponse(String response) {
                finishRefresh();
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (!response.isEmpty()) {
                    PurchseAttachBean attachBean = JSONObject.parseObject(response, new TypeReference<PurchseAttachBean>() {});
                    if (attachBean.getErrcode().equals("GLOBAL-S-0")) {
                        int total = attachBean.getResult().getTotalresult();
                        int totalpage=attachBean.getResult().getTotalpage();
                        if (total > 0) {
                            List<PurchseAttachBean.ResultBean.ResultlistBean> list = attachBean.getResult().getResultlist();
                            LogUtils.d("222222 list.size()==" + list.size());
                            nodata.setVisibility(View.GONE);
                            if (currentPageNum == 1) {
                                if (adapter == null) {
                                    adapter = new CommonAdapter<PurchseAttachBean.ResultBean.ResultlistBean>(MyApplication.applicationContext, R.layout.contract_detail_attach, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, final PurchseAttachBean.ResultBean.ResultlistBean listBean) {


                                            TextView tv_attach_no =  holder.getView(R.id.tv_attach_no);
                                            TextView tv_attach_desc =  holder.getView(R.id.tv_attach_desc);
                                            TextView tv_upload_time =  holder.getView(R.id.tv_upload_time);
                                            tv_attach_no.setText("附件编号：" + listBean.getDOCINFOID());
                                            tv_attach_desc.setText(HighLightUtils.highlight(mContext, "附件描述：" + listBean.getDOCDESC(), listBean.getDOCDESC(), "#03DAC5", 0, 0));
                                            tv_upload_time.setText("上传日期：" + listBean.getCREATEDATE());


                                            holder.setTextSize(R.id.tv_attach_no);
                                            holder.setTextSize(R.id.tv_attach_desc);
                                            holder.setTextSize(R.id.tv_upload_time);

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
                    }else {
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
