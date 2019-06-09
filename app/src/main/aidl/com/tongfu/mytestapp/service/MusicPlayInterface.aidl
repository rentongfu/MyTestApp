// MusicPlayInterface.aidl
package com.tongfu.mytestapp.service;

// Declare any non-default types here with import statements

interface MusicPlayInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

     void start();
     void pause() ;
     void resume();
     void stop();
     int getPlayState();

     void setForeground(boolean isForeground);
}
