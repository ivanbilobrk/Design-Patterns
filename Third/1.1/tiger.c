#include <stdlib.h>

typedef char const* (*PTRFUN)();

struct Tiger{
  PTRFUN* vtable;
  char const* name;
};

char const* tigerGreet(){
  return "tiger sound";
}

char const* tigerMenu(){
  return "meso";
}

char const* tigerName(void* this){
    struct Tiger* t = (struct Tiger*)(this);
    return t->name;
}


PTRFUN vtblTiger [3]={ tigerName, tigerGreet , tigerMenu};

struct Tiger* construct (void* t, char const* name){
    struct Tiger* tiger = (struct Tiger*)(t);
    tiger->vtable = &vtblTiger[0];
    tiger->name = name;
    return t;
}

struct Tiger* create (char const* name){
    struct Tiger* t = (struct Tiger*) malloc(sizeof(struct Tiger));
    construct(t, name);
    return t;
}

size_t size(){
    return sizeof(struct Tiger);
}



