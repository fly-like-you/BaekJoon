#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(){
    int n;
    scanf("%d", &n);


    
    for(int j = 0; j < n; j++){
        int score = 1;
        int sum = 0;
        char string[80];
        scanf("%s", string);
        for(int i = 0; i < strlen(string); i++){
            if(string[i] == 'O') { // O가 있는 경우
                sum = sum + score;
                score++;
            } else if(!(string[i] == 'O')){
                score = 1;
            }
        }
        printf("%d\n", sum);
    }


}