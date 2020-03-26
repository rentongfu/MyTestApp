package com.tongfu.mytestapp.eventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyViewGroup extends LinearLayout {
    public MyViewGroup(@NonNull Context context) {
        super(context);
    }

    public MyViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean isHandled = super.onInterceptTouchEvent(ev);
        Log.i("DispatchEvent" , "MyViewGrout onInterceptTouchEvent " + isHandled);
        return isHandled;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean isHandled = super.onTouchEvent(event) ;
        Log.i("DispatchEvent" , "MyViewGrout onTouchEvent " + isHandled);
        return isHandled;
    }
}
