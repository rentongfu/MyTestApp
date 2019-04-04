package com.tongfu.mytestapp.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tongfu.mytestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

final class VH extends RecyclerView.ViewHolder  {
    @BindView(R.id.tv_name)
    public TextView tvName ;

    public VH(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this , itemView);
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
