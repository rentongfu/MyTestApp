package com.tongfu.mytestapp.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.tongfu.mytestapp.MyTestWidgetInterface;

public class MyTestWidgetService extends Service {
    public MyTestWidgetService() {
    }

    private long currentTime ;

    MyTestWidgetInterface.Stub stub = new MyTestWidgetInterface.Stub() {
        @Override
        public long getCurrentTime() throws RemoteException {
            return currentTime;
        }

        @Override
        public void setCurrentTime(long time) throws RemoteException{
            currentTime = time;
        }
    };



    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}
