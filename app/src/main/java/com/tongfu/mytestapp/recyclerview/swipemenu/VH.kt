package com.tongfu.mytestapp.recyclerview.swipemenu

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.tongfu.mytestapp.R

internal class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.tv_name_a)
    lateinit var tv :TextView
    init{
        ButterKnife.bind(this , itemView )
    }
}