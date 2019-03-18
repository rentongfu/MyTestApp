package com.tongfu.mytestapp.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.animation.shareelement.ShareElementActivity1;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_entry);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_share_element)
    public void onBtnShareElementClicked(){
        Intent intent = new Intent(this , ShareElementActivity1.class);
        startActivity(intent);
    }
}
