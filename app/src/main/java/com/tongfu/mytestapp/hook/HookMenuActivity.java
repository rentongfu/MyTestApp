package com.tongfu.mytestapp.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.hook.activitylaunch.InstrumentationProxy;

import java.lang.reflect.Field;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HookMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook_menu);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_hook_activity_launch , R.id.btn_activity_launch})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_hook_activity_launch:{
                hookActivityLaunch();
                break;
            }
            case R.id.btn_activity_launch:{
                Intent intent = new Intent(this , HookMenuActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    private void hookActivityLaunch(){
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.O_MR1){
            try {
                Field instrumentationField = Activity.class.getDeclaredField("mInstrumentation");
                instrumentationField.setAccessible(true);
                Instrumentation instrumentation = (Instrumentation) instrumentationField.get(this);
                InstrumentationProxy instrumentationProxy = new InstrumentationProxy(instrumentation);
                instrumentationField.set(this , instrumentationProxy);
            } catch (Exception e) {
                Toast.makeText(this , "Hook失败", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }else{
            Toast.makeText(this, "Activity Hook目前不支持当前系统版本", Toast.LENGTH_SHORT).show();
        }
    }
}
