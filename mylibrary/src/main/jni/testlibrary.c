#include <jni.h>
#include <stdio.h>
#include <syslog.h>

JNIEXPORT void JNICALL
Java_com_rentf_mylibrary_TestLibrary_print(JNIEnv *env, jclass type, jstring str_) {
    const char *str = (*env)->GetStringUTFChars(env, str_, 0);

    // TODO
    syslog( 0 , "this is a log print by c");
    (*env)->ReleaseStringUTFChars(env, str_, str);
}

JNIEXPORT jstring JNICALL
Java_com_rentf_mylibrary_JniUtil_getString(JNIEnv *env, jobject instance) {

    const char* returnValue = "String from Jni" ;
    syslog( 0 , "this is a log print by c");
    return (*env)->NewStringUTF(env, returnValue);
}