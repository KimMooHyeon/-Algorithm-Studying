#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int main() {
	char A[30];
	int cnt = 0;
	gets(A);

	for (int i = 0; A[i] != '\0'; i++) {
		if (A[i] == '(') cnt++;
		else if (A[i] == ')') cnt--;
		if (cnt<0) {
			printf("NO");
			return 0;
		}
	}
	printf("YES");
	return 0;
}
