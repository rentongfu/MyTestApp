package com.tongfu.mytestapp.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tongfu.mytestapp.R;

import javax.inject.Inject;

public class Dagger2TestActivity extends AppCompatActivity {

    @Inject
    Dagger2TestFragment dagger2TestFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2_test);
        DaggerMyComponent.builder().build().inject(this);
        if(dagger2TestFragment == null){
            Log.i("Dagger2TestActivity" , "dagger2TestFragment是null");
        }else{
            Log.i("Dagger2TestActivity" , "dagger2TestFragment不是null");
            getSupportFragmentManager().beginTransaction().add(R.id.fl_container, dagger2TestFragment , "dagger").commit();
        }
    }
}
