package com.cn.hainanproject.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.R;
import com.cn.hainanproject.adapter.MyImageAdapter;
import com.cn.hainanproject.base.Constants;
import com.cn.hainanproject.model.AssertCheckDetail;
import com.cn.hainanproject.model.AssertCheckLine;
import com.cn.hainanproject.model.PostData;
import com.cn.hainanproject.model.ScanResultBean;
import com.cn.hainanproject.model.StartWorkProcessBean;
import com.cn.hainanproject.net.CallBackUtil;
import com.cn.hainanproject.net.OkhttpUtil;
import com.cn.hainanproject.utils.DisTancesUtils;
import com.cn.hainanproject.utils.ImageUtils;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.SharedPreferencesUtil;
import com.cn.hainanproject.utils.StatusBarUtils;
import com.cn.hainanproject.utils.StringUtil;
import com.cn.hainanproject.view.MyGridView;
import com.donkingliang.imageselector.utils.ImageSelector;
import com.donkingliang.imageselector.utils.ImageUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import okhttp3.Call;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by tzl
 * on 2021/6/21
 */
public class ScanResultActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks, BGASortableNinePhotoLayout.Delegate {
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
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_no)
    TextView tvNo;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_current_location)
    TextView tvCurrentLocation;
    @BindView(R.id.tv_created_by)
    TextView tvCreatedBy;
    @BindView(R.id.tv_created_time)
    TextView tvCreatedTime;
    @BindView(R.id.cardview1)
    CardView cardview1;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_xj)
    TextView tvXj;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_repair)
    TextView tvRepair;
    @BindView(R.id.cardview2)
    CardView cardview2;
    @BindView(R.id.tv_level)
    TextView tvLevel;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.ll_container)
    LinearLayout llContainer;
    @BindView(R.id.tv_commit)
    Button tvCommit;
    @BindView(R.id.gridview)
    MyGridView gridView;
    @BindView(R.id.edt_desc)
    EditText edtDesc;
    @BindView(R.id.tv_load)
    TextView tvLoad;
    @BindView(R.id.snpl_moment_add_photos)
    BGASortableNinePhotoLayout mPhotosSnpl;




    private String result;
    private LoadingDialog ld;
    List<AssertCheckLine.ResultBean.ResultlistBean> resultlist;
    int PERMISSION_WRITE_EXTERNAL_REQUEST_CODE = 0x00000012;
    int REQUEST_CODE = 0x00000011;
    MyImageAdapter mAdapter;
    private Activity mContext;
    private static final int PRC_PHOTO_PICKER = 1;

    private static final int RC_CHOOSE_PHOTO = 1;
    private static final int RC_PHOTO_PREVIEW = 2;
    private static final int GET_LOCATION = 100;

    private static final String EXTRA_MOMENT = "EXTRA_MOMENT";
    List<JSONObject> jsonList = new ArrayList<>();
    AssertCheckDetail assertCheckDetail;
    private MapView mMapView;
    ScanResultBean scanResultBean;

    Double Lat;
    Double Lon;
    Double currentLat;
    Double currentLon;
    private AMap aMap;
    private ArrayList<String> imageArray = new ArrayList<>();
    JSONArray jsonArray = new JSONArray();
    RadioGroup ra_group;
    RadioButton ra_ok;
    RadioButton ra_no;
    HashMap<Integer, String> mapTag;
    int ownerid;
    LocationManager manager;
    private String locationProvider;
    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationOption;
    double distance;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_result_activity);
        ButterKnife.bind(this);
        mContext = this;
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        tvCommonTitle.setText("设备详情");
        ld = new LoadingDialog(mContext);

        if (getIntent().getExtras().get("result") != null) {
            result = getIntent().getStringExtra("result");
            scanResultBean = JSONObject.parseObject(result, new TypeReference<ScanResultBean>() {
            });
            LogUtils.d("222222", "scanResultBean:" + scanResultBean.getAssetnum());
            getDetail();
        }
        checkPermission();
        //隐藏标题栏
        mMapView = new MapView(mContext);
        mMapView.onCreate(savedInstanceState);
        // 设置拖拽排序控件的代理
        mPhotosSnpl.setDelegate(this);
        mPhotosSnpl.isPlusEnable();
