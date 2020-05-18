//
// Created by 燕国庆 on 2020/3/8.
//

#include <stdlib.h>
#include <stdio.h>
#include <jni.h>
#include <string.h>
#include <android/log.h>
#define LOG_TAG "abner"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)


char*   Jstring2CStr(JNIEnv*   env,   jstring   jstr)
{
    char*   rtn   =   NULL;
    jclass   clsstring   =   (*env)->FindClass(env,"java/lang/String");
    jstring   strencode   =   (*env)->NewStringUTF(env,"GB2312");
    jmethodID   mid   =   (*env)->GetMethodID(env,clsstring,   "getBytes",   "(Ljava/lang/String;)[B");
    jbyteArray   barr=   (jbyteArray)(*env)->CallObjectMethod(env,jstr,mid,strencode); // String .getByte("GB2312");
    jsize   alen   =   (*env)->GetArrayLength(env,barr);
    jbyte*   ba   =   (*env)->GetByteArrayElements(env,barr,JNI_FALSE);
    if(alen   >   0)
    {
        rtn   =   (char*)malloc(alen+1);         //"\0"
        memcpy(rtn,ba,alen);
        rtn[alen]=0;
    }
    (*env)->ReleaseByteArrayElements(env,barr,ba,0);  //
    return rtn;
}

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    helloJNI
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_abner_practicecollect_jni_JniHelper_helloJNI
        (JNIEnv * env, jobject thiz){
    return (**env).NewStringUTF(env,"你好 JNI");
}

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    add
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_abner_practicecollect_jni_JniHelper_add
        (JNIEnv * env, jobject thiz, jint a, jint b){
    int result = a + b;
    LOGD("%d+%d=%d", a,b,result);
    return result;
}

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    sysHelloInC
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_abner_practicecollect_jni_JniHelper_sysHelloInC
        (JNIEnv * env, jobject thiz, jstring str){
        char* arr = Jstring2CStr(env,str);
        int i;
        for(i =0;i< strlen(arr);i++){
            arr[i] += 1; //字符加1
        }
        return (*env)->NewStringUTF(env,arr);
}

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    arrayElementsIncrease
 * Signature: ([I)[I
 */
JNIEXPORT jintArray JNICALL Java_com_abner_practicecollect_jni_JniHelper_arrayElementsIncrease
        (JNIEnv * env, jobject thiz, jintArray arr){
        LOGD("arr1=%#x", &arr);
        //获取数组长度
        int length = (*env)->GetArrayLength(env,arr);
        //获取数组首地址
        int* p  = (*env)->GetIntArrayElements(env,arr,NULL);
        LOGD("arr3=%#x", *p);
        //操作数组中元素
        int i;
        for(i = 0;i<length;i++){
            *(p+i) += 10;
             LOGD("i=%d", *(p+i));
        }
        LOGD("arr2=%#x", &arr);
        //ReleaseIntArrayElements 方法，其中 mode 为 0，也就是说将数据处理结构同步到 java 数组，并释放数组指针；
        (*env)->ReleaseIntArrayElements(env, arr,p, 0);
        return arr;
}

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    callbackVoid
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_abner_practicecollect_jni_JniHelper_callbackVoid
        (JNIEnv * env, jobject thiz){
    //1,找到字节码，findclass 第一个参数env,第二个参数要找字节码对应的路径
    // jclass      (*FindClass)(JNIEnv*, const char*);
    jclass  clazz = (*env)->FindClass(env,"com/abner/practicecollect/jni/JniHelper");

    //2,找到方法jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
    jmethodID methodId = (*env)->GetMethodID(env,clazz,"helloFromJava","()V");
    //3,创建对象，如果native方法和要回调的方法在同一个Java类中，就不需要从新创建对象，直接使用传进来的jobject作为对象调用方法
    //4，通过对象调用方法
        //第一个参数JNIEnv
        //第二个参数 要调用的方法的对象
        //第三个参数 要调用的方法的methodid 变量
        //....可变参数 调用方法时如果有参数，就是后面的可变参数要传入的内容
    (*env)->CallVoidMethod(env,thiz,methodId);
}

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    callbackInt
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_abner_practicecollect_jni_JniHelper_callbackInt
        (JNIEnv * env, jobject thiz){
    jclass  clazz = (*env)->FindClass(env,"com/abner/practicecollect/jni/JniHelper");

    jmethodID methodId = (*env)->GetMethodID(env,clazz,"jianfa","(II)I");

    int result = (*env)->CallIntMethod(env,thiz,methodId,5,2);

    LOGD("%d-%d=%d", 5,2,result);
}

/*
 * Class:     com_abner_practicecollect_jni_JniHelper
 * Method:    callbackString
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_abner_practicecollect_jni_JniHelper_callbackString
        (JNIEnv * env, jobject thiz){
    jclass  clazz = (*env)->FindClass(env,"com/abner/practicecollect/jni/JniHelper");

    jmethodID methodId = (*env)->GetMethodID(env,clazz,"helloFromJava","(Ljava/lang/String;)V");

    (*env)->CallVoidMethod(env,thiz,methodId,(*env)->NewStringUTF(env,"你好Java"));
}