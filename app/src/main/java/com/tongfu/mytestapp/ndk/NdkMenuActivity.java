package com.tongfu.mytestapp.ndk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.ndk.hellogl2.HelloGL2Activity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NdkMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk_menu);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_hello_jni , R.id.btn_hello_gl2})
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
        }
    }
}
