package com.tongfu.mytestapp.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tongfu.mytestapp.R
import kotlinx.coroutines.*

class CoroutineActivity : AppCompatActivity() {
    lateinit var mainScope :CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        mainScope  = MainScope()
        GlobalScope.launch {
            val def = async { getNumber() }
            val num = def.await()
            val job = mainScope.launch {
                Toast.makeText(this@CoroutineActivity , "delay has completed. $num",Toast.LENGTH_SHORT).show()
                Log.i("CoroutineActivity" , "Toast success")
            }
            Log.i("CoroutineActivity" , "Before Join")
            job.join()
            Log.i("CoroutineActivity" , "After Join")
        }
    }

    private suspend fun getNumber(): Int {
        delay(3000)
        return 1
    }

    override fun onDestroy() {
        mainScope.cancel()
        super.onDestroy()
    }
}