#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int main() {
	int A, B;
	int sum = 0;
	int i = 0;
	int start;
	//freopen("input.txt", "rt", stdin);
	scanf("%d%d", &A, &B);
	printf("%d", A);
	start = A + 1;
	sum += A;
	for (start; start <= B; start++) {
		printf(" +%d", start);
		sum += start;
	}
	printf(" = %d", sum);
	return 0;
}