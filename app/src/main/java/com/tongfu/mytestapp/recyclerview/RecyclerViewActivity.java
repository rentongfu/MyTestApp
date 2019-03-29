package com.tongfu.mytestapp.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView rv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        initCom();
    }

    private void initCom() {
        RecyclerView.Adapter<VH> adapter = new MyRecyclerViewAdapter(this);
        rv.setAdapter(adapter);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        GridLayoutManager manager = new GridLayoutManager(this , 2);



        rv.setLayoutManager(manager);
    }
}
