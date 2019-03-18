package com.tongfu.mytestapp.imageload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PicassoActivity extends AppCompatActivity {

    @BindView(R.id.iv_image)
    ImageView iv_image ;
    @BindView(R.id.et_url)
    EditText etUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_load)
    void onBtnLoadClicked(){
        String url = etUrl.getText().toString();
        if(url==null|| url.length() == 0){
            Toast.makeText(this, "输入url为空" , Toast.LENGTH_SHORT).show();
            return;
        }
        Picasso.with(this).load(url).placeholder(R.drawable.ic_blank).error(R.drawable.ic_error).into(iv_image);
    }
}
