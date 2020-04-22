package com.tongfu.mytestapp.architecture.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewModelActivity extends AppCompatActivity {
    MyViewModel myViewModel = null ;
    @BindView(R.id.tv_name)
    TextView tvName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        ButterKnife.bind(this);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        myViewModel.getName();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myViewModel.getName().observe(ViewModelActivity.this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Log.i("ViewModelActivity" , s);
                        tvName.setText("当前名字：" + s);
                    }
                });
            }
        }, 1000);


    }
}
