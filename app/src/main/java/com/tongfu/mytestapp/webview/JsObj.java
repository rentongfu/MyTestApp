package com.tongfu.mytestapp.webview;


import android.os.Build;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class JsObj {
    @JavascriptInterface
    public void showLog(String str){
        Log.i("WebView" , str) ;
    }

    @JavascriptInterface
    public int getSDKVersion(){
        return Build.VERSION.SDK_INT ;
    }
}
