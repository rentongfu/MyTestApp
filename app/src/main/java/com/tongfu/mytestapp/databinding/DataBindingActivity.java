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

    Poet poet = null ;
    Poet2 poet2 = null ;

    ActivityDataBindingBinding dataBindingBinding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBindingBinding = DataBindingUtil.setContentView(this , R.layout.activity_data_binding);
        ButterKnife.bind(this );
        poet = new Poet("曹操" , "安徽亳州" , "65" , "东汉");
        poet2 = new Poet2("陶渊明" , "江西九江" , "62" , "东晋") ;
        dataBindingBinding.setPoet(poet);
        dataBindingBinding.setPoet2(poet2);

    }

    @OnClick(R.id.btn_change)
    public void onClicked(View view){
        Toast.makeText(this, "poets[0]的名字已设置为rentongfu", Toast.LENGTH_SHORT).show();
        poet.setName("rentongfu");//不会刷新对应UIWidget
        poet.getBirthPlace().set("河南辉县");//通过Observable类设置的成员对应的UIWidget可以直接刷新

        poet2.setName("rentongfu"); // 如果ViewModel继承了BaseObservable，并在所有的setter方法中执行了notifyChange()，那么任何改动都会刷新界面。
    }

}
