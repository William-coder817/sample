cmake_minimum_required(VERSION 3.22.1)
project(MyLib LANGUAGES CXX)  # Explicitly set C++ as the language

# Create an interface library for header-only files
add_library(my-lib INTERFACE)
target_include_directories(my-lib INTERFACE ${CMAKE_CURRENT_SOURCE_DIR})
target_compile_features(my-lib INTERFACE cxx_std_17)  # Set C++17 standard

# For non-header-only libraries, use this instead:
# add_library(my-lib STATIC my-source.cpp)