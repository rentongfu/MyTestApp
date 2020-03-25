package com.tongfu.mytestapp.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.lifecycle.activity.ActivityLifecycleTestActivity;
import com.tongfu.mytestapp.lifecycle.fragment.FragmentLifecycleActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_activity,R.id.btn_service,R.id.btn_fragment})
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
            case R.id.btn_fragment:{
                Intent intent = new Intent(this, FragmentLifecycleActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
