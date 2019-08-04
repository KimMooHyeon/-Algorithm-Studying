#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int A[100];
int B[100];
int main() {
	int N;
	int cnt = 0;
	int flag = 0;
	//freopen("input.txt", "rt", stdin);
	scanf("%d", &N);
	for (int i = 0; i<N; i++) {
		scanf("%d", &A[i]);
	}
	for (int i = 0; i<N; i++) {
		scanf("%d", &B[i]);
	}
	for (int i = 0; i<N; i++) {
		if (A[i] == B[i]) {
			printf("D\n");
		}
		else {
			switch (A[i]) {
			case 1:
				if (B[i] == 2) {
					printf("B\n");
				}
				else {
					printf("A\n");
				}
				break;

			case 2:
				if (B[i] == 1) {
					printf("A\n");
				}
				else {
					printf("B\n");
				}
				break;

			case 3:
				if (B[i] == 1) {
					printf("B\n");
				}
				else {
					printf("A\n");
				}
				break;

			}
		}
	}

	return 0;
}
