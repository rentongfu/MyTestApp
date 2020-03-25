package com.tongfu.mytestapp.animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.animation.frameanimation.FrameAnimationActivity;
import com.tongfu.mytestapp.animation.propertyanimation.PropertyAnimationActivity;
import com.tongfu.mytestapp.animation.shareelement.ShareElementActivity1;
import com.tongfu.mytestapp.animation.tweenanimation.TweenAnimationActivity;
import com.tongfu.mytestapp.animation.valueanimation.ValueAnimationActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_entry);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_share_element , R.id.btn_frame_animation,R.id.btn_property_animation,R.id.btn_tween_animation,R.id.btn_value_animation})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_share_element:{
                Intent intent = new Intent(this , ShareElementActivity1.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_frame_animation:{
                Intent intent = new Intent(this , FrameAnimationActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_property_animation:{
                Intent intent = new Intent(this , PropertyAnimationActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_tween_animation:{
                Intent intent = new Intent(this , TweenAnimationActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_value_animation:{
                Intent intent = new Intent(this , ValueAnimationActivity.class);
                startActivity(intent);
                break;
            }
        }

    }
}
