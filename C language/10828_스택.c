#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int stack[10000];
int top = -1;
void push(int num){
    top++;
    stack[top] = num;
}
int empty(){
    if(top == -1){
        return 1;
    }else return 0;
}
int pop(){
    if(empty()) return -1;
    int num;
    num = stack[top];
    top--;
    return num;
}
int size(){
    return top + 1;
}
int stackTop(){
    if(empty()) return -1;
    else return stack[top];
}

int main(){
    int instruction_num;
    scanf("%d", &instruction_num);
    char instruction[100];
    
    for(int i = 0; i < instruction_num; i++){
        scanf("%s", &instruction);
        if(strcmp(instruction, "push") == 0){
            int num;
            scanf("%d", &num);
            push(num);
        } else if(strcmp(instruction, "pop") == 0) printf("%d\n",pop());
        else if(strcmp(instruction, "size") == 0) printf("%d\n", size());
        else if(strcmp(instruction, "empty") == 0) printf("%d\n", empty());
        else if(strcmp(instruction, "top") == 0) printf("%d\n", stackTop());
        
    }
    
}