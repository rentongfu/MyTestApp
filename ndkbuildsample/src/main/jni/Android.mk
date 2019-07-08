LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := ndkbuildsample
LOCAL_SRC_FILES := ndkbuildsample.cpp
LOCAL_LDLIBS    := -llog

include $(BUILD_SHARED_LIBRARY)