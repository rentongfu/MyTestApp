package com.tongfu.mytestapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ClassLoaderTest {
    @Test
    public void printClassLoader(){
        Log.i("ClassLoadertTest" , "---------------");
        Context appContext = InstrumentationRegistry.getTargetContext();
        ClassLoader classLoader = appContext.getClassLoader();
        do {
            Log.i("ClassLoadertTest" , classLoader.toString());
            classLoader = classLoader.getParent();
        }while (classLoader!=null);
    }
}
