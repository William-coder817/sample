cmake_minimum_required(VERSION 3.22.1)
project("MyApp")

# Add the /lib directory to include paths
include_directories(../../lib)

# (Optional) Create a library or link to existing code
add_library(my-lib SHARED IMPORTED)
set_target_properties(my-lib PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/lib/build/libmy-lib.so)

add_library(native-lib SHARED src/main/cpp/native-lib.cpp)
target_include_directories(native-lib PRIVATE ../../lib)

# Link libraries if needed
target_link_libraries(native-lib my-lib)
