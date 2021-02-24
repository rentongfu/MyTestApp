//
// Created by rentf on 2021/2/24.
//
#include <jni.h>

extern "C"
JNIEXPORT void JNICALL
Java_com_tongfu_mytestapp_ndk_jnicall_JNICallActivity_native_1call_1object_1method(JNIEnv *env,
                                                                                   jobject thiz,
                                                                                   jobject test_bean) {
    /*通过env我们我可找到所有和java交换信息的方法。包括：
        寻找类定义：FindClass
        寻找类的方法定义：GetMethodID/GetStaticMethodID
        调用方法：CallVoidMethod/CallStaticVoidMethod
        等等
     */
    jclass testBeanClass = env->FindClass("com/tongfu/mytestapp/ndk/jnicall/TestBean");
    jmethodID sayHiMethod = env->GetMethodID(testBeanClass , "sayHello", "(I)V");
    env->CallVoidMethod(test_bean , sayHiMethod , 12);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_tongfu_mytestapp_ndk_jnicall_JNICallActivity_native_1call_1static_1method(JNIEnv *env,
                                                                                   jobject thiz) {
    jclass testBeanClass = env->FindClass("com/tongfu/mytestapp/ndk/jnicall/TestBean");
    jmethodID sayHiMethod = env->GetStaticMethodID(testBeanClass , "sayHi", "()V");
    env->CallStaticVoidMethod(testBeanClass , sayHiMethod);
}