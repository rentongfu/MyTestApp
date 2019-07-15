package com.tongfu.mytestapp.dagger2.advanceduse2;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tongfu.mytestapp.R;

import javax.inject.Inject;

public class AdvancedUseActivity2 extends AppCompatActivity {

    @Inject
    ActivityManager activityManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_use1);
        DaggerAdvancedUseComponent2.builder().context(getApplicationContext()).build().inject(this);
        if(activityManager == null){
            Toast.makeText(this , "activityManager注入失败" , Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this , "activityManager注入成功" , Toast.LENGTH_SHORT).show();
        }
    }
}
