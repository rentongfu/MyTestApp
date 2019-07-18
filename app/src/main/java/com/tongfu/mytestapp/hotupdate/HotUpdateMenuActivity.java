package com.tongfu.mytestapp.hotupdate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.hotupdate.classloader.HotUpdateClassLoaderActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HotUpdateMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_update_menu);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_class_loader})
    public void onClick(View view){
        Intent intent = new Intent(this , HotUpdateClassLoaderActivity.class);
        startActivity(intent);
    }
}
