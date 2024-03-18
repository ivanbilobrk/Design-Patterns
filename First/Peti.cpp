#include<iostream>
using namespace std;

class B{
public:
  virtual int prva()=0;
  virtual int druga(int)=0;
};

class D: public B{

public:
    
  virtual int prva(){return 42;}
  virtual int druga(int x){return prva()+x;}
};

typedef int (*PTRprva)(B*);
typedef int (*PTRdruga)(B*, int);

void testFunc(B* pb){ 
    size_t* vptr = *(size_t**)pb;

   int result = ((PTRprva)vptr[0])(pb);
   int result2 = ((PTRdruga)vptr[1])(pb, 16);
   cout<<"Result of first call is "<<result<<", result of second call is "<<result2<<"\n";

   /*Drugi način za pozvat virtualnu funkciju:
        size_t** temp = (size_t**)pb;
        int res = ((PTRprva)temp[0][0])(pb);
   */
}

int main(){
    B* pb = new D;
    testFunc(pb);
    return 0;
}