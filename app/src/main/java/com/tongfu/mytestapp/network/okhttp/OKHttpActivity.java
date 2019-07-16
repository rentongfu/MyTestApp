package com.tongfu.mytestapp.network.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tongfu.mytestapp.R;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpActivity extends AppCompatActivity {
    @BindView(R.id.et_content)
    EditText etContent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        setTitle("OKHttp");
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_get, R.id.btn_post})
    public void onClicked(View view){
        switch (view.getId()){
            case R.id.btn_get:{
                doGet();
                break;
            }
            case R.id.btn_post:{
                doPost();
                break;
            }
        }
    }

    /**
     * 异步Get请求
     */
    private void doGet(){
        OkHttpClient okHttpClient = new OkHttpClient();

        Request.Builder builder = new Request.Builder().url("http://www.baidu.com").addHeader("abc" , "123").get();
        Request request = builder.build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(OKHttpActivity.this , e.getMessage() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                etContent.setText(result);
            }
        });
    }

    private void doPost(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder().url("http://blog.rentongfu.com").addHeader("abc" , "123").get();
        /*
         * 三种创建RequestBody的方法：
         * FormBody.Builder
         * MultiPart.Builder
         * RequestBody.create(MediaType.parse("File/*") , file )
         */
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        formBodyBuilder.add("abc" , "123").add("def" , "456") ;
        Request request = builder.post(formBodyBuilder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(OKHttpActivity.this , e.getMessage() , Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                etContent.setText(result);
            }
        });
    }
}
