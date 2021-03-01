package com.tongfu.mytestapp.customview.ontouchevent1;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 自定义View，每次绘制将绘制成随机颜色。
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    int lastX,lastY ;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX() ;
        int y = (int)event.getY() ;

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                lastX = x ;
                lastY = y ;
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                int offsetX = x - lastX ;
                int offsetY = y - lastY ;
                layout(getLeft() + offsetX , getTop() + offsetY , getRight() + offsetX , getBottom() + offsetY );
                break;
            }
            default:
                return super.onTouchEvent(event) ;
        }

        return true ;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }
}
