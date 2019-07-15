package com.tongfu.mytestapp.dagger2.baseuse;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseUseModule {
    @Provides
    public ClassB getClassB(){
        return new ClassB();
    }
}
