#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(){
    int num_arr[9] = { 0, };
    int max_num = 0, index = 0;

    for(int i = 0; i < 9; i++){
        scanf("%d\n", &num_arr[i]);
        if(max_num < num_arr[i]) {
            max_num = num_arr[i];
            index = i + 1;
        }
        
    }
    printf("%d\n%d", max_num, index);

    
}