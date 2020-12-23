package com.tongfu.mytestapp.uiwidget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.recyclerview.base.RecyclerViewActivity;
import com.tongfu.mytestapp.recyclerview.multistyle.MultiStyleRecyclerViewActivity;
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

    @OnClick({R.id.btn_other ,R.id.btn_recycler_view,R.id.btn_surface_view,R.id.btn_preference_fragment,
            R.id.btn_multi_style_recycler_view })
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
            case R.id.btn_multi_style_recycler_view:{
                Intent intent = new Intent(this , MultiStyleRecyclerViewActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
