#include <stdio.h>

class Base{
public:
 int a;
  Base(int a):a(a) {
    metoda();
  }

  virtual void virtualnaMetoda(){
    printf("EEEObicna");
  }
  
  virtual void neka() =0;

  void metoda() {
    printf("Metoda kaze: ");
    virtualnaMetoda();
  }
};

class Derived: public Base{
public:
int b;
  Derived(int a, int b): Base(a), b(b) {
    metoda();
  }
  virtual void virtualnaMetoda() {
    Base::virtualnaMetoda();
    printf("%d%d", a, b);
    printf("ja sam izvedena implementacija!\n");
  }

  virtual void neka(){
    printf("ja sam izvedena implementacija!\n");
  }
};

int main(){
  Derived* pd=new Derived(2,5);
  pd->metoda();
}