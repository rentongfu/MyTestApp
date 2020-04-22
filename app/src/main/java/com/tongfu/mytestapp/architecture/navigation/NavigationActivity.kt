package com.tongfu.mytestapp.architecture.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.R

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_fragment_one, R.id.btn_fragment_two)
    fun onClicK(view:View){
        Log.i("NavigationActivity" , "onClick")
        when(view.id){
            R.id.btn_fragment_one->{
                findNavController(R.id.nav_host_fragment).navigate(R.id.action_navigationOneFragment_to_navigationTwoFragment)
            }
            R.id.btn_fragment_two->{
                findNavController(R.id.nav_host_fragment).navigate(R.id.action_navigationTwoFragment_to_navigationOneFragment)
            }
        }
    }
}
