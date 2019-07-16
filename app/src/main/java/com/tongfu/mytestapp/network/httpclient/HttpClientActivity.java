package com.tongfu.mytestapp.network.httpclient;

/* Android6.0之后HttpClient将不能再继续使用，如果一定要用，需要在build.gradle文件中做如下配置：
 * useLibrary 'org.apache.http.legacy'
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tongfu.mytestapp.R;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HttpClientActivity extends AppCompatActivity {

    @BindView(R.id.et_content)
    EditText etContent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_get, R.id.btn_post})
    public void onClicked(View view){
        switch (view.getId()){
            case R.id.btn_get:{

                break;
            }
            case R.id.btn_post:{
                break;
            }
        }
    }

    private void doGet(){
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        httpGet.addHeader("abc" ,"123" );
        httpGet.setHeader("abc" , "456");

        NameValuePair s = new BasicNameValuePair("" , "" );


        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            try(InputStream inputStream = httpResponse.getEntity().getContent()){
                final String result = IOUtils.toString(inputStream , "UTF-8");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        etContent.setText(result);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doPost(){
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://www.baidu.com");
        httpPost.addHeader("abc" ,"123" );
        httpPost.setHeader("abc" , "456");
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            try(InputStream inputStream = httpResponse.getEntity().getContent()){
                final String result = IOUtils.toString(inputStream , "UTF-8");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        etContent.setText(result);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
