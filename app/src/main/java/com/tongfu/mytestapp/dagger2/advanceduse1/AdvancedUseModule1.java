package com.tongfu.mytestapp.dagger2.advanceduse1;

import android.app.ActivityManager;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AdvancedUseModule1 {
    private Context context;
    AdvancedUseModule1(Context context){
        this.context = context ;
    }
    @Provides
    public Context provideContext(){
        return context ;
    }

    @Provides
    public ActivityManager provideActivityManager(Context context){
        return  (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
    }
}
