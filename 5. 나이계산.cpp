#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int main() {
	char A[14];
	int age = 0;
	//	freopen("input.txt", "rt", stdin);
	scanf("%s", A);
	if (A[7] == '1' || A[7] == '2') {
		age = 100 - ((A[0] - 48) * 10 + (A[1] - 48)) + 20;
		if (A[7] == '1') {
			printf("%d M", age);
		}
		else if (A[7] == '2') {
			printf("%d W", age);
		}

	}
	else if (A[7] == '3' || A[7] == '4') {
		age = 20 - ((A[0] - 48) * 10 + (A[1] - 48));
		if (A[7] == '3') {
			printf("%d M", age);
		}
		else if (A[7] == '4') {
			printf("%d W", age);
		}
	}


	return 0;
}