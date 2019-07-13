package com.tongfu.ndkbuildsample;

public class NdkBuildJniUtil {
    static {
        System.loadLibrary("ndkbuildsample");
    }
    public native static void printHelloWorld();
}
