#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int pow(int a, int b) {
	int sum = 1;
	for (int i = 0; i<b; i++) {
		sum = sum * 10;
	}
	return sum;
}

int main() {
	int num;
	int temp;
	int cnt = 0;
	int A = 1;
	scanf("%d", &num);
	temp = num;
	while (1) {
		if (temp / 10>0) {
			A++;
			temp = temp / 10;
		}
		else break;
	}

	for (int i = 1; i<A; i++) {
		cnt += 9 * pow(10, i - 1)*i;
	}

	cnt += (num - (pow(10, A - 1) - 1))*A;
	printf("%d", cnt);
	return 0;
}
