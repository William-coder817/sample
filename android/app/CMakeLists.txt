cmake_minimum_required(VERSION 3.22.1)
project(native-lib LANGUAGES CXX)

# Include your lib directory
set(MY_LIB_PATH "../../../lib/build/libmy-lib.a")

add_library(
    native-lib
    SHARED
    src/main/cpp/native-lib.cpp)

# Link to your header-only library
target_link_libraries(native-lib
    "../../../lib/build/my-lib.a"
    android
    log)
