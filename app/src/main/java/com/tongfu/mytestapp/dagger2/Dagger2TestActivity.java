package com.tongfu.mytestapp.dagger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.dagger2.advanceduse1.AdvancedUseActivity1;
import com.tongfu.mytestapp.dagger2.advanceduse2.AdvancedUseActivity2;
import com.tongfu.mytestapp.dagger2.baseuse.DaggerBaseUseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Dagger2TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2_test);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_base_use , R.id.btn_advance_use1,R.id.btn_advance_use2})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_base_use:{
                Intent intent = new Intent(this , DaggerBaseUseActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_advance_use1:{
                Intent intent = new Intent(this , AdvancedUseActivity1.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_advance_use2:{
                Intent intent = new Intent(this , AdvancedUseActivity2.class);
                startActivity(intent);
                break;
            }
        }
    }
}
