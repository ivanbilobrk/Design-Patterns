#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <dlfcn.h>
#include <stddef.h>

typedef void* (*PTRFUN)();
typedef size_t (*SIZE)();

char* getPath(char const* libname){
    char symbol[] = "./";
    char symbol2[] = ".so";
    size_t libname_len = strlen(libname);
    char* path = (char*)malloc(sizeof(char) * (strlen(symbol) + libname_len + 1 + strlen(symbol2)));

    strcpy(path, symbol); 
    strcat(path, libname);
    strcat(path, symbol2);

    return path;
}

void* myfactory(char const* libname, char const* ctorarg, void* object){

    void* handle = dlopen(getPath(libname), RTLD_LAZY);

    PTRFUN func = dlsym(handle, "construct");
    return func(object, ctorarg);
 }

size_t size(char const* libname){
    void* handle = dlopen(getPath(libname), RTLD_LAZY);

    SIZE func = dlsym(handle, "size");

    return func();
 }