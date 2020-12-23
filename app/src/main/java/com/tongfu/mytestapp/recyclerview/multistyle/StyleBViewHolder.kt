package com.tongfu.mytestapp.recyclerview.multistyle

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.tongfu.mytestapp.R

class StyleBViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

  @BindView(R.id.tv_name_b)
  lateinit var tv : TextView
    init{
   ButterKnife.bind(this , itemView )
   tv.text = "RecyclerView Item Style B"
  }
 }