//        int hasWriteExternalPermission = ContextCompat.checkSelfPermission(this,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        if (hasWriteExternalPermission == PackageManager.PERMISSION_GRANTED) {
//            //预加载手机图片。加载图片前，请确保app有读取储存卡权限
//            ImageSelector.preload(this);
//        } else {
//            //没有权限，申请权限。
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_WRITE_EXTERNAL_REQUEST_CODE);
//        }


    }


    private void checkPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(getApplicationContext(), "没有权限,请手动开启定位权限", Toast.LENGTH_SHORT).show();
            // 申请一个（或多个）权限，并提供用于回调返回的获取码（用户定义）
            ActivityCompat.requestPermissions(mContext, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_PHONE_STATE}, GET_LOCATION);
        } else {
            getCurrentAddress();
        }
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                !=PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(), "没有权限,请手动开启手机读写权限", Toast.LENGTH_SHORT).show();
            //没有权限，申请权限。
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_WRITE_EXTERNAL_REQUEST_CODE);
        }else {
            //预加载手机图片。加载图片前，请确保app有读取储存卡权限
            ImageSelector.preload(this);
        }

    }


    private void getCurrentAddress() {
//        声明定位回调监听器
        AMapLocationListener mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。

                        LogUtils.d("222222", aMapLocation.getLocationType() +
                                "  纬度：" + aMapLocation.getLatitude()// 30.496411
                                + "  经度：" + aMapLocation.getLongitude()// 114.391092
                                + "  国家：" + aMapLocation.getCountry()
                                + "  省份：" + aMapLocation.getProvince()
                                + "  城市：" + aMapLocation.getCity()
                                + "  城区：" + aMapLocation.getDistrict()
                                + "  街道：" + aMapLocation.getStreet()
                                + "  门牌号：" + aMapLocation.getStreetNum());
                        tvCurrentLocation.setText(aMapLocation.getProvince()+aMapLocation.getCity()+aMapLocation.getDistrict()+aMapLocation.getStreet()+aMapLocation.getStreetNum());
                        currentLat = aMapLocation.getLatitude();
                        currentLon = aMapLocation.getLongitude();
                        //获取当前位置和设备所在位置的距离·  ,
                         distance = DisTancesUtils.getDistance(currentLon, Lon, currentLat, Lat);
                        LogUtils.d("222222 distance =" + distance);


                    } else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        };
