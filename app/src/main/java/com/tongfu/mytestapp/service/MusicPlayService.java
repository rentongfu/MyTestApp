package com.tongfu.mytestapp.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.Trace;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.TraceRecorder;

import java.io.FileDescriptor;
import java.io.IOException;

public class MusicPlayService extends Service {
    private static final int FOREGROUND_NOTIFICATION_ID = 1 ;

    public MusicPlayService() {
        TraceRecorder.record(getClass(),  "MusicPlayService");
    }

    MediaPlayer mediaPlayer  ;

    private IBinder mBinder = new MusicPlayInterface.Stub(){

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) {
            TraceRecorder.record(getClass() , "start");
        }

        @Override
        public void start() {
            TraceRecorder.record(getClass() , "start");
            mediaPlayer.start();
        }

        @Override
        public void pause() {
            TraceRecorder.record(getClass() , "pause");
            mediaPlayer.pause();
        }

        @Override
        public void resume() {
            TraceRecorder.record(getClass() , "resume");
            mediaPlayer.start();
        }

        @Override
        public void stop() {
            TraceRecorder.record(getClass() , "stop" );
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }

        @Override
        public int getPlayState() {
            TraceRecorder.record(getClass() , "getPlayState");
            return 0;
        }

        @Override
        public void setForeground(boolean isForeground) throws RemoteException {
            if(isForeground){

                    Notification.Builder builder = new Notification.Builder(MusicPlayService.this);
                    builder.setContentText("音乐播放服务通知")
                            .setContentTitle("音乐播放")
                            .setSmallIcon(R.drawable.ic_blank);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        NotificationChannel channel = new NotificationChannel("MusicPlayService" , "Music Play" , NotificationManager.IMPORTANCE_DEFAULT );
                        NotificationManager notificationManager = (NotificationManager )getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.createNotificationChannel(channel);
                        builder.setChannelId("MusicPlayService");
                    }
                    startForeground( FOREGROUND_NOTIFICATION_ID , builder.build() );

            }else{
                stopForeground(true);
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        TraceRecorder.record(getClass() , "onBind");
        // TODO: Return the communication channel to the service.
        new IBinder(){

            @Nullable
            @Override
            public String getInterfaceDescriptor() throws RemoteException {
                return null;
            }

            @Override
            public boolean pingBinder() {
                return false;
            }

            @Override
            public boolean isBinderAlive() {
                stopSelf();
                return false;
            }

            @Nullable
            @Override
            public IInterface queryLocalInterface(@NonNull String descriptor) {
                return null;
            }

            @Override
            public void dump(@NonNull FileDescriptor fd, @Nullable String[] args) throws RemoteException {

            }

            @Override
            public void dumpAsync(@NonNull FileDescriptor fd, @Nullable String[] args) throws RemoteException {

            }

            @Override
            public boolean transact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
                return false;
            }

            @Override
            public void linkToDeath(@NonNull DeathRecipient recipient, int flags) throws RemoteException {

            }

            @Override
            public boolean unlinkToDeath(@NonNull DeathRecipient recipient, int flags) {
                return false;
            }
        };

        return mBinder;
    }

    @Override
    public void onCreate() {
        TraceRecorder.record(getClass() , "onCreate");
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor  ad = getAssets().openFd("demonssouls.mp3") ;
            mediaPlayer.setDataSource(ad.getFileDescriptor()  , ad.getStartOffset() , ad.getLength());
            mediaPlayer.setLooping(true);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        TraceRecorder.record(getClass() , "onStartCommand");
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        TraceRecorder.record(getClass() , "onDestroy");

        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        TraceRecorder.record(getClass() , "onUnBind");
        return false;
    }

    @Override
    public void onRebind(Intent intent) {
        TraceRecorder.record(getClass() , "onRebind");
        super.onRebind(intent);
    }
}
