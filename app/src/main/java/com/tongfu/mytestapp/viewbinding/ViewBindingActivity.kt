package com.tongfu.mytestapp.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tongfu.mytestapp.R
import com.tongfu.mytestapp.databinding.ActivityViewBindingBinding
import kotlinx.android.synthetic.main.activity_view_binding.*

/*
    1. 要使用ViewBinding，首先需要将Gradle版本升至gradle-6.5版本。将gradle build tool升至4.1.3
    2. 在build.gradle配置文件中开启view binding.
    android{
        ...
        buildFeatures {
            ...
            viewBinding {
                enabled = true
            }
            ...
        }
        ...
    }

    3. 开启后，gradle会为每一个layout xml文件生成一个binding类
    4. 通过binding类的inflate方法解析layout文件，生成binding对象。
        val binding by lazy { ActivityViewBindingBinding.inflate(layoutInflater)  }
    5. 将binding对象的root成员设值为content view
        setContentView(binding.root)
 */
class ViewBindingActivity : AppCompatActivity() {
    val binding by lazy {  ActivityViewBindingBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tv.text = "Hello World"
        tv.text = "Hello World!"//这个是kotlin-android-extensions提供的功能。
    }
}