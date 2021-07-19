package com.tongfu.mytestapp.volatiletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tongfu.mytestapp.R;

public class VolatileTestActivity extends AppCompatActivity {
    private boolean flag = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volatile_test);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(VolatileTestActivity.class.getName() , "volatile thread started!");
                while(flag){

                }
                Log.i(VolatileTestActivity.class.getName() , "volatile thread stopped!");
            }
        }).start();
        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false ;
            }
        });
    }

}
