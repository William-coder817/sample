cmake_minimum_required(VERSION 3.22.1)
project("MyApp")

# Add the /lib directory to include paths
include_directories(../../lib)

# (Optional) Create a library or link to existing code
add_library(
    native-lib 
    SHARED 
    src/main/cpp/native-lib.cpp
    ../../lib/mylib.cpp
)

target_include_directories(
    native-lib
    PRIVATE
    ../../lib  # Adjust path to where version.h is located
)

# Link libraries if needed
target_link_libraries(native-lib)
