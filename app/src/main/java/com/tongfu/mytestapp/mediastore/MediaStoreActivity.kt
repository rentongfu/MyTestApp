package com.tongfu.mytestapp.mediastore

import android.content.ContentValues
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.R
import java.io.IOException
import java.io.OutputStream


class MediaStoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_store)
        ButterKnife.bind(this)
    }
    @OnClick(R.id.btn_save)
    public fun onClick(v: View){
        when(v.id){
            R.id.btn_save->{
                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.Q){
                    Toast.makeText(this , "Android Q之前的版本不支持MediaStore的文件访问方式" ,Toast.LENGTH_SHORT).show()
                }else{
                    val resolver = contentResolver
                    val values = ContentValues()
                    values.put(MediaStore.Downloads.DISPLAY_NAME, "FILENAME")
                    //设置文件类型（有哪些类型网上很容易查到，如果不设置的话，就是默认没有扩展名的文件）
                    //设置文件类型（有哪些类型网上很容易查到，如果不设置的话，就是默认没有扩展名的文件）
                    values.put(MediaStore.Downloads.MIME_TYPE, "text/plain")
                    //这个方法只可在Android10的手机上执行，设置路径
                    //这个方法只可在Android10的手机上执行，设置路径
                    values.put(MediaStore.Downloads.RELATIVE_PATH, "Download/mypath")
                    val external: Uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI
// 写入文件
// 写入文件
                    val insertUri: Uri? = resolver.insert(external, values)
                    if(insertUri==null){
                        Toast.makeText(this ,"写入失败" , Toast.LENGTH_SHORT).show()
                        return
                    }
// io写入

// io写入
                    var os: OutputStream? = null
                    val test = "aaaaaaaaaa"
                    try {
                        os = resolver.openOutputStream(insertUri)
                        if (os == null) {
                            return
                        }
                        val buffer = test.toByteArray()
                        os.write(buffer, 0, buffer.size)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    } finally {
                        try {
                            if (os != null) {
                                os.close()
                            }
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                    Toast.makeText(this ,"写入成功" , Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}
