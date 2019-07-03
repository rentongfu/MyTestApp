package com.tongfu.mytestapp.ndk.hellogl2;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class ConfigChooser implements GLSurfaceView.EGLConfigChooser {
    int mRedSize, mGreenSize, mBlueSize, mAlphaSize, mDepthSize, mStencilSize ;
    public ConfigChooser(int r , int g, int b , int a , int depth , int stencil){
        mRedSize = r ;
        mGreenSize = g ;
        mBlueSize = b ;
        mAlphaSize = a ;
        mDepthSize = depth ;
        mStencilSize = stencil ;
    }
    int EGL_OPENGL_ES2_BIT = 4 ;
    int[] s_configAttribs = {EGL10.EGL_RED_SIZE , 4 ,
        EGL10.EGL_GREEN_SIZE , 4 ,
        EGL10.EGL_BLUE_SIZE , 4 ,
        EGL10.EGL_RENDERABLE_TYPE , EGL_OPENGL_ES2_BIT,
        EGL10.EGL_NONE};
    @Override
    public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
        int[]  num_config = new int[1] ;
        egl.eglChooseConfig(display , s_configAttribs , null , 0 , num_config) ;
        int num_configs = num_config[0] ;
        if(num_configs <= 0){
            throw new IllegalArgumentException("No configs match configSpec");
        }
        EGLConfig[] configs = new EGLConfig[num_configs] ;
        egl.eglChooseConfig(display , s_configAttribs , configs , num_configs , num_config) ;

        for(EGLConfig config : configs){
            int d = findConfigAttrib(egl , display , config , EGL10.EGL_DEPTH_SIZE , 0 );
            int s = findConfigAttrib(egl , display , config , EGL10.EGL_STENCIL_SIZE ,  0) ;
            if(d < mDepthSize || s < mStencilSize ){
                continue;
            }
            int r = findConfigAttrib( egl , display , config , EGL10.EGL_RED_SIZE , 0 ) ;

            int g = findConfigAttrib( egl , display , config , EGL10.EGL_GREEN_SIZE , 0 ) ;
            int b = findConfigAttrib( egl , display , config , EGL10.EGL_BLUE_SIZE , 0 ) ;
            int a = findConfigAttrib( egl , display , config , EGL10.EGL_ALPHA_SIZE , 0 ) ;
            if( r == mRedSize && g == mGreenSize && b == mBlueSize && a == mAlphaSize){
                return config ;
            }
        }
        return null;
    }

    int[] mValue = new int[1] ;
    private int findConfigAttrib(EGL10 egl , EGLDisplay display , EGLConfig config ,int attribute ,int defaultValue){
//        int numConfigs = configs.length ;
        if(egl.eglGetConfigAttrib(display , config , attribute, mValue)){
            return mValue[0];
        }
        return defaultValue ;
    }
    private void printConfig(){

    }
}
