#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
/*
���� ������� 30�ʸ��� 10���� û���ȴ�.
�� ���� ���� 29�� �Ǵ� �� ���� ���� �ð� ��ȭ�� ������ 10���� û���ȴ�.
���� 30�ʺ��� 59�� ���̷� ��ȭ�� ������ 20���� û���ȴ�.

�ν� ������� 60�ʸ��� 15���� û���ȴ�.
�� ���� ���� 59�� �Ǵ� �� ���� ���� �ð� ��ȭ�� ������ 15���� û���ȴ�.
���� 60�ʺ��� 119�� ���̷� ��ȭ�� ������ 30���� û���ȴ�.
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