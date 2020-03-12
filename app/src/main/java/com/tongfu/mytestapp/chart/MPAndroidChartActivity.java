package com.tongfu.mytestapp.chart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;

public class MPAndroidChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpandroid_chart);
        ButterKnife.bind(this);



    }
}
