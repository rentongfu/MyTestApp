package com.tongfu.mytestapp.lifecycle.activity;

import android.Manifest;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.TraceRecorder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityLifecycleTestActivity extends AppCompatActivity {

    @BindView(R.id.et_content)
    EditText et_content ;

    public static int[] memoryData = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TraceRecorder.record(this , "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_lifecycle_test);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        TraceRecorder.record(this , "onCreateOptionMenu");
        getMenuInflater().inflate(R.menu.menu_lifecycle_test , menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TraceRecorder.record(this , "onOptionsItemSelected");
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        TraceRecorder.record(this , "onCreateContextMenu");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        TraceRecorder.record(this , "onPrepareOptionMenu");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        TraceRecorder.record(this , "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        TraceRecorder.record(this , "onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        TraceRecorder.record(this , "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        TraceRecorder.record(this , "onResume");
        super.onResume();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        TraceRecorder.record(this , "onNewIntent");
        super.onNewIntent(intent);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        TraceRecorder.record(this , "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        TraceRecorder.record(this , "onSaveInstanceState");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TraceRecorder.record(this , "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        TraceRecorder.record(this , "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        TraceRecorder.record(this , "onRequestPermissionResult");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onPause() {
        TraceRecorder.record(this , "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        TraceRecorder.record(this , "onStop");
        super.onStop();
    }

    @OnClick({R.id.btn_show_menu,R.id.btn_show_dialog,R.id.btn_request_permission,R.id.btn_start_activity,R.id.btn_delay_task
    ,R.id.btn_start_dialog_activity,R.id.btn_start_self,R.id.btn_crash,R.id.btn_apply_memory,R.id.btn_release_memory})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_show_menu:{

                break;
            }
            case R.id.btn_show_dialog:{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("对话框标题");
                builder.create().show();
                break;
            }
            case R.id.btn_request_permission:{
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    requestPermissions(new String[]{Manifest.permission.READ_CALENDAR} , 1 );
                break;
            }
            case R.id.btn_start_activity:{
                Intent intent = new Intent(this, ActivityLifecycleTestActivity2.class);
                startActivity(intent  );
                break;
            }
            case R.id.btn_delay_task:{
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            et_content.setText(new SimpleDateFormat("HH:mm:ss" , Locale.CHINA).format(new Date() ));
                            Log.i("Lifecycle" , "et_content设置成功" );
                        }catch (Throwable throwable){
                            throwable.printStackTrace();
                        }
                    }
                } , 5000);
                break;
            }
            case R.id.btn_start_dialog_activity:{
                Intent intent = new Intent(this, ActivityLifecycleDialogActivity.class);
                startActivity(intent  );
                break;
            }
            case R.id.btn_start_self:{
                Intent intent = new Intent(this , ActivityLifecycleTestActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_crash:{
                Log.i("ActivityLifecycle" ,""+1/0);
                break;
            }
            case R.id.btn_apply_memory:{
                Log.i("Activity" , "触发申请内存" );
                memoryData = new int[1024*1024*20];
                for( int i = 0 ; i < memoryData.length ;i++){
                    memoryData[i] = i ;
                }
//                memoryData[10240000] = 20 ;
                Log.i("Activity" ,""+memoryData.length);
                break;
            }
            case R.id.btn_release_memory:{
//                Log.i("Activity" ,""+memoryData[10240000]);
                memoryData = null ;
                break;
            }
        }
    }
}
