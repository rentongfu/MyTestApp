package com.tongfu.mytestapp.dagger2;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MyModule {
//    @ActivityScoped
//    @ContributesAndroidInjector(modules = Dagger2TestModule.class)
//    abstract Dagger2TestActivity dagger2TestActivity();
@FragmentScoped
@ContributesAndroidInjector
abstract Dagger2TestFragment dagger2TestFragment();
}
