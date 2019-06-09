package com.tongfu.mytestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.tongfu.mytestapp.animation.AnimationEntryActivity;
import com.tongfu.mytestapp.broadcastreceiver.BroadcastReceiverActivity;
import com.tongfu.mytestapp.contentprovider.ContentProviderActivity;
import com.tongfu.mytestapp.crashrecord.CrashRecordActivity;
import com.tongfu.mytestapp.customview.ontouchevent1.OnTouchEventTestActivity;
import com.tongfu.mytestapp.database.DatabaseMenuActivity;
import com.tongfu.mytestapp.eventbus.EventBusActivity;
import com.tongfu.mytestapp.imageload.ImageLoadEntryActivity;
import com.tongfu.mytestapp.multiprocess.MultiProcessActivity;
import com.tongfu.mytestapp.network.NetworkActivity;
import com.tongfu.mytestapp.nonification.NotificationActivity;
import com.tongfu.mytestapp.permission.PermissionActivity;
import com.tongfu.mytestapp.recyclerview.RecyclerViewActivity;
import com.tongfu.mytestapp.service.MusicPlayActivity;
import com.tongfu.mytestapp.smoothexit.SmoothExitActivity;
import com.tongfu.mytestapp.smoothexit.SmoothExitMenuActivity;
import com.tongfu.mytestapp.swiperefresh.SwipeRefreshActivity;
import com.tongfu.mytestapp.video.VideoPlayEntryActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @OnClick(R.id.btnCustomViewOnTouchEvent)
    void onBtnCustomViewOnTouchEventClicked(){
        Intent intent = new Intent(this ,OnTouchEventTestActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_content_provider)
    void onBtnContentProviderClicked(){
        Intent intent = new Intent( this , ContentProviderActivity.class) ;
        startActivity(intent);
    }
    @OnClick(R.id.btn_music_service)
    void onBtnMusicServiceClicked(){
        Intent intent = new Intent(this , MusicPlayActivity.class) ;
        startActivity(intent);
    }
    @OnClick({R.id.btn_broadcast_receiver})
    void onBtnBroadcastReceiverClicked(){
        Intent intent = new Intent(this , BroadcastReceiverActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_network)
    void onBtnNetworkClicked(){
        Intent intent = new Intent(this , NetworkActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_mvp)
    void onBtnMVPClicked(){

    }

    @OnClick(R.id.btn_database)
    void onBtnDatabaseClicked(){
        Intent intent = new Intent(this , DatabaseMenuActivity.class) ;
        startActivity(intent);
    }

    @OnClick(R.id.btn_notification)
    void onBtnNotificationClicked(){
        Intent intent = new Intent(this , NotificationActivity.class) ;
        startActivity(intent);
    }

    @OnClick(R.id.btn_butterknife)
    void onBtnButterKnifeClicked(){

    }

    @OnClick(R.id.btn_video)
    void onBtnVideoClicked(){
        Intent intent = new Intent(this , VideoPlayEntryActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_smooth_exit)
    void onBtnSmoothExitClicked(){
        Intent intent = new Intent(this , SmoothExitMenuActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.btn_image)
    void onBtnImageClicked(){
        Intent intent = new Intent(this , ImageLoadEntryActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_anim)
    void onBtnAnimClicked(){
        Intent intent = new Intent(this , AnimationEntryActivity.class) ;
        startActivity(intent);
    }

    @OnClick(R.id.btn_crash_record)
    void onBtnCrashRecordClicked(){
        Intent intent = new Intent(this , CrashRecordActivity.class) ;
        startActivity(intent);
    }

    @OnClick(R.id.btn_recycler_view)
    void onBtnRecyclerViewClicked(){
        Intent intent = new Intent(this , RecyclerViewActivity.class) ;
        startActivity(intent);
    }

    @OnClick(R.id.btn_swipe_refresh)
    void onBtnSwipeRefreshClicked(){
        Intent intent = new Intent(this , SwipeRefreshActivity.class) ;
        startActivity(intent);
    }

    @OnClick(R.id.btn_multiple_process)
    void onBtnMultipleProcessClicked(){
        Intent intent = new Intent(this , MultiProcessActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_event_bus)
    void onBtnEventBusClicked(){
        Intent intent = new Intent(this , EventBusActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_permissoin)
    void onBtnPermissionClicked(){
        Intent intent = new Intent(this , PermissionActivity.class);
        startActivity(intent);
    }

}
