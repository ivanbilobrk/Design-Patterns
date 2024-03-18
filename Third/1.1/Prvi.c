#include "myfactory.h"

#include <stdio.h>
#include <stdlib.h>
#include <stddef.h>
#include <string.h>

typedef char const* (*PTRFUN)();

struct Animal{
  PTRFUN* vtable;
  // vtable entries:
  // 0: char const* name(void* this);
  // 1: char const* greet();
  // 2: char const* menu();
};

void animalPrintGreeting(struct Animal* animal){
    printf("%s pozdravlja: %s\n", ((PTRFUN)(animal->vtable[0]))(animal), ((PTRFUN)(animal->vtable[1]))());
}

void animalPrintMenu(struct Animal* animal){
    printf("%s voli: %s\n", ((PTRFUN)(animal->vtable[0]))(animal), ((PTRFUN)(animal->vtable[2]))());
}

int main(int argc, char *argv[]){

  char* location = argv[argc-1];
  --argc;
  int compare = strcmp(location, "heap");

  for (int i=0; i<argc/2; ++i){
    int unsigned long space = size(argv[1+2*i]);
    struct Animal* a;
    char mem[space];
    if(compare == 0){
        a = (struct Animal*)(malloc(space));
    } else {
        //a = (struct Animal*)(&mem); drugi način alociranja memorije na stogu
        a = (struct Animal*)(alloca(space));
    }

    myfactory(argv[1+2*i], argv[1+2*i+1], a);

    if (!a){
      printf("Creation of plug-in object %s failed.\n", argv[1+2*i]);
      continue;
    }

    animalPrintGreeting(a);
    animalPrintMenu(a);

    if(compare == 0){
        free(a);
    }
         
  }
}