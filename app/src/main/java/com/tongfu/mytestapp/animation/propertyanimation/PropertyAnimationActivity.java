package com.tongfu.mytestapp.animation.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PropertyAnimationActivity extends AppCompatActivity {
    @BindView(R.id.btn_start)
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_start)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_start:{
                Animator animator = AnimatorInflater.loadAnimator(this , R.animator.animator01);
                animator.setTarget(btnStart);
                animator.start();
            }
        }
    }
}
