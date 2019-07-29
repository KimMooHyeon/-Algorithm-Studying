#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int main() {
	char A[100];
	gets(A);

	for (int i = 0; A[i] != '\0'; i++) {
		if (65 <= A[i] && A[i] <= 90)
			printf("%c", A[i] + 32);
		else if (97 <= A[i] && A[i] <= 122)
			printf("%c", A[i]);
	}

	return 0;
}

