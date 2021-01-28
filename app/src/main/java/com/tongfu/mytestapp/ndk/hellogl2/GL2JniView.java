package com.tongfu.mytestapp.ndk.hellogl2;

import android.content.Context;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class GL2JniView extends GLSurfaceView {
    private static final String TAG = "GLSurfaceView";
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

        setEGLContextFactory(new EGLContextFactory() {

            @Override
            public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig eglConfig) {
                Log.w(TAG, "creating OpenGL ES 2.0 context");
                checkEglError("Before eglCreateContext", egl);
                final int EGL_CONTEXT_CLIENT_VERSION = 0x3098;
                int[] attrib_list = {EGL_CONTEXT_CLIENT_VERSION, 2, EGL10.EGL_NONE };
                EGLContext context = egl.eglCreateContext(display, eglConfig, EGL10.EGL_NO_CONTEXT, attrib_list);
                checkEglError("After eglCreateContext", egl);
                return context;
            }
            private void checkEglError(String prompt, EGL10 egl) {
                int error;
                while ((error = egl.eglGetError()) != EGL10.EGL_SUCCESS) {
                    Log.e(TAG, String.format("%s: EGL error: 0x%x", prompt, error));
                }
            }


            @Override
            public void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context) {
                egl.eglDestroyContext(display, context);
            }
        });
        setRenderer(new Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int width, int height) {
                GL2JniLib.init(width , height);
            }

            @Override
            public void onDrawFrame(GL10 gl) {
                GL2JniLib.step();
            }
        });
    }
}
