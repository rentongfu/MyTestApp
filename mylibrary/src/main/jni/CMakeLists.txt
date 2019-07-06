cmake_minimum_required(VERSION 3.4.1)



set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -Wall")

add_library( # Sets the name of the library.
       native-lib
        SHARED
        testlibrary.cpp)

add_library( # Sets the name of the library.
        jnicallback
        SHARED
        jnicallback.cpp)


find_library( # Sets the name of the path variable.
        log-lib
        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.
target_link_libraries( # Specifies the target library.
        native-lib
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib}
        android
        log
        EGL
        GLESv2)

target_link_libraries( # Specifies the target library.
        jnicallback
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib}
        android
        log
        EGL
        GLESv2)

# build native_app_glue as a static lib
set(${CMAKE_C_FLAGS}, "${CMAKE_C_FLAGS}")
add_library(native_app_glue STATIC ${ANDROID_NDK}/sources/android/native_app_glue/android_native_app_glue.c)
# now build app's shared lib
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -Wall -Werror")
# Export ANativeActivity_onCreate(),
# Refer to: https://github.com/android-ndk/ndk/issues/381.
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -u ANativeActivity_onCreate")
#MESSAGE(-----------------androidndk---------------------)
#MESSAGE(${ANDROID_NDK})
add_library( mynativeactivity
        SHARED
        mynativeactivity.cpp)
target_include_directories(mynativeactivity PRIVATE
        ${ANDROID_NDK}/sources/android/native_app_glue)
target_link_libraries(mynativeactivity
        android
        native_app_glue
        EGL
        GLESv1_CM
        log)