//初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
//设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
//初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
//        AMapLocationClientOption option = new AMapLocationClientOption();
        /**
         * 设置定位场景，目前支持三种场景（签到、出行、运动，默认无场景）
         */
        mLocationOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        if (null != mLocationClient) {
            mLocationClient.setLocationOption(mLocationOption);
            //设置场景模式后最好调用一次stop，再调用start以保证场景模式生效
            mLocationClient.stopLocation();
            mLocationClient.startLocation();
        }
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位模式为AMapLocationMode.Battery_Saving，低功耗模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
        mLocationOption.setInterval(1000);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        mLocationOption.setHttpTimeOut(20000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
//启动定位
        mLocationClient.startLocation();

    }


    private void getDetail() {
        /**
         * {
         *   "objectname" : "ASSET",
         *   "option" : "read",
         *   "curpage" : 1,
         *   "showcount" : 20,
         *   "sqlSearch" : " APP='XBJ' and RFQID=:ownerid ",
         *   "appid" : "ASSET"
         * }
         */
        ld.show();
        LogUtils.d("getDetail==");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "ASSET");
        object.put("objectname", "ASSET");
        object.put("curpage", 1);
        object.put("showcount", 20);
        object.put("option", "read");
        object.put("sqlSearch", "assetnum=" + "'" + scanResultBean.getAssetnum() + "'");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222 onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222 onResponse==" + response);
                ld.close();

                if (!response.isEmpty()) {
                    assertCheckDetail = JSONObject.parseObject(response, new TypeReference<AssertCheckDetail>() {
                    });

                    if (assertCheckDetail.getErrcode().equals("GLOBAL-S-0")) {
                        AssertCheckDetail.ResultBean.ResultlistBean resultlistBean = assertCheckDetail.getResult().getResultlist().get(0);
                        tvNo.setText(resultlistBean.getASSETNUM());
                        tvName.setText(resultlistBean.getDESCRIPTION());
                        tvType.setText(resultlistBean.getUDASSETTYPE());
                        tvLevel.setText(resultlistBean.getUDLEVEL());


                        Lat = Double.parseDouble(resultlistBean.getUDWD());//纬度 20.02971
                        Lon = Double.parseDouble(resultlistBean.getUDJD());//经度 110.32941
                        getAssertAdress(Lat, Lon);
                        getCheckLine();
                    }

                }

            }


        });
    }

    private void getCheckLine() {

        ld.show();
        LogUtils.d("222222 getCheckLine");
        String url = Constants.COMMONURL;
        JSONObject object = new JSONObject();
        object.put("appid", "UDWODXJTASK");
        object.put("objectname", "UDWODXJTASK");
        object.put("curpage", 1);
        object.put("showcount", 10);
        object.put("option", "read");
        object.put("sqlSearch", " assetnum= " + "'" + scanResultBean.getAssetnum() + "'" + "and bw=" + "'" + scanResultBean.getBw() + "'");
        object.put("orderby", "assetnum,bw,linenum asc");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        HashMap<String, String> map = new HashMap<>();
        map.put("data", String.valueOf(object));

        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222 onFailure" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222 onResponse" + response);
                ld.close();
                AssertCheckLine assertCheckLine;
                if (!response.isEmpty()) {
                    assertCheckLine = JSONObject.parseObject(response, new TypeReference<AssertCheckLine>() {
                    });

                    if (assertCheckLine.getErrcode().equals("GLOBAL-S-0")) {
                        int total = assertCheckLine.getResult().getTotalresult();
                        int totalpage = assertCheckLine.getResult().getTotalpage();
                        if (total > 0) {
                            llContainer.removeAllViews();
                            mapTag = new HashMap<>();
                            resultlist = assertCheckLine.getResult().getResultlist();

//                            nodata.setVisibility(View.GONE);
                            for (int i = 0; i < total; i++) {
                                View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.assert_check_line, llContainer, false);
                                TextView tv_line_no = inflate.findViewById(R.id.tv_line_no);
                                TextView tv_line_name = inflate.findViewById(R.id.tv_line_name);
                                ra_group = inflate.findViewById(R.id.ra_group);
                                ra_ok = inflate.findViewById(R.id.ra_ok);
                                ra_no = inflate.findViewById(R.id.ra_no);
                                tv_line_no.setText(resultlist.get(i).getLINENUM() + "");
                                tv_line_name.setText(resultlist.get(i).getDESCRIPTION());
                                int finalI = i;
                                mapTag.put(resultlist.get(i).getLINENUM(), "");
                                ra_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                                        switch (checkedId) {
                                            case R.id.ra_ok://正常
//                                                SharedPreferencesUtil.setString(getApplicationContext(), String.valueOf(resultlist.get(finalI).getLINENUM()), "ok");
                                                mapTag.put(resultlist.get(finalI).getLINENUM(), "ok");
                                                break;
                                            case R.id.ra_no://异常
//                                                SharedPreferencesUtil.setString(getApplicationContext(), String.valueOf(resultlist.get(finalI).getLINENUM()), "no");
                                                mapTag.put(resultlist.get(finalI).getLINENUM(), "no");

                                                break;
                                        }
                                    }
                                });

                                llContainer.addView(inflate);
                                JSONObject jsonObj = new JSONObject();
                                jsonObj.put("LINENUM", resultlist.get(i).getLINENUM());
                                jsonObj.put("ASSETNUM", resultlist.get(i).getASSETNUM());
                                jsonObj.put("BW", resultlist.get(i).getBW());
                                jsonObj.put("DESCRIPTION", resultlist.get(i).getDESCRIPTION());

                                jsonObj.put("RESULT", mapTag.get(resultlist.get(i).getLINENUM()).equals("ok") ? "正常" : "异常");

                                jsonList.add(jsonObj);
                            }

                        }

                    }

                }
            }
        });
    }


    @OnClick({R.id.ll_back, R.id.tv_xj, R.id.tv_repair, R.id.tv_commit, R.id.tv_load, R.id.tv_location})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_location://创建巡检记录
                startActivity(new Intent(this, MapViewActivity.class).putExtra("Lat", Lat).putExtra("Lon", Lon));
