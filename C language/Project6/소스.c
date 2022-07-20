#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
/*
영식 요금제는 30초마다 10원씩 청구된다.
이 말은 만약 29초 또는 그 보다 적은 시간 통화를 했으면 10원이 청구된다.
만약 30초부터 59초 사이로 통화를 했으면 20원이 청구된다.

민식 요금제는 60초마다 15원씩 청구된다.
이 말은 만약 59초 또는 그 보다 적은 시간 통화를 했으면 15원이 청구된다.
만약 60초부터 119초 사이로 통화를 했으면 30원이 청구된다.
*/
int yungsikVOIP(int secs);
int minsikVOIP(int secs);
int main() {
	int countCall;
	scanf("%d", &countCall);

	int yungsikPrice = 0, minsikPrice = 0;
	int call_length = 0;
	for (int i = 0; i < countCall; i++) {
		scanf("%d", &call_length);
		yungsikPrice = yungsikPrice + yungsikVOIP(call_length);
		minsikPrice = minsikPrice + minsikVOIP(call_length);
	}
	if (yungsikPrice > minsikPrice) {
		printf("M %d", minsikPrice);
	}
	else if (minsikPrice > yungsikPrice) printf("Y %d", yungsikPrice);
	else printf("Y M %d", yungsikPrice);
}
//56 sec / 30 = 1
// 56 % 30 = 26
int yungsikVOIP(int secs) {
	int times = (secs / 30) + 1;
	int prices = times * 10;
	return prices;
}
int minsikVOIP(int secs) {
	int times = (secs / 60) + 1;
	int prices = times * 15;
	return prices;
}