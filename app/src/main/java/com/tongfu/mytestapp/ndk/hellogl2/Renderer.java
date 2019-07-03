package com.tongfu.mytestapp.ndk.hellogl2;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Renderer implements GLSurfaceView.Renderer {
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
}
