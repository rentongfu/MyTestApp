package com.tongfu.mytestapp.ndk.jnicallback;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

public class JniCallbackActivity extends AppCompatActivity {
    int hour = 0 , minute = 0 , second = 0 ;

    static {
        System.loadLibrary("jnicallback");
    }

    TextView tickView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_callback);
        tickView = (TextView) findViewById(R.id.tickView);
    }

    @Override
    public void onResume(){
        super.onResume();
        hour = minute = second = 0;
        ((TextView)findViewById(R.id.hellojniMsg)).setText(stringFromJni());
        startTicks();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopTicks();
    }

    /*
     * A function calling from JNI to update current timer
     */
    @Keep
    private void updateTimer() {
        ++second;
        if(second >= 60) {
            ++minute;
            second -= 60;
            if(minute >= 60) {
                ++hour;
                minute -= 60;
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String ticks = "" + JniCallbackActivity.this.hour + ":" +
                        JniCallbackActivity.this.minute + ":" +
                        JniCallbackActivity.this.second;
                JniCallbackActivity.this.tickView.setText(ticks);
            }
        });
    }

    public native String stringFromJni();
    public native void startTicks();
    public native void stopTicks();

}
