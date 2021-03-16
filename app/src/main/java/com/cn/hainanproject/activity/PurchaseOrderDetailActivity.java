package com.cn.hainanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.R;
import com.cn.hainanproject.base.Constants;
import com.cn.hainanproject.base.MyApplication;
import com.cn.hainanproject.fragment.AttachFragment;
import com.cn.hainanproject.fragment.ContractLineFragment;
import com.cn.hainanproject.fragment.PurchaseOrderLineFragment;
import com.cn.hainanproject.model.PostData;
import com.cn.hainanproject.model.PurchseOrderListBean;
import com.cn.hainanproject.model.StartWorkProcessBean;
import com.cn.hainanproject.model.StockMoveListBean;
import com.cn.hainanproject.net.CallBackUtil;
import com.cn.hainanproject.net.OkhttpUtil;
import com.cn.hainanproject.utils.HighLightUtils;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.SharedPreferencesUtil;
import com.cn.hainanproject.utils.StatusBarUtils;
import com.cn.hainanproject.utils.Tools;
import com.cn.hainanproject.view.MyPagerTransition;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/2/9
 */
public class PurchaseOrderDetailActivity extends AppCompatActivity {
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
    @BindView(R.id.tv_statue)
    TextView tvStatue;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_order_desc)
    TextView tvOrderDesc;
    @BindView(R.id.tv_state_date)
    TextView tvStateDate;
    @BindView(R.id.tv_purchaser)
    TextView tvPurchaser;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_vender_desc)
    TextView tvVenderDesc;
    @BindView(R.id.tv_end_date)
    TextView tvEndDate;
    @BindView(R.id.tv_pay_date)
    TextView tvPayDate;
    @BindView(R.id.tv_price_with_tax)
    TextView tvPriceWithTax;
    @BindView(R.id.tv_price_without_tax)
    TextView tvPriceWithoutTax;
    @BindView(R.id.tv_price_tax)
    TextView tvPriceTax;
    @BindView(R.id.tv_tax_quota)
    TextView tvTaxQuota;
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_way)
    TextView tvWay;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_change_time)
    TextView tvChangeTime;
    @BindView(R.id.tv_change_by)
    TextView tvChangeBy;
    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.ll_3)
    LinearLayout ll3;
    @BindView(R.id.ll_container)
    LinearLayout llContainer;
    @BindView(R.id.magicIndicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.tv_receive)
    TextView tvReceive;
    private int isAgree = 1;
    private LoadingDialog ld;
    private String status;
    private TextView tv_approval, tv_statues;
    private String FIXEDASSETJSID;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragmentList;
    private Fragment currentFragment;
    String title;    private PurchseOrderListBean.ResultBean.ResultlistBean listBean;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_order_detail_activity);
        ButterKnife.bind(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        if ((getIntent().getExtras().get("data") != null)) {
            listBean = (PurchseOrderListBean.ResultBean.ResultlistBean) getIntent().getExtras().get("data");
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("title"))) {
            title = getIntent().getStringExtra("title");
        }
        ld = new LoadingDialog(this);
        initView();
    }

    private void initView() {
        tvCommonTitle.setText("采购订单详情");
        SpannableString highlight = HighLightUtils.highlight(this, "订单号：" + listBean.getPONUM(), listBean.getPONUM(), "#03DAC5", 0, 0);

        tvNo.setText(highlight);
        tvDesc.setText("描述："+listBean.getDESCRIPTION());
        tvOrderDesc.setText(listBean.getUDMS());
        tvStatue.setText(listBean.getSTATUS());
        tvStateDate.setText("状态日期："+listBean.getSTATUSDATE());
        tvPurchaser.setText("采购员："+listBean.getSHIPTOATTN());
        tvMoney.setText("货币："+listBean.getCURRENCYCODE());
        tvReceive.setText("接收情况："+listBean.getRECEIPTS());
        tvEndDate.setText("要求到货日期："+listBean.getREQUIREDDATE());
        tvPayDate.setText("交货日期："+listBean.getUDJHRQ());
        tvPriceWithTax.setText("含税总价："+listBean.getUDHSZJ());
        tvPriceWithoutTax.setText("不含税总价："+listBean.getPRETAXTOTAL());
        tvPriceTax.setText("总税金："+listBean.getTOTALTAX1());
        tvTaxQuota.setText("税率："+listBean.getUDTAX());
        tvCompany.setText("公司："+listBean.getVENDORDESC());
        tvWay.setText("发运方式："+listBean.getTRANSPORT());
        tvPrice.setText("价格基准："+listBean.getPRICELEVEL());
        tvPay.setText("付款方式："+listBean.getUDPAYMENTTERMS());
        tvChangeBy.setText("制单人："+listBean.getDISPLAYNAME());
        tvChangeTime.setText("制单日期："+listBean.getUDCREATEDATE());

        titles = new ArrayList<String>();
        pager.removeAllViews();
        titles.clear();
        titles.add("采购明细行");
        titles.add("附件");
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.clear();
        PurchaseOrderLineFragment purchaseOrderLineFragment = new PurchaseOrderLineFragment(this, listBean);//采购明细行
        AttachFragment attachFragment = new AttachFragment(this, listBean,2);//附件
        fragmentList.add(purchaseOrderLineFragment);
        fragmentList.add(attachFragment);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        pager.setAdapter(myFragmentPagerAdapter);
        final CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        pager.setOffscreenPageLimit(fragmentList.size());
        pager.setPageTransformer(false,new MyPagerTransition());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(titles.get(index));
                simplePagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.sp13));
                simplePagerTitleView.setPadding(Tools.dip2px(context, 18), Tools.dip2px(context, 1), Tools.dip2px(context, 18), Tools.dip2px(context, 1));
                simplePagerTitleView.setNormalColor(Color.parseColor("#000000"));
                simplePagerTitleView.setSelectedColor(MyApplication.applicationContext.getResources().getColor(R.color.colorAccent));
