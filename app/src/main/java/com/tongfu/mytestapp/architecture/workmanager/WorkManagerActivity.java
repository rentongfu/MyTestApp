package com.tongfu.mytestapp.architecture.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.widget.TextView;

import com.tongfu.mytestapp.R;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.work.WorkInfo.State.BLOCKED;

public class WorkManagerActivity extends AppCompatActivity {
    @BindView(R.id.tv_status)
    TextView tvStatus ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);
        ButterKnife.bind(this);
        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true) // 设置任务执行条件：充电
                .setRequiredNetworkType(NetworkType.CONNECTED) //设置任务执行条件：网络
                .build();
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(UploadWorker.class).setConstraints(constraints).build();
        WorkManager.getInstance(this).enqueue(request);
        tvStatus.setText("创建任务：" + new Date().toString());
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                WorkInfo.State state = workInfo.getState();
                switch (state){
                    case BLOCKED:
                        tvStatus.setText(tvStatus.getText() + "\n" + "BLOCKED " + new Date().toString());
                        break;
                    case FAILED:
                        tvStatus.setText(tvStatus.getText() + "\n" + "FAILED " + new Date().toString());
                        break;
                    case SUCCEEDED:
                        tvStatus.setText(tvStatus.getText() + "\n" + "SUCCEEDED " + new Date().toString());
                        break;
                    case RUNNING:
                        tvStatus.setText(tvStatus.getText() + "\n" + "RUNNING " + new Date().toString());
                        break;
                    case ENQUEUED:
                        tvStatus.setText(tvStatus.getText() + "\n" + "ENQUEUED " + new Date().toString());
                        break;
                    case CANCELLED:
                        tvStatus.setText(tvStatus.getText() + "\n" + "CANCELLED " + new Date().toString());
                        break;
                }

            }
        });
    }
}
