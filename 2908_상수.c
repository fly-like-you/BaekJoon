#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int reverse_int(int num1);
int main(){
    int num1, num2;
    scanf("%d %d", &num1, &num2);
    int reversed_num1, reversed_num2;
    reversed_num1 = reverse_int(num1);
    reversed_num2 = reverse_int(num2);
    if(reversed_num1 > reversed_num2){
        printf("%d", reversed_num1);
    }else{
        printf("%d", reversed_num2);
    }
}
int reverse_int(int number){
    int a[3];
    for(int i = 0; i < 3; i++){
        
        a[i] = number % 10;
        number /= 10;
    }
    return a[0] * 100 + a[1] * 10 + a[2];
}
