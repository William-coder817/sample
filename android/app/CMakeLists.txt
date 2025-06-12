cmake_minimum_required(VERSION 3.22.1)
project("native-lib")

# Path to your prebuilt library (adjust as needed)
set(MY_LIB_DIR ${CMAKE_SOURCE_DIR}/../../../lib/build)
set(MY_LIB_NAME my-lib)

# Include directories
include_directories(
    ${CMAKE_CURRENT_SOURCE_DIR}
    ${MY_LIB_DIR}/../  # Path to your lib headers
)

# Find or verify the library exists
find_library(MY_LIB 
    NAMES ${MY_LIB_NAME}
    PATHS ${MY_LIB_DIR}
    NO_DEFAULT_PATH
    REQUIRED)

if(NOT MY_LIB)
    message(FATAL_ERROR "Could not find my-lib at ${MY_LIB_DIR}")
endif()

add_library(
    native-lib
    SHARED
    src/main/cpp/native-lib.cpp  # Your JNI interface file
)

target_link_libraries(
    native-lib
    ${MY_LIB}  # Your prebuilt library
    android
    log
)

# Android-specific configurations
set_target_properties(native-lib PROPERTIES
    LIBRARY_OUTPUT_DIRECTORY ${CMAKE_LIBRARY_OUTPUT_DIRECTORY}
    ANDROID_ABI ${ANDROID_ABI}
    ANDROID_PLATFORM android-${ANDROID_PLATFORM_LEVEL}
)