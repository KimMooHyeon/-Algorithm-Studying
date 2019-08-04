#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int A[100];
int main() {
	int N, M;
	int cnt = 0;
	int flag = 0;
	//freopen("input.txt", "rt", stdin);
	scanf("%d", &N);
	for (int i = 0; i<N; i++) {
		scanf("%d", &A[i]);
	}
	for (int i = 0; A[i] != '\0'; i++) {
		flag = 0;
		for (int j = i + 1; A[j] != '\0'; j++) {

			if (A[i] <= A[j]) {
				flag = 1;
				//printf("To chang flag=1 A[i]=%d < A[j]=%d \n",A[i],A[j]);
				break;
			}
		}
		if (flag == 0) {
			cnt++;
			//	printf("cnt=%d, A[i]=%d\n",cnt,A[i]);
		}
	}
	printf("%d", cnt - 1);

	return 0;
}
