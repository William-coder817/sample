cmake_minimum_required(VERSION 3.22.1)
project("MyApp")

# Add the /lib directory to include paths
include_directories(${CMAKE_SOURCE_DIR}/../../../../lib)

# (Optional) Create a library or link to existing code
add_library(native-lib SHARED native-lib.cpp)

# Link libraries if needed
target_link_libraries(native-lib)