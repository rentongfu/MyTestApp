package com.tongfu.mytestapp.uiwidget.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.R
class VH(itemView: View) :RecyclerView.ViewHolder(itemView){

}

/**
 * ViewPager2相对ViewPager的差异：
 *  ViewPager2是一个对RecyclerView的封装，使用的Adapter直接就是RecyclerView的Adapter。
 *  新功能：支持垂直方向，支持动态增删元素。
 */
class ViewPager2Activity : AppCompatActivity() {

    var itemLength = 3

    val adapter by lazy{
        object: RecyclerView.Adapter<VH>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
                val view = layoutInflater.inflate(R.layout.layout_view_pager2_item , parent , false)
                return VH(view)
            }

            override fun getItemCount(): Int = itemLength

            override fun onBindViewHolder(holder: VH, position: Int) {

            }

        }
    }

    @BindView(R.id.vp2)
    lateinit var vp2:ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)
        ButterKnife.bind(this)
        vp2.adapter = adapter
    }

    @OnClick(R.id.btn_add_item , R.id.btn_change_orientation , R.id.btn_delete_item)
    fun onClick(view:View){
        when(view.id){
            R.id.btn_change_orientation->{
                if(vp2.orientation == ViewPager2.ORIENTATION_HORIZONTAL){
                    vp2.orientation = ViewPager2.ORIENTATION_VERTICAL
                }else{
                    vp2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                }
            }
            R.id.btn_add_item->{
                itemLength++
                adapter.notifyDataSetChanged()
            }
            R.id.btn_delete_item->{
                if(itemLength > 0){
                    itemLength--
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}