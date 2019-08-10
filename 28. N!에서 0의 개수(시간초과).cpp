#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int fac(int N) {
	int sum = 1;
	for (int i = 1; i <= N; i++) {
		sum *= i;
	}
	return sum;
}

int main() {

	freopen("input.txt", "rt", stdin);
	int N;
	int cnt = 0;
	scanf("%d", &N);
	int temp = fac(N);
	while (1) {

		if (temp % 10 == 0) {
			cnt++;
			temp = temp / 10;
		}
		else {
			break;
		}
	}
	printf("%d", cnt);
	return 0;
}
