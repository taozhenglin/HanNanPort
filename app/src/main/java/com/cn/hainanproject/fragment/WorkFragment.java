package com.cn.hainanproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
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
import com.cn.hainanproject.model.PostData;
import com.cn.hainanproject.model.WaitDoListBean;
import com.cn.hainanproject.net.CallBackUtil;
import com.cn.hainanproject.net.OkhttpUtil;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.SharedPreferencesUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
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
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.scwang.smart.refresh.layout.simple.SimpleMultiListener;
import com.scwang.smart.refresh.layout.util.SmartUtil;
import com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper;
import com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.header.DeliveryHeader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/2/2
 */
public class WorkFragment extends Fragment implements View.OnClickListener {
    private final Context mContext;
    private LoadingDialog ld;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    int currentPageNum = 1;
    private boolean isRefresh;
    private int totalepage;
    private LinearLayout ll_top;
    private TextView tv_select_all;
    private TextView tv_unselect_all;
    private TextView tv_commit_all;
//    List<WaitDoListBean.ResultBean.ResultlistBean> resultlist;
    private TextView tv_select_menu;
    private List<WaitDoListBean.ResultBean.ResultlistBean> resultlist;
    private CommonAdapter<WaitDoListBean.ResultBean.ResultlistBean> adapter;
    private ImageView nodata;

    public WorkFragment(Context context) {
        mContext=context;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.waitdo_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        refreshLayout = view.findViewById(R.id.refreshLayout);
//        mainListAdapter.setShowLine(false);
        layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ll_top = view.findViewById(R.id.ll_top);
        tv_select_menu = view.findViewById(R.id.tv_select_menu);
        tv_select_all = view.findViewById(R.id.tv_select_all);
        tv_unselect_all = view.findViewById(R.id.tv_unselect_all);
        tv_commit_all = view.findViewById(R.id.tv_commit_all);
        nodata=view.findViewById(R.id.nodata);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEvent();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    void initEvent() {
        tv_select_menu.setOnClickListener(this);
        tv_select_all.setOnClickListener(this);
        tv_unselect_all.setOnClickListener(this);
        tv_commit_all.setOnClickListener(this);
        queryData();
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
                                refreshLayout.setRefreshFooter(new RefreshFooterWrapper(new DropBoxHeader(mContext)));
                            } else if (footerView instanceof DropBoxHeader) {
                                refreshLayout.setRefreshFooter(new RefreshFooterWrapper(new DeliveryHeader(mContext)));
                            } else if (footerView instanceof com.scwang.smart.refresh.header.DeliveryHeader) {
                                refreshLayout.setRefreshFooter(new RefreshFooterWrapper(new BezierCircleHeader(mContext)));
                            } else {
                                refreshLayout.setRefreshFooter(new BallPulseFooter(mContext));
                            }
                        }
                    } else if (oldState == RefreshState.RefreshFinish) {
                        RefreshHeader refreshHeader = refreshLayout.getRefreshHeader();
                        if (refreshHeader instanceof RefreshHeaderWrapper) {
                            refreshLayout.setRefreshHeader(new PhoenixHeader(mContext), ViewGroup.LayoutParams.MATCH_PARENT, SmartUtil.dp2px(100));
                        } else if (refreshHeader instanceof PhoenixHeader) {
                            refreshLayout.setRefreshHeader(new DeliveryHeader(mContext), ViewGroup.LayoutParams.MATCH_PARENT, SmartUtil.dp2px(150));
                        } else if (refreshHeader instanceof DeliveryHeader) {
                            refreshLayout.setRefreshHeader(new FunGameHitBlockHeader(mContext));
                        } else if (refreshHeader instanceof FunGameHitBlockHeader) {
                            refreshLayout.setRefreshHeader(new ClassicsHeader(mContext));
                        } else {
                            refreshLayout.setRefreshHeader(new RefreshHeaderWrapper(new BallPulseFooter(mContext)));
                        }
                    }
                }
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
//                if (mWaitDoAdapter != null) {
//                    mWaitDoAdapter.mFlag = false;
//                    tv_select_menu.setText("编辑");
//                }
                queryData();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                queryData();
            }
        });
    }

    private void queryData() {
        ld = new LoadingDialog(mContext);
        ld.show();
        /**
         * ---代办任务记录
         * {"appid":"WFASSIGNMENT","objectname":"WFASSIGNMENT","curpage":1,"showcount":20,"option":"read","orderby":"startdate desc",
         * "sqlSearch":"  exists (select personid from maxuser where loginid='HUYUE'
         * and wfassignment.assigncode=maxuser.personid)
         * and assignstatus='活动' and processname in('PO','RFQ','CONTPURCH','PRSUM','PR','GPDTZ','VENAPPLY','JLTZ','MATREQ','SBTZ','SSTZ','XMHT','UDXMHTBG','PRPROJ','XBJ','PROJSUM','XXHTZ','CONTRACTPO','INVUSEZY','FIXEDASSETJS','FIXEASSETRET')"}
         */
        LogUtils.d("query");
        LogUtils.d("currentPageNum" + currentPageNum);
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "WFASSIGNMENT");
        object.put("objectname", "WFASSIGNMENT");
        object.put("curpage", currentPageNum);
        object.put("showcount", 10);
        object.put("option", "read");
        object.put("orderby", "startdate desc");
