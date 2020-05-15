package com.tongfu.mytestapp.ndk.performance

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.R

class NdkPerformanceCompareActivity : AppCompatActivity() {
    companion object {
        init{
            System.loadLibrary("native-lib")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ndk_performance_compare)
        ButterKnife.bind(this)
    }

    public fun compute(){
        val startTime = System.currentTimeMillis()
        var result :Long = 0
        for(i in 1 .. 2147483647){
            if(i%5 != 0)
                result+=i;
            else
                result-=i;
        }
        Log.i("NDK" , "结果：${result}。Java执行耗时：${System.currentTimeMillis() - startTime}")
    }

    @OnClick(R.id.btn_jni_execute,R.id.btn_java_execute)
    public fun onClick(view:View){
        when(view.id){
            R.id.btn_java_execute->{
                compute()
            }
            R.id.btn_jni_execute->{
                executeJni(2147483647)
            }
        }
    }

    public external fun executeJni(value:Int)
}
