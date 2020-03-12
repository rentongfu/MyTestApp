package com.tongfu.mytestapp.network;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.network.httpclient.HttpClientActivity;
import com.tongfu.mytestapp.network.httpurlconnection.HttpUrlConnectionActivity;
import com.tongfu.mytestapp.network.okhttp.OKHttpActivity;
import com.tongfu.mytestapp.network.retrofit.RetrofitActivity;
import com.tongfu.mytestapp.network.volley.VolleyActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_httpclient , R.id.btn_httpurlconnection , R.id.btn_volley ,R.id.btn_okhttp , R.id.btn_retrofit })
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_httpclient:{
                Intent intent = new Intent(this , HttpClientActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_httpurlconnection:{
                Intent intent = new Intent(this , HttpUrlConnectionActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_volley:{
                Intent intent = new Intent(this , VolleyActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_okhttp:{
                Intent intent = new Intent(this , OKHttpActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_retrofit:{
                Intent intent = new Intent(this , RetrofitActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
