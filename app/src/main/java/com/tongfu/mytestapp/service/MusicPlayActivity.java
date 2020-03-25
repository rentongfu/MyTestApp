package com.tongfu.mytestapp.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.TraceRecorder;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicPlayActivity extends AppCompatActivity {

    MusicPlayInterface musicPlayInterface ;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TraceRecorder.record(getClass() , "onServiceConnected");
            musicPlayInterface = MusicPlayInterface.Stub.asInterface(service);
            Toast.makeText(MusicPlayActivity.this , "bindService连接成功" , Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            TraceRecorder.record(getClass() , "onServiceDisconnected");
            Toast.makeText(MusicPlayActivity.this , "bindService断开连接" , Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_start_service)
    void onBtnStartServiceClicked(){
        Intent intent = new Intent(this , MusicPlayService.class ) ;
        startService(intent);
    }

    @OnClick(R.id.btn_stop_service)
    void onBtnStopServiceClicked(){
        Intent intent = new Intent(this , MusicPlayService.class);
        stopService(intent);
    }

    @OnClick(R.id.btn_bind_service)
    void onBtnBindServiceClicked(){
        Intent intent = new Intent(this , MusicPlayService.class);
        bindService(intent , serviceConnection , Context.BIND_AUTO_CREATE );
    }

    @OnClick(R.id.btn_clear_connection)
    void onBtnClearConnectionClicked(){
        musicPlayInterface  = null ;
    }

    @OnClick(R.id.btn_set_foreground)
    void onBtnSetForegroundClicked(){
        if(musicPlayInterface == null){
            Toast.makeText(this , "musicPlayInterface object is null", Toast.LENGTH_SHORT ).show();
            return ;
        }
        try {
            musicPlayInterface.setForeground(true);
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(this , e.getMessage() , Toast.LENGTH_SHORT ).show();
        }
    }

    @OnClick(R.id.btn_clear_foreground)
    void onBtnClearForegroundClicked(){
        if(musicPlayInterface == null){
            Toast.makeText(this , "musicPlayInterface object is null", Toast.LENGTH_SHORT ).show();
            return ;
        }
        try {
            musicPlayInterface.setForeground(false);
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(this , e.getMessage() , Toast.LENGTH_SHORT ).show();
        }
    }


    @OnClick(R.id.btn_start)
    void onBtnStartClicked(){
        if(musicPlayInterface == null){
            Toast.makeText(this , "musicPlayInterface object is null", Toast.LENGTH_SHORT ).show();
            return ;
        }

        try {
            musicPlayInterface.start();
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(this , e.getMessage() , Toast.LENGTH_SHORT ).show();
        }
    }

    @OnClick(R.id.btn_pause)
    void onBtnPauseClicked(){
        if(musicPlayInterface == null){
            Toast.makeText(this , "musicPlayInterface object is null", Toast.LENGTH_SHORT ).show();
            return ;
        }
        try {
            musicPlayInterface.pause();
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(this , e.getMessage()  , Toast.LENGTH_SHORT ).show();
        }
    }
    @OnClick(R.id.btn_resume)
    void onBtnResumeClicked(){
        if(musicPlayInterface == null){
            Toast.makeText(this , "musicPlayInterface Object is null" , Toast.LENGTH_SHORT ).show();
            return ;
        }
        try {
            musicPlayInterface.resume();
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(this , e.getMessage() , Toast.LENGTH_SHORT ).show();
        }
    }
    @OnClick(R.id.btn_stop)
    void onStopClicked(){
        if(musicPlayInterface == null){
            Toast.makeText(this , "musicPlayInterface object is null", Toast.LENGTH_SHORT ).show();
            return ;
        }
        try {
            musicPlayInterface.stop();
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(this , e.getMessage() , Toast.LENGTH_SHORT ).show();
        }
    }

    @OnClick(R.id.btn_disconnect)
    void onBtnDisconnectClicked(){
        unbindService(serviceConnection);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
