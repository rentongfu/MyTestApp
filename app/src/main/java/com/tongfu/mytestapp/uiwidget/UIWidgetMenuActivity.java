package com.tongfu.mytestapp.uiwidget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.recyclerview.RecyclerViewActivity;
import com.tongfu.mytestapp.uiwidget.preferenceactivity.PreferenceFragmentTestActivity;
import com.tongfu.mytestapp.uiwidget.surfaceview.SurfaceViewActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class UIWidgetMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiwidget_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_other ,R.id.btn_recycler_view,R.id.btn_surface_view,R.id.btn_preference_fragment})
    public void onClicked(View view){
        switch (view.getId()){
            case R.id.btn_other:{
                Intent intent = new Intent(this , UIWidgetActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_recycler_view:{
                Intent intent = new Intent(this , RecyclerViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_surface_view:{
                Intent intent = new Intent(this, SurfaceViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_preference_fragment:{
                Intent intent = new Intent(this, PreferenceFragmentTestActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
