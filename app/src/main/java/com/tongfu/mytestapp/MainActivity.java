package com.tongfu.mytestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tongfu.mytestapp.animation.AnimationEntryActivity;
import com.tongfu.mytestapp.broadcastreceiver.BroadcastReceiverActivity;
import com.tongfu.mytestapp.contentprovider.ContentProviderActivity;
import com.tongfu.mytestapp.crashrecord.CrashRecordActivity;
import com.tongfu.mytestapp.customview.ontouchevent1.OnTouchEventTestActivity;
import com.tongfu.mytestapp.database.DatabaseMenuActivity;
import com.tongfu.mytestapp.eventbus.EventBusActivity;
import com.tongfu.mytestapp.imageload.ImageLoadEntryActivity;
import com.tongfu.mytestapp.lifecycle.LifecycleActivity;
import com.tongfu.mytestapp.memory.MemoryCheckActivity;
import com.tongfu.mytestapp.multiprocess.MultiProcessActivity;
import com.tongfu.mytestapp.network.NetworkActivity;
import com.tongfu.mytestapp.nonification.NotificationActivity;
import com.tongfu.mytestapp.permission.PermissionActivity;
import com.tongfu.mytestapp.recyclerview.RecyclerViewActivity;
import com.tongfu.mytestapp.sampleactivity.SampleMenuActivity;
import com.tongfu.mytestapp.service.MusicPlayActivity;
import com.tongfu.mytestapp.smoothexit.SmoothExitActivity;
import com.tongfu.mytestapp.smoothexit.SmoothExitMenuActivity;
import com.tongfu.mytestapp.swiperefresh.SwipeRefreshActivity;
import com.tongfu.mytestapp.uiwidget.UIWidgetActivity;
import com.tongfu.mytestapp.uiwidget.UIWidgetMenuActivity;
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

    @OnClick({R.id.btnCustomViewOnTouchEvent,R.id.btn_memory,R.id.btn_content_provider,R.id.btn_music_service,
            R.id.btn_broadcast_receiver,R.id.btn_network,R.id.btn_database,R.id.btn_notification,R.id.btn_video,
            R.id.btn_smooth_exit,R.id.btn_image,R.id.btn_anim,R.id.btn_crash_record,
            R.id.btn_swipe_refresh,R.id.btn_multiple_process,R.id.btn_event_bus,R.id.btn_permissoin,R.id.btn_lifecycle,
            R.id.btn_activity_sample,R.id.btn_ui_widget})
    void onClick(View v){
        switch (v.getId()){
            case R.id.btn_memory:{
                Intent intent = new Intent(this , MemoryCheckActivity.class);
                startActivity(intent) ;
                break;
            }
            case R.id.btnCustomViewOnTouchEvent:{
                Intent intent = new Intent(this ,OnTouchEventTestActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_content_provider:{
                Intent intent = new Intent( this , ContentProviderActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_music_service:{
                Intent intent = new Intent(this , MusicPlayActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_broadcast_receiver:{
                Intent intent = new Intent(this , BroadcastReceiverActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_network:{
                Intent intent = new Intent(this , NetworkActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_database:{
                Intent intent = new Intent(this , DatabaseMenuActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_notification:{
                Intent intent = new Intent(this , NotificationActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_video:{
                Intent intent = new Intent(this , VideoPlayEntryActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_smooth_exit:{
                Intent intent = new Intent(this , SmoothExitMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_image:{
                Intent intent = new Intent(this , ImageLoadEntryActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_anim:{
                Intent intent = new Intent(this , AnimationEntryActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_crash_record:{
                Intent intent = new Intent(this , CrashRecordActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_swipe_refresh:{
                Intent intent = new Intent(this , SwipeRefreshActivity.class) ;
                startActivity(intent);
                break;
            }
            case R.id.btn_multiple_process:{
                Intent intent = new Intent(this , MultiProcessActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_event_bus:{
                Intent intent = new Intent(this , EventBusActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_permissoin:{
                Intent intent = new Intent(this , PermissionActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_lifecycle:{
                Intent intent = new Intent(this , LifecycleActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_activity_sample:{
                Intent intent = new Intent(this , SampleMenuActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_ui_widget:{
                Intent intent = new Intent(this , UIWidgetMenuActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
