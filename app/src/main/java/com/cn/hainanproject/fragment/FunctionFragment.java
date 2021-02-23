package com.cn.hainanproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cn.hainanproject.R;
import com.cn.hainanproject.activity.FixedassetPdListActivity;
import com.cn.hainanproject.activity.FixedassetYsListActivity;
import com.cn.hainanproject.activity.MaterialRequestListActivity;
import com.cn.hainanproject.activity.ProjectContractListActivity;
import com.cn.hainanproject.activity.PurchaseContractListActivity;
import com.cn.hainanproject.activity.PurchaseMonthPlanListActivity;
import com.cn.hainanproject.activity.PurchaseOrderListActivity;
import com.cn.hainanproject.activity.StockCheckListActivity;
import com.cn.hainanproject.activity.StockMoveListActivity;
import com.cn.hainanproject.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by tzl
 * on 2020/12/14
 */
public class FunctionFragment extends Fragment {
    final Context mContext;
    LinearLayout ll_equment;
    @BindView(R.id.tv_purchase_contract)
    TextView tvPurchaseContract;
    @BindView(R.id.tv_project_contract)
    TextView tvProjectContract;
    @BindView(R.id.tv_stock_move)
    TextView tvStockMove;
    @BindView(R.id.tv_purchase_order)
    TextView tvPurchaseOrder;
    @BindView(R.id.tv_assert_ys)
    TextView tvFixassertYs;
    @BindView(R.id.tv_stock_check)
    TextView tvStockcheck;
    @BindView(R.id.tv_material_request)
    TextView tvMaterialrequest;
    @BindView(R.id.tv_pur_month_plan)
    TextView tvPurmonthplan;
    @BindView(R.id.tv_assert_pd)
    TextView tvAssertpd;



    public FunctionFragment(Context context) {
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmrnt1, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @OnClick({R.id.tv_purchase_contract, R.id.tv_project_contract,R.id.tv_stock_move, R.id.tv_purchase_order,R.id.tv_assert_ys,R.id.tv_assert_pd,
            R.id.tv_stock_check,R.id.tv_material_request,R.id.tv_pur_month_plan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_purchase_contract://采购合同
                LogUtils.d("onViewClicked tv_purchase_contract");
                mContext.startActivity(new Intent(mContext, PurchaseContractListActivity.class));
                break;
            case R.id.tv_project_contract://项目合同
                LogUtils.d("onViewClicked tv_purchase_order");
                mContext.startActivity(new Intent(mContext, ProjectContractListActivity.class));
                break;
            case R.id.tv_stock_move://库存转移
                LogUtils.d("onViewClicked tv_stock_move");
                mContext.startActivity(new Intent(mContext, StockMoveListActivity.class));
                break;
            case R.id.tv_purchase_order://采购订单
                LogUtils.d("onViewClicked tv_purchase_order");
                mContext.startActivity(new Intent(mContext, PurchaseOrderListActivity.class));
                break;
            case R.id.tv_assert_ys://固定资产验收
                LogUtils.d("onViewClicked tv_purchase_order");
                mContext.startActivity(new Intent(mContext, FixedassetYsListActivity.class));
                break;
            case R.id.tv_assert_pd://固定资产盘点
                LogUtils.d("onViewClicked tv_purchase_order");
                mContext.startActivity(new Intent(mContext, FixedassetPdListActivity.class));
                break;
            case R.id.tv_stock_check://库存盘点
                LogUtils.d("onViewClicked tv_purchase_order");
                mContext.startActivity(new Intent(mContext, StockCheckListActivity.class));
                break;
            case R.id.tv_material_request://领料申请
                LogUtils.d("onViewClicked tv_purchase_order");
                mContext.startActivity(new Intent(mContext, MaterialRequestListActivity.class));
                break;
            case R.id.tv_pur_month_plan://采购月度计划
                LogUtils.d("onViewClicked tv_purchase_order");
                mContext.startActivity(new Intent(mContext, PurchaseMonthPlanListActivity.class));
                break;
        }
    }
}
