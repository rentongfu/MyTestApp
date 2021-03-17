package com.tongfu.mytestapp.uiwidget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyListViewButton extends androidx.appcompat.widget.AppCompatButton {

    public MyListViewButton(Context context) {
        super(context);
    }

    public MyListViewButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListViewButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("MyListViewButton" , "onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("MyListViewButton" , "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

}
