package com.tongfu.mytestapp;

import android.util.Log;

public class TraceRecorder {
    private static final boolean recordTrace = true ;
    public static void record(Class clazz , String methodName ){
        if(recordTrace) {
            Log.d("TraceRecord", clazz.getName() + "." + methodName + " run on Thread " + Thread.currentThread().getName());
//            Thread currentThread = Thread.currentThread() ;
//            StackTraceElement[] stackTraceElements =  currentThread.getStackTrace() ;
//            StackTraceElement stackTraceElement = stackTraceElements[3] ;
//            Log.d("TraceRecord", stackTraceElement.toString() );
        }

    }

    public static void record(Object object , String methodName ){
        if(recordTrace) {
            Log.d("TraceRecord", object.toString() + "." + methodName + " run on Thread " + Thread.currentThread().getName());
//            Thread currentThread = Thread.currentThread() ;
//            StackTraceElement[] stackTraceElements =  currentThread.getStackTrace() ;
//            StackTraceElement stackTraceElement = stackTraceElements[3] ;
//            Log.d("TraceRecord", stackTraceElement.toString() );
        }

    }
}
