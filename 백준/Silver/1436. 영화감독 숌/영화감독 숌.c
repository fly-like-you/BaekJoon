//
//  main.c
//  BeckJoon
//
//  Created by 박준호 on 2022/01/24.
//
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    int num; // N번째 종말의 수
    scanf("%d", &num);
    

    // n번째로 작은 666을 포함하는 수 출력하기
    // 2번째로 작은 666은 1666 2666, 3666, 4666, 5666, 6661, 6662, 6663, 6664, 6665, 6666, 6667, 7666, 6668, 8666,
    // 만번째 10666, 16660, 20666, 26660, 21666
    int ans = 666;
    int count = 0;
    int temp;
    while(1){
        temp = ans;
        while(1){
            if(temp == 0) break;
            if(temp % 1000 == 666){
                count++;
                break;
            }else{
                temp = temp / 10;
            }
        }
        if(num == count) { printf("%d\n", ans); return 0;}
        ans++;
    }
}
