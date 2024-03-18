#include <iostream>

using namespace std;


class bird {

    public:

        virtual void display(){
            cout<< "This is virtual bird.";
        }

        void example(){
            cout<<"This is example bird";
        }

};

class parrot : public bird{

    public:
        void display(){
            cout<<"This is virtual parrot.";
        }

        void example(){
            cout<<"This is example parrot.";
        }

};

int main(){
    bird *b1 = new bird();
    parrot p1;

    b1->display();

    //p1.display();
}