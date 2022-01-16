#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
/*
세준이는 자기 점수 중에 최댓값을 골랐다. 
이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
*/
int searchMaxScore(int *subjectArr, int arrLength);
int main(){
    // --------------- 입력 부---------------//

    int countSubject; // 시험 본 과목의 개수 1000보다 작거나 같다.
    scanf("%d", &countSubject);
    int *subjectScore = malloc(sizeof(int) * countSubject);
    float *counterfeitScore = malloc(sizeof(float) * countSubject);   
    for(int i = 0; i < countSubject; i++){
        scanf("%d",&subjectScore[i]);
    }
    // ------------------------------------//
    int maxScore = searchMaxScore(subjectScore, countSubject);
    float sum = 0;
    for(int i = 0; i < countSubject; i++){
        counterfeitScore[i] = (float) subjectScore[i] / maxScore * 100;
        sum = counterfeitScore[i] + sum;
    }
    printf("%f", sum / countSubject);
    
}

int searchMaxScore(int *subjectArr, int arrLength){
    int maxScore = subjectArr[0];
    for(int i = 0; i < arrLength; i++){
        if(subjectArr[i] > maxScore){
            maxScore = subjectArr[i];
        }
    }
    return maxScore;
}