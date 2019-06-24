package com.tongfu.mytestapp.animation.frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FrameAnimationActivity extends AppCompatActivity {
    @BindView(R.id.imageView2)
    ImageView frameAnimationView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        ButterKnife.bind(this);
        AnimationDrawable rocketAnimation = (AnimationDrawable)  frameAnimationView.getDrawable();
        rocketAnimation.start();
    }
}
