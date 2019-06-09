package com.tongfu.mytestapp.smoothexit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SmoothExitMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smooth_exit_menu);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_my_smooth_exit)
    void onBtnMySmoothExitClicked(){
        Intent intent = new Intent(this , SmoothExitActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_swipe_back_layout)
    void onBtnSwipeBackLayoutClicked(){
        Intent intent = new Intent(this ,  SwipeBackLayoutActivity.class );
        startActivity(intent);
    }
}
