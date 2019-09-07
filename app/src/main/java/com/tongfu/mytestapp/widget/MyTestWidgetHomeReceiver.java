package com.tongfu.mytestapp.widget;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class MyTestWidgetHomeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        int action = intent.getIntExtra("BTN_NEXT" , ACTION_HOME ) ;
//        int appWidgetId = intent.getIntExtra("WIDGET_ID" , -1 );
//        switch (btnAction){
//            case ACTION_HOME:{
//                time = new Date().getTime();
//                break;
//            }
//            case ACTION_NEXT:{
//                MyTestWidget.time = CalendarUtil.getMonthStart(new Date(time)).getTimeInMillis();
//                break;
//            }
//            case ACTION_PREV:{
//                time = CalendarUtil.getPrevMonthStart(new Date(time)).getTimeInMillis();
//                break;
//            }
//        }
        MyTestWidget.time = new Date().getTime();
        Intent widgetUpdateIntent = new Intent(context , MyTestWidget.class);
        widgetUpdateIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, new int[]{MyTestWidget.appWidgetId});
        widgetUpdateIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        context.sendBroadcast(widgetUpdateIntent);
    }
}
