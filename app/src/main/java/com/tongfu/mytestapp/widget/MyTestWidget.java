package com.tongfu.mytestapp.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.RemoteViews;

import com.tongfu.mytestapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Implementation of App Widget functionality.
 */
public class MyTestWidget extends AppWidgetProvider {

    public static long time = new Date().getTime();

    public static int appWidgetId = -1 ;


    static int[] tvDayIds = {R.id.tv_day01,R.id.tv_day02,R.id.tv_day03,R.id.tv_day04,R.id.tv_day05,R.id.tv_day06,R.id.tv_day07,
            R.id.tv_day08,R.id.tv_day09,R.id.tv_day10,R.id.tv_day11,R.id.tv_day12,R.id.tv_day13,R.id.tv_day14,
            R.id.tv_day15,R.id.tv_day16,R.id.tv_day17,R.id.tv_day18,R.id.tv_day19,R.id.tv_day20,R.id.tv_day21,
            R.id.tv_day22,R.id.tv_day23,R.id.tv_day24,R.id.tv_day25,R.id.tv_day26,R.id.tv_day27,R.id.tv_day28,
            R.id.tv_day29,R.id.tv_day30,R.id.tv_day31,R.id.tv_day32,R.id.tv_day33,R.id.tv_day34,R.id.tv_day35,
            R.id.tv_day36,R.id.tv_day37,R.id.tv_day38,R.id.tv_day39,R.id.tv_day40,R.id.tv_day41,R.id.tv_day42};
    static int [] tvLunarIds = {R.id.tv_lunar_day01,R.id.tv_lunar_day02,R.id.tv_lunar_day03,R.id.tv_lunar_day04,R.id.tv_lunar_day05,R.id.tv_lunar_day06,R.id.tv_lunar_day07,
            R.id.tv_lunar_day08,R.id.tv_lunar_day09,R.id.tv_lunar_day10,R.id.tv_lunar_day11,R.id.tv_lunar_day12,R.id.tv_lunar_day13,R.id.tv_lunar_day14,
            R.id.tv_lunar_day15,R.id.tv_lunar_day16,R.id.tv_lunar_day17,R.id.tv_lunar_day18,R.id.tv_lunar_day19,R.id.tv_lunar_day20,R.id.tv_lunar_day21,
            R.id.tv_lunar_day22,R.id.tv_lunar_day23,R.id.tv_lunar_day24,R.id.tv_lunar_day25,R.id.tv_lunar_day26,R.id.tv_lunar_day27,R.id.tv_lunar_day28,
            R.id.tv_lunar_day29,R.id.tv_lunar_day30,R.id.tv_lunar_day31,R.id.tv_lunar_day32,R.id.tv_lunar_day33,R.id.tv_lunar_day34,R.id.tv_lunar_day35,
            R.id.tv_lunar_day36,R.id.tv_lunar_day37,R.id.tv_lunar_day38,R.id.tv_lunar_day39,R.id.tv_lunar_day40,R.id.tv_lunar_day41,R.id.tv_lunar_day42,};
    static int[] loDateIds = {R.id.ll_date01,R.id.ll_date02,R.id.ll_date03,R.id.ll_date04,R.id.ll_date05,R.id.ll_date06,R.id.ll_date07,
            R.id.ll_date08,R.id.ll_date09,R.id.ll_date10,R.id.ll_date11,R.id.ll_date12,R.id.ll_date13,R.id.ll_date14,
            R.id.ll_date15,R.id.ll_date16,R.id.ll_date17,R.id.ll_date18,R.id.ll_date19,R.id.ll_date20,R.id.ll_date21,
            R.id.ll_date22,R.id.ll_date23,R.id.ll_date24,R.id.ll_date25,R.id.ll_date26,R.id.ll_date27,R.id.ll_date28,
            R.id.ll_date29,R.id.ll_date30,R.id.ll_date31,R.id.ll_date32,R.id.ll_date33,R.id.ll_date34,R.id.ll_date35,
            R.id.ll_date36,R.id.ll_date37,R.id.ll_date38,R.id.ll_date39,R.id.ll_date40,R.id.ll_date41,R.id.ll_date42,};

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_calendar);
        MyTestWidget.appWidgetId = appWidgetId;

        Intent intent = new Intent(context , MyTestWidgetHomeReceiver.class);
        intent.putExtra("WIDGET_ID" , appWidgetId);
        views.setOnClickPendingIntent(R.id.btn_home , PendingIntent.getBroadcast(context , 0 , intent ,PendingIntent.FLAG_IMMUTABLE ));

        Intent intent2 = new Intent(context , MyTestWidgetPrevReceiver.class );
        intent2.putExtra("WIDGET_ID" , appWidgetId);
        views.setOnClickPendingIntent(R.id.btn_left_arrow , PendingIntent.getBroadcast(context , 0 , intent2 , PendingIntent.FLAG_IMMUTABLE));

        Intent intent3 = new Intent(context , MyTestWidgetNextReceiver.class );
        intent3.putExtra("WIDGET_ID" , appWidgetId);
        views.setOnClickPendingIntent(R.id.btn_right_arrow , PendingIntent.getBroadcast(context , 0 , intent3 , PendingIntent.FLAG_IMMUTABLE));

        Calendar monthStart = CalendarUtil.getMonthStart(new Date(time));
        int month = monthStart.get(Calendar.MONTH);
        Calendar tmpCalendar = (Calendar) monthStart.clone();
        views.setTextViewText( R.id.tv_month , new SimpleDateFormat("yyyy-MM").format(tmpCalendar.getTime()));
        tmpCalendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        for (int i = 0 ;i < 42; i++) {
            Lunar lunar = new Lunar(tmpCalendar);
            views.setTextViewText(tvDayIds[i] , Integer.toString(tmpCalendar.get(Calendar.DAY_OF_MONTH)));
            views.setTextViewText(tvLunarIds[i] ,Lunar.getChinaDayString(lunar.day) );
            if (today.getTimeInMillis() == tmpCalendar.getTimeInMillis()) {
                views.setTextColor(tvDayIds[i] , Color.WHITE );
                views.setTextColor(tvLunarIds[i] , Color.WHITE );
                views.setInt(loDateIds[i], "setBackgroundColor",0xFF00FFFF);
            }else if(tmpCalendar.get(Calendar.MONTH) != month){
                views.setInt(loDateIds[i], "setBackgroundColor",0x00000000);
                views.setTextColor(tvDayIds[i] , Color.DKGRAY );
                views.setTextColor(tvLunarIds[i] , Color.DKGRAY );
            }else{
                views.setTextColor(tvDayIds[i] , Color.WHITE );
                views.setTextColor(tvLunarIds[i] , Color.WHITE );
                views.setInt(loDateIds[i], "setBackgroundColor",0x00000000);
            }

            tmpCalendar.setTimeInMillis( tmpCalendar.getTimeInMillis() + 1000L * 60 * 60 * 24);
        }




        appWidgetManager.updateAppWidget(appWidgetId, views);
    }



    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }



    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

