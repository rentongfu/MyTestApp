package com.tongfu.mytestapp.ndk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.ndk.hellogl2.HelloGL2Activity;
import com.tongfu.mytestapp.ndk.jnicallback.JniCallbackActivity;
import com.tongfu.mytestapp.ndk.nativeactivity.MyNativeActivity;
import com.tongfu.mytestapp.ndk.performance.NdkPerformanceCompareActivity;
import com.tongfu.ndkbuildsample.NdkBuildJniUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NdkMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk_menu);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_hello_jni , R.id.btn_hello_gl2 ,R.id.btn_jni_callback,R.id.btn_native_activity,R.id.btn_ndk_build,R.id.btn_jni_performance})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_hello_jni:{
                Intent intent = new Intent(this , HelloJniActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_hello_gl2:{
                Intent intent = new Intent(this , HelloGL2Activity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_jni_callback:{
                Intent intent = new Intent(this , JniCallbackActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_native_activity: {
                Intent intent = new Intent(this, MyNativeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_ndk_build:{
                NdkBuildJniUtil.printHelloWorld();
                break;
            }
            case R.id.btn_jni_performance:{
                startActivity(new Intent(this , NdkPerformanceCompareActivity.class));
                break;
            }
        }
    }
}
