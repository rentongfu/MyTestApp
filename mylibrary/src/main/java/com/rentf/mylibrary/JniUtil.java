package com.rentf.mylibrary;

public class JniUtil {
    static {
        System.loadLibrary("native-lib");//这里必须加载包含了native方法实现的so。
    }
    public native String getString();
}
