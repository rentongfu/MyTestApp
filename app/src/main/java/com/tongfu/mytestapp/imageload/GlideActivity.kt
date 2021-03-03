package com.tongfu.mytestapp.imageload

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import com.tongfu.mytestapp.R

class GlideActivity : AppCompatActivity() {
    @BindView(R.id.iv_image)
    lateinit var iv_image: ImageView

    @BindView(R.id.et_url)
    lateinit var etUrl: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_load)
    fun onBtnLoadClicked() {
        val url: String = etUrl.getText().toString()
        if (url == null || url.length == 0) {
            Toast.makeText(this, "输入url为空", Toast.LENGTH_SHORT).show()
            return
        }

//        Glide.with()
        Glide.with(this).load(url).apply(RequestOptions.fitCenterTransform()).into(iv_image)

//        Picasso.with(this).load(url).placeholder(R.drawable.ic_blank).error(R.drawable.ic_error).into(iv_image)
    }
}