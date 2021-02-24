package com.tongfu.mytestapp.ndk.jnicall;

import android.util.Log;

public class TestBean {
    public int a = 1066 ;

    public void sayHello(int i){
        Log.i("TestBean" , "Hello, This is me " + i + " !");
    }
    public static void sayHi(){
        Log.i("TestBean" , "Hi, This is me!");
    }
}
