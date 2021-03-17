package com.tongfu.mytestapp.customview.ontouchevent1;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 自定义View，每次绘制将绘制成随机颜色。
 *
 *
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
        Log.i("MyView" , "onLayout");
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        Log.i("MyView" , "layout");
        super.layout(l, t, r, b);
    }

    private final int INIT_WIDTH = 200 ;
    private final int INIT_HEIGHT = 100 ;

    private ValueAnimator animator = null;

    /**
     * 页面打开时调用，内部必须调用setMeasuredDimension。传入的值后续会影响layout和onLayout方法接受的值。
     * 理论上也可以重写layout方法，将计算宽高的逻辑放在layout方法里面。本demo中onTouchEvent中就是这么做的。
     */
    private int mWidth = INIT_WIDTH , mHeight = INIT_HEIGHT ;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i("MyView" , "onMeasure");
//        System.out.println("width:" + widthMeasureSpec + "height:" + heightMeasureSpec);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(INIT_WIDTH , INIT_HEIGHT);
    }


    private final int[] colors = {Color.RED , Color.GREEN , Color.BLACK , Color.GREEN , Color.BLUE , Color.DKGRAY , Color.LTGRAY , Color.YELLOW , Color.MAGENTA};
    private int prevColor = Color.WHITE ;
    private int currentColor = prevColor ;
    /**
     * 触发时机：
     *  调用invalidate()之后
     *  layout方法的入参计算出的宽度和高度发生改变时自动调用。
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("MyView" , "onDraw");
        super.onDraw(canvas);
        canvas.drawColor(currentColor);
    }

    int lastX,lastY ;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX() ;
        int y = (int)event.getY() ;
        Log.i("MyView" , "onTouchEvent x:" + x +" y:" + y);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                lastX = x ;
                lastY = y ;
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                int offsetX = x - lastX ;
                int offsetY = y - lastY ;
                if(x < 50 || y <50){
                    mHeight = mHeight + offsetY ;
                    mWidth = mWidth + offsetX ;
                }
                layout(getLeft() + offsetX , getTop() + offsetY , getLeft() + offsetX + mWidth , getTop() + offsetY + mHeight );

                break;
            }
            case MotionEvent.ACTION_UP:{
//                invalidate();
                if(animator == null){
                    animator = ValueAnimator.ofArgb( prevColor ,  colors[(int)(Math.random()* colors.length)]);
                    animator.setDuration(1000);
                    animator.setRepeatCount(0);
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            currentColor = (int) animation.getAnimatedValue();
                            invalidate();
                        }
                    });
                    animator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            prevColor = currentColor ;
                            animator = null ;
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    animator.start();
                }

                break;
            }
            default:
                return super.onTouchEvent(event) ;
        }

        return true ;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("MyView" , "dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }
}
