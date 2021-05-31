package com.tongfu.mytestapp.renderscript

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Allocation
import android.renderscript.RenderScript
import android.renderscript.Script
import android.view.View
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.GreyBitCode
import com.tongfu.mytestapp.R
import com.tongfu.mytestapp.ScriptC_Grey

class RenderScriptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_render_script)
        ButterKnife.bind(this)
    }
    val bitmap by lazy {BitmapFactory.decodeResource(resources , R.drawable.sample)}
    @BindView(R.id.iv_image)
    lateinit var iv:ImageView
    @OnClick(R.id.btn_show_origin , R.id.btn_show_new)
    public fun onViewClick(view:View){
        when(view.id){
            R.id.btn_show_origin->{
                iv.setImageBitmap(bitmap)
            }
            R.id.btn_show_new->{
                val width = bitmap.width
                val height = bitmap.height
                val outBitmap = Bitmap.createBitmap(width, height , Bitmap.Config.ARGB_8888)
                val rs = RenderScript.create(this)
                val allocationIn = Allocation.createFromBitmap(rs , bitmap)
                val allocationOut =Allocation.createFromBitmap(rs , outBitmap)
                val script = ScriptC_Grey(rs)
                script.forEach_root(allocationIn , allocationOut)
                allocationOut.copyTo(outBitmap)
                rs.destroy()
                iv.setImageBitmap(outBitmap)
            }
        }
    }
}