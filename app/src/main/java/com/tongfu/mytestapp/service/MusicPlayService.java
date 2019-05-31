package com.tongfu.mytestapp.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.RemoteException;

import java.io.FileDescriptor;
import java.io.IOException;

public class MusicPlayService extends Service {
    public MusicPlayService() {
    }

    MediaPlayer mediaPlayer  ;

    private IBinder mBinder = new MusicPlayInterface.Stub(){

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) {

        }

        @Override
        public void start() {
            mediaPlayer.start();
        }

        @Override
        public void pause() {
            mediaPlayer.pause();
        }

        @Override
        public void resume() {
            mediaPlayer.start();
        }

        @Override
        public void stop() {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }

        @Override
        public int getPlayState() {
            return 0;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor  ad = getAssets().openFd("demonssouls.mp3") ;
            mediaPlayer.setDataSource(ad.getFileDescriptor()  , ad.getStartOffset() , ad.getLength());
            mediaPlayer.setLooping(true);
            mediaPlayer.prepareAsync();
//            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mp) {
//                    mp.setOnPreparedListener(null);
//                    mp.start();
//                }
//            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
