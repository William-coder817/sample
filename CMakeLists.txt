cmake_minimum_required(VERSION 3.10)
project(MyAndroidLibrary)

# Specify the path to your header files if necessary
include_directories(${CMAKE_SOURCE_DIR}/lib)

# Add the version header (optional)
include_directories(${CMAKE_SOURCE_DIR}/lib/version.h)

# Add your source files
add_library(my_android_lib SHARED
    src/main/cpp/my_library.cpp
)

# Link the Android NDK libraries (for example, OpenGL or other Android dependencies)
find_library(log-lib log)
target_link_libraries(my_android_lib ${log-lib})