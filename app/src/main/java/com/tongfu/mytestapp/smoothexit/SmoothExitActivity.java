package com.tongfu.mytestapp.smoothexit;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SmoothExitActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smooth_exit);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
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
    }

    Float downX = null ;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch(ev.getAction()){
            case MotionEvent.ACTION_DOWN:{
//                downPoint = new Point((int)ev.getX() , (int)ev.getY());
                if(ev.getX() < 10){
                    downX = ev.getX();
                    Log.i("SmoothExit" , "当前的横坐标为：" + downX ) ;
                    return true ;
                }
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                if (downX!= null){
                    float x =  ev.getX() - downX ;
//                    int y = (int)ev.getY() - downPoint.y;
                    if(x > 0)
                        getWindow().getDecorView().setTranslationX(x);
                    return true ;
                }
                break;
            }
            case MotionEvent.ACTION_UP:{
                if(downX !=null){
                    getWindow().getDecorView().setTranslationX(0);
                    downX = null ;
                    return true;
                }
                break;

            }
        }

        return super.dispatchTouchEvent(ev);
    }
}
