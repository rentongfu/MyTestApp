//
// Created by rentf on 2021/3/9.
//

#include "android/native_window_jni.h"
#include <jni.h>

void draw(JNIEnv* env , jobject surfaceObj){
    ANativeWindow_Buffer buffer ;
    ANativeWindow* pWindow = ANativeWindow_fromSurface(env , surfaceObj);
    ANativeWindow_setBuffersGeometry(pWindow ,  100 , 100 ,WINDOW_FORMAT_RGBA_8888);
    if(ANativeWindow_lock(pWindow , &buffer , NULL) == 0){
        auto * pStart = static_cast<unsigned int *>(buffer.bits);
        for(int rowIndex = 0 ; rowIndex < 50 ; rowIndex++){
            int rowStart = rowIndex * buffer.stride ;
            for (int colIndex = 0 ;colIndex < 100 ; colIndex++){
                pStart[rowStart + colIndex] = 0xFF00FFFF ;
            }
        }
        ANativeWindow_unlockAndPost(pWindow);
        ANativeWindow_release(pWindow);
    }

}

extern "C"
JNIEXPORT void JNICALL
Java_com_tongfu_mytestapp_ndk_nativesurface_NativeSurfaceActivity_drawSurface(JNIEnv *env,
                                                                              jobject thiz,
                                                                              jobject surface) {
    draw(env , surface);
}