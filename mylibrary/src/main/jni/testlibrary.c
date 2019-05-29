#include <jni.h>
#include <stdio.h>

JNIEXPORT void JNICALL
Java_com_rentf_mylibrary_TestLibrary_print(JNIEnv *env, jclass type, jstring str_) {
    const char *str = (*env)->GetStringUTFChars(env, str_, 0);

    // TODO

    (*env)->ReleaseStringUTFChars(env, str_, str);
}