package com.tongfu.mytestapp.recyclerview.swipemenu

import android.content.Context
import android.graphics.Color
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
import com.yanzhenjie.recyclerview.OnItemMenuClickListener
import com.yanzhenjie.recyclerview.SwipeMenuCreator
import com.yanzhenjie.recyclerview.SwipeMenuItem
import com.yanzhenjie.recyclerview.SwipeRecyclerView

fun dpToPixel(dp:Int , context: Context):Int {
    val scale = context.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}

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

//    private

    private val swipeMenuCreator = SwipeMenuCreator { leftMenu, rightMenu, position ->
        val menuItemWidth = dpToPixel(72 ,this )
        val menuItem = SwipeMenuItem(this@SwipeMenuRecyclerViewActivity)
        menuItem.text = "删除"
        menuItem.width = menuItemWidth
        menuItem.height = ViewGroup.LayoutParams.MATCH_PARENT
        menuItem.setBackgroundColor(Color.RED)
        leftMenu?.addMenuItem(menuItem)
        val menuItem2 = SwipeMenuItem(this@SwipeMenuRecyclerViewActivity)
        menuItem2.text = "编辑"
        menuItem2.width = menuItemWidth
        menuItem2.height = ViewGroup.LayoutParams.MATCH_PARENT
        menuItem2.setBackgroundColor(Color.GREEN)
        rightMenu?.addMenuItem(menuItem2)

        val menuItem3 = SwipeMenuItem(this@SwipeMenuRecyclerViewActivity)
        menuItem3.text = "标记"
        menuItem3.width = menuItemWidth
        menuItem3.height = ViewGroup.LayoutParams.MATCH_PARENT
        menuItem3.setBackgroundColor(Color.BLUE)
        rightMenu?.addMenuItem(menuItem3)
    }
    private val swipeMenuListener = OnItemMenuClickListener { menuBridge, adapterPosition ->
        menuBridge?.closeMenu()
        val direction = menuBridge!!.direction
        val menuPosition = menuBridge.position
        Toast.makeText(this@SwipeMenuRecyclerViewActivity , "侧滑菜单显示，索引：$adapterPosition，方向：$direction，位置：$menuPosition"   , Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_menu_recycler_view)
        ButterKnife.bind(this)
        srv.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL ,false)
        srv.addItemDecoration(DividerItemDecoration(this , DividerItemDecoration.VERTICAL))
        srv.setSwipeMenuCreator(swipeMenuCreator)
        srv.setOnItemMenuClickListener(swipeMenuListener)
        srv.adapter = adapter
    }
}