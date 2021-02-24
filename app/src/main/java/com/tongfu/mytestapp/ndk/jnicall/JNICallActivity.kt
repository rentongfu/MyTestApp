package com.tongfu.mytestapp.ndk.jnicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tongfu.mytestapp.MyApplication
import com.tongfu.mytestapp.R

class JNICallActivity : AppCompatActivity() {
    companion object{
        init {
            System.loadLibrary("native_call")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_j_n_i_call)
    }

//    external fun native_receive_basic(integer:Int , boolean:Boolean , float:Float)
//    external fun native_receive_object(testBean:TestBean)
    external fun native_call_static_method()
    external fun native_call_object_method(testBean: TestBean)
//    external fun native_access_static_variable()
//    external fun native_access_object_variable()
//    external fun native_initalize_object()
//    external fun native_return_basic():Int
//    external fun native_return_Object():TestBean
}