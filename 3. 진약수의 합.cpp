#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int main() {
	int N;
	int sum = 1;
	printf("���ڸ� �Է��ϼ���\n");
	scanf("%d", &N);
	printf("1");
	for (int i = 2; i<N; i++) {
		if (N%i == 0) {
			sum += i;
			printf(" + %d", i);
		}
	}
	printf(" = %d", sum);
	return 0;
}