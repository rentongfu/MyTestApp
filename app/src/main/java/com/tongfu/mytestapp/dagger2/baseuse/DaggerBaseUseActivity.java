package com.tongfu.mytestapp.dagger2.baseuse;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaggerBaseUseActivity extends AppCompatActivity {
    @Inject
    ClassA objectA ;
    @Inject
    ClassB objectB ;

    @BindView(R.id.tv_content)
    TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_base_use);
        ButterKnife.bind(this);
        DaggerBaseUseComponent.builder().build().inject(this);
        tv.setText((objectA==null ? "" : objectA.toString()) + (objectB==null ? "" : objectB.toString()));
    }
}
