package com.tongfu.mytestapp.dagger2;

import android.content.Context;
import android.util.Log;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public class MyModule {
    public MyModule(Context context){
        Log.i(context.getPackageName() ,"");
    }
//    @ActivityScoped
//    @ContributesAndroidInjector(modules = Dagger2TestModule.class)
//    abstract Dagger2TestActivity dagger2TestActivity();
//@FragmentScoped
//@ContributesAndroidInjector
//abstract Dagger2TestFragment dagger2TestFragment();
}
