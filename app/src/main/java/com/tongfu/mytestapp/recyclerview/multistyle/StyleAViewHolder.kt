package com.tongfu.mytestapp.recyclerview.multistyle

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.tongfu.mytestapp.R
import kotlinx.android.synthetic.main.layout_multi_style_recycler_view_item_a.view.*

class StyleAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.tv_name_a)
    lateinit var tv :TextView
    init{
        ButterKnife.bind(this , itemView )
    }
}