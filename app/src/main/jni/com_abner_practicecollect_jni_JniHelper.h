/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_abner_practicecollect_jni_JniHelper */

#ifndef _Included_com_abner_practicecollect_jni_JniHelper
#define _Included_com_abner_practicecollect_jni_JniHelper
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    helloJNI
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_abner_practicecollect_jni_JniHelper_helloJNI
  (JNIEnv *, jobject);

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    add
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_abner_practicecollect_jni_JniHelper_add
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    sysHelloInC
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_abner_practicecollect_jni_JniHelper_sysHelloInC
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    arrayElementsIncrease
 * Signature: ([I)[I
 */
JNIEXPORT jintArray JNICALL Java_com_abner_practicecollect_jni_JniHelper_arrayElementsIncrease
  (JNIEnv *, jobject, jintArray);

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    callbackVoid
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_abner_practicecollect_jni_JniHelper_callbackVoid
  (JNIEnv *, jobject);

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    callbackInt
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_abner_practicecollect_jni_JniHelper_callbackInt
  (JNIEnv *, jobject);

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    callbackString
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_abner_practicecollect_jni_JniHelper_callbackString
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
