#include <iostream>
using namespace std;

class Point{
    private:
        int x, y;
    public:
        int getX(){
            return x;
        }
        int getY(){
            return y;
        } 
};

class Shape{
    public:
        virtual void draw()=0;
        virtual void translate(int translation)=0;
};

class Circle: public Shape{
    private:
        Point p;
    public:
        virtual void draw(){
            cout<<"In draw circle\n";
        }

        virtual void translate(int translation){
            cout<<"In translate cirle, translating for: "<<translation<<"\n";
        }
};

class Square: public Shape{
    private:
        Point p;
    public:
        virtual void draw(){
            cout<<"In draw square\n";
        }

        virtual void translate(int translation){
            cout<<"In translate square, translating for: "<<translation<<"\n";
        }
};

class Rhomb: public Shape{
    private:
        Point p;
    public:
        virtual void draw(){
            cout<<"In draw rhomb\n";
        }

        virtual void translate(int translation){
            cout<<"In translate rhomb, translating for: "<<translation<<"\n";
        }
};

void drawShapes(Shape** shapes, int n){
    for (int i=0; i<n; ++i){
        struct Shape* s = shapes[i];
        s->draw();
    }
}

void moveShapes(Shape** shapes, int n, int translation){
    for (int i=0; i<n; ++i){
        struct Shape* s = shapes[i];
        s->translate(translation);
    }
}

int main(){
    Shape* shapes[3];
    shapes[0] = new Circle;
    shapes[1] = new Square;
    shapes[2] = new Rhomb;

    drawShapes(shapes, 3);
    moveShapes(shapes, 3, 10);
  }


