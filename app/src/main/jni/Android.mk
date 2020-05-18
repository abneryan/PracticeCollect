#makefile 文件：作用就是向编译系统描述，我要编译的文件在什么位置，要生成的文件叫什么名字，是什么类型

LOCAL_PATH := $(call my-dir)
#清除上次编译的信息
include $(CLEAR_VARS)
#指定生成文件的名字
LOCAL_MODULE := jni-lib
#要编译的C代码的文件名字
LOCAL_SRC_FILES := JniCommunication.c
LOCAL_LDLIBS += -llog
#要生成一个动态链接库
include $(BUILD_SHARED_LIBRARY)