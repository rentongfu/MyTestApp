package com.tongfu.mytestapp.bitmap

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.R

class BitmapTransformActivity : AppCompatActivity() {
    @BindView(R.id.iv)
    lateinit var iv :ImageView
    val bitmap by lazy { BitmapFactory.decodeResource(resources , R.drawable.sample) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap_transform)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_reset , R.id.btn_pre_rotate , R.id.btn_post_rotate , R.id.btn_set_scale)
    public fun onClick(view: View){
        when(view.id){
            R.id.btn_reset->{
                iv.setImageBitmap(bitmap)
            }
            R.id.btn_pre_rotate->{
                val matrix = Matrix()
                matrix.preRotate(30f)
                iv.setImageBitmap(Bitmap.createBitmap(bitmap , 0 , 0, bitmap.width, bitmap.height , matrix , false))
            }
            R.id.btn_post_rotate->{
                val matrix = Matrix()
                matrix.postRotate(30f)
                iv.setImageBitmap(Bitmap.createBitmap(bitmap , 0 , 0, bitmap.width, bitmap.height , matrix , false))
            }
            R.id.btn_set_scale->{
                val matrix = Matrix()
                matrix.setScale(-1f, 1f)
                iv.setImageBitmap(Bitmap.createBitmap(bitmap , 0 , 0, bitmap.width, bitmap.height , matrix , false))
            }
        }
    }
}