//
//                //多选(最多9张)
//                ImageSelector.builder()
//                        .useCamera(true) // 设置是否使用拍照
//                        .setSingle(false)  //设置是否单选
//                        .canPreview(true) //是否点击放大图片查看,，默认为true
//                        .setMaxSelectCount(9) // 图片的最大选择数量，小于等于0时，不限数量。
//                        .start(this, REQUEST_CODE); // 打开相册
                break;

            case R.id.tv_commit://提交
                if (distance>500){
                    ToastUtils.showShort("您不在提交范围内");
                    return;
                }

                if (mapTag.size() == 0) {
                    ToastUtils.showShort("请认真填写每项巡检明细行");
                } else {
                    if (mapTag.containsValue("no") && mPhotosSnpl.getData().size() == 0) {
                        ToastUtils.showShort("请上传现场图片");
                        return;
                    } else {
                        Set<Integer> keySet = mapTag.keySet();
                        for (Integer i : keySet) {
                            String value = mapTag.get(i);
                            LogUtils.d("222222 isCheck = " + i + "   =    " + value);
                            if (StringUtils.isEmpty(value)) {
                                ToastUtils.showShort("请认真填写每项巡检明细行");
                                return;
                            }

                        }
                        commit();
                    }
                }


//                for (int i = 0; i < resultlist.size(); i++) {
//                    String isCheck = SharedPreferencesUtil.getString(getApplicationContext(), String.valueOf(resultlist.get(i).getLINENUM()));
//                    LogUtils.d("222222 isCheck = " + resultlist.get(i).getLINENUM() + "   =    " + isCheck);
//                    //每一项都必须填写
//                    if (StringUtils.isEmpty(isCheck)) {
//                        ToastUtils.showShort("请认真填写每项巡检明细行");
//                        return;
//                    }
//                    //只要有一个异常 就必须上传照片
//                    if (isCheck.equals("no")&&mPhotosSnpl.getData().size()==0){
//                        ToastUtils.showShort("请上传现场图片");
//                        return;
//                    }
//                }

//                uploadImage();
//

