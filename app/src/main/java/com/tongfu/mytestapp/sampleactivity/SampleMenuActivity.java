package com.tongfu.mytestapp.sampleactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.sampleactivity.ui.login.SampleLoginActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SampleMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_basic_activity,R.id.btn_bottom_navigation_activity,R.id.btn_empty_activity,
            R.id.btn_view_model_activity,R.id.btn_fullscreen_activity,R.id.btn_google_admob_activity,
        R.id.btn_map_activity ,R.id.btn_login_activity , R.id.btn_master_detail_flow_activity,
        R.id.btn_navigation_drawer_activity,R.id.btn_scroll_activity,R.id.btn_tabbed_activity})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_basic_activity:{
                Intent intent = new Intent(this , SampleBasicActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_bottom_navigation_activity:{
                Intent intent = new Intent(this , SampleBottomNavigationActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_empty_activity:{
                Intent intent = new Intent(this , SampleEmptyActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_view_model_activity:{
                Intent intent = new Intent(this , SampleEmptyActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_fullscreen_activity:{
                Intent intent = new Intent(this , SampleFullscreenActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_google_admob_activity:{
                Toast.makeText(this , "功能冲突，已删除" , Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(this , SampleAdMobActivity.class);
//                startActivity(intent);
                break;
            }
            case R.id.btn_map_activity:{
                Toast.makeText(this , "功能冲突，已删除" , Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(this , SampleMapsActivity.class);
//                startActivity(intent);
                break;
            }
            case R.id.btn_login_activity:{
                Intent intent = new Intent(this , SampleLoginActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_master_detail_flow_activity:{
                Intent intent = new Intent(this , SampleItemDetailActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_navigation_drawer_activity:{
                Intent intent = new Intent(this , SampleNavigationDrawerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_scroll_activity:{
                Intent intent = new Intent(this , SampleScrollingActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_tabbed_activity:{
                Intent intent = new Intent(this , SampleTabActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
