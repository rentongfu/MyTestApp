package com.tongfu.mytestapp.widget;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Date;

public class MyTestWidgetNextReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        MyTestWidget.time = CalendarUtil.getMonthEnd(new Date(MyTestWidget.time)).getTimeInMillis();
        Intent widgetUpdateIntent = new Intent(context , MyTestWidget.class);
        widgetUpdateIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, new int[]{MyTestWidget.appWidgetId});
        widgetUpdateIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        context.sendBroadcast(widgetUpdateIntent);
    }
}
