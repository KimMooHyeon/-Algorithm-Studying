#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int A[10];
int B[100];
int main() {
	int N = 10;
	int flag = -1;// flag:1 = A , flag:0 =B
	int aScore = 0;
	int bScore = 0;
	// freopen("input.txt", "rt", stdin);
	for (int i = 0; i<N; i++) {
		scanf("%d", &A[i]);
	}
	for (int i = 0; i<N; i++) {
		scanf("%d", &B[i]);
	}

	for (int i = 0; i<N; i++) {
		//	printf("aScore=%d bScore=%d \n",aScore,bScore);
		if (A[i] == B[i]) {
			//printf("before aScore=%d \n",aScore);
			aScore++;
			//	printf("after aScore=%d \n",aScore);
			bScore++;
		}
		else if (A[i]>B[i]) {
			flag = 1;
			aScore += 3;
		}
		else {
			flag = 0;
			bScore += 3;
		}
	}
	printf("%d %d\n", aScore, bScore);
	if (aScore>bScore) {
		printf("A");
	}
	else if (bScore>aScore) {
		printf("B");
	}
	else if (aScore == bScore) {
		if (aScore == 10) {
			printf("D");
		}
		else {
			if (flag == 0) {
				printf("B");
			}
			else {
				printf("A");
			}
		}
	}
	return 0;
}
