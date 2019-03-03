package com.tongfu.mytestapp.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyStaticReceiver extends BroadcastReceiver {
    public static final String action = "com.tongfu.mytestapp.broadcastreceiver.MyStaticReceiver" ;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        Log.i("MyStaticReceiver" , "静态接收器收到广播" );
        Toast.makeText(context ,"静态接收器收到广播" , Toast.LENGTH_SHORT ).show();
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
