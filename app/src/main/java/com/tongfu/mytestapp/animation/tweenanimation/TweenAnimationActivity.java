package com.tongfu.mytestapp.animation.tweenanimation;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TweenAnimationActivity extends AppCompatActivity {
@BindView(R.id.iv)
    ImageView iv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        ButterKnife.bind(this);
        iv.setAnimation(AnimationUtils.loadAnimation(this , R.anim.fanzhuan));
        iv.getAnimation().start();
    }


}
