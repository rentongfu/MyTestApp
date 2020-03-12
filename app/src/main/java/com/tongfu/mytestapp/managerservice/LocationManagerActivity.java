package com.tongfu.mytestapp.managerservice;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.tongfu.mytestapp.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LocationManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_manager);
        ButterKnife.bind(this);
    }

    LocationListener gpsLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    GnssStatus gnssStatus = null;
    GnssStatus.Callback gnssCallback = null ;


    LocationListener networkLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    @OnClick({R.id.btn_start_gps_locate , R.id.btn_get_gps_location , R.id.btn_permission , R.id.btn_stop_gps_locate , R.id.btn_gps_available,
        R.id.btn_start_network_locate , R.id.btn_get_network_location , R.id.btn_stop_network_locate , R.id.btn_network_available,
        R.id.btn_start_gnss , R.id.btn_stop_gnss , R.id.btn_show_gnss})
    public void onClicked(View view) {
        final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if(locationManager==null){
            Toast.makeText(this , "获取LocationManager失败" , Toast.LENGTH_SHORT).show();
            return ;
        }
        switch (view.getId()) {
            case R.id.btn_permission:{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION , Manifest.permission.ACCESS_FINE_LOCATION} , 0 );
                }else{
                    Toast.makeText(this , "Android6.0及以下系统无需手动请求权限" , Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.btn_start_gps_locate: {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this , "没有权限" , Toast.LENGTH_SHORT).show();
                    return;
                }
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 1, gpsLocationListener);
                break;
            }
            case R.id.btn_get_gps_location:{
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                Toast.makeText(this , "当前位置：longitude：" + location.getLongitude() + "，latitude：" + location.getLatitude() + "，altitude：" + location.getAltitude() +"，accuracy：" + location.getAccuracy(), Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_stop_gps_locate:{
                locationManager.removeUpdates(gpsLocationListener);
                break;
            }
            case R.id.btn_gps_available:{
                if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                    Toast.makeText(this , "GPS可用" , Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this , "GPS不可用" , Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_start_network_locate:{
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this , "没有权限" , Toast.LENGTH_SHORT).show();
                    return;
                }
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 1, gpsLocationListener);
                break;
            }
            case R.id.btn_get_network_location:{
                Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                Toast.makeText(this , "当前位置：longitude：" + location.getLongitude() + "，latitude：" + location.getLatitude() + "，altitude：" + location.getAltitude() +"，accuracy：" + location.getAccuracy(), Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_stop_network_locate:{
                locationManager.removeUpdates(gpsLocationListener);
                break;
            }
            case R.id.btn_network_available:{
                if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                    Toast.makeText(this , "网络定位可用" , Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this , "网络定位不可用" , Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_start_gnss:{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    if(gnssCallback == null){
                        gnssCallback = new GnssStatus.Callback() {
                            @Override
                            public void onStarted() {
                                super.onStarted();
                            }

                            @Override
                            public void onStopped() {
                                super.onStopped();
                            }

                            @Override
                            public void onFirstFix(int ttffMillis) {
                                super.onFirstFix(ttffMillis);
                            }

                            @Override
                            public void onSatelliteStatusChanged(GnssStatus status) {
                                gnssStatus = status ;
                                status.getAzimuthDegrees(0);
                            }
                        };
                    }
                    locationManager.registerGnssStatusCallback(gnssCallback);
                }
                break;
            }
            case R.id.btn_stop_gnss:{
                if(gnssCallback!=null)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        locationManager.unregisterGnssStatusCallback(gnssCallback);
                    }
                break;
            }
            case R.id.btn_show_gnss:{
                if(gnssStatus!=null){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        NumberFormat floatFormat = new DecimalFormat("000.00");
                        NumberFormat intFormat = new DecimalFormat("000");

                        Toast.makeText(this , "卫星数量：" + gnssStatus.getSatelliteCount() , Toast.LENGTH_SHORT).show();
                        StringBuffer stringBuffer = new StringBuffer();
                        for( int i = 0 ; i < gnssStatus.getSatelliteCount() ; i++){
                            stringBuffer.append(i).append(",");
                            stringBuffer.append(floatFormat.format(gnssStatus.getAzimuthDegrees(i))).append(",");
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                stringBuffer.append(floatFormat.format(gnssStatus.getCarrierFrequencyHz(i))).append(",");
                            }
                            stringBuffer.append(floatFormat.format(gnssStatus.getCn0DbHz(i))).append(",");
                            stringBuffer.append(floatFormat.format(gnssStatus.getElevationDegrees(i))).append(",");
                            stringBuffer.append(intFormat.format(gnssStatus.getSvid(i))).append(",");
                            switch (gnssStatus.getConstellationType(i)){
                                case GnssStatus.CONSTELLATION_UNKNOWN:
                                    stringBuffer.append("位置");
                                    break;
                                case GnssStatus.CONSTELLATION_GPS:
                                    stringBuffer.append("美国");
                                    break;
                                case GnssStatus.CONSTELLATION_SBAS:
                                    stringBuffer.append("美国");
                                    break;
                                case GnssStatus.CONSTELLATION_GLONASS:
                                    stringBuffer.append("俄国");
                                    break;
                                case GnssStatus.CONSTELLATION_QZSS:
                                    stringBuffer.append("日本");
                                    break;
                                case GnssStatus.CONSTELLATION_BEIDOU:
                                    stringBuffer.append("中国");
                                    break;
                                case GnssStatus.CONSTELLATION_GALILEO:
                                    stringBuffer.append("欧盟");
                                    break;
                            }
                            stringBuffer.append(",");
                            stringBuffer.append('\n');
                        }
                        new AlertDialog.Builder(this).setTitle("信号信息").setMessage(stringBuffer.toString()).setPositiveButton("确定" , null).create().show();
                    }else{
                        Toast.makeText(this , "当前系统不支持本操作" , Toast.LENGTH_SHORT).show();
                    }
                }


            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(permissions!=null && permissions.length>0){
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0 ; i < permissions.length ; i++){
                stringBuffer.append(permissions[i] ).append(grantResults[i] == PackageManager.PERMISSION_GRANTED ? "请求通过" :"请求被拒").append('\n');
            }
            Toast.makeText(this,  "权限" + stringBuffer.toString() , Toast.LENGTH_SHORT).show();
        }
    }
}
