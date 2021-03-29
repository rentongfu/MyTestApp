package com.tongfu.mytestapp.video

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.tongfu.mytestapp.R
import tv.danmaku.ijk.media.player.IjkMediaPlayer
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class IjkVideoPlayActivity : AppCompatActivity() {


    @BindView(R.id.surfaceView)
    var surfaceView: SurfaceView? = null

    var mediaPlayer: IjkMediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ijk_video_play)
        ButterKnife.bind(this)
        mediaPlayer = IjkMediaPlayer()
        try { //sdcard/西部往事BD中英双字[电影天堂www.dy2018.com].mp4
            mediaPlayer!!.reset()
            val source = File(intent.getStringExtra("url"))
            //            File source = new File(Environment.getExternalStorageDirectory() + "/西部往事BD中英双字[电影天堂www.dy2018.com].mp4");
            Log.i("VideoPlay", if (source.exists()) "文件存在" else "文件不存在")
            mediaPlayer!!.setDataSource(FileInputStream(source).fd)
            mediaPlayer!!.prepareAsync()
            mediaPlayer!!.setOnPreparedListener { mp ->
                supportActionBar!!.hide()
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
                window.setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
                surfaceView!!.visibility = View.VISIBLE
                mp.start()
            }
            mediaPlayer!!.setOnErrorListener { mp, what, extra ->
                Toast.makeText(this@IjkVideoPlayActivity, "播放错误", Toast.LENGTH_LONG).show()
                false
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        surfaceView!!.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                mediaPlayer!!.setDisplay(holder)
            }

            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}
            override fun surfaceDestroyed(holder: SurfaceHolder) {}
        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
        }
        this.window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
        this.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        super.onDestroy()
    }
}