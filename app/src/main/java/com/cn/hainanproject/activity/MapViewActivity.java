package com.cn.hainanproject.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.hainanproject.R;
import com.cn.hainanproject.utils.LogUtils;
import com.cn.hainanproject.utils.StatusBarUtils;


/**
 * Created by tzl
 * on 2021/6/16
 */
public class MapViewActivity extends AppCompatActivity implements View.OnClickListener {
    private MapView mMapView;
    private AMap aMap;
    MyLocationStyle myLocationStyle;
    private TextView tv_location;
    private AMapLocationClient mLocationClient;
    private CameraUpdate cameraUpdate;
    Double Lat;
    Double Lon;
    private TextView tvCommonTitle;
    private LinearLayout llBack;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        Lat=  getIntent().getDoubleExtra("Lat",0.0);
         Lon=  getIntent().getDoubleExtra("Lon",0.0);
        llBack=findViewById(R.id.ll_back);
        llBack.setOnClickListener(this::onClick);
        tvCommonTitle=findViewById(R.id.tv_common_title);
        tvCommonTitle.setText("位置预览");
        mMapView = (MapView) findViewById(R.id.map);
        tv_location =  findViewById(R.id.tv_location);
        mMapView.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        getadress();

//        LatLng latLng = new LatLng(31.340404, 118.385146);
//        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20));
//        MarkerOptions markerOption = new MarkerOptions();
//        markerOption.position(latLng);
//        markerOption.draggable(true);
//        markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.locationbig));
//        markerOption.anchor(0.0f,1.0f);
////        aMap.setMinZoomLevel(2.0f);
//        aMap.addMarker(markerOption);
        //声明定位回调监听器
//         AMapLocationListener mLocationListener = new AMapLocationListener() {
//             @Override
//             public void onLocationChanged(AMapLocation aMapLocation) {
//                 if (aMapLocation != null) {
//                     if (aMapLocation.getErrorCode() == 0) {
//                         LogUtils.d("222222",aMapLocation.getLocationType()+
//                                 "  纬度："+aMapLocation.getLatitude()
//                                 +"  经度：" + aMapLocation.getLongitude()
//                                 + "  国家："+aMapLocation.getCountry()
//                                 +"  省份："+aMapLocation.getProvince()
//                                 +"  城市："+aMapLocation.getCity()
//                                 +"  城区："+aMapLocation.getDistrict()
//                                 +"  街道："+aMapLocation.getStreet()
//                                 +"  门牌号："+aMapLocation.getStreetNum());
//
//                         tv_location.setText(aMapLocation.getProvince()+aMapLocation.getCity()+aMapLocation.getDistrict()+aMapLocation.getStreet());
////可在其中解析amapLocation获取相应内容。
//                     }else {
//                         //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
//                         Log.e("AmapError","location Error, ErrCode:"
//                                 + aMapLocation.getErrorCode() + ", errInfo:"
//                                 + aMapLocation.getErrorInfo());
//                     }
//                 }
//             }
//         };
//        mLocationClient = new AMapLocationClient(getApplicationContext());
//        mLocationClient.setLocationListener(mLocationListener);
//        mLocationClient.startLocation();

//        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
//        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
//        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
//        aMap.getUiSettings().setMyLocationButtonEnabled(false);//设置默认定位按钮是否显示，非必需设置。
//        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
//
//        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_MAP_ROTATE);//连续定位、且将视角移动到地图中心点，地图依照设备方向旋转，定位点会跟随设备移动。（1秒1次定位）
//        myLocationStyle.showMyLocation(true);//设置是否显示定位小蓝点，用于满足只想使用定位，不想使用定位小蓝点的场景，设置false以后图面上不再有定位蓝点的概念，但是会持续回调位置信息。
//        myLocationStyle.anchor(0.0f,1.0f);

    }
    //解析指定坐标的地址
    public void getadress() {
        Log.e("Shunxu", "调用getadress");
        GeocodeSearch geocodeSearch = new GeocodeSearch(this);//地址查询器

        //设置查询参数,
        //三个参数依次为坐标，范围多少米，坐标系
        RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(Lat, Lon), 200, GeocodeSearch.AMAP);

        //设置查询结果监听
        geocodeSearch.setOnGeocodeSearchListener(new GeocodeSearch.OnGeocodeSearchListener() {
            //根据坐标获取地址信息调用
            @Override
            public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
                String s = regeocodeResult.getRegeocodeAddress().getFormatAddress();
                Log.e("Shunxu", "获得请求结果");
                makepoint(s);
            }

            //根据地址获取坐标信息是调用
            @Override
            public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
            }
        });

        geocodeSearch.getFromLocationAsyn(regeocodeQuery);//发起异步查询请求
    }
    //根据地址绘制需要显示的点
    public void makepoint(String s){
        LogUtils.d("222222","开始绘图");
        //北纬39.22，东经116.39，为负则表示相反方向
        LatLng latLng=new LatLng(Lat, Lon);
        LogUtils.d("222222 地址",s);
        tv_location.setText(s);
        //使用默认点标记
        Marker maker=aMap.addMarker(new MarkerOptions().position(latLng).title("地点:").snippet(s));


        //自定义点标记
        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.position(latLng).title("地点：").snippet(s);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                .decodeResource(getResources(),R.drawable.locationmiddle)));//设置图标

        aMap.addMarker(markerOptions);

        //改变可视区域为指定位置
        //CameraPosition4个参数分别为位置，缩放级别，目标可视区域倾斜度，可视区域指向方向（正北逆时针算起，0-360）
        cameraUpdate= CameraUpdateFactory.newCameraPosition(new CameraPosition(latLng,18,0,30));
        aMap.moveCamera(cameraUpdate);//地图移向指定区域

        //位置坐标的点击事件
        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //Toast.makeText(MainActivity.this,"点击指定位置",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //位置上面信息窗口的点击事件
        aMap.setOnInfoWindowClickListener(new AMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
//                Toast.makeText(MainActivity.this,"点击了我的地点",Toast.LENGTH_SHORT).show();
                ToastUtils.showShort("点击了我的地点");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }


    @Override
    public void onClick(View v) {
        finish();
    }
}
