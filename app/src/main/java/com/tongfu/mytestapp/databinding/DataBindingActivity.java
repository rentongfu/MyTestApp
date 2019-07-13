package com.tongfu.mytestapp.databinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tongfu.mytestapp.R;

public class DataBindingActivity extends AppCompatActivity {

    Poet[] poets = null ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);
        poets = new Poet[4] ;
        poets[0] = new Poet("曹操" , "安徽亳州" , 65 , "东汉");
        poets[1] = new Poet("陶渊明" , "江西九江" , 62 , "东晋");
        poets[2] = new Poet("李白"  , "绵阳江油" , 61 , "唐");
        poets[3] = new Poet("杜甫" , "湖北襄阳" , 58 , "唐");

    }
}
