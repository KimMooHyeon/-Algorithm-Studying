#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int fun(int A) {
	int cnt = 0;
	if (A == 1)
		return 1;
	for (int i = 1; i*i <= A; i++) {
		if (i*i == A) cnt++;
		else if (A%i == 0) cnt += 2;

	}
	return cnt;
}

int main() {
	int A;
	int cnt = 0;
	scanf("%d", &A);
	for (int i = 1; i <= A; i++) {
		printf("%d ", fun(i));
	}
	return 0;
}
