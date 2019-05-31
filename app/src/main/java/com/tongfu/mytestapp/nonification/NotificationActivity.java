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
import android.widget.RemoteViews;
import android.widget.Toast;

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

        Bitmap bigPicture = BitmapFactory.decodeResource(getResources() , R.drawable.a  ) ;

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentText("少小离家老大回，乡音无改鬓毛衰。")
                .setContentTitle("回乡偶书")
                .setSmallIcon(R.drawable.ic_blank)
                .setLargeIcon(bigPicture)
                .setContentIntent(pi)
                .setTicker("唐诗三百首")
                .setAutoCancel(false)
//                .setOngoing(true)
                .setProgress(100 , 33 , false );
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

    @OnClick(R.id.btn_big_text_style)
    public void sendBigTextStyleNotifcation(){
        NotificationManager notificationManager = (NotificationManager )getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(this , NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pi = PendingIntent.getActivity(this , 0 ,  intent , PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap bigPicture = BitmapFactory.decodeResource(getResources() , R.drawable.a) ;

        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        bigTextStyle.bigText("少小离家老大回，乡音无改鬓毛衰。\n儿童相见不相识，笑问客从何处来。");
        bigTextStyle.setBigContentTitle("回乡偶书");
        bigTextStyle.setSummaryText("作者：贺知章");

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentText("BigTextStyle重要方法：bigText，setBigContentTitle，setSummaryText。")
                .setContentTitle("BigTextStyle演示")
                .setSubText("日期：2019年5月23日")
                .setSmallIcon(R.drawable.ic_blank)
                .setLargeIcon(bigPicture)
                .setContentIntent(pi)
                .setStyle(bigTextStyle)
                .setTicker("唐诗三百首")
                .setAutoCancel(false)
                .setOngoing(false);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            builder.setChannelId("a");
        }
        notificationManager.notify(i++, builder.build());
    }

    @OnClick(R.id.btn_big_picture_style)
    public void sendBigPictureStyleNotification(){
        NotificationManager notificationManager = (NotificationManager )getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(this , NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pi = PendingIntent.getActivity(this , 0 ,  intent , PendingIntent.FLAG_UPDATE_CURRENT);


        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
        bigPictureStyle.bigLargeIcon( BitmapFactory.decodeResource(getResources() , R.drawable.c))
                .setBigContentTitle("这是大内容标题")
                .setSummaryText("总结文本")
                .bigPicture( BitmapFactory.decodeResource(getResources() , R.drawable.b));

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentText("BigPictureStyle重要方法：bigLargeIcon，setBigContentTitle，setSummaryText，bigPicture。")
                .setContentTitle("BigPictureStyle演示")
                .setSmallIcon(R.drawable.ic_blank)
                .setLargeIcon(BitmapFactory.decodeResource(getResources() , R.drawable.a))
                .setContentIntent(pi)
                .setStyle(bigPictureStyle)
                .setTicker("唐诗三百首");

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            builder.setChannelId("a");
        }
        notificationManager.notify(i++, builder.build());
    }

    @OnClick(R.id.btn_inbox_style)
    public void btnSendInboxStyleNotification(){
        NotificationManager notificationManager = (NotificationManager )getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(this , NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pi = PendingIntent.getActivity(this , 0 ,  intent , PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
        inboxStyle.setBigContentTitle("上古卷轴5九大地区");
        inboxStyle.setSummaryText("这是总结文本");
        inboxStyle.addLine("雪漫城");
        inboxStyle.addLine("裂谷城");
        inboxStyle.addLine("独孤城");
        inboxStyle.addLine("风盔城");
        inboxStyle.addLine("马卡斯城");
        inboxStyle.addLine("晨星");
        inboxStyle.addLine("福克瑞斯");
        inboxStyle.addLine("莫萨尔");
        inboxStyle.addLine("冬堡");

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentText("InboxStyle重要方法：setBigContextTitle，setSummaryText，addLine。")
                .setContentTitle("InboxStyle介绍")
                .setSmallIcon(R.drawable.ic_blank)
                .setLargeIcon(BitmapFactory.decodeResource(getResources() , R.drawable.a))
                .setContentIntent(pi)
                .setStyle(inboxStyle)
                .setTicker("唐诗三百首");

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            builder.setChannelId("a");
        }
        notificationManager.notify(i++, builder.build());
    }

    @OnClick(R.id.btn_messaging_style)
    public void btnSendMessagingStyleNotifcation(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            NotificationManager notificationManager = (NotificationManager )getSystemService(NOTIFICATION_SERVICE);

            Intent intent = new Intent(this , NotificationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent pi = PendingIntent.getActivity(this , 0 ,  intent , PendingIntent.FLAG_UPDATE_CURRENT);

            Notification.MessagingStyle messagingStyle = new Notification.MessagingStyle("Jack");
            messagingStyle.setConversationTitle("Conversation Title");
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                messagingStyle.addHistoricMessage( new Notification.MessagingStyle.Message( "历史消息内容" , System.currentTimeMillis() - 15000 , "Anne" ));
            messagingStyle.addMessage(new Notification.MessagingStyle.Message("消息内容" , System.currentTimeMillis() - 10000 , "Conner"));
            messagingStyle.addMessage(new Notification.MessagingStyle.Message("第二条消息内容" , System.currentTimeMillis() , "Conner"));

            Notification.Builder builder = new Notification.Builder(this);
            builder.setContentText("MessagingStyle相关方法：setConversationTitle，addHistoricMessage，addMessage。")
                    .setContentTitle("MessagingStyle演示")
                    .setSmallIcon(R.drawable.ic_blank)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources() , R.drawable.a))
                    .setContentIntent(pi)
                    .setStyle(messagingStyle)
                    .setTicker("唐诗三百首");

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
                builder.setChannelId("a");
            }
            notificationManager.notify(i++, builder.build());
        }else{
            Toast.makeText(this, "MessagingStyle要求手机最低版本为Android N", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_custom_notification)
    public void onBtnCustomNotificationClicked(){

        NotificationManager notificationManager = (NotificationManager )getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(this , NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pi = PendingIntent.getActivity(this , 0 ,  intent , PendingIntent.FLAG_UPDATE_CURRENT);


        RemoteViews remoteViews = new RemoteViews(getPackageName() , R.layout.layout_custom_notification);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentText("InboxStyle重要方法：setBigContextTitle，setSummaryText，addLine。")
                .setContentTitle("InboxStyle介绍")
                .setSmallIcon(R.drawable.ic_blank)
                .setLargeIcon(BitmapFactory.decodeResource(getResources() , R.drawable.a))
                .setContentIntent(pi)
                .setTicker("唐诗三百首");

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
//            builder.setCustomContentView(remoteViews);
            builder.setCustomBigContentView(remoteViews);
        }else{
            builder.setContent(remoteViews);//在24之后的源码之中，这个方法内部也是调用了setCustomContentView。
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            builder.setChannelId("a");
        }
        notificationManager.notify(i++, builder.build());
    }

}
