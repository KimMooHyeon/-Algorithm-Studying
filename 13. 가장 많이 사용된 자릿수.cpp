#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;
int A[11];

int main() {
	int space;
	int max = 0;
	int maxnumber = 0;
	char list[100];
	scanf("%s", list);

	for (int i = 0; list[i] != '\0'; i++) {
		space = list[i] - 48;
		A[space]++;
	}

	for (int i = 0; i<11; i++) {
		if (max <= A[i]) {
			if (maxnumber<i) {
				max = A[i];
				maxnumber = i;
			}
		}

	}
	printf("%d", maxnumber);
	return 0;
}
