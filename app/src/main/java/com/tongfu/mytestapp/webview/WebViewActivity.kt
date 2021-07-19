package com.tongfu.mytestapp.webview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.tongfu.mytestapp.R

class WebViewActivity : AppCompatActivity() {



    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        WebView.setWebContentsDebuggingEnabled(true)
        val webView = findViewById<WebView>(R.id.web_view)
        webView.settings.javaScriptEnabled = true //一定要开启JavaScript
        webView.loadUrl("file:///android_asset/test.html")
        webView.addJavascriptInterface(JsObj() , "nativeObj")
    }
}