package com.tongfu.mytestapp.dagger2.advanceduse2;

import android.content.Context;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = AdvancedUseModule2.class)
public interface AdvancedUseComponent2 {
    Context context();
    void inject(AdvancedUseActivity2 activity1);
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder context(Context context);
//        Builder advancedUseModule2(AdvancedUseModule2 module);

        AdvancedUseComponent2 build();
    }
}
