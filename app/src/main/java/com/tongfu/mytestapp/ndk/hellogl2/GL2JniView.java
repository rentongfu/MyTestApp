package com.tongfu.mytestapp.ndk.hellogl2;

import android.content.Context;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class GL2JniView extends GLSurfaceView {
    public GL2JniView(Context context) {
        super(context);
        init( false , 0 , 0);
    }

    /**
     *
     * @param translucent 半透明
     * @param depth
     * @param stencil
     */
    private void init(boolean translucent , int depth , int stencil){
        if(translucent){
            this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        }

        setEGLContextFactory(new GL2ContextFactory());
        setEGLConfigChooser(translucent?new ConfigChooser(8 , 8 , 8 , 8 , depth , stencil):
                new ConfigChooser(5 , 6 , 5 , 0 , depth , stencil));
        setRenderer(new com.tongfu.mytestapp.ndk.hellogl2.Renderer());
    }
}
