package com.tongfu.mytestapp.lifecycle.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.TraceRecorder;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentLifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TraceRecorder.record(this , "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_lifecycle);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.anim_fragment_show_from_left, R.anim.anim_fragment_exit_to_right).add(R.id.fl_container , new LifecycleTestFragment() , "test").commit();
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

    @OnClick({R.id.btn_add_fragment,R.id.btn_remove_fragment,R.id.btn_show_fragment,R.id.btn_hide_fragment})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_add_fragment:{
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.anim_fragment_show_from_left, R.anim.anim_fragment_exit_to_right).add(R.id.fl_container , new LifecycleTestFragment() , "test").commit();
                break;
            }
            case R.id.btn_remove_fragment:{
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.anim_fragment_show_from_left, R.anim.anim_fragment_exit_to_right).remove(getSupportFragmentManager().findFragmentByTag("test")).commit();
                break;
            }
            case R.id.btn_hide_fragment:{
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.anim_fragment_show_from_left, R.anim.anim_fragment_exit_to_right).hide(getSupportFragmentManager().findFragmentByTag("test")).commit();

                break;
            }
            case R.id.btn_show_fragment:{
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.anim_fragment_show_from_left, R.anim.anim_fragment_exit_to_right).show(getSupportFragmentManager().findFragmentByTag("test")).commit();
                break;
            }
        }
    }
}
