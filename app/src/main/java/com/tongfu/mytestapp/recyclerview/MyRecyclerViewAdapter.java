package com.tongfu.mytestapp.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tongfu.mytestapp.R;

final class MyRecyclerViewAdapter extends RecyclerView.Adapter<VH>{

    private Context mContext ;
    public MyRecyclerViewAdapter(Context context){
        mContext = context ;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_recycler_view_item , viewGroup, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH viewHolder, int i) {
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}