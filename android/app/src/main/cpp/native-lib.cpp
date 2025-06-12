#include <jni.h>
#include <string>
#include "../../../../../lib/version.h"  // Path to your lib/version.h

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapp_MainActivity_getNativeVersion(JNIEnv* env, jobject /* this */) {
    return env->NewStringUTF(GetAppVersion());  // Call C++ function
}