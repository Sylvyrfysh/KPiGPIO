#include <pigpio.h>
#include <jni.h>

#include "com_nicholaspjohnson_kpigpio_PiGPIO.h"

#ifndef METHOD
#define METHOD(x) JNICALL Java_com_nicholaspjohnson_kpigpio_PiGPIO_##x
#endif

JavaVM *g_vm;

void METHOD(gpioInitialize)(JNIEnv *env, jobject obj) {
	(*env)->GetJavaVM(env, &g_vm);
	gpioInitialise();
}

void METHOD(gpioTerminate)(JNIEnv *env, jobject obj) {
	gpioTerminate();
}