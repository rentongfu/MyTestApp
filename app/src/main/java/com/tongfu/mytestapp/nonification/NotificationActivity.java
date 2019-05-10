package com.tongfu.mytestapp.nonification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_send_notification)
    public void sendNotification(){
        NotificationManager notificationManager = (NotificationManager )getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(this , NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pi = PendingIntent.getActivity(this , 0 ,  intent , PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap bigPicture = BitmapFactory.decodeResource(getResources() , R.mipmap.ic_launcher) ;

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentText("少小离家老大回，乡音无改鬓毛衰。")
                .setContentTitle("回乡偶书")
                .setSmallIcon(R.drawable.ic_blank)
                .setLargeIcon(bigPicture)
                .setContentIntent(pi)
                .setStyle(new Notification.BigPictureStyle().bigPicture(bigPicture)
                        .bigLargeIcon((Bitmap) null));

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            builder.setChannelId("a");
        }
        notificationManager.notify(i++, builder.build());
    }

    @OnClick(R.id.btn_create_notification_channel)
    public void createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            NotificationManager notificationManager = (NotificationManager )getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel mChannel = new NotificationChannel("a", "通知渠道名称", NotificationManager.IMPORTANCE_HIGH);
            mChannel.setDescription("这是通知渠道说明，会在系统的通知渠道设置界面显示给用户看");
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100});
            notificationManager.createNotificationChannel(mChannel);
        }
    }

}