//                simplePagerTitleView.setNormalFontSize(TypedValue.COMPLEX_UNIT_SP,  Tools.dip2px(context, 20));
//                simplePagerTitleView.setSelectedFontSize(TypedValue.COMPLEX_UNIT_SP,  Tools.dip2px(context, 28));
                simplePagerTitleView.setTextSize(15);
                simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;


            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                linePagerIndicator.setLineWidth(Tools.dip2px(context, 30));
                linePagerIndicator.setLineHeight(Tools.dip2px(context, 4));
                linePagerIndicator.setRoundRadius(4);
                linePagerIndicator.setColors(ContextCompat.getColor(MyApplication.applicationContext, R.color.colorAccent));
                return linePagerIndicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, pager);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                magicIndicator.onPageSelected(position);
            }

            @Override
            public void onPageSelected(int position) {
                LogUtils.d("222222", "position=" + position);
//                magicIndicator.onPageSelected(position);
                currentFragment = fragmentList.get(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                magicIndicator.onPageScrollStateChanged(state);
            }
        });

        pager.setCurrentItem(0);
        currentFragment = fragmentList.get(0);

    }

    private PopupWindow pop;

    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.purchase_order_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.commondialog, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
        final EditText input_et = (EditText) remarkView.findViewById(R.id.input_et);
        TextView finish_tv = (TextView) remarkView.findViewById(R.id.finish_tv);
        TextView cancel_tv = (TextView) remarkView.findViewById(R.id.cancel_tv);
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        ImageView iv_agree = (ImageView) remarkView.findViewById(R.id.iv_agree);
        iv_agree.setBackgroundResource(R.drawable.selected);
        ImageView iv_disagree = (ImageView) remarkView.findViewById(R.id.iv_disagree);
        iv_disagree.setBackgroundResource(R.drawable.unselected);
        iv_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_agree.setBackgroundResource(R.drawable.selected);
                iv_disagree.setBackgroundResource(R.drawable.unselected);
                isAgree = 1;
                input_et.setHint("同意");
                LogUtils.d("同意==");
            }
        });
        iv_disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_disagree.setBackgroundResource(R.drawable.selected);
                iv_agree.setBackgroundResource(R.drawable.unselected);
                isAgree = 0;
                input_et.setHint("驳回");
                LogUtils.d("不同意==");
            }
        });

        finish_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = input_et.getText().toString().trim();
                goApproval(isAgree, txt);
                pop.dismiss(); //不管有否字符串都应该去dismiss
            }
        });

        cancel_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
    }

    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
    }

    private void start() {
        /**
         * <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:max="http://www.ibm.com/maximo">
         *    <soap:Header/>
         *    <soap:Body>
         *       <max:wfservicestartWF creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:processname>UDFIXZZZG</max:processname>
         *          <max:mbo>FIXEDASSETJS</max:mbo>
         *          <max:keyValue>101</max:keyValue>
         *          <max:key>FIXEDASSETJSID</max:key>
         *          <max:loginid>MAXADMIN</max:loginid>
         *       </max:wfservicestartWF>
         *    </soap:Body>
         * </soap:Envelope>
         */
        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <max:wfservicestartWF creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:processname>UDFIXZZZG</max:processname>\n" +
                "         <max:mbo>FIXEDASSETJS</max:mbo>\n" +
                "         <max:keyValue>%s</max:keyValue>\n" +
                "         <max:key>FIXEDASSETJSID</max:key>\n" +
                "         <max:loginid>%s</max:loginid>\n" +
                "      </max:wfservicestartWF>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        request = String.format(request, FIXEDASSETJSID, SharedPreferencesUtil.getString(this, "personId"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (!response.isEmpty()) {
                    if (response.contains("<return>") && response.contains("</return>")) {
                        int start = response.indexOf("<return>");
                        int end = response.indexOf("</return>");
                        String substring = response.substring(start + 8, end);
                        LogUtils.d("substring==" + substring);
                        StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                        });
                        if (startWorkProcessBean.getMsg().equals("流程启动成功！")) {
                            status = startWorkProcessBean.getNextStatus();
                            tv_approval.setText("工作流审批");
                            tv_statues.setText(startWorkProcessBean.getNextStatus());
                            PostData postData = new PostData();
                            postData.setTag("固定资产接收");
                            EventBus.getDefault().post(postData);
                        } else {

                        }
                        ToastUtils.showShort(startWorkProcessBean.getMsg());
                    } else {
                        ToastUtils.showShort(R.string.UNKNOW_ERROR);
                    }

                }


            }
        });
    }

    private void goApproval(int ifAgree, String opinion) {
        ld.show();
        if (StringUtils.isEmpty(opinion)) {
            if (isAgree == 1) {
                opinion = "同意";
            } else {
                opinion = "驳回";
            }
        }
        /**
         * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:max="http://www.ibm.com/maximo">
         * 	<soapenv:Header />
         * 	<soapenv:Body>
         * 		<max:wfservicewfGoOn creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         * 			<max:processname>UDFIXZZZG</max:processname>
         * 			<max:mboName>FIXEDASSETJS</max:mboName>
         * 			<max:keyValue>102</max:keyValue>
         * 			<max:key>FIXEDASSETJSNUM</max:key>
         * 			<max:ifAgree>1</max:ifAgree>
         * 			<max:opinion>666666</max:opinion>
         * 			<max:loginid>MAXADMIN</max:loginid>
         * 		</max:wfservicewfGoOn>
         * 	</soapenv:Body>
         * </soapenv:Envelope>
         */
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "\t<soapenv:Header />\n" +
                "\t<soapenv:Body>\n" +
                "\t\t<max:wfservicewfGoOn creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "\t\t\t<max:processname>UDFIXYSRG</max:processname>\n" +
                "\t\t\t<max:mboName>FIXEDASSETJS</max:mboName>\n" +
                "\t\t\t<max:keyValue>%s</max:keyValue>\n" +
                "\t\t\t<max:key>FIXEDASSETJSID</max:key>\n" +
                "\t\t\t<max:ifAgree>%s</max:ifAgree>\n" +
                "\t\t\t<max:opinion>%s</max:opinion>\n" +
                "\t\t\t<max:loginid>%s</max:loginid>\n" +
                "\t\t</max:wfservicewfGoOn>\n" +
                "\t</soapenv:Body>\n" +
                "</soapenv:Envelope>";
        request = String.format(request, FIXEDASSETJSID, ifAgree, opinion, SharedPreferencesUtil.getString(this, "personId"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");
        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (response.contains("<return>") && response.contains("</return>")) {
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                    });
                    if (startWorkProcessBean.getMsg().equals("审批成功")) {
//                        if (isAgree == 1 && startWorkProcessBean.getNextStatus().equals("已确认")) {
//                            tv_approval.setVisibility(View.GONE);
//                        }
                        PostData postData = new PostData();
                        postData.setTag("固定资产接收");
                        EventBus.getDefault().post(postData);
                        status = startWorkProcessBean.getNextStatus();
                        tv_statues.setText(startWorkProcessBean.getNextStatus());
                    } else {

                    }
                    ToastUtils.showShort(startWorkProcessBean.getMsg());
                } else
                    ToastUtils.showShort(R.string.UNKNOW_ERROR);

            }
        });
    }

    @OnClick(R.id.ll_back)
    public void onViewClicked() {
    }
    public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
        private ArrayList<Fragment> fragmentLists;
        private ArrayList<String> titlelists;

        public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList, ArrayList<String> titleList) {
            super(fm);
            this.fragmentLists = fragmentList;
            this.titlelists = titleList;
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentLists.get(position);
        }

        @Override
        public int getCount() {
            return fragmentLists.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titlelists.get(position);
        }
    }

}
