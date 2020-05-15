package com.tongfu.mytestapp.wmstest;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WMSTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wmstest);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_create_window)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_create_window:{
//                Class phoneWindowClass =  Class.forName("com.android.internal.policy.PhoneWindow");
//                Constructor phoneContructor = phoneWindowClass.getDeclaredConstructor(Context.class);
//                Object phoneWindow =  phoneContructor.newInstance(this);
//                break;
            }
        }
    }
}
