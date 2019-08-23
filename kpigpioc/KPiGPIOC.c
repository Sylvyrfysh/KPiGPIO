#include <pigpio.h>
#include <jni.h>

#include "com_nicholaspjohnson_kpigpio_PiGPIO.h"

#ifndef METHOD
#define METHOD(x) JNICALL Java_com_nicholaspjohnson_kpigpio_PiGPIO_##x
#endif

#ifndef CHECK_ERRCODE
#define CHECK_ERRCODE(x)	if (x < 0) { \
								(*env)->Throw(env, makeGPIOException(env, obj, x)); \
							}
#endif

JavaVM *g_vm;

jthrowable makeGPIOException(JNIEnv *env, jobject obj, int errCode);

jint METHOD(gpioInitialize)(JNIEnv *env, jobject obj) {
	int errCode = gpioInitialise();
	CHECK_ERRCODE(errCode)
	(*env)->GetJavaVM(env, &g_vm);
	return errCode; //version number
}

void METHOD(gpioTerminate)(JNIEnv *env, jobject obj) {
	gpioTerminate();
}

void METHOD(gpioSetMode)(JNIEnv *env, jobject obj, jint gpio, jint mode) {
	int errCode = gpioSetMode(gpio, mode);
	CHECK_ERRCODE(errCode)
}

jint METHOD(gpioGetMode)(JNIEnv *env, jobject obj, jint gpio) {
	int errCode = gpioGetMode(gpio);
	CHECK_ERRCODE(errCode)
	return errCode;
}

void METHOD(gpioSetPullUpDown)(JNIEnv * env, jobject obj, jint gpio, jint pud) {
	int errCode = gpioSetPullUpDown(gpio, pud);
	CHECK_ERRCODE(errCode)
}

jint METHOD(gpioRead)(JNIEnv *env, jobject obj, jint gpio) {
	int errCode = gpioRead(gpio);
	CHECK_ERRCODE(errCode)
	return errCode;
}

void METHOD(gpioWrite)(JNIEnv *env, jobject obj, jint gpio, jint level) {
	int errCode = gpioWrite(gpio, level);
	CHECK_ERRCODE(errCode)
}

void METHOD(gpioPWM)(JNIEnv *env, jobject obj, jint userGPIO, jint dutycycle) {
	int errCode = gpioPWM(userGPIO, dutycycle);
	CHECK_ERRCODE(errCode)
}

jint METHOD(gpioGetPWMdutycycle)(JNIEnv *env, jobject obj, jint userGPIO) {
	int errCode = gpioGetPWMdutycycle(userGPIO);
	CHECK_ERRCODE(errCode)
	return errCode;
}

jint METHOD(gpioSetPWMrange)(JNIEnv *env, jobject obj, jint userGPIO, jint range) {
	int errCode = gpioSetPWMrange(userGPIO, range);
	CHECK_ERRCODE(errCode)
	return errCode;
}

jint METHOD(gpioGetPWMrange)(JNIEnv *env, jobject obj, jint userGPIO) {
	int errCode = gpioGetPWMrange(userGPIO);
	CHECK_ERRCODE(errCode)
	return errCode;
}

jint METHOD(gpioGetPWMrealRange)(JNIEnv *env, jobject obj, jint userGPIO) {
	int errCode = gpioGetPWMrealRange(userGPIO);
	CHECK_ERRCODE(errCode)
	return errCode;
}

jint METHOD(gpioSetPWMfrequency)(JNIEnv *env, jobject obj, jint userGPIO, jint frequency) {
	int errCode = gpioSetPWMfrequency(userGPIO, frequency);
	CHECK_ERRCODE(errCode)
	return errCode;
}

jint METHOD(gpioGetPWMfrequency)(JNIEnv *env, jobject obj, jint userGPIO) {
	int errCode = gpioGetPWMfrequency(userGPIO);
	CHECK_ERRCODE(errCode)
	return errCode;
}

jint METHOD(gpioCfgSetInternals)(JNIEnv *env, jobject obj, jint cfgVal) {
	int errCode = gpioCfgSetInternals(cfgVal);
	CHECK_ERRCODE(errCode)
	return errCode;
}

jthrowable makeGPIOException(JNIEnv *env, jobject obj, int errCode) {
	jclass exceptionClass = (*env)->FindClass(env, "com/nicholaspjohnson/kpigpio/exceptions/GPIOException");
	jclass exceptionCompClass = (*env)->FindClass(env, "com/nicholaspjohnson/kpigpio/exceptions/GPIOException$Companion");
	jfieldID companion = (*env)->GetStaticFieldID(env, exceptionClass, "Companion", "Lcom/nicholaspjohnson/kpigpio/exceptions/GPIOException$Companion;");
	jobject jobj = (*env)->GetStaticObjectField(env, exceptionClass, companion);
	jmethodID mid = (*env)->GetMethodID(env, exceptionCompClass, "getProperThrowable", "(I)Ljava/lang/Class;");
	jobject actualExceptionClass = (*env)->CallObjectMethod(env, jobj, mid, errCode);	
	jmethodID exceptionConstructorID = (*env)->GetMethodID(env, actualExceptionClass, "<init>", "()V");
	return (*env)->NewObject(env, actualExceptionClass, exceptionConstructorID);
}