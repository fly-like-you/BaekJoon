#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(){
    int first, second, third, forth, fifth;
    scanf("%d %d %d %d %d", &first, &second, &third, &forth, &fifth);
    int inspectNumber = first * first + second * second + third * third + forth * forth + fifth * fifth;
    printf("%d", inspectNumber % 10);
}