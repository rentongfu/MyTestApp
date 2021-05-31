package com.tongfu.mytestapp.camera.camerax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tongfu.mytestapp.R
import androidx.camera.lifecycle.ProcessCameraProvider
import java.util.concurrent.Executors

class CameraXActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_x)
        val future = ProcessCameraProvider.getInstance(this)
        future.addListener(Runnable {
            val pro = future.get()
        }, Executors.newSingleThreadExecutor() )
    }
}