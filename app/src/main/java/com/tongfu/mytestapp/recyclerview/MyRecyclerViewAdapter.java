package com.tongfu.mytestapp.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tongfu.mytestapp.R;

final class MyRecyclerViewAdapter extends RecyclerView.Adapter<VH>{

    private Context mContext ;
    public MyRecyclerViewAdapter(Context context){
        mContext = context ;
    }

    int count = 0 ;
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_recycler_view_item , viewGroup, false);
        VH vh = new VH(v);
        vh.tvName.setText("Pic" + ++count  + ":"  + vh);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH viewHolder, int i) {
//        viewHolder.tvName.setText("Pic:" +  viewHolder);
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}