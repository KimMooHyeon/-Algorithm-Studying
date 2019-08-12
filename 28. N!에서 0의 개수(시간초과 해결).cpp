#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;
int fac(int N) {
	int cnt;
	int twoNumber = 0;
	int fiveNumber = 0;

	for (int i = 2; i <= N; i++) {
		cnt = i;
		//	printf("Init cnt=%d\n",cnt);
		if (i % 2 == 0 || i % 5 == 0) {
			while (cnt != 1) {
				if (cnt % 2 == 0) {
					//	printf("cnt 2 \n");
					twoNumber++;
					cnt = cnt / 2;
					//	printf("twoNumber++ = %d\n",twoNumber);
					//	printf("cnt = %d\n",cnt);
				}
				else if (cnt % 5 == 0) {
					//	printf("cnt 5 \n");
					fiveNumber++;
					cnt = cnt / 5;
					//	printf("fiveNumber++ = %d\n",fiveNumber);
					//	printf("cnt = %d\n",cnt);
				}
				else {
					break;
				}

			}
		}

	}
	if (twoNumber == fiveNumber) {
		return twoNumber;
	}
	else if (twoNumber>fiveNumber) {
		return fiveNumber;
	}
	else {
		return twoNumber;
	}
}

int main() {

	//	freopen("input.txt", "rt", stdin);
	int N;

	scanf("%d", &N);
	int zeroNum = fac(N);
	int cnt = 0;



	printf("%d", zeroNum);
	return 0;
}