//                String toBase64 = ImageUtils.imageToBase64(mPhotosSnpl.getData().get(0));
//                LogUtils.d("222222  toBase64 = " + toBase64);


                break;
        }
    }

    private void uploadImage() {
        ld.show();
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <max:mobileserviceuploadImageAll creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:s>" +
                "            %s" +
                "         </max:s>\n" +
                "         <max:ownertable>WORKORDER</max:ownertable>\n" +
                "         <max:ownerid>%s</max:ownerid>\n" +
                "      </max:mobileserviceuploadImageAll>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        request = String.format(request, jsonArray, ownerid);
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/xml;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");

        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP2, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure" + e.toString());
                ToastUtils.showShort(R.string.upLoadfailed);
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse222222" + response);
                ld.close();
                if (response.contains("<return>") && response.contains("</return>")) {
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    ToastUtils.showShort(R.string.upLoadok);
                    finish();
//                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {});
//                    if (startWorkProcessBean.getErrorNo() == 0 && startWorkProcessBean.getSuccess().equals("成功")) {
//                        ToastUtils.showShort("图片上传"+startWorkProcessBean.getSuccess());
//                        finish();
////                        PostData data = new PostData();
////                        data.setTag("assert check scuess");
////                        //通知固定资产盘点明细行和固定资产盘点差异列表刷新数据
////                        EventBus.getDefault().post(data);
//                    } else {
//                        ToastUtils.showShort(startWorkProcessBean.getErrorMsg());
//                    }

                } else
                    ToastUtils.showShort(R.string.UNKNOW_ERROR);

            }
        });


    }

    /**
     * 明细行盘点
     */
    private void commit() {
        ld.show();
        /**
         * 新增工单主信息、点检任务明细行，soapui示例：
         * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:max="http://www.ibm.com/maximo">
         *    <soapenv:Header/>
         *    <soapenv:Body>
         *       <max:mobileserviceInsertMbo creationDateTime="" baseLanguage="zh" transLanguage="zh" messageID="" maximoVersion="">
         *          <max:json>{"WORKTYPE" : "DXJ","DESCRIPTION" : "主子同时新增6-28","ASSETNUM" : "11-00100702A01","UDNWXTYPE" : "内修","relationShip" : [{"UDWODXJLINE" :""}],"UDWODXJLINE" : [{"LINENUM" : "1","ASSETNUM" : "11-00100702A01","BW" : "A","DESCRIPTION" : "检查任务测试6-24","WONUM":"151740"},{"LINENUM" : "2","ASSETNUM" : "11-00100702A01","BW" : "B","DESCRIPTION" : "检查任务测试6-24BBB","WONUM":"151740"}]}</max:json>
         *          <max:mboObjectName>WORKORDER</max:mboObjectName>
         *          <max:mboKey>WONUM</max:mboKey>
         *          <max:personId>MAXADMIN</max:personId>
         *       </max:mobileserviceInsertMbo>
         *    </soapenv:Body>
         * </soapenv:Envelope>
         *
         */
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:max=\"http://www.ibm.com/maximo\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <max:mobileserviceInsertMbo creationDateTime=\"\" baseLanguage=\"zh\" transLanguage=\"zh\" messageID=\"\" maximoVersion=\"\">\n" +
                "         <max:json>" +
                "         %s " +
                "        </max:json>\n" +
                "         <max:mboObjectName>WORKORDER</max:mboObjectName>\n" +
                "         <max:mboKey>WONUM</max:mboKey>\n" +
                "         <max:personId>%s</max:personId>\n" +
                "      </max:mobileserviceInsertMbo>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("WORKTYPE", "DXJ");
        jsonObject.put("DESCRIPTION", edtDesc.getText().toString());
        jsonObject.put("ASSETNUM", scanResultBean.getAssetnum());
        jsonObject.put("UDNWXTYPE", "内修");

        JSONArray relationShip = new JSONArray();
        JSONObject obj1 = new JSONObject();
        obj1.put("UDWODXJLINE", "");
        relationShip.add(obj1);
        jsonObject.put("relationShip", relationShip);


        JSONArray UDWODXJLINE = new JSONArray();
        UDWODXJLINE.addAll(jsonList);
        jsonObject.put("UDWODXJLINE", UDWODXJLINE);

        String request1 = String.valueOf(jsonObject);
        request = String.format(request, request1, SharedPreferencesUtil.getString(mContext, "loginid"));
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/xml;charset=utf-8");
        headermap.put("SOAPAction", "urn:action");

        OkhttpUtil.okHttpPostJson(Constants.COMMONSOAP2, request, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222onFailure" + e.toString());
//                ToastUtils.showShort(R.string.upLoadfailed);
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse222222" + response);
                ld.close();
                if (response.contains("<return>") && response.contains("</return>")) {
                    int start = response.indexOf("<return>");
                    int end = response.indexOf("</return>");
                    String substring = response.substring(start + 8, end);
                    LogUtils.d("substring==" + substring);
                    StartWorkProcessBean startWorkProcessBean = JSONObject.parseObject(substring, new TypeReference<StartWorkProcessBean>() {
                    });
                    ownerid = startWorkProcessBean.getOwnerid();
                    if (startWorkProcessBean.getErrorNo() == 0 && startWorkProcessBean.getSuccess().equals("成功")) {
//                        ToastUtils.showShort(startWorkProcessBean.getSuccess());
//                        PostData data = new PostData();
//                        data.setTag("assert check scuess");
//                        //通知固定资产盘点明细行和固定资产盘点差异列表刷新数据
//                        EventBus.getDefault().post(data);
                        //此处判断是否有图片需要上传
                        if (mPhotosSnpl.getData().size() > 0) {
                            uploadImage();
                        } else {
                            finish();
                        }

                    } else {
                        ToastUtils.showShort(startWorkProcessBean.getErrorMsg());
                    }
                } else
                    ToastUtils.showShort(R.string.UNKNOW_ERROR);

            }
        });


    }


    @Override
    public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
        choicePhotoWrapper();

    }

    @Override
    public void onClickDeleteNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
        mPhotosSnpl.removeItem(position);
        LogUtils.d("222222 " + mPhotosSnpl.getData());

    }

    @Override
    public void onClickNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
        Intent photoPickerPreviewIntent = new BGAPhotoPickerPreviewActivity.IntentBuilder(this)
                .previewPhotos(models) // 当前预览的图片路径集合
                .selectedPhotos(models) // 当前已选中的图片路径集合
                .maxChooseCount(mPhotosSnpl.getMaxItemCount()) // 图片选择张数的最大值
                .currentPosition(position) // 当前预览图片的索引
                .isFromTakePhoto(false) // 是否是拍完照后跳转过来
                .build();
        startActivityForResult(photoPickerPreviewIntent, RC_PHOTO_PREVIEW);
    }

    @Override
    public void onNinePhotoItemExchanged(BGASortableNinePhotoLayout sortableNinePhotoLayout, int fromPosition, int toPosition, ArrayList<String> models) {
        Toast.makeText(this, "排序发生变化", Toast.LENGTH_SHORT).show();

    }

    @AfterPermissionGranted(PRC_PHOTO_PICKER)
    private void choicePhotoWrapper() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话就没有拍照功能
            File takePhotoDir = new File(Environment.getExternalStorageDirectory(), "HaiNanPortCheckPic");

            Intent photoPickerIntent = new BGAPhotoPickerActivity.IntentBuilder(this)
                    .cameraFileDir(true ? takePhotoDir : null) // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话则不开启图库里的拍照功能
                    .maxChooseCount(mPhotosSnpl.getMaxItemCount() - mPhotosSnpl.getItemCount()) // 图片选择张数的最大值
                    .selectedPhotos(null) // 当前已选中的图片路径集合
                    .pauseOnScroll(false) // 滚动列表时是否暂停加载图片
                    .build();
            startActivityForResult(photoPickerIntent, RC_CHOOSE_PHOTO);
        } else {
            EasyPermissions.requestPermissions(this, "图片选择需要以下权限:\n\n1.访问设备上的照片\n\n2.拍照", PRC_PHOTO_PICKER, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        switch (requestCode) {
            case GET_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 获取到权限，作相应处理（调用定位SDK应当确保相关权限均被授权，否则可能引起定位失败）
                    getCurrentAddress();
                } else {
                    // 没有获取到权限，做特殊处理
                    Toast.makeText(getApplicationContext(), "获取位置权限失败，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (requestCode == PRC_PHOTO_PICKER) {
            Toast.makeText(this, "您拒绝了「图片选择」所需要的相关权限!", Toast.LENGTH_SHORT).show();
        } else if (requestCode == GET_LOCATION) {
            Toast.makeText(this, "您拒绝了「获取定位」所需要的相关权限!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == RC_CHOOSE_PHOTO) {
//            LogUtils.d("222222 data  ="+BGAPhotoPickerActivity.getSelectedPhotos(data));

            mPhotosSnpl.addMoreData(BGAPhotoPickerActivity.getSelectedPhotos(data));
            LogUtils.d("222222 data  =" + mPhotosSnpl.getData());
            jsonArray.clear();
            for (int i = 0; i < mPhotosSnpl.getData().size(); i++) {
                JSONObject object = new JSONObject();
                int start = mPhotosSnpl.getData().get(i).lastIndexOf("/");
                int end = mPhotosSnpl.getData().get(i).length();
                object.put("filename", mPhotosSnpl.getData().get(i).substring(start, end));
                object.put("image", ImageUtils.imageToBase64(mPhotosSnpl.getData().get(i)));
                jsonArray.add(object);
            }
            LogUtils.d("222222 jsonArray  =" + jsonArray);

        } else if (requestCode == RC_PHOTO_PREVIEW) {
//            LogUtils.d("222222 data  ="+BGAPhotoPickerPreviewActivity.getSelectedPhotos(data));
            mPhotosSnpl.setData(BGAPhotoPickerPreviewActivity.getSelectedPhotos(data));


        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    //解析指定坐标的地址
    public String getAssertAdress(Double lat, Double lon) {
        final String[] location = {""};
        Log.e("Shunxu", "调用getadress");

        GeocodeSearch geocodeSearch = new GeocodeSearch(this);//地址查询器

        //设置查询参数,
        //三个参数依次为坐标，范围多少米，坐标系
        RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(lat, lon), 200, GeocodeSearch.AMAP);

        //设置查询结果监听
        geocodeSearch.setOnGeocodeSearchListener(new GeocodeSearch.OnGeocodeSearchListener() {
            //根据坐标获取地址信息调用
            @Override
            public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
                String s = regeocodeResult.getRegeocodeAddress().getFormatAddress();
                tvLocation.setText(s);
                location[0] = s;
                Log.e("Shunxu", "获得请求结果");
            }

            //根据地址获取坐标信息是调用
            @Override
            public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
            }
        });

        geocodeSearch.getFromLocationAsyn(regeocodeQuery);//发起异步查询请求
        return location[0];
    }

}
