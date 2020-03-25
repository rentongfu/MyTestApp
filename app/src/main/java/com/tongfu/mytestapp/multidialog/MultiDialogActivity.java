package com.tongfu.mytestapp.multidialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MultiDialogActivity extends AppCompatActivity {

    @BindView(R.id.btn_show_dialog)
    Button btnShowDialog;

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_dialog);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_show_dialog)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_show_dialog:{
                Dialog firstDialog = new AlertDialog.Builder(this ).setMessage("第一个对话框").create();
                Dialog secondDialog = new AlertDialog.Builder(this ).setMessage("第二个对话框").create();
                firstDialog.show();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        secondDialog.show();
                    }
                } , 300 ) ;
                break;
            }
        }
    }
}
