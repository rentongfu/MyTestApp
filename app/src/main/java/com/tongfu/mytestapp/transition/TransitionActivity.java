package com.tongfu.mytestapp.transition;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Scene;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;
import androidx.transition.TransitionManager;

import com.tongfu.mytestapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_show_image)
    public void onClick(){
        ViewGroup rootView  = findViewById(R.id.cl_root);
        Scene scene = Scene.getSceneForLayout(rootView ,R.layout.layout_transition_scene_one , this);
//        Transition transition = new AutoTransition();
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.test_transition);
        TransitionManager.go(scene , transition);
    }
}
