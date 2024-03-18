#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char const* (* PTRFUN )();

char const* dogGreet(void){
  return "vau!";
}
char const* dogMenu(void){
  return "kuhanu govedinu";
}
char const* catGreet(void){
  return "mijau!";
}
char const* catMenu(void){
  return "konzerviranu tunjevinu";
}

struct Animal_vTable {
  PTRFUN greet;
  PTRFUN menu;
};

static struct Animal_vTable dogVtable = {dogGreet, dogMenu};
static struct Animal_vTable catVtable = {catGreet, catMenu};

struct Animal {
    struct Animal_vTable* vtable ;
    char const* name ;
};

struct Animal* constructDog (struct Animal*  animal , char const* realName ){
    animal->vtable = &dogVtable;
    animal->name = realName ;
    return animal ;
}

struct Animal* createDog (char const* realName){
    struct Animal* animal = (struct Animal*) malloc(sizeof(struct Animal));
    constructDog(animal, realName);
    return animal;
}

struct Animal* constructCat (struct Animal*  animal , char const* realName ){
    animal->vtable = &catVtable;
    animal->name = realName ;
    return animal ;
}

struct Animal* createCat (char const* realName){
    struct Animal* animal = (struct Animal*) malloc(sizeof(struct Animal));
    constructCat(animal, realName);
    return animal;
}

void animalPrintGreeting(struct Animal* animal){
    printf("%s pozdravlja: %s\n", animal->name, animal->vtable->greet());
}

void animalPrintMenu(struct Animal* animal){
    printf("%s voli: %s\n", animal->name, animal->vtable->menu());
}

void createNDogs(int n, const char *names[]){
  struct Animal* dogs = (struct Animal*) malloc(sizeof(struct Animal)*n);

  int i;
  for(i = 0; i < n; i++){
    constructDog(dogs+i, "Dog");
  }

  for(i = 0; i < n; i++){
    printf("%s menu is: ", names[i]);
    animalPrintMenu(dogs+i);
  }


  free(dogs);

}



void testAnimals(void){
  struct Animal* p1=createDog("Hamlet");
  struct Animal* p2=createCat("Ofelija");
  struct Animal* p3=createDog("Polonije");

  animalPrintGreeting(p1);
  animalPrintGreeting(p2);
  animalPrintGreeting(p3);

  animalPrintMenu(p1);
  animalPrintMenu(p2);
  animalPrintMenu(p3);

  const char *names[]  = {"Dog1", "Dog2", "Dog3"};
  createNDogs(3, names);

  //stvaranje na stogu
  struct Animal cat1;
  constructCat(&cat1, "catStack");
  animalPrintGreeting(&cat1);
  animalPrintMenu(&cat1);

  free(p1); free(p2); free(p3);
}



int main(){
  testAnimals();
  return 0;
}