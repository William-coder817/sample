cmake_minimum_required(VERSION 3.22.1)
project(MyLib LANGUAGES CXX)  # Explicitly set C++ as the language

# Set C++17 standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Define the source files
# Adjust the path and filenames as needed
file(GLOB SOURCES
    ${CMAKE_CURRENT_SOURCE_DIR}/*.cpp
)

# Create an interface library for header-only files
add_library(my-lib SHARED ${SOURCES})
target_include_directories(my-lib PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
