cmake_minimum_required(VERSION 3.4.1)

add_library(cool-jni-lib SHARED
            math.cc)

target_link_libraries(cool-jni-lib
                      android
                      log)
