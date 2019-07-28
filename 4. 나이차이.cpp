#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int main() {
	int size;
	int max, min, number = 0;
	scanf("%d", &size);
	scanf("%d", &number);
	max = min = number;
	for (int i = 1; i<size; i++) {
		scanf("%d", &number);
		if (max<number) max = number;
		if (min>number) min = number;
	}
	printf("%d", max - min);
	return 0;
}
