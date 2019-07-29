#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int digit_sum(int x) {
	int sum = 0;
	while (1) {
		sum += x % 10;
		x = x / 10;
		if (x == 0)
			return sum;
	}
}
int main() {
	int size;
	int max = 0;
	int maxnumber;
	int number;
	int cnt = 0;
	scanf("%d", &size);
	for (int i = 0; i<size; i++) {
		scanf("%d", &number);
		if (max<digit_sum(number)) {
			max = digit_sum(number);
			maxnumber = number;
		}
	}
	printf("%d", maxnumber);
	return 0;
}
