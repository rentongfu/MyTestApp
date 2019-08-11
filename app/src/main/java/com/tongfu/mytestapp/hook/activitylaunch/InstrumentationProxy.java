package com.tongfu.mytestapp.hook.activitylaunch;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.UserHandle;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InstrumentationProxy extends Instrumentation {
    private Instrumentation mInstrumentation;
    public InstrumentationProxy(Instrumentation instrumentation){
        mInstrumentation = instrumentation;
    }

    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options){
        try {
            Toast.makeText(who , "拦截到Activity："+ intent.getComponent().getClassName() +"启动" , Toast.LENGTH_SHORT).show();

            Method execStartActivityMethod = Instrumentation.class.getDeclaredMethod("execStartActivity" ,
                    Context.class ,IBinder.class , IBinder.class , Activity.class ,
                    Intent.class , int.class , Bundle.class);
            return (ActivityResult) execStartActivityMethod.invoke(mInstrumentation , who , contextThread , token , target , intent , requestCode , options);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, String target,
            Intent intent, int requestCode, Bundle options) {
        try {

            Method execStartActivityMethod = Instrumentation.class.getDeclaredMethod("execStartActivity" ,
                    Context.class ,IBinder.class , IBinder.class , String.class ,
                    Intent.class , int.class , Bundle.class);
            return (ActivityResult) execStartActivityMethod.invoke(mInstrumentation , who , contextThread , token , target , intent , requestCode , options);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, String resultWho,
            Intent intent, int requestCode, Bundle options, UserHandle user) {
        try {

            Method execStartActivityMethod = Instrumentation.class.getDeclaredMethod("execStartActivity" ,
                    Context.class ,IBinder.class , IBinder.class , String.class ,
                    Intent.class , int.class , Bundle.class , UserHandle.class );
            return (ActivityResult) execStartActivityMethod.invoke(mInstrumentation , who , contextThread , token , resultWho , intent , requestCode , options , user);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ActivityResult execStartActivityAsCaller(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options, boolean ignoreTargetSecurity,
            int userId) {
        try {

            Method execStartActivityAsCallerMethod = Instrumentation.class.getDeclaredMethod("execStartActivityAsCaller" ,
                    Context.class ,IBinder.class , IBinder.class , Activity.class ,
                    Intent.class , int.class , Bundle.class , boolean.class ,
                    int.class);
            return (ActivityResult) execStartActivityAsCallerMethod.invoke(mInstrumentation , who , contextThread , token , target ,
                    intent , requestCode , options , ignoreTargetSecurity,
                    userId);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void execStartActivities(Context who, IBinder contextThread,
                                    IBinder token, Activity target, Intent[] intents, Bundle options) {
        try {
            Method execStartActivityAsCallerMethod = Instrumentation.class.getDeclaredMethod("execStartActivityAsCaller" ,
                    Context.class ,IBinder.class , IBinder.class , Activity.class ,
                    Intent[].class , Bundle.class);
            execStartActivityAsCallerMethod.invoke(mInstrumentation , who , contextThread , token , target ,
                    intents , options);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
