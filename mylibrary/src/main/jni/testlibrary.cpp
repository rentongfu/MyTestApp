#include <jni.h>
#include <ctime>
#include <android/log.h>

#define  LOG_TAG    "test_library"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)



extern "C"
JNIEXPORT jstring JNICALL
Java_com_rentf_mylibrary_JniUtil_getString(JNIEnv *env, jobject instance) {
    const char* returnValue = "String from Jni" ;
    return env->NewStringUTF( returnValue);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_tongfu_mytestapp_ndk_performance_NdkPerformanceCompareActivity_executeJni(JNIEnv *env,
                                                                                   jobject thiz,
                                                                                   jint value) {
    clock_t start_time = clock();

    long result = 0;
    for (int i = 0; i < value ; ++i) {
        if(i%5 != 0)
            result+=i;
        else
            result-=i;
    }
    clock_t end_time = clock();

    LOGI("结果：%ld。NDK c++执行耗时：%ld" ,result, (end_time-start_time)/1000);

}