//        String sqlSearch = " exists (select personid from maxuser where loginid=%s " +
//                "and wfassignment.assigncode=maxuser.personid)  " +
//                "and assignstatus='活动' and processname in('PO','RFQ','CONTPURCH','PRSUM','PR','GPDTZ','VENAPPLY','JLTZ','MATREQ','SBTZ','SSTZ','XMHT','UDXMHTBG','PRPROJ','XBJ','PROJSUM','XXHTZ','CONTRACTPO','INVUSEZY','UDFIXYSRG','UDFIXBF','UDFIXZZ','UDPRYS')";
        String sqlSearch="ASSIGNCODE= %s and assignstatus='活动'";
        sqlSearch = String.format(sqlSearch, "'" + SharedPreferencesUtil.getString(mContext, "personId") + "'");
        object.put("sqlSearch", sqlSearch);

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
                WaitDoListBean waitDoListBean = null;
                finishRefresh();
                ld.close();
                 waitDoListBean = JSONObject.parseObject(response, new TypeReference<WaitDoListBean>() {});

                if (!response.isEmpty()) {
                    if (response.startsWith("Error")) {
                        ToastUtils.showShort(R.string.GETDATAFAILED);
                    } else {
                        if (waitDoListBean.getErrcode().equals("GLOBAL-S-0")) {
                            int total=waitDoListBean.getResult().getTotalresult();
                            SharedPreferencesUtil.setInt(mContext,"waitdocount",total);
                            PostData postData=new PostData();
                            postData.setTag("refresh waitdo");
                            EventBus.getDefault().post(postData);
                            int totalpage = waitDoListBean.getResult().getTotalpage();
                            if (total > 0) {
                                List<WaitDoListBean.ResultBean.ResultlistBean> list = waitDoListBean.getResult().getResultlist();
                                LogUtils.d("222222 list.size()==" + list.size());
                                nodata.setVisibility(View.GONE);
                                if (currentPageNum == 1) {
                                    if (adapter == null) {
                                        adapter = new CommonAdapter<WaitDoListBean.ResultBean.ResultlistBean>(MyApplication.applicationContext, R.layout.waitdo_list_item, list) {
                                            @Override
                                            public void convert(CommonViewHolder holder, final WaitDoListBean.ResultBean.ResultlistBean listBean) {
                                                CardView cardview = holder.getView(R.id.cardview);
                                               

                                                TextView tv_title = holder.getView(R.id.tv_title);
                                                TextView tv_desc = holder.getView(R.id.tv_desc);
                                                TextView tv_date = holder.getView(R.id.tv_date);
                                                TextView  tv_type = holder.getView(R.id.tv_type);
//                                                CheckBox checkbox = holder.getView(R.id.checkbox);
                                                switch (listBean.getPROCESSNAME()) {
                                                    case "PO":
                                                       tv_title.setText("采购订单");
                                                        break;
                                                    case "RFQ":
                                                       tv_title.setText("采购询价单");
                                                        break;
                                                    case "PURCHVIEW":
                                                       tv_title.setText("采购合同");
                                                        break;
                                                    case "PRSUM":
                                                       tv_title.setText("采购计划月度汇总");
                                                        break;
                                                    case "PR":
                                                       tv_title.setText("采购月度计划");
                                                        break;
                                                    case "GPDTZ":
                                                       tv_title.setText("供配电设备台账增减申请");
                                                        break;
                                                    case "VENAPPLY":
                                                       tv_title.setText("供应商申请");
                                                        break;
                                                    case "JLTZ":
                                                       tv_title.setText("计量设备台账增减申请");
                                                        break;
                                                    case "WORKORDER":
                                                       tv_title.setText("领料申请单");
                                                        break;
                                                    case "SBTZ":
                                                       tv_title.setText("设备台账增减申请");
                                                        break;
                                                    case "SSTZ":
                                                       tv_title.setText("设施台账增减申请");
                                                        break;
                                                    case "WZBMSQ":
                                                       tv_title.setText("物资编码申请");
                                                        break;
                                                    case "XMHT":
                                                       tv_title.setText("项目合同");
                                                        break;
                                                    case "UDXMHTBG":
                                                       tv_title.setText("项目合同变更");
                                                        break;
                                                    case "PRPROJ":
                                                       tv_title.setText("项目立项/项目月度计划");
                                                        break;
                                                    case "XBJ":
                                                       tv_title.setText("项目询价单");
                                                        break;
                                                    case "PROJSUM":
                                                       tv_title.setText("项目月度计划汇总");
                                                        break;
                                                    case "XXHTZ":
                                                       tv_title.setText("信息化台账增减申请");
                                                        break;
                                                    case "CONTRACTPO":
                                                       tv_title.setText("采购订单");
                                                        break;
                                                    case "INVUSE":
                                                       tv_title.setText("库存转移");
                                                        break;
                                                    case "FIXEDYS":
                                                       tv_title.setText("固定资产验收");
                                                        break;
                                                    case "FIXEDASJS":
                                                       tv_title.setText("固定资产接收");
                                                        break;
                                                    case "UDFIXBF":
                                                       tv_title.setText("固定资产处置");
                                                        break;
                                                    case "UDMGPR":
                                                       tv_title.setText("物资采购申请");
                                                        break;

                                                }
                                                tv_desc.setText(listBean.getDESCRIPTION());
                                                tv_date.setText(listBean.getSTARTDATE() + "");
                                                tv_type.setText(listBean.getASSIGNSTATUS() + "");
                                                
//                                                SpannableString highlightNo = HighLightUtils.highlight(MyApplication.applicationContext, "盘点单号：" + listBean.getFIXPDNUM(), edt_search.getText().toString(), "#03DAC5", 0, 0);
//                                                tv_no.setText(highlightNo);
//                                                SpannableString highlight = HighLightUtils.highlight(MyApplication.applicationContext, "备注：" + listBean.getMEMO(), edt_search.getText().toString(), "#03DAC5", 0, 0);
//                                                tv_desc.setText(highlight);
//                                                holder.setStatues(listBean.getPDZT(),iv_contract_statue,tv_statue);
//                                                tv_type.setText("盘点开始日期：" + listBean.getSTARTDATE());
//                                                tv_own_company.setText("盘点结束日期：" + listBean.getENDDATE());
//                                                tv_dute.setText("盘点人：" + listBean.getPDUSER());
//                                                tv_date.setText("创建日期：" + listBean.getPDZTDATE());

                                                holder.setTextSize(R.id.tv_title);
                                                holder.setTextSize(R.id.tv_desc);
                                                holder.setTextSize(R.id.tv_date);
                                                holder.setTextSize(R.id.tv_type);


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
                }
            }
        });

    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

    // 收到扫描盘点界面上传盘点ok后的通知 刷新列表
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotify(PostData postData) {
        if (postData.getTag().equals("采购合同") || postData.getTag().equals("项目合同") ||
                postData.getTag().equals("领料单") || postData.getTag().equals("库存转移") ||
                postData.getTag().equals("计量设备台账增减申请") || postData.getTag().equals("设备台账增减申请") ||
                postData.getTag().equals("信息化台账增减申请") || postData.getTag().equals("设施台账增减申请") ||
                postData.getTag().equals("供配电设备台账增减申请") || postData.getTag().equals("供应商申请") ||
                postData.getTag().equals("采购月度计划汇总") || postData.getTag().equals("采购月度计划") ||
                postData.getTag().equals("采购询价单") || postData.getTag().equals("采购订单") ||
                postData.getTag().equals("入库单") || postData.getTag().equals("项目合同变更") ||
                postData.getTag().equals("项目月度计划汇总") || postData.getTag().equals("项目询价单") ||
                postData.getTag().equals("项目立项/项目月度计划") || postData.getTag().equals("固定资产接收") ||
                postData.getTag().equals("固定资产处置") || postData.getTag().equals("项目验收")
        ) {
            queryData();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.tv_select_menu:
//                mWaitDoAdapter.mFlag = !mWaitDoAdapter.mFlag;
//
//                if (mWaitDoAdapter.mFlag) {
//                    tv_select_menu.setText("取消");
//                } else {
//                    tv_select_menu.setText("编辑");
//                }
//                mWaitDoAdapter.notifyDataSetChanged();
//                break;
//            case R.id.tv_select_all:
//                if (mWaitDoAdapter.mFlag) {
//                    for (int i = 0; i < mWaitDoAdapter.getData().size(); i++) {
//                        mWaitDoAdapter.getData().get(i).setChecked(true);
//                    }
//                }
//                mWaitDoAdapter.notifyDataSetChanged();
//                break;
//            case R.id.tv_unselect_all:
//                if (mWaitDoAdapter.mFlag) {
//                    for (int i = 0; i < mWaitDoAdapter.getData().size(); i++) {
//                        mWaitDoAdapter.getData().get(i).setChecked(false);
//                    }
//                }
//                mWaitDoAdapter.notifyDataSetChanged();
//                break;
//            case R.id.tv_commit_all:
//                List<String> ids = new ArrayList<>();
//                if (mWaitDoAdapter.mFlag) {
//                    for (int i = 0; i < mWaitDoAdapter.getData().size(); i++) {
//                        if (mWaitDoAdapter.getData().get(i).getChecked()) {
//                            ids.add(mWaitDoAdapter.getData().get(i).getOWNERID() + "");
//                        }
//                    }
//                    LogUtils.d("222222    "+ids.size());
//
//                }
//                break;
        }
    }

}
