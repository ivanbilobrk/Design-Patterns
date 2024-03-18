#include <iostream>
#include <string.h>
#include <string>
#include <vector>
#include <set>
using namespace std;

template <typename Iterator, typename Predicate> 
Iterator mymax(Iterator first, Iterator last, Predicate pred){

    Iterator currentMax = first;

    for(; first != last; ++first){
        if(pred(*first, *currentMax)) currentMax = first;
    }

    return currentMax;
}

bool gt_int(int i1, int i2){
    if(i1 > i2) return true;
    return false;
}

bool gt_char(char c1, char c2){
    if(c1 > c2) return true;
    return false;
}

bool gt_string(const char* str1, const char* str2){
    int flag = strcmp(str1, str2);
    if(flag > 0) return true;
    return false;
}

bool gt_string2(string str1, string str2){
    int flag = str1.compare(str2);
    if(flag > 0) return true;
    return false;
}


int main(){
    int arr_int[] = { 1, 3, 5, 7, 4, 6, 9, 2, 0 };
    const int* maxint = mymax(arr_int, &arr_int[sizeof(arr_int)/sizeof(*arr_int)], gt_int);
    cout <<*maxint <<" is max in arr_int\n";

    char arr_char[]="Suncana strana ulice";
    const char* maxChar = mymax(arr_char, &arr_char[sizeof(arr_char)/sizeof(char)], gt_char);
    cout<<*maxChar <<" is max in arr_char\n";

    const char* arr_str[] = {"Gle", "malu", "vocku", "poslije", "kise", "Puna", "je", "kapi", "pa", "ih", "njise"};
    const char** maxString = mymax(arr_str, &arr_str[sizeof(arr_str)/sizeof(const char*)], gt_string);
    cout<<*maxString<<" is max in arr_str\n";

    string stringovi[] = {"Gle", "malu", "vocku", "poslije", "kise", "Puna", "je", "kapi", "pa", "ih", "njise"};
    const string* maxString2 = mymax(stringovi, &stringovi[sizeof(stringovi)/sizeof(stringovi[0])], gt_string2);
    cout<<*maxString2<<" is max in stringovi\n";

    vector<int> vec_int = {1, 3, 5, 7, 4, 6, 9, 2, 0};
    auto maxint2 = mymax(vec_int.begin(), vec_int.end(), gt_int);
    cout<<*maxint2<<" is max in vec_int\n";

    vector<string> vec_string = {"Gle", "malu", "vocku", "poslije", "kise", "Puna", "je", "kapi", "pa", "ih", "njise"};
    auto maxstring2 = mymax(vec_string.begin(), vec_string.end(), gt_string2);
    cout<<*maxstring2<<" is max in vec_string\n";

    set<char> set_char;
    set_char.insert('S');
    set_char.insert('U');
    set_char.insert('N');

    auto maxChar2 = mymax(set_char.begin(), set_char.end(), gt_char);
    cout<<*maxChar2<<" is max in set_char\n";
}