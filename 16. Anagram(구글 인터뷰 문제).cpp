#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int C[200];
int D[200];
int main() {
	//65 =A , 90=Z
	//97=a , 122=z

	char A[100];
	char B[100];
	scanf("%s", A);
	scanf("%s", B);
	for (int i = 0; A[i] != '\0'; i++) {
		C[(int)A[i]]++;
	}
	for (int i = 0; B[i] != '\0'; i++) {
		D[(int)B[i]]++;
	}
	for (int i = 0; i<200; i++) {
		if (C[i] != D[i]) {
			printf("NO");
			return 0;
		}
	}
	printf("YES");
	return 0;
}

