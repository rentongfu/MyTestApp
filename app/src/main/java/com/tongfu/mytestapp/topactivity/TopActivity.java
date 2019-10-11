package com.tongfu.mytestapp.topactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tongfu.mytestapp.R;

public class TopActivity extends AppCompatActivity {

    static int topTaskId = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        setTitle("置顶界面");
        topTaskId = getTaskId() ;
    }

    @Override
    protected void onDestroy() {
        topTaskId = 0 ;
        super.onDestroy();
    }
}
