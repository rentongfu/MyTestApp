package com.tongfu.mytestapp.ndk.hellogl2;

public class GL2JniLib {
    static {
        System.loadLibrary("native-lib");//这里必须加载包含了native方法实现的so。
//        System.loadLibrary("");
    }
    public static native void init(int width , int height);
    public static native void step();
}
