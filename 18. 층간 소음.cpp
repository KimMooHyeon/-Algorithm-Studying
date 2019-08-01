#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int main() {
	int N, M, dec;
	int problem;
	int max = 0;
	int cnt = -1;

	scanf("%d%d", &N, &M);
	for (int i = 0; i<N; i++) {
		scanf("%d", &dec);
		if (dec>M) cnt++;
		else {
			if (cnt>max) {
				max = cnt;
				cnt = 0;
			}
			else {
				cnt = 0;
			}
		}
	}
	if (cnt>max) max = cnt;
	printf("%d", max);

	return 0;
}
