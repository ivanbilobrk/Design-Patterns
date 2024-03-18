#include <stdlib.h>

typedef char const* (*PTRFUN)();

struct Parrot{
  PTRFUN* vtable;
  char const* name;
};

char const* parrotGreet(){
  return "parrot sound";
}

char const* parrotMenu(){
  return "voce";
}

char const* parrotName(void* this){
    struct Parrot* p = (struct Parrot*)(this);
    return p->name;
}


PTRFUN vtblParrot [3]={ parrotName, parrotGreet , parrotMenu};

struct Parrot* construct (void* t, char const* name){
    struct Parrot* p = (struct Parrot*)(t);
    p->vtable = &vtblParrot[0];
    p->name = name;
    return t;
}

struct Parrot* create (char const* name){
    struct Parrot* t = (struct Parrot*) malloc(sizeof(struct Parrot));
    construct(t, name);
    return t;
}

size_t size(){
    return sizeof(struct Parrot);
}