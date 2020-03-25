package com.tongfu.mytestapp.architecture.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.tongfu.mytestapp.R;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle2);
        MyLocationListner myLocationListner = new MyLocationListner(this);
        getLifecycle().addObserver(myLocationListner);
    }

    public static class MyLocationListner implements LifecycleObserver {
        public MyLocationListner(Context context ){

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void start(){
            Log.i("Architecture" , "activity resumed") ;
        }
        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public void stop(){
            Log.i("Architecture" , "activity paused") ;

        }
    }
}
