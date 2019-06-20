package com.tongfu.mytestapp.lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_activity,R.id.btn_service})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_activity:{
                Intent intent = new Intent(this , ActivityLifecycleTestActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_service:{
                break;
            }
        }
    }
}
