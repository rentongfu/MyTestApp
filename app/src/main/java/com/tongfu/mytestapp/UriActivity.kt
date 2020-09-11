package com.tongfu.mytestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

class UriActivity : AppCompatActivity() {
    @BindView(R.id.tv_content)
    lateinit var tvContent:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uri)
        ButterKnife.bind(this)
        tvContent.setText(intent.data.toString())
    }
}
