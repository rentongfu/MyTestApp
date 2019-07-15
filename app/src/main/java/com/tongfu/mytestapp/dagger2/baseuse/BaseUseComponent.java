package com.tongfu.mytestapp.dagger2.baseuse;

import dagger.Component;

@Component(modules = {BaseUseModule.class})
public interface BaseUseComponent {
    void inject(DaggerBaseUseActivity activity);
}
