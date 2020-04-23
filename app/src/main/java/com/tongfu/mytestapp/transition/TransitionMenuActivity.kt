package com.tongfu.mytestapp.transition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.R

class TransitionMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_menu)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_custorm_transition ,R.id.btn_animate_layout_change )
    fun onClick(view: View){
        when(view.id){
            R.id.btn_custorm_transition->{
                val intent = Intent(this , TransitionActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_animate_layout_change->{
                val intent = Intent(this , AnimateLinearLayoutChangeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
