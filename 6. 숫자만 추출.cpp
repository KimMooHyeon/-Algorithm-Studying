#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int main() {
	char A[50];
	int num = 0;
	int cnt = 0;
	int flag = 0;
	scanf("%s", A);
	for (int i = 0; A[i] != '\0'; i++) {
		if (48 <= A[i] && A[i] <= 57) {

			if (A[i] == 48 && flag == 0) {

			}
			else {
				flag = 1;
				num = num * 10 + (A[i] - 48);
			}

		}
	}
	printf("%d\n", num);
	for (int i = 1; i*i<num; i++) {
		if (num%i == 0) cnt += 2;
		if (i*i == num) cnt++;
	}
	printf("%d", cnt);
	return 0;
}