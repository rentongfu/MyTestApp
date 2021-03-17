package com.tongfu.mytestapp.uiwidget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyListViewItem extends LinearLayout {
    public MyListViewItem(Context context) {
        super(context);
    }

    public MyListViewItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListViewItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyListViewItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("MyListViewItem" , "onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("MyListViewItem" , "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("MyListViewItem" , "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }
}
