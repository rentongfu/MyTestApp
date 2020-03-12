package com.tongfu.mytestapp.animation.shareelement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;

public class ShareElementActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element2);
        ButterKnife.bind(this);
    }

}
