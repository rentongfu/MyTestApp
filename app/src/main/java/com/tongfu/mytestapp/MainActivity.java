package com.tongfu.mytestapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tongfu.mytestapp.broadcastreceiver.BroadcastReceiverActivity;
import com.tongfu.mytestapp.contentprovider.ContentProviderActivity;
import com.tongfu.mytestapp.customview.ontouchevent1.OnTouchEventTestActivity;
import com.tongfu.mytestapp.database.DatabaseMenuActivity;
import com.tongfu.mytestapp.network.NetworkActivity;
import com.tongfu.mytestapp.nonification.NotificationActivity;
import com.tongfu.mytestapp.service.MusicPlayActivity;

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


}
