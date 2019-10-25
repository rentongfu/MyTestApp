package com.tongfu.mytestapp.topactivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.tongfu.mytestapp.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopMenuActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_flag_new_task , R.id.btn_show_stack_info})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_flag_new_task:{

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(TopMenuActivity.this , BottomActivity.class);
                        startActivity(intent);
                    }
                } , 4000 );

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(TopMenuActivity.this , TopActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                } , 2000 );
                break;
            }
            case R.id.btn_show_stack_info:{
                ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                List<ActivityManager.RunningTaskInfo> infoList =  activityManager.getRunningTasks(99);
                Log.i("StartModeMenuActivity" , "当前任务数量：" + infoList.size() );
                break;
            }
        }
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        if(TopActivity.topTaskId != 0){
            ActivityManager activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE) ;
            activityManager.moveTaskToFront(TopActivity.topTaskId , ActivityManager.MOVE_TASK_NO_USER_ACTION  );
        }
    }
}
