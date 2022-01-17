#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(){
    int num1, num2, num3;
    scanf("%d %d %d", &num1, &num2, &num3);
    int ans = num1 * num2 * num3;
    int numbers[10] = { 0, };
    // 997,002,999 //999 3개 
    
    while(1){
        if(ans == 0) break;
        numbers[ans % 10]++; 
        ans = ans / 10;
        
    }
    for(int i = 0; i < 10; i++){
        printf("%d\n", numbers[i]);
    }
    

}