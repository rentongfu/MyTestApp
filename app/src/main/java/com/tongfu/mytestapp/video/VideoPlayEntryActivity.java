package com.tongfu.mytestapp.video;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.tongfu.mytestapp.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoPlayEntryActivity extends AppCompatActivity {

    @BindView(R.id.et_url)
    EditText etUrl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play_entry);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_play)
    public void onClick(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE} , 1 );
            }else{
                checkAndToPlayActivity();
            }
        }else {
            checkAndToPlayActivity();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                checkAndToPlayActivity();
            }
        }
    }

    void checkAndToPlayActivity(){
        if(etUrl.getText().length() == 0){
            Toast.makeText(this , "请输入视频文件路径" ,Toast.LENGTH_SHORT).show();
            return ;
        }
        String url = etUrl.getText().toString();
        File file = new File(url);
        if(!file.exists()){
            Toast.makeText(this , "视频文件不存在" ,Toast.LENGTH_SHORT).show();
            return ;
        }
        Intent intent = new Intent(this , VideoPlayActivity.class);
        intent.putExtra("url" , url );
        startActivity(intent);
    }
}
