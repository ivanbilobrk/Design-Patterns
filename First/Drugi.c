#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef double (* PTRFUN )();

struct Unary_Function_vTable { 
    PTRFUN value_at;
    PTRFUN negative_value_at;
};

struct Unary_Function {
    struct Unary_Function_vTable* vTable;
    int lower_bound;
    int upper_bound;
};

struct Linear {
    struct Unary_Function_vTable* vTable;
    int lower_bound;
    int upper_bound;
    double a;
    double b;
};


double value_at_Square(struct Unary_Function* inst, double x) {
      return x*x;
}

double value_at_Linear(struct Unary_Function* inst, double x) {
      struct Linear* derived = (struct Linear*)inst;
      return derived->a*x+derived->b;
}

double value_at(struct Unary_Function* inst, double x){
    return inst->vTable->value_at(inst, x);
}

void tabulate(struct Unary_Function* inst){
    for(int x = inst->lower_bound; x <= inst->upper_bound; x++) {
        printf("f(%d)=%lf\n", x, value_at(inst, x));
    }
}

double negative_value_at(struct Unary_Function* inst, double x) {
      return -value_at(inst, x);
}

static struct Unary_Function_vTable uFunction_vTable = {0, negative_value_at};
static struct Unary_Function_vTable Square_vTable = {value_at_Square, negative_value_at};
static struct Unary_Function_vTable Linear_vTable = {value_at_Linear, negative_value_at};

static bool same_functions_for_ints(struct Unary_Function *f1, struct Unary_Function *f2, double tolerance) {
    if(f1->lower_bound != f2->lower_bound) return false;
      if(f1->upper_bound != f2->upper_bound) return false;
      for(int x = f1->lower_bound; x <= f1->upper_bound; x++) {
        double delta = value_at(f1, x) - value_at(f2, x);
        if(delta < 0) delta = -delta;
        if(delta > tolerance) return false;
      }
    return true;
};

struct Unary_Function* constructUnaryFunction(struct Unary_Function* inst, int lb, int ub){
    inst->vTable = &uFunction_vTable;
    inst->lower_bound = lb;
    inst->upper_bound = ub;
    return inst;
}

struct Unary_Function* constructSquare(struct Unary_Function* inst, int lb, int ub){
    constructUnaryFunction(inst, lb, ub);

    inst->vTable = &Square_vTable;
    return inst;
}

struct Unary_Function* createSquare(int lb, int ub){
    struct Unary_Function* inst = (struct Unary_Function*) malloc(sizeof(struct Unary_Function));
    constructSquare(inst, lb, ub);
    return inst;
}

struct Unary_Function* constructLinear(struct Linear* inst, int lb, int ub, int a, int b){
    constructUnaryFunction((struct Unary_Function*) inst, lb, ub);

    inst->vTable = &Linear_vTable;
    inst->a = a;
    inst->b = b;

    return (struct Unary_Function*)inst;
}

struct Unary_Function* createLinear(int lb, int ub, int a, int b){
    struct Linear* inst = (struct Linear*) malloc(sizeof(struct Linear));
    return constructLinear(inst, lb, ub, a, b);
}

int main(){
  struct Unary_Function* f1 = createSquare(-2, 2);
  tabulate(f1);

  struct Unary_Function *f2 = createLinear(-2, 2, 5, -2);
  tabulate(f2);

  printf("f1==f2: %s\n", same_functions_for_ints(f1, f2, 1E-6) ? "DA" : "NE");
  printf("neg_val f2(1) = %lf\n", negative_value_at(f2, 1.0));

  free(f1); free(f2);
  return 0;
}