package com.tongfu.mytestapp.databinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DataBindingActivity extends AppCompatActivity {

    Poet[] poets = null ;

    ActivityDataBindingBinding dataBindingBinding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBindingBinding = DataBindingUtil.setContentView(this , R.layout.activity_data_binding);
        ButterKnife.bind(this );
        poets = new Poet[4] ;
        poets[0] = new Poet("曹操" , "安徽亳州" , "65" , "东汉");
        poets[1] = new Poet("陶渊明" , "江西九江" , "62" , "东晋");
        poets[2] = new Poet("李白"  , "绵阳江油" , "61" , "唐");
        poets[3] = new Poet("杜甫" , "湖北襄阳" , "58" , "唐");
        dataBindingBinding.setPoet(poets[0]);

    }

    @OnClick(R.id.btn_change)
    public void onClicked(View view){
        Toast.makeText(this, "poets[0]的名字已设置为rentongfu", Toast.LENGTH_SHORT).show();
        poets[0].setName("rentongfu");//不会刷新对应UIWidget
        poets[0].getBirthPlace().set("河南辉县");//通过Observable类设置的成员对应的UIWidget可以直接刷新
    }

}
