package com.cn.hainanproject.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.R;
import com.cn.hainanproject.base.Constants;
import com.cn.hainanproject.model.PostData;
import com.cn.hainanproject.model.StartWorkProcessBean;
import com.cn.hainanproject.net.CallBackUtil;
import com.cn.hainanproject.net.OkhttpUtil;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.SharedPreferencesUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/2/9
 */
public class PurchaseOrderDetailActivity extends AppCompatActivity {
    private int isAgree=1;
    private LoadingDialog ld;
    private String status;
    private TextView tv_approval,tv_statues;
    private String FIXEDASSETJSID;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_order_detail_activity);
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
        String request="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
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
                    if (response.contains("<return>")&&response.contains("</return>")){
                        int start = response.indexOf("<return>");
                        int end = response.indexOf("</return>");
                        String substring = response.substring(start + 8, end);
                        LogUtils.d("substring==" + substring);
                        StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {});
                        if (startWorkProcessBean.getMsg().equals("流程启动成功！")){
                            status=startWorkProcessBean.getNextStatus();
                            tv_approval.setText("工作流审批");
                            tv_statues.setText(startWorkProcessBean.getNextStatus());
                            PostData postData=new PostData();
                            postData.setTag("固定资产接收");
                            EventBus.getDefault().post(postData);
                        }else {

                        }
                        ToastUtils.showShort(startWorkProcessBean.getMsg());
                    }else {
                        ToastUtils.showShort(R.string.UNKNOW_ERROR);
                    }

                }


            }
        });
    }
    private void goApproval(int ifAgree, String opinion) {
        ld.show();
        if (StringUtils.isEmpty(opinion)){
            if (isAgree==1){
                opinion="同意";
            }else {
                opinion="驳回";
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
                if (response.contains("<return>")&&response.contains("</return>")){
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {});
                    if (startWorkProcessBean.getMsg().equals("审批成功")) {
//                        if (isAgree == 1 && startWorkProcessBean.getNextStatus().equals("已确认")) {
//                            tv_approval.setVisibility(View.GONE);
//                        }
                        PostData postData=new PostData();
                        postData.setTag("固定资产接收");
                        EventBus.getDefault().post(postData);
                        status = startWorkProcessBean.getNextStatus();
                        tv_statues.setText(startWorkProcessBean.getNextStatus());
                    } else {

                    }
                    ToastUtils.showShort(startWorkProcessBean.getMsg());
                }else
                    ToastUtils.showShort(R.string.UNKNOW_ERROR);

            }
        });
    }
}
