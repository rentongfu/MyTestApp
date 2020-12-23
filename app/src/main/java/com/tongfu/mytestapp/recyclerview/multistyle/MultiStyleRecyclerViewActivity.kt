package com.tongfu.mytestapp.recyclerview.multistyle

/**
 * 可现实多种布局的RecyclerView
 *
 * 关键内容：
 *      RecyclerView.Adapter的onCreateViewHolder方法的第二个参数viewType
 *      RecyclerView.Adapter的onBindViewHolder方法的第二个参数viewType
 *      RecyclerView.Adapter的getItemViewType方法的返回值
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.tongfu.mytestapp.R
import java.text.SimpleDateFormat
import java.util.*

class MultiStyleRecyclerViewActivity : AppCompatActivity() {
    @BindView(R.id.rv_main)
    lateinit var rv:RecyclerView

    val adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            if(viewType == 0){
                val view = layoutInflater.inflate(R.layout.layout_multi_style_recycler_view_item_a , parent , false)
                return StyleAViewHolder(view)
            }else if(viewType == 1){
                val view = layoutInflater.inflate(R.layout.layout_multi_style_recycler_view_item_b ,parent , false)
                return StyleBViewHolder(view)
            }else{
                val view = layoutInflater.inflate(R.layout.layout_multi_style_recycler_view_item_c , parent , false)
                return StyleCViewHolder(view)
            }
        }

        override fun getItemCount(): Int {
            return 30
        }
        val format = SimpleDateFormat("mm:ss:SSS")
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if(holder is StyleAViewHolder){
                holder.tv.text = "Style A: " + format.format(Date())
            }else if(holder is StyleBViewHolder){
                holder.tv.text = "Style B: " + format.format(Date())
            }else if(holder is StyleCViewHolder){
                holder.tv.text = "Style C: " + format.format(Date())
            }
        }

        override fun getItemViewType(position: Int): Int {
            return position%3
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_style_recycler_view)
        ButterKnife.bind(this)
        rv.adapter = adapter

        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        rv.layoutManager = manager
    }
}