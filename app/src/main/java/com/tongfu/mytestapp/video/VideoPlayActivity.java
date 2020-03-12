package com.tongfu.mytestapp.video;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoPlayActivity extends AppCompatActivity {

    @BindView(R.id.surfaceView)
    SurfaceView surfaceView;

    MediaPlayer mediaPlayer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        ButterKnife.bind(this);
        mediaPlayer = new MediaPlayer();
        try {//sdcard/西部往事BD中英双字[电影天堂www.dy2018.com].mp4
            mediaPlayer.reset();
            File source = new File(getIntent().getStringExtra("url"));
//            File source = new File(Environment.getExternalStorageDirectory() + "/西部往事BD中英双字[电影天堂www.dy2018.com].mp4");
            Log.i("VideoPlay" , source.exists()?"文件存在" :"文件不存在");
            mediaPlayer.setDataSource(new FileInputStream(source).getFD());
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    getSupportActionBar().hide();
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON ,WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );
                    surfaceView.setVisibility(View.VISIBLE);
                    mp.start();
                }
            });
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    Toast.makeText(VideoPlayActivity.this, "播放错误" , Toast.LENGTH_LONG).show();
                    return false;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer.setDisplay(holder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer!= null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );
        super.onDestroy();
    }
}
