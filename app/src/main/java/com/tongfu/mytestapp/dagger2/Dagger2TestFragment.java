package com.tongfu.mytestapp.dagger2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tongfu.mytestapp.R;

import javax.inject.Inject;

public class Dagger2TestFragment extends Fragment {

    @Inject
    public Dagger2TestFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FrameLayout fl = new FrameLayout(requireContext());
        fl.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        fl.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark ));
        return fl;
    }
}
