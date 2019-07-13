package com.tongfu.mytestapp.dagger2;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        MyModule.class,
        AndroidSupportInjectionModule.class
})
public interface MyComponent {
    void inject(Dagger2TestActivity object);
}
