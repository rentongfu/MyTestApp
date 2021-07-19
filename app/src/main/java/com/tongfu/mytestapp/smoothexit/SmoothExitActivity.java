package com.tongfu.mytestapp.smoothexit;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SmoothExitActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView ;

    private FrameLayout newDecorViewChild ;
    private View originDecorViewChild ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smooth_exit);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        replaceDecorView();
        ButterKnife.bind(this);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 50;
            }
            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    convertView = LayoutInflater.from(getBaseContext()).inflate(R.layout.layout_user_info_lv_item , parent ,false);
                }
                return convertView;
            }
        });
        String[] list  = new String[20];
        for( int i = 0 ; i < list.length ; i++){
            list[i] = "列表项：" + i ;
        }

        listView.setAdapter(new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , list ));
    }

    private void replaceDecorView(){
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView() ;
        originDecorViewChild = decorView.getChildAt(0) ;
        decorView.removeView(originDecorViewChild );
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT , FrameLayout.LayoutParams.MATCH_PARENT);
        newDecorViewChild  = new FrameLayout(this );
        newDecorViewChild.setLayoutParams(params);
        newDecorViewChild.addView(originDecorViewChild);
        decorView.addView(newDecorViewChild);
        newDecorViewChild.setBackgroundColor(0x77000000);
    }

    Float downX = null ;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch(ev.getAction()){
            case MotionEvent.ACTION_DOWN:{
                Log.i("SmoothExit" , "当前的横坐标为：" + ev.getX() ) ;
//                downPoint = new Point((int)ev.getX() , (int)ev.getY());
                if(ev.getX() < 100){
                    downX = ev.getX();
                    return true ;
                }
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                if (downX!= null){
                    float x =  ev.getX() - downX ;
//                    int y = (int)ev.getY() - downPoint.y;
                    if(x > 0) {
                        originDecorViewChild.setTranslationX(x);

                        newDecorViewChild.setBackgroundColor((0xFF - (int)(x / newDecorViewChild.getWidth() * 0xFF))<<24 );
                    }
                    return true ;
                }
                break;
            }
            case MotionEvent.ACTION_UP:{
                if(downX !=null){
                    int screenWidth = getResources().getDisplayMetrics().widthPixels;
                    if(ev.getX() / screenWidth > 0.3){
                        goOnToExit(downX , ev.getX());
                    }else{
                        goToReset(downX , ev.getX());
                    }
                    downX = null ;
                    return true;
                }
                break;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private void goToReset(float downX , float currentX) {
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        View view = originDecorViewChild;
        float currentDeltaX = currentX-downX ;
        Animator a = ObjectAnimator.ofFloat(view , "x" , currentDeltaX , 0 );
        a.setDuration((long) (300 * Math.abs(currentDeltaX) / screenWidth));
        a.start();
    }

    private void goOnToExit(float downX , float currentX) {
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        View view = originDecorViewChild;
        float currentDeltaX = currentX-downX ;
        Animator a = ObjectAnimator.ofFloat(view , "x" , currentDeltaX , screenWidth );
        a.setDuration((long) (300 - 300 * currentDeltaX / screenWidth));
        a.start();
        a.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }
            @Override
            public void onAnimationEnd(Animator animation) {
                finish();
                overridePendingTransition(0,0);
            }
            @Override
            public void onAnimationCancel(Animator animation) { }
            @Override
            public void onAnimationRepeat(Animator animation) { }
        });
    }
}
