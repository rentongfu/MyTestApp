package com.tongfu.mytestapp.permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_read_calendar)
    public void onBtnReadCalendarClicked(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED ){
            Toast.makeText(this, "已获得授权，无需重新请求" , Toast.LENGTH_SHORT).show();
        }else{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(shouldShowRequestPermissionRationale(Manifest.permission.READ_CALENDAR)){
                    requestPermissions(new String[]{Manifest.permission.READ_CALENDAR} , 1 );
                }else{
                    Toast.makeText(this, "权限已被多粗拒绝，需要到设置中手动设置" , Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    @OnClick(R.id.btn_write_calendar)
    public void onBtnWriteCalendarClicked(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED ){
            Toast.makeText(this, "已获得授权，无需重新请求" , Toast.LENGTH_SHORT).show();
        }else{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CALENDAR)){
                    requestPermissions(new String[]{Manifest.permission.WRITE_CALENDAR} , 1 );
                }else{
                    Toast.makeText(this, "权限已被多粗拒绝，需要到设置中手动设置" , Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    @OnClick(R.id.btn_read_call_log)
    public void onBtnReadCallLogClicked(){

    }

    @OnClick(R.id.btn_write_call_log)
    public void onBtnWriteCallLogClicked(){

    }

    @OnClick(R.id.btn_process_outgoing_calls)
    public void onBtnProcessOutgoingCalls(){

    }
}
