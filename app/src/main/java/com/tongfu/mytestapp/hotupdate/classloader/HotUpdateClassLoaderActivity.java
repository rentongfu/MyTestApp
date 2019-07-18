package com.tongfu.mytestapp.hotupdate.classloader;

import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.TraceRecorder;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class HotUpdateClassLoaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_update_class_loader);
        ButterKnife.bind(this);
    }

    @BindView(R.id.et_console)
    EditText etConsonle;

    @OnClick({R.id.btn_print_class_loader,R.id.btn_clear_console, R.id.print_sample_class, R.id.change_class_loader})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_print_class_loader:{

                ClassLoader classLoader = TraceRecorder.class.getClassLoader();
                do {
                    etConsonle.append( classLoader.toString());
                    etConsonle.append("\n");
                    classLoader = classLoader.getParent();
                }while (classLoader!=null);
                break;
            }
            case R.id.btn_clear_console:{
                etConsonle.setText("");
                break;
            }
            case R.id.print_sample_class:{
                etConsonle.append(SampleClass.getName());
                break;
            }
            case R.id.change_class_loader:{
                try {
                    ClassLoader classLoader = getClassLoader();
                    Field field = classLoader.getClass().getSuperclass().getDeclaredField("pathList");
                    field.setAccessible(true);
                    Object dexPathList =  field.get( classLoader );
                    Field elementsField = dexPathList.getClass().getDeclaredField("dexElements");
                    elementsField.setAccessible(true);
                    Object[] elements = (Object[])elementsField.get(dexPathList);
                    Object[] newElements =(Object[]) Array.newInstance(elements.getClass().getComponentType() , elements.length+1);

//                    dexElements

                    Log.i("ClassLoader" , dexPathList.getClass().toString());

                    MultiDex.install(this);

                } catch (Exception e) {
                    etConsonle.append(e.getMessage());
                    e.printStackTrace();
                }


                break;
            }
        }
    }
}
