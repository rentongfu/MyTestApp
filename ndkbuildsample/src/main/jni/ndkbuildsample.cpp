//
// Created by rentf on 2019/7/8.
//
#include <jni.h>
#include <android/log.h>

#define  LOG_TAG    "ndkbuildsample"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)

extern "C"
JNIEXPORT void JNICALL Java_com_tongfu_ndkbuildsample_NdkBuildJniUtil_printHelloWorld(JNIEnv *env, jclass type) {
    LOGI("Hello World from Nkd Build");
}