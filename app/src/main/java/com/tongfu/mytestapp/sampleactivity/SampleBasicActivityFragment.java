package com.tongfu.mytestapp.sampleactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.tongfu.mytestapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SampleBasicActivityFragment extends Fragment {

    public SampleBasicActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample_basic, container, false);
    }
}
