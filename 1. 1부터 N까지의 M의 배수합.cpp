#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int main() {
	int N, M;
	int sum = 0;
	int i = 0;
	scanf("%d%d", &N, &M);

	for (i = 1; i <= N; i++) {
		if (i%M == 0) {
			sum += i;
		}
	}
	printf("%d", sum);
	return 0;
}
