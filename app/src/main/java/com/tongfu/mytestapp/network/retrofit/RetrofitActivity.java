package com.tongfu.mytestapp.network.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tongfu.mytestapp.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    @BindView(R.id.et_content)
    EditText etContent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        setTitle("Retrofit");
    }

    @OnClick({R.id.btn_get, R.id.btn_post , R.id.btn_weather})
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
            case R.id.btn_weather:{
                getWeather();
                break;
            }
        }
    }

    private void doPost() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://blog.rentongfu.com/").addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        retrofitApi.postHomePage(2 , "123" , "345").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String result = response.body().string();
                    etContent.setText(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void doGet() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://blog.rentongfu.com/").build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        retrofitApi.getHomePage(2 , "123").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String result = response.body().string();
                    etContent.setText(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getWeather(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://blog.rentongfu.com/").addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        retrofitApi.getRetrofitBean("101010100").enqueue(new Callback<MyResponseData>() {
            @Override
            public void onResponse(Call<MyResponseData> call, Response<MyResponseData> response) {
                MyResponseData myResponseData = response.body();
                Log.i("Retrofit" , response.message());
                etContent.setText("城市：" + myResponseData.getWeatherinfo().getCity() + "，城市编号：" + myResponseData.getWeatherinfo().getCityid() + "，天气：" + myResponseData.getWeatherinfo().getWeather());
            }

            @Override
            public void onFailure(Call<MyResponseData> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getWeather2(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://blog.rentongfu.com/").addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new MyCallAdapter.Fcatory()).build();
    }
}
