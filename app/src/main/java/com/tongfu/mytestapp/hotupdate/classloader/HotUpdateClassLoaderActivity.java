package com.tongfu.mytestapp.hotupdate.classloader;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.tongfu.mytestapp.R;
import com.tongfu.mytestapp.TraceRecorder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HotUpdateClassLoaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_update_class_loader);
        ButterKnife.bind(this);
    }

    @BindView(R.id.et_console)
    EditText etConsonle;

    @OnClick({R.id.btn_print_class_loader,R.id.btn_clear_console, R.id.print_sample_class, R.id.change_class_loader,R.id.btn_load_external_class})
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
//                etConsonle.append(SampleClass.getName());
                try {
//                    etConsonle.append((String)Class.forName("com.tongfu.mytestapp.hotupdate.classloader.SampleClass").getDeclaredMethod("getName").invoke(null));
                    etConsonle.append(SampleClass.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                     etConsonle.append(e.getMessage());
                }
                break;
            }
            case R.id.change_class_loader:{
                try {
                    ClassLoader classLoader = getClassLoader();
                    Field field = classLoader.getClass().getSuperclass().getDeclaredField("pathList");
                    field.setAccessible(true);
                    Object dexPathList =  field.get( classLoader );

                    Class dexPathListClass = dexPathList.getClass() ;

                    Field elementsField = dexPathListClass.getDeclaredField("dexElements");
                    elementsField.setAccessible(true);
                    Object[] elements = (Object[])elementsField.get(dexPathList);

                    Method makeDexElementsMethod = dexPathListClass.getDeclaredMethod("makeDexElements" , List.class, File.class, List.class , ClassLoader.class );
                    File file = new File(getCacheDir().getAbsolutePath() + "/hotupdate/patch.apk");
                    if(!file.exists()){
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                        FileUtils.writeByteArrayToFile(file ,IOUtils.toByteArray(getAssets().open("patch.apk")));
                    }
                    List<File> fileList = new ArrayList<>();
                    fileList.add(file);
                    makeDexElementsMethod.setAccessible(true);
                    Object[] myElements =(Object[]) makeDexElementsMethod.invoke( dexPathList , fileList , file.getParentFile().getParentFile() , new ArrayList<>() , null );

                    Object[] newElements =(Object[]) Array.newInstance(elements.getClass().getComponentType() , elements.length+1);
                    newElements[0] = myElements[0] ;
                    System.arraycopy(elements , 0 , newElements ,1 , elements.length);
                    elementsField.set(dexPathList , newElements);

//                    ((PathClassLoader)classLoader).loadClass("com.tongfu.mytestapp.hotupdate.classloader.SampleClass");

//                    MultiDex.install(this);

                } catch (Exception e) {
                    etConsonle.append(e.getMessage());
                    e.printStackTrace();
                }
                break;
            }
            case R.id.btn_load_external_class:{

                try {
                    ClassLoader classLoader = getClassLoader();
                    Field field = classLoader.getClass().getSuperclass().getDeclaredField("pathList");
                    field.setAccessible(true);
                    Object dexPathList =  field.get( classLoader );

                    Class dexPathListClass = dexPathList.getClass() ;

                    Field elementsField = dexPathListClass.getDeclaredField("dexElements");
                    elementsField.setAccessible(true);
                    Object[] elements = (Object[])elementsField.get(dexPathList);

                    Method makeDexElementsMethod = dexPathListClass.getDeclaredMethod("makePathElements" , List.class, File.class, List.class );
                    File file = new File(getCacheDir().getAbsolutePath() + "/hotupdate/patch.apk");
                    if(!file.exists()){
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                        FileUtils.writeByteArrayToFile(file ,IOUtils.toByteArray(getAssets().open("patch.apk")));
                    }
                    List<File> fileList = new ArrayList<>();
                    fileList.add(file);
                    makeDexElementsMethod.setAccessible(true);
                    Object[] myElements =(Object[]) makeDexElementsMethod.invoke( dexPathList , fileList , file.getParentFile() , new ArrayList<>() );

                    Class elementClass = myElements[0].getClass() ;
                    Method elementLoadClassMethod = elementClass.getDeclaredMethod("findClass" , String.class , ClassLoader.class , List.class);
                    Class myClass = (Class) elementLoadClassMethod.invoke(myElements[0] , "com.tongfu.mytestapp.hotupdate.classloader.SampleClass" , classLoader , new ArrayList<>());
                    Method getNameMethod = myClass.getMethod("getName");
                    etConsonle.append((String)getNameMethod.invoke(null));

                } catch (Exception e) {
                    etConsonle.append(e.getMessage());
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
