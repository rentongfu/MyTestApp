package com.tongfu.mytestapp.recyclerview.swipemenu

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.tongfu.mytestapp.R
import com.yanzhenjie.recyclerview.*


class SwipeMenuRecyclerViewActivity : AppCompatActivity() {
    @BindView(R.id.srv)
    lateinit var srv:SwipeRecyclerView

    private val adapter = object: RecyclerView.Adapter<VH>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = layoutInflater.inflate(R.layout.layout_multi_style_recycler_view_item_a , parent ,false)
            return VH(view)
        }

        override fun getItemCount(): Int {
            return 20
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.tv.text = "Style A: $position"
        }
    }

    val swipeMenuCreator = object :SwipeMenuCreator{
        override fun onCreateMenu(leftMenu: SwipeMenu?, rightMenu: SwipeMenu?, position: Int) {
            val menuItem = SwipeMenuItem(this@SwipeMenuRecyclerViewActivity)
            menuItem.text = "删除"
            leftMenu?.addMenuItem(menuItem)
            val menuItem2 = SwipeMenuItem(this@SwipeMenuRecyclerViewActivity)
            menuItem2.text = "编辑"
            rightMenu?.addMenuItem(menuItem2)
        }
    }
    val swipeMenuListener = object :OnItemMenuClickListener{
        override fun onItemClick(menuBridge: SwipeMenuBridge?, adapterPosition: Int) {
            menuBridge?.closeMenu()
            val direction = menuBridge!!.direction
            val menuPosition = menuBridge.position
            Toast.makeText(this@SwipeMenuRecyclerViewActivity , "侧滑菜单显示，方向：$direction，位置：$menuPosition"   , Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_menu_recycler_view)
        ButterKnife.bind(this)
        srv.adapter = adapter
        srv.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL ,false)
        srv.addItemDecoration(DividerItemDecoration(this , DividerItemDecoration.VERTICAL))
        srv.setSwipeMenuCreator(swipeMenuCreator)
        srv.setOnItemMenuClickListener(swipeMenuListener)
    }
}