package com.tongfu.mytestapp.lifecycle.fragment;

import android.animation.Animator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import androidx.fragment.app.Fragment;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.TraceRecorder;
import com.tongfu.mytestapp.lifecycle.activity.ActivityLifecycleDialogActivity;
import com.tongfu.mytestapp.lifecycle.activity.ActivityLifecycleTestActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 */
public class LifecycleTestFragment extends Fragment {
    @OnClick({R.id.btn_start_activity  ,R.id.btn_start_dialog_activity , R.id.btn_show_dialog})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_start_activity:{
                Intent intent = new Intent(requireContext() , ActivityLifecycleTestActivity.class);
                startActivity(intent);
                break;
            }
            case  R.id.btn_start_dialog_activity:{
                Intent intent = new Intent(requireContext() , ActivityLifecycleDialogActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_show_dialog:{
                new AlertDialog.Builder(requireContext()).setMessage("My Message").create().show();
                break;
            }
        }
    }

    public LifecycleTestFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        TraceRecorder.record(this , "onCreate");
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onDestroy() {
        TraceRecorder.record(this , "onDestroy");
        super.onDestroy();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TraceRecorder.record(this , "onCreateView");
        View view = inflater.inflate(R.layout.fragment_lifecycle_test, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        TraceRecorder.record(this , "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onAttach(Context context) {
        TraceRecorder.record(this , "onAttach");
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        TraceRecorder.record(this , "onDetach");
        super.onDetach();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        TraceRecorder.record(this , "onHiddenChanged");
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        TraceRecorder.record(this , "onCreateOptionsMenu");
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        TraceRecorder.record(this , "onPrepareOptionsMenu");
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onDestroyOptionsMenu() {
        TraceRecorder.record(this , "onPrepareOptionsMenu");
        super.onDestroyOptionsMenu();
    }

    @Override
    public void onStart() {
        TraceRecorder.record(this , "onStart");
        super.onStart();
    }

    @Override
    public void onStop() {
        TraceRecorder.record(this , "onStop");
        super.onStop();
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        TraceRecorder.record(this , "onCreateAnimation");
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        TraceRecorder.record(this , "onCreateAnimator");
        return super.onCreateAnimator(transit, enter, nextAnim);
    }

    @Override
    public void onPause() {
        TraceRecorder.record(this , "onPause");
        super.onPause();
    }

    @Override
    public void onResume() {
        TraceRecorder.record(this , "onResume");
        super.onResume();
    }
}
