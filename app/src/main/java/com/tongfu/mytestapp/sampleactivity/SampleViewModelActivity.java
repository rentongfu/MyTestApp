package com.tongfu.mytestapp.sampleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.sampleactivity.ui.sampleviewmodel.SampleViewModelFragment;

public class SampleViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_view_model_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SampleViewModelFragment.newInstance())
                    .commitNow();
        }
    }
}
