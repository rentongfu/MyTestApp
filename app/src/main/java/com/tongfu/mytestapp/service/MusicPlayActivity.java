package com.tongfu.mytestapp.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicPlayActivity extends AppCompatActivity {

    MusicPlayInterface musicPlayInterface ;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            musicPlayInterface = MusicPlayInterface.Stub.asInterface(service);
            Toast.makeText(MusicPlayActivity.this , "bindService连接成功" , Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicPlayInterface = null ;
            Toast.makeText(MusicPlayActivity.this , "bindService断开连接" , Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_bind_service)
    void onBtnBindServiceClicked(){
        Intent intent = new Intent(this , MusicPlayService.class);
        bindService(intent , serviceConnection , Context.BIND_AUTO_CREATE );
    }

    @OnClick(R.id.btn_start)
    void onBtnStartClicked(){
        if(musicPlayInterface == null){
            Toast.makeText(this , "请先连接服务" , Toast.LENGTH_SHORT ).show();
            return ;
        }

        try {
            musicPlayInterface.start();
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(this , "start失败" , Toast.LENGTH_SHORT ).show();
        }
    }

    @OnClick(R.id.btn_pause)
    void onBtnPauseClicked(){
        if(musicPlayInterface == null){
            Toast.makeText(this , "请先连接服务" , Toast.LENGTH_SHORT ).show();
            return ;
        }
        try {
            musicPlayInterface.pause();
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(this , "pause失败" , Toast.LENGTH_SHORT ).show();
        }
    }
    @OnClick(R.id.btn_resume)
    void onBtnResumeClicked(){
        if(musicPlayInterface == null){
            Toast.makeText(this , "请先连接服务" , Toast.LENGTH_SHORT ).show();
            return ;
        }
        try {
            musicPlayInterface.resume();
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(this , "resume失败" , Toast.LENGTH_SHORT ).show();
        }
    }
    @OnClick(R.id.btn_stop)
    void onStopClicked(){
        if(musicPlayInterface == null){
            Toast.makeText(this , "请先连接服务" , Toast.LENGTH_SHORT ).show();
            return ;
        }
        try {
            musicPlayInterface.stop();
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(this , "stop失败" , Toast.LENGTH_SHORT ).show();
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(serviceConnection);
        super.onDestroy();
    }
}
