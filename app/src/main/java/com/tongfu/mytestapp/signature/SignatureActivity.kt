package com.tongfu.mytestapp.signature

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.OnClick
import com.tongfu.mytestapp.R
import java.lang.StringBuilder

class SignatureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signature)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_show_signature)
    fun onClick(view:View){
        when(view.id){
            R.id.btn_show_signature->{
                val packageInfo = packageManager.getPackageInfo(packageName , PackageManager.GET_SIGNATURES)
                val signatures = packageInfo.signatures
                val sb = StringBuilder("There are ${signatures.size} signatures. ")
                signatures.forEach {
                    sb.append(it.toCharsString()).append("; ")
                }
                Toast.makeText(this , sb.toString() , Toast.LENGTH_SHORT).show()
            }
        }
    }
}
