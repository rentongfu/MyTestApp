package com.tongfu.mytestapp.managerservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ManagerServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_service);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_location_manager})
    public void onClicked(View view){
        switch (view.getId()){
            case R.id.btn_location_manager:{
                Intent intent = new Intent(this , LocationManagerActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
