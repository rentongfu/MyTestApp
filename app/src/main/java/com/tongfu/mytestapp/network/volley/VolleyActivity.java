package com.tongfu.mytestapp.network.volley;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VolleyActivity extends AppCompatActivity {
    @BindView(R.id.et_content)
    EditText etContent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        ButterKnife.bind(this);
        setTitle("Volley");
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

    private void doPost() {

    }

    private void doGet() {

    }
}
