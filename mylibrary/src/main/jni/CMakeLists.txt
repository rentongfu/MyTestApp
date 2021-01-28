cmake_minimum_required(VERSION 3.4.1)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -Wall")


add_library( native-lib SHARED testlibrary.cpp )
#find_library( log-lib log)
target_link_libraries( native-lib log  android  )

add_library( gl2demo SHARED gl2demo.cpp )
target_link_libraries( gl2demo log  android  EGL GLESv2)


add_library( jnicallback SHARED jnicallback.cpp)
target_link_libraries( jnicallback  android log EGL GLESv2)


set(${CMAKE_C_FLAGS}, "${CMAKE_C_FLAGS}")
add_library(native_app_glue STATIC ${ANDROID_NDK}/sources/android/native_app_glue/android_native_app_glue.c)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -Wall -Werror")
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -u ANativeActivity_onCreate")
add_library( mynativeactivity SHARED mynativeactivity.cpp)

target_include_directories(mynativeactivity PRIVATE ${ANDROID_NDK}/sources/android/native_app_glue)

target_link_libraries(mynativeactivity android native_app_glue EGL GLESv1_CM log)