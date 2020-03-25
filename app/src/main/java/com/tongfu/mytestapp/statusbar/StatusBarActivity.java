package com.tongfu.mytestapp.statusbar;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class StatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_status_bar);
        ButterKnife.bind(this);
        getWindow().setBackgroundDrawableResource(R.drawable.sample);
    }

    @OnClick({R.id.btn_flag_fullscreen , R.id.btn_hide_action_bar ,R.id.btn_flag_immersive , R.id.btn_show_action_bar
        , R.id.btn_set_transparent_status_bar , R.id.btn_set_status_bar_font_color1 , R.id.btn_set_status_bar_font_color2
        , R.id.btn_cancel_transparent_status_bar , R.id.btn_flag_layout_fullscreen ,R.id.btn_flag_immersive_sticky
        , R.id.btn_flag_low_profile , R.id.btn_flag_layout_stable , R.id.btn_flag_hide_navigation ,R.id.btn_flag_layout_hide_navigation
        , R.id.btn_cancel_flag_fullscreen})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_flag_fullscreen:{
                //全屏效果，不显示状态栏
                View decorView = getWindow().getDecorView();
                findViewById(R.id.btn_flag_fullscreen).setSystemUiVisibility( decorView.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_FULLSCREEN);
                break;
            }
            case R.id.btn_cancel_flag_fullscreen:{

                View decorView = getWindow().getDecorView();
                findViewById(R.id.btn_flag_fullscreen).setSystemUiVisibility( decorView.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_FULLSCREEN);
                break;
            }
            case R.id.btn_flag_layout_fullscreen:{
                //
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                break;
            }
            case R.id.btn_flag_immersive:{
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_IMMERSIVE);
                break;
            }
            case R.id.btn_flag_immersive_sticky:{
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                break;
            }
            case R.id.btn_flag_low_profile:{
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_LOW_PROFILE);
                break;
            }
            case R.id.btn_flag_layout_stable:{
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                break;
            }
            case R.id.btn_flag_hide_navigation:{
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                break;
            }
            case R.id.btn_flag_layout_hide_navigation:{
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                break;
            }

            case R.id.btn_set_transparent_status_bar:{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }else{
                    Toast.makeText(this , "当前系统不支持设置状态栏透明" , Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case R.id.btn_cancel_transparent_status_bar:{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark , getTheme()));
                    }else{
                        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                    }
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
                Resources.Theme theme = null ;
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
