package com.tongfu.mytestapp.transition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.R

class AnimateLinearLayoutChangeActivity : AppCompatActivity() {

    @BindView(R.id.ll_content)
    lateinit var llContent:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animate_linear_layout_change)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_add)
    fun onClick(view:View){
        val textView = TextView(this)
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT , LinearLayout.LayoutParams.WRAP_CONTENT)
        textView.textSize = 24f
        textView.setPadding(24 , 24 ,24 ,24)
        textView.text = "这是一沟绝望的死水"
        llContent.addView(textView , 0 )
    }
}
