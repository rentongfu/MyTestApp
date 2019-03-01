package com.tongfu.mytestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tongfu.mytestapp.customview.ontouchevent1.OnTouchEventTestActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCustomViewOnTouchEvent)
    void onBtnCustomViewOnTouchEventClicked(){
        Intent intent = new Intent(this ,OnTouchEventTestActivity.class);
        startActivity(intent);
    }
}
