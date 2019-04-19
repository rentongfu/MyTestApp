package com.tongfu.mytestapp.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.tongfu.mytestapp.R;

public class CalendarService extends RemoteViewsService {
    public CalendarService() {
    }

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Log.i("CalendarService" , "onGetViewFactory" );
        return new RemoteViewsFactory() {
            @Override
            public void onCreate() {

            }

            @Override
            public void onDataSetChanged() {

            }

            @Override
            public void onDestroy() {

            }

            @Override
            public int getCount() {
                return 42;
            }

            @Override
            public RemoteViews getViewAt(int position) {
                RemoteViews views = new RemoteViews(getPackageName(), R.layout.layout_calendar_day);
                views.setTextViewText(R.id.tv_day , "1");
                views.setTextViewText(R.id.tv_lunar_day , "初一");
                return views;
            }

            @Override
            public RemoteViews getLoadingView() {
                return null;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }
        };
    }
}
