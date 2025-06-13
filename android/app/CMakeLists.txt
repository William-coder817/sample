cmake_minimum_required(VERSION 3.22.1)
project("MyApp")

# Add the /lib directory to include paths
include_directories(../../lib)

add_library(native-lib SHARED src/main/cpp/native-lib.cpp)
target_include_directories(native-lib PRIVATE ../../lib)
