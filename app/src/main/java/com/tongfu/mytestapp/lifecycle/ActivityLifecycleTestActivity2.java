package com.tongfu.mytestapp.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;

public class ActivityLifecycleTestActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_lifecycle_test2);
        ButterKnife.bind(this);
    }
}
