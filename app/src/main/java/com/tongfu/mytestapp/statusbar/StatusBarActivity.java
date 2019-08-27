package com.tongfu.mytestapp.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class StatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);
        ButterKnife.bind(this);
        getWindow().setBackgroundDrawableResource(R.drawable.sample);
    }

    @OnClick({R.id.btn_flag_fullscreen , R.id.btn_hide_action_bar ,R.id.btn_flag_immersive , R.id.btn_show_action_bar
        , R.id.btn_set_transparent_status_bar , R.id.btn_set_status_bar_font_color1 , R.id.btn_set_status_bar_font_color2
        , R.id.btn_cancel_transparent_status_bar})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_flag_fullscreen:{
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                break;
            }
            case R.id.btn_flag_immersive:{
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_IMMERSIVE);
                break;
            }
            case R.id.btn_set_transparent_status_bar:{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getColor(R.color.colorPrimaryDark));
                }else{
                    Toast.makeText(this , "当前系统不支持设置状态栏透明" , Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case R.id.btn_cancel_transparent_status_bar:{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }else{
                    Toast.makeText(this , "当前系统不支持设置状态栏透明" , Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.btn_hide_action_bar:{
                ActionBar actionBar = getSupportActionBar();
                actionBar.hide();
                break;
            }
            case R.id.btn_show_action_bar:{
                ActionBar actionBar = getSupportActionBar();
                actionBar.show();
                break;
            }
            case R.id.btn_set_status_bar_font_color1:{
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility( decorView.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                break;
            }
            case R.id.btn_set_status_bar_font_color2:{

                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility( decorView.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                break;
            }
        }
    }

    private void  setStatusBarTransparent(final boolean transparent){
        if (Build.VERSION.SDK_INT >= 21) {
            final Window window = getWindow();
            if (transparent) {
                window.getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.setStatusBarColor(Color.TRANSPARENT);


                View decorView = window.getDecorView();
                int uiOptions = decorView.getSystemUiVisibility();
//                decorView.setSystemUiVisibility(uiOptions | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                decorView.setSystemUiVisibility(uiOptions & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            else {
                window.getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_VISIBLE);
            }
        }
    }
}
