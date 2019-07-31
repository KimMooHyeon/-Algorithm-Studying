#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
using namespace std;

int result[10];

int score(int problem, int solve) {
	int sum;
	sum = (problem*(problem + 1)) / 2;
	if (solve == sum) return 1;
	else return 0;
}

int main() {
	int N;
	int problem;
	int solve;
	//	freopen("input.txt", "rt", stdin);
	scanf("%d", &N);
	for (int i = 0; i<N; i++) {
		scanf("%d%d", &problem, &solve);
		result[i] = score(problem, solve);
	}
	for (int i = 0; i<N; i++) {
		if (result[i] == 1) printf("YES\n");
		else printf("NO\n");
	}

	return 0;
}
