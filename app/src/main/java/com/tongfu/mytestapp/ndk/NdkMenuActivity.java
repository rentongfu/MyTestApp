package com.tongfu.mytestapp.ndk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NdkMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk_menu);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_hello_jni)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_hello_jni:{
                Intent intent = new Intent(this , HelloJniActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
