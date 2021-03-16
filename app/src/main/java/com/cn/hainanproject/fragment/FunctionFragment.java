package com.cn.hainanproject.fragment;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.cn.hainanproject.R;
import com.cn.hainanproject.activity.FixedassetCzListActivity;
import com.cn.hainanproject.activity.FixedassetDbListActivity;
import com.cn.hainanproject.activity.FixedassetFcListActivity;
import com.cn.hainanproject.activity.FixedassetJsListActivity;
import com.cn.hainanproject.activity.FixedassetPdListActivity;
import com.cn.hainanproject.activity.FixedassetTzListActivity;
import com.cn.hainanproject.activity.FixedassetWjListActivity;
import com.cn.hainanproject.activity.FixedassetYsListActivity;
import com.cn.hainanproject.activity.GzWorkOrderListActivity;
import com.cn.hainanproject.activity.MaterialRequestListActivity;
import com.cn.hainanproject.activity.ProjectContractListActivity;
import com.cn.hainanproject.activity.PurchaseContractListActivity;
import com.cn.hainanproject.activity.PurchaseMonthPlanListActivity;
import com.cn.hainanproject.activity.PurchaseOrderListActivity;
import com.cn.hainanproject.activity.StockCheckListActivity;
import com.cn.hainanproject.activity.StockMoveListActivity;
import com.cn.hainanproject.activity.WxServerContractListActivity;
import com.cn.hainanproject.activity.WxServerListActivity;
import com.cn.hainanproject.activity.WxServerPurchaseOrderListActivity;
import com.cn.hainanproject.activity.WxServerXbjListActivity;
import com.cn.hainanproject.net.CallBackUtil;
import com.cn.hainanproject.net.OkhttpUtil;
import com.cn.hainanproject.utils.DownloadUtil;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.OpenFileUtils;
import com.cn.hainanproject.utils.SharedPreferencesUtil;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;


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
    @BindView(R.id.tv_purchase_request)
    TextView tvPurchaseRequest;
    @BindView(R.id.tv_assert_pd)
    TextView tvAssertpd;
    @BindView(R.id.tv_workorder_cm)
    TextView tvWorkorderCm;
    @BindView(R.id.tv_workorder_sr)
    TextView tvWorkorderSr;
    @BindView(R.id.tv_workorder_pm)
    TextView tvWorkorderPm;
    @BindView(R.id.tv_workorder_pj)
    TextView tvWorkorderPj;
    @BindView(R.id.tv_workorder_jc)
    TextView tvWorkorderJc;
    @BindView(R.id.tv_workorder_dxj)
    TextView tvWorkorderDxj;
    @BindView(R.id.tv_workorder_zg)
    TextView tvWorkorderZg;
    @BindView(R.id.tv_workorder_em)
    TextView tvWorkorderEm;
    @BindView(R.id.tv_workorder_ospr)
    TextView tvWorkorderOspr;
    @BindView(R.id.tv_year_purchase_order)
    TextView tvYearPurchaseOrder;
    @BindView(R.id.tv_office_request)
    TextView tvOfficeRequest;
    @BindView(R.id.tv_assert_request)
    TextView tvAssertRequest;
    @BindView(R.id.tv_item_request)
    TextView tvItemRequest;
    @BindView(R.id.tv_assert_js)
    TextView tvAssertJs;
    @BindView(R.id.tv_assert_tz)
    TextView tvAssertTz;
    @BindView(R.id.tv_assert_cz)
    TextView tvAssertCz;
    @BindView(R.id.tv_assert_fc)
    TextView tvAssertFc;
    @BindView(R.id.tv_assert_wj)
    TextView tvAssertWj;
    @BindView(R.id.tv_assert_db)
    TextView tvAssertDb;
    @BindView(R.id.tv_download)
    TextView tvDownLoad;
    @BindView(R.id.tv_wx_xbj)
    TextView tvWxxBJ;
    @BindView(R.id.tv_wx_contract)
    TextView tvWxContract;
    @BindView(R.id.tv_wx_order)
    TextView tvWxOrder;
    File file;

    public FunctionFragment(Context context) {
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmrnt1, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkNeedPermissions();

    }


    @OnClick({R.id.tv_download, R.id.tv_purchase_contract, R.id.tv_project_contract, R.id.tv_stock_move, R.id.tv_purchase_order,
            R.id.tv_year_purchase_order, R.id.tv_purchase_request, R.id.tv_office_request, R.id.tv_assert_request, R.id.tv_item_request,
            R.id.tv_assert_ys, R.id.tv_assert_js, R.id.tv_assert_pd, R.id.tv_assert_tz, R.id.tv_assert_cz, R.id.tv_assert_fc,
            R.id.tv_assert_wj, R.id.tv_assert_db, R.id.tv_stock_check, R.id.tv_material_request, R.id.tv_workorder_cm,
            R.id.tv_workorder_sr, R.id.tv_workorder_pm, R.id.tv_workorder_pj, R.id.tv_workorder_jc, R.id.tv_workorder_dxj,
            R.id.tv_workorder_zg, R.id.tv_workorder_em, R.id.tv_workorder_ospr,R.id.tv_wx_order,R.id.tv_wx_contract,R.id.tv_wx_xbj})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_download://采购合同

                downLoad(mContext, "http://192.168.1.180:7010/maximo/webclient/login/app-debug.apk", "app-debug.apk", "001");
                break;
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
            case R.id.tv_purchase_order://非年度采购订单
                LogUtils.d("onViewClicked tv_purchase_order");
                mContext.startActivity(new Intent(mContext, PurchaseOrderListActivity.class).putExtra("type", "UNYEAR").putExtra("title", "非年度采购订单"));
                break;
            case R.id.tv_year_purchase_order://年度采购订单
                LogUtils.d("onViewClicked tv_purchase_order");
                mContext.startActivity(new Intent(mContext, PurchaseOrderListActivity.class).putExtra("type", "YEAR").putExtra("title", "年度采购订单"));
                break;
            case R.id.tv_assert_ys://固定资产验收
                LogUtils.d("onViewClicked tv_purchase_order");
                mContext.startActivity(new Intent(mContext, FixedassetYsListActivity.class));
                break;
            case R.id.tv_assert_js://固定资产接收
                mContext.startActivity(new Intent(mContext, FixedassetJsListActivity.class));
                break;
            case R.id.tv_assert_pd://固定资产盘点
                mContext.startActivity(new Intent(mContext, FixedassetPdListActivity.class));
                break;
            case R.id.tv_assert_tz://固定资产台账
                mContext.startActivity(new Intent(mContext, FixedassetTzListActivity.class));
                break;
            case R.id.tv_assert_cz://固定资产处置
                mContext.startActivity(new Intent(mContext, FixedassetCzListActivity.class));
                break;
            case R.id.tv_assert_fc://固定资产封存
                mContext.startActivity(new Intent(mContext, FixedassetFcListActivity.class));
                break;
            case R.id.tv_assert_wj://固定资产外借
                mContext.startActivity(new Intent(mContext, FixedassetWjListActivity.class));
                break;
            case R.id.tv_assert_db://固定资产调拨
                mContext.startActivity(new Intent(mContext, FixedassetDbListActivity.class));
                break;
            case R.id.tv_stock_check://库存盘点
                mContext.startActivity(new Intent(mContext, StockCheckListActivity.class));
                break;
            case R.id.tv_purchase_request://采购申请
                mContext.startActivity(new Intent(mContext, PurchaseMonthPlanListActivity.class).putExtra("sql", "").putExtra("title", "采购申请"));
                break;
            case R.id.tv_office_request://办公用品采购
                mContext.startActivity(new Intent(mContext, PurchaseMonthPlanListActivity.class).putExtra("sql", "udapptype='BG' and status not in ('已取消')").putExtra("title", "办公用品采购申请"));
                break;
            case R.id.tv_assert_request://固定资产申购
                mContext.startActivity(new Intent(mContext, PurchaseMonthPlanListActivity.class).putExtra("sql", "udapptype='GD'").putExtra("title", "固定资产申购"));
                break;
            case R.id.tv_item_request://物资采购申请
                mContext.startActivity(new Intent(mContext, PurchaseMonthPlanListActivity.class).putExtra("sql", "udapptype='MG' and status not in ('已取消')").putExtra("title", "物资采购申请"));
                break;
            case R.id.tv_material_request://领料申请
                mContext.startActivity(new Intent(mContext, MaterialRequestListActivity.class));
                break;
            case R.id.tv_workorder_cm://故障工单
                mContext.startActivity(new Intent(mContext, GzWorkOrderListActivity.class).putExtra("type", "CM").putExtra("title", "故障工单"));
                break;
            case R.id.tv_workorder_sr://状态维修工单
                mContext.startActivity(new Intent(mContext, GzWorkOrderListActivity.class).putExtra("type", "SR").putExtra("title", "状态维修工单"));
                break;
            case R.id.tv_workorder_pm://预防性维护工单
                mContext.startActivity(new Intent(mContext, GzWorkOrderListActivity.class).putExtra("type", "PM").putExtra("title", "预防性维护工单"));
                break;
            case R.id.tv_workorder_pj://项目工单
                mContext.startActivity(new Intent(mContext, GzWorkOrderListActivity.class).putExtra("type", "PJ").putExtra("title", "项目工单"));
                break;
            case R.id.tv_workorder_jc://检查工单
                mContext.startActivity(new Intent(mContext, GzWorkOrderListActivity.class).putExtra("type", "JC").putExtra("title", "检查工单"));
                break;
            case R.id.tv_workorder_dxj://点巡检工单
                mContext.startActivity(new Intent(mContext, GzWorkOrderListActivity.class).putExtra("type", "DXJ").putExtra("title", "点巡检工单"));
                break;
            case R.id.tv_workorder_zg://整改工单
                mContext.startActivity(new Intent(mContext, GzWorkOrderListActivity.class).putExtra("type", "ZG").putExtra("title", "整改工单"));
                break;
            case R.id.tv_workorder_em://维修工单
                mContext.startActivity(new Intent(mContext, GzWorkOrderListActivity.class).putExtra("type", "EM").putExtra("title", "维修工单"));
                break;
            case R.id.tv_workorder_ospr://外协服务申请单
                mContext.startActivity(new Intent(mContext, WxServerListActivity.class).putExtra("type", "EM").putExtra("title", "外协服务申请单"));
                break;
            case R.id.tv_wx_xbj://外协服务询比价
                mContext.startActivity(new Intent(mContext, WxServerXbjListActivity.class));
                break;
            case R.id.tv_wx_contract://外协服务年度采购合同
                mContext.startActivity(new Intent(mContext, WxServerContractListActivity.class));
                break;
            case R.id.tv_wx_order://外协服务采购订单
                mContext.startActivity(new Intent(mContext, WxServerPurchaseOrderListActivity.class));
                break;
        }
    }

    private void downLoad(Context mContext, String downloadUrl, String filename, String documentId) {
//配置progressDialog
        final ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        dialog.setTitle("正在下载中");
        dialog.setMessage("请稍后...");
        dialog.setProgress(0);
        dialog.setMax(100);
        dialog.show();
        file = new File(Environment.getExternalStorageDirectory().getPath() + "/download/" + filename);
//        file = new File(Environment.getExternalStorageDirectory().getPath() + "/download/" + "debug.apk");
//
//        OkhttpUtil.okHttpDownloadFile("http://192.168.1.180:7010/maximo/webclient/login/app-debug.apk", new CallBackUtil.CallBackFile(file.getAbsolutePath(),"debug.apk") {
//            @Override
//            public void onFailure(Call call, Exception e) {
//                LogUtils.d("222222  onFailure");
//            }
//
//            @Override
//            public void onResponse(File response) {
//                LogUtils.d("222222  response.length()= "+response.length());
//                                try {
//                    LogUtils.d("222222 打开");
//                    OpenFileUtils.openFile(mContext, file);
//                } catch (Exception e) {
//                    LogUtils.d("222222 无打开方式" + e.toString());
//
//                    e.printStackTrace();
//                }
//            }
//        });

        DownloadUtil.get().download(mContext, downloadUrl, "/download/", filename, new DownloadUtil.OnDownloadListener() {
            @Override
            public void onDownloadSuccess() {
                LogUtils.d("222222  onDownloadSuccess");
                dialog.dismiss();
                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    LogUtils.d("222222  没有内存卡");
                    return;
                }
                long length = file.length();
                LogUtils.d("222222  file.length()= "+length);
                LogUtils.d("222222 sp downloadUrl=" + downloadUrl);
                LogUtils.d("222222 sp savepath=" + file.getAbsolutePath());
                SharedPreferencesUtil.setString(mContext, documentId, file.getAbsolutePath());

                check(file);
//                try {
//                    LogUtils.d("222222 打开");
//                    OpenFileUtils.openFile(mContext, file);
//                } catch (Exception e) {
//                    LogUtils.d("222222 无打开方式" + e.toString());
//
//                    e.printStackTrace();
//                }

            }

            @Override
            public void onDownloading(int progress) {
                LogUtils.d("222222  onDownloading" + progress);
                dialog.setProgress(progress);
            }

            @Override
            public void onDownloadFailed() {
                LogUtils.d("222222  onDownloadFailed");
                dialog.dismiss();
            }
        });
    }

    private void check(File file) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LogUtils.d("222222  " + Build.VERSION.SDK_INT);
            boolean b = getActivity().getPackageManager().canRequestPackageInstalls();
            LogUtils.d("222222  " + b);
            if (!b) {
                requestPermissions(new String[]{Manifest.permission.REQUEST_INSTALL_PACKAGES, Manifest.permission.INSTALL_PACKAGES}, 996);
            } else {
                installApk(file);
            }
        } else {
            installApk(file);
        }
    }

    private void installApk(File file) {

        if (file != null) {
            LogUtils.d("222222  installApk。。。。。");
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            Uri fileUri = null;

            if (Build.VERSION.SDK_INT >= 24) {
                fileUri = FileProvider.getUriForFile(mContext, getActivity().getPackageName() + ".fileProvider", file);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                fileUri = Uri.fromFile(file);
            }

//            intent.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
//            Uri uri = FileProvider.getUriForFile(getActivity(), getActivity().getPackageName() + ".fileProvider", file);

            intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
            startActivity(intent);
            Process.killProcess(Process.myPid());
        } else {
            LogUtils.d("222222  安装失败");
        }

    }

    private void checkNeedPermissions() {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(mContext, Manifest.permission.INSTALL_PACKAGES)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(mContext, Manifest.permission.REQUEST_INSTALL_PACKAGES)
                != PackageManager.PERMISSION_GRANTED) {
            //多个权限一起申请
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.INSTALL_PACKAGES,
                    Manifest.permission.REQUEST_INSTALL_PACKAGES
            }, 1);
        } else {
            downLoad(mContext, "http://192.168.1.180:7010/maximo/webclient/login/app-debug.apk", "app-debug.apk", "001");
        }
//        else {
//            String current_documentid=SharedPreferencesUtil.getString(ProjectMonthDetailActivity.this,"current_documentid");
//            getUrl(current_documentid);
//        }
    }

    //    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LogUtils.d("222222  onRequestPermissionsResult");

        switch (requestCode) {
            case 996:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    LogUtils.d("222222  已授权");
                    installApk(file);
                } else {
                    LogUtils.d("222222  没有授权");
                    Uri uri = Uri.parse("package:" + getActivity().getPackageName());
                    Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, uri);
                    try {
                        startActivityForResult(intent, 996);
                        startActivity(intent);
                    } catch (ActivityNotFoundException exception) {
                        exception.getMessage();
                        LogUtils.d("222222  " + exception.getMessage());
                    }

                }
                break;
        }
    }
}
