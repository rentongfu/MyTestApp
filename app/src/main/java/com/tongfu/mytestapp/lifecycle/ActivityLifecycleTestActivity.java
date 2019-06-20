package com.tongfu.mytestapp.lifecycle;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.TraceRecorder;
import com.tongfu.mytestapp.network.NetworkActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityLifecycleTestActivity extends AppCompatActivity {

    @BindView(R.id.et_content)
    EditText et_content ;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        TraceRecorder.record(getClass() , "onCreateOptionMenu");
        getMenuInflater().inflate(R.menu.menu_lifecycle_test , menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TraceRecorder.record(getClass() , "onOptionsItemSelected");
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        TraceRecorder.record(getClass() , "onPrepareOptionMenu");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TraceRecorder.record(getClass() , "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_lifecycle_test);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        TraceRecorder.record(getClass() , "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        TraceRecorder.record(getClass() , "onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        TraceRecorder.record(getClass() , "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        TraceRecorder.record(getClass() , "onResume");
        super.onResume();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        TraceRecorder.record(getClass() , "onNewIntent");
        super.onNewIntent(intent);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        TraceRecorder.record(getClass() , "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        TraceRecorder.record(getClass() , "onSaveInstanceState");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TraceRecorder.record(getClass() , "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        TraceRecorder.record(getClass() , "onConfigureChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        TraceRecorder.record(getClass() , "onRequestPermissionResult");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onPause() {
        TraceRecorder.record(getClass() , "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        TraceRecorder.record(getClass() , "onStop");
        super.onStop();
    }

    @OnClick({R.id.btn_show_menu,R.id.btn_show_dialog,R.id.btn_request_permission,R.id.btn_start_activity,R.id.btn_delay_task})
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
                Intent intent = new Intent(this, NetworkActivity.class);
                startActivityForResult(intent , 1 );
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
        }
    }
}
