#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(){
    int n;
    scanf("%d", &n);
    char d[100];

    scanf("%s", &d);
    int sum = 0;
    for(int i = 0; i<n ;i++){
        sum += d[i] - '0';
    }
    printf("%d",sum);
}