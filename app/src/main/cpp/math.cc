#include <jni.h>

extern "C" JNIEXPORT jfloat JNICALL
Java_io_mishkav_jnicalculatorsample_ui_screens_main_MainActivity_sum(JNIEnv* env, jobject thiz, jfloat first, jfloat second)
{
    return first + second;
}

extern "C" JNIEXPORT jfloat JNICALL
Java_io_mishkav_jnicalculatorsample_ui_screens_main_MainActivity_sub(JNIEnv* env, jobject thiz, jfloat first, jfloat second)
{
    return first - second;
}

extern "C" JNIEXPORT jfloat JNICALL
Java_io_mishkav_jnicalculatorsample_ui_screens_main_MainActivity_mult(JNIEnv* env, jobject thiz, jfloat first, jfloat second)
{
    return first * second;
}

extern "C" JNIEXPORT jfloat JNICALL
Java_io_mishkav_jnicalculatorsample_ui_screens_main_MainActivity_div(JNIEnv* env, jobject thiz, jfloat first, jfloat second)
{
    if (second) {
        return first / second;
    }
    return 0;
}