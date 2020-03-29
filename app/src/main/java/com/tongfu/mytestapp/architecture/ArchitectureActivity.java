package com.tongfu.mytestapp.architecture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import com.j256.ormlite.stmt.query.In;
import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.architecture.lifecycle.LifecycleActivity;
import com.tongfu.mytestapp.architecture.paging.PagingActivity;
import com.tongfu.mytestapp.architecture.viewmodel.ViewModelActivity;
import com.tongfu.mytestapp.architecture.workmanager.WorkManagerActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ArchitectureActivity extends AppCompatActivity implements LifecycleOwner {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_lifecycle , R.id.btn_view_model , R.id.btn_paging , R.id.btn_work_manager})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_lifecycle:{
                Intent intent = new Intent(this , LifecycleActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_view_model:{
                Intent intent = new Intent(this , ViewModelActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_paging:{
                Intent intent = new Intent(this , PagingActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_work_manager:{
                Intent intent = new Intent(this , WorkManagerActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
