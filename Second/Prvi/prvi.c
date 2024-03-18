#include <stdio.h>
#include <string.h>

const void* mymax(const void *base, size_t nmemb, size_t size, int (*compar)(const void *, const void *)){

    const void* currentMax = base;

    size_t i;

    for(i = 1; i < nmemb; i++){
        const void* temp = base+i*size;

        if(compar(temp, currentMax) > 0) currentMax = temp;
    }

    return currentMax;
}

int compareInt(const void* i1, const void* i2){
    int* first = (int*)i1;
    int* second = (int*)i2;

    if(*first > *second) return 1;
    return 0;
}

int compareChar(const void* c1, const void* c2){
    char* first = (char*)c1;
    char* second = (char*)c2;

    if(*first > *second) return 1;
    return 0;
}

int compareString(const void* s1, const void* s2){
    const char** first = (const char**)s1;
    const char** second = (const char**)s2;

    return strcmp(*first, *second);
}

int main(){
    const char* arr_str[] = {"Gle", "malu", "vocku", "poslije", "kise", "Puna", "je", "kapi", "pa", "ih", "njise"};
    int arr_int[] = { 1, 3, 5, 7, 4, 6, 9, 2, 0 };
    char arr_char[]="Suncana strana ulice";
    
    int max1 = *(int*)(mymax(arr_int, sizeof(arr_int)/sizeof(int), sizeof(int), compareInt));
    printf("%d is max in arr_int\n", max1);

    char max2 = *(char*)(mymax(arr_char, sizeof(arr_char), sizeof(char), compareChar));
    printf("%c is max in arr_char\n", max2);

    const char** max3= (const char**)(mymax(arr_str, sizeof(arr_str)/sizeof(const char*), sizeof(const char*), compareString));

    printf("%s is mx in arr_str\n", *max3);
}