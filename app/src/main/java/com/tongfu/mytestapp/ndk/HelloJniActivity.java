package com.tongfu.mytestapp.ndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.rentf.mylibrary.JniUtil;
import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HelloJniActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_jni);
        ButterKnife.bind(this);
        textView.setText(new JniUtil().getString());
    }
}
