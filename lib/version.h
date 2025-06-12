#pragma once
#include <string>

// Return version as a C-style string (better for JNI)
const char* GetAppVersion() {
    return "1.0.